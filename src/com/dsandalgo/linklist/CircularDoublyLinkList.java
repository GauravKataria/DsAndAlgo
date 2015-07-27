package com.dsandalgo.linklist;

public class CircularDoublyLinkList {
	
	public void printList(DoublyListNode head){
		DoublyListNode headRef= head;
		while(headRef.getNext() != head){
			System.out.print(" "+ headRef.getData() +" ");
			headRef=headRef.getNext();
		}	
		System.out.print(" "+ headRef.getData() +" ");
	}
	
	public int getSize(DoublyListNode head){
		int size = 0;
		DoublyListNode headRef= head;
		while(headRef != head){
			size++;
		}
		return size;
	}
	
	public DoublyListNode insertAtFrount(DoublyListNode head, int nodeData){
		DoublyListNode node = new DoublyListNode(nodeData);
		
		if(head==null){
			head = node;
			head.setNext(node);
			head.setPre(node);
		}
		
		node.setNext(head);
		node.setPre(head.pre);
		head.getPre().setNext(node);
		head = node;
		
		return head;
	}
	
	public DoublyListNode insertAtLocation(DoublyListNode head, int nodeData, int loc){
		DoublyListNode node = new DoublyListNode(nodeData);
		DoublyListNode headRef = head;
		
		if(loc==0){
			head = insertAtFrount(head, nodeData);
			return head;
		}
		
		while(loc>1 && headRef.next != head){
			loc--;
			headRef = headRef.next;
		}
		
		if(loc>1){
			System.out.println("cant reach location");
		}else {
			node.setNext(headRef.next);
			node.setPre(headRef);
			headRef.getNext().setPre(node);
			headRef.setNext(node);
		}
		
		return head;
	}
	
	public DoublyListNode deleteAtlocation(DoublyListNode head, int loc){
		DoublyListNode headRef = head;
		
		if(head==null){
			System.out.println("list is empty, nothing to delete");
			return null;
		}
		else if(head.next == head){
			return null;
		}
		while(loc>0 && headRef.next != head){
			loc--;
			headRef = headRef.next;
		}
		if(loc>0){
			System.out.println("cant reach location");
		}else {
			headRef.getPre().setNext(headRef.getNext());
			headRef.getNext().setPre(headRef.getNext());
			if(head==headRef)
				return headRef.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		CircularDoublyLinkList cdll = new CircularDoublyLinkList();
		
		DoublyListNode head = null;
		head = cdll.insertAtFrount(head, 1);
		head = cdll.insertAtFrount(head, 2);
		head = cdll.insertAtFrount(head, 3);
		head = cdll.insertAtFrount(head, 4);
		
		head = cdll.insertAtLocation(head, 5, 2);
		
		head = cdll.deleteAtlocation(head, 0);
		
		cdll.printList(head);
	}
}
