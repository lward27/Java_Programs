package edu.ncsu.csc.csc216.heckman_brewery.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeerLinkedList<E> implements List<E> {

	private ListNode<E> front;
	private ListNode<E> back;
	private int size;
	
	public BeerLinkedList() {
		front = new ListNode<E>(null); //optimization to save empty list check
		back = new ListNode<E>(null); //optimization to save empty list check
		clear();
	}
	
	@Override
	public void add(E value) {
		add(value, size);
	}

	@Override
	public void add(E value, int index) {
		checkIndex(index);
		ListNode<E> current = nodeAt(index - 1); //get node before where we want to add
		ListNode<E> newNode = new ListNode<E>(value, current.next, current);
		current.next = newNode;
		newNode.next.prev = newNode;
		size++;
	}
	
	@Override
	public void addAll(List<E> other) {
		for (E value: other) {
			add(value);
		}
	}

	@Override
	public void clear() {
		front.next = back;
		back.prev = front;
		size = 0;
	}

	@Override
	public boolean contains(E value) {
		return indexOf(value) >= 0;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return nodeAt(index).data;
	}

	@Override
	public int indexOf(E value) {
		ListNode<E> current = front.next; //b/c front points to dummy node
		int index = 0;
		while (current != back) { //we can use != b/c we're comparing references
			if (value.equals(current.data)) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1; //the node doesn't exist in the list
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		ListNode<E> current = nodeAt(index - 1);
		current.next = current.next.next;
		current.next.prev = current;
		size--;
	}

	@Override
	public void set(int index, E value) {
		checkIndex(index);
		ListNode<E> current = nodeAt(index);
		current.data = value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}
	
	private ListNode<E> nodeAt(int index) {
		ListNode<E> current = null;
		if (index < size / 2) {
			current = front;
			for (int i = 0; i < index + 1; i++) {
				current = current.next;
			}
		} else {
			current = back;
			for (int i = size; i >= index + 1; i--) {
				current = current.prev;
			}
		}
		return current;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private static class ListNode<E> {
		
		public E data;
		public ListNode<E> next;
		public ListNode<E> prev;
		
		public ListNode(E data) {
			this(data, null, null);
		}
		
		public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private class LinkedIterator implements Iterator<E> {
		
		private ListNode<E> current;
		private boolean removeOK;
		
		public LinkedIterator() {
			current = front.next;
			removeOK = false;
		}

		@Override
		public boolean hasNext() {
			return current != back;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.data;
			current = current.next;
			removeOK = true; //only want to allow removal if we've gone to the next node
			return result;
		}

		@Override
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			ListNode<E> prev = current.prev.prev;
			prev.next = current;
			current.prev = prev;
			size--;
			removeOK = false;
		}
		
	}

}
