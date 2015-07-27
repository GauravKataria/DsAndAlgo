package com.dsandalgo.linklist;

public class DoublyLinkList {
	
	public int getSize(){
		return 0;
	}
	
	public void printList(DoublyListNode head){
		while(head != null){
			System.out.print(" "+ head.getData() +" ");
			head=head.getNext();
		}
	}
	
	public DoublyListNode insertAtFrount(DoublyListNode head, int nodeData){
		DoublyListNode node = new DoublyListNode(nodeData);
		
		if(head != null){
			head.setPre(node);
			node.setNext(head);
		}
		
		return node;
	}
	
	public DoublyListNode insertAtLocation(DoublyListNode head, int nodeData, int loc){
		DoublyListNode headRef = head;
		DoublyListNode node = new DoublyListNode(nodeData);
	
		if(loc == 0){
			if(node.getNext() !=null)
				node.getNext().setPre(node);
			node.setNext(headRef);
			return node;
		}
		
		while(headRef !=null && loc>1){
			loc--;
			headRef= headRef.next;
		}
		
		if(headRef == null){
			System.out.println("location do not exist");
		}else {
			node.setNext(headRef.getNext());
			node.setPre(headRef);
			if(node.getNext() !=null)
				node.getNext().setPre(node);
			headRef.setNext(node);
		}
		
		return head;
	}
	
	public DoublyListNode deleteAtLocation(DoublyListNode head, int loc){
		DoublyListNode headRef = head;
		
		if(loc==0){
			if(headRef.next != null)
				headRef.getNext().setPre(null);
			return head.next;
		}
		
		while(headRef!=null && loc>0){
			loc--;
			headRef= headRef.next;
		}
		
		if(loc>0 || headRef == null){
			System.out.println("location do not exist");
		}else {
			if(headRef.next != null)
				headRef.getNext().setPre(headRef.getPre());
			if(headRef.pre != null)
				headRef.getPre().setNext(headRef.getNext());
			headRef.setData(0);
			headRef.setNext(null);
			head.setPre(null);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		DoublyLinkList dll = new DoublyLinkList();
		
		DoublyListNode head = null;			
		head = dll.insertAtFrount(head, 1);
		head = dll.insertAtFrount(head, 2);
		head = dll.insertAtFrount(head, 3);
		head = dll.insertAtFrount(head, 4);
		
		head = dll.insertAtLocation(head, 5, 0);
		head = dll.insertAtLocation(head, 8, 3);
		//head = dll.deleteAtLocation(head, 0);
		
		dll.printList(head);
	}
}
