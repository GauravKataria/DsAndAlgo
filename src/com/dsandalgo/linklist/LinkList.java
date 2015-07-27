package com.dsandalgo.linklist;

public class LinkList {
	public int getSize(ListNode head){
		int length = 0 ;
		while(head != null){
			length++;
			head=head.getNext();
		}
		return length;
	}
	
	public void printLinkList(ListNode head){
		while(head != null){
			System.out.print(" "+ head.getData() +" ");
			head=head.getNext();
		}
	}
	
	public ListNode insertAtFrount(ListNode head, int nodeData){
		ListNode node = new ListNode(nodeData);
		node.setNext(head);
		return node;
	}
	
	public ListNode insertAtLast(ListNode head, int nodeData){
		ListNode headRef = head;
		ListNode node = new ListNode(nodeData);
		
		if(headRef != null){
			while(headRef.next!=null){
				headRef = headRef.next;
			}			
		} else {
			return node;
		} 		
		headRef.next = node; 
		
		return head;
	}
	
	public ListNode insertAtLocation(ListNode head, int nodeData,int loc) {
		ListNode headRef = head;
		ListNode node = new ListNode(nodeData);
		
		while(headRef !=null && loc>1){
			loc--;
			headRef= headRef.next;
		}
		
		if(headRef == null){
			System.out.println("location do not exist");
		}else {
			node.setNext(headRef.getNext());
			headRef.setNext(node);
		}
		
		return head;
	}
	
	public ListNode deleteAtFrount(ListNode head){
		ListNode temp = head.next;
		
		if(head != null){
			head.next=null;
		}
		return temp;
	}
	
	public ListNode deleteAtLast(ListNode head){
		ListNode headRef = head;
		ListNode temp = null;
		
		if(headRef != null){
			while(headRef.next!=null){
				temp = headRef;
				headRef = headRef.next;
			}			
		}				
		temp.next = null;
		return head;
	}
	
	public ListNode deleteAtLocation(ListNode head, int loc){
		ListNode headRef = head;
		
		while(headRef !=null && loc>0){
			loc--;
			headRef= headRef.next;
		}
		
		if(loc>0 || headRef == null){
			System.out.println("location do not exist");
		}else {
			headRef.setData(headRef.next.getData());
			headRef.setNext(headRef.next.next);
		}
		return head;
	}
	
	public ListNode deleteLinklist(){
		return null;
	}
	
	public static void main(String args[]){
		LinkList ll = new LinkList(); 
		
		ListNode head = null;
		head = ll.insertAtFrount(head, 1);
		head = ll.insertAtFrount(head, 2);
		head = ll.insertAtFrount(head, 3);
		head = ll.insertAtFrount(head, 4);
		head = ll.insertAtFrount(head, 5);
		
		head = ll.insertAtLast(head, 6);
		head = ll.insertAtLast(head, 7);
		head = ll.insertAtLast(head, 8);
		head = ll.insertAtLast(head, 9);
				
		head = ll.deleteAtFrount(head);
		head = ll.deleteAtLast(head);
		
		head = ll.deleteAtLocation(head, 2);
		head = ll.insertAtLocation(head, 10, 1);
		
		ll.printLinkList(head);
		
		System.out.println("LinkList Size : " + ll.getSize(head));
	}
}
