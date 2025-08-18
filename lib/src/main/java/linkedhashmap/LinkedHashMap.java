package linkedhashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinkedHashMap<K, V> {

	private LinkedHashMapNode<K, V>[] bucketArray;
	private LinkedHashMapNode<K, V> head, tail;

	@SuppressWarnings("unchecked")
	public LinkedHashMap() {
		bucketArray = (LinkedHashMapNode<K, V>[]) new LinkedHashMapNode[16];
	}

	public void put(K key, V value) {
		int bucket = findBucketIndex(key);
		boolean nodeUpdated = false;
		LinkedHashMapNode<K, V> newNode = new LinkedHashMapNode<>(key, value);
		if (bucketArray[bucket] == null) {
			bucketArray[bucket] = newNode;
		} else {
			LinkedHashMapNode<K, V> prev = null;
			LinkedHashMapNode<K, V> node = bucketArray[bucket];
			while (node != null) {
				if (node.getKey().equals(newNode.getKey())) {
					node.setValue(newNode.getValue());
					nodeUpdated = true;
					newNode = node;
					break;
				}
				prev = node;
				node = node.getBucketNext();
			}
			if (!nodeUpdated) {
				prev.setBucketNext(newNode);
				newNode.setBucketPrev(prev);
			}
		}

		if (tail == null) {
			head = tail = newNode;
		} else {
			if (nodeUpdated) {
				if (newNode != tail) {
					if (newNode == head) {
						head = head.getOrderNext();
						head.setOrderPrev(null);
						newNode.setOrderNext(null);
						tail.setOrderNext(newNode);
						newNode.setOrderPrev(tail);
						tail = newNode;
					} else {
						LinkedHashMapNode<K, V> prev = newNode.getOrderPrev();
						LinkedHashMapNode<K, V> next = newNode.getOrderNext();
						prev.setOrderNext(next);
						next.setOrderPrev(prev);
						tail.setOrderNext(newNode);
						newNode.setOrderPrev(tail);
						newNode.setOrderNext(null);
						tail = newNode;
					}
				}
			} else {
				tail.setOrderNext(newNode);
				newNode.setOrderPrev(tail);
				tail = newNode;
			}
		}
	}

	public V remove(K key) {
		int bucket = findBucketIndex(key);
		LinkedHashMapNode<K, V> node = bucketArray[bucket];
		while (node != null) {
			if (node.getKey().equals(key)) {
				break;
			}
			node = node.getBucketNext();
		}
		if (node != null) {
			if (bucketArray[bucket] == node) {
				LinkedHashMapNode<K, V> nextNode = node.getBucketNext();
				bucketArray[bucket] = nextNode;
				if (nextNode != null) {
					nextNode.setBucketPrev(null);
				}
				node.setBucketNext(null);
			} else if (node.getBucketNext() == null) {
				LinkedHashMapNode<K, V> prev = node.getBucketPrev();
				prev.setBucketNext(null);
				node.setBucketPrev(null);
			} else {
				LinkedHashMapNode<K, V> prev = node.getBucketPrev();
				LinkedHashMapNode<K, V> next = node.getBucketNext();
				node.setBucketPrev(null);
				node.setBucketNext(null);
				prev.setBucketNext(next);
				next.setBucketPrev(prev);
			}

			if (node == head) {
				head = head.getOrderNext();
				if (head == null) {
					head = tail = null;
				} else {
					head.setOrderPrev(null);
				}
				node.setOrderNext(null);
			} else if (node == tail) {
				tail = node.getOrderPrev();
				tail.setOrderNext(null);
				node.setOrderPrev(null);
			} else {
				LinkedHashMapNode<K, V> prev = node.getOrderPrev();
				LinkedHashMapNode<K, V> next = node.getOrderNext();
				prev.setOrderNext(next);
				next.setOrderPrev(prev);
				node.setOrderPrev(null);
				node.setOrderNext(null);
			}

			return node.getValue();
		}
		return null;
	}

	public List<Map.Entry<K, V>> entrySet() {
		List<Map.Entry<K, V>> entrySet = new ArrayList<>();
		LinkedHashMapNode<K, V> node = head;
		while (node != null) {
			entrySet.add(node);
			node = node.getOrderNext();
		}
		return entrySet;
	}

	private int findBucketIndex(K key) {
		return (bucketArray.length-1) & key.hashCode();
	}
}
