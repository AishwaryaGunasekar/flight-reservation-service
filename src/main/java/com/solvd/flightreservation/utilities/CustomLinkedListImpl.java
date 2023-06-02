package com.solvd.flightreservation.utilities;

public class CustomLinkedListImpl<T> {

	private Node<T> head; //Starting of the node in the list

	public CustomLinkedListImpl() {
		this.head = null;
	}

	public void add(T data) {
		Node<T> newNode = new Node<>(data); // creating object for the node and assigning data to the node 
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode; 
		}
	}

	public void remove(T data) {
		if (head == null) {
			System.out.println("List is Empty here ");
			return;
		}

		if (head.data.equals(data)) {
			head = head.next;
			return;
		}

		Node<T> current = head;
		Node<T> prev = null;

		while (current != null && !current.data.equals(data)) {
			prev = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println("Element not found in the list.");
			return;
		}

		prev.next = current.next;
	}

	public boolean contains(T data) {
		Node<T> current = head;

		while (current != null) {
			if (current.data.equals(data)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}
}