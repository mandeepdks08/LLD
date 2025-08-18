package linkedhashmap;

import java.util.Map.Entry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedHashMapNode<K,V> implements Entry<K, V> {
	private K key;
	private V value;
	private LinkedHashMapNode<K,V> bucketNext;
	private LinkedHashMapNode<K,V> bucketPrev;
	private LinkedHashMapNode<K,V> orderNext;
	private LinkedHashMapNode<K,V> orderPrev;
	
	public LinkedHashMapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		this.value = value;
		return this.value;
	}
}
