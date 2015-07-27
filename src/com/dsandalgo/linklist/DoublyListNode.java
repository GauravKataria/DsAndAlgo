package com.dsandalgo.linklist;

public class DoublyListNode {
	int data;
	DoublyListNode next;
	DoublyListNode pre;
	
	DoublyListNode(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyListNode getNext() {
		return next;
	}

	public void setNext(DoublyListNode next) {
		this.next = next;
	}

	public DoublyListNode getPre() {
		return pre;
	}

	public void setPre(DoublyListNode pre) {
		this.pre = pre;
	}
	
}
