package com.dsandalgo.linklist;

public class FindNthNodeFromEndOfLinklist extends LinkList{
	
	public int findFromEnd(ListNode head, int loc){
		ListNode headRef= head;
		
		while(loc>0 && headRef!=null){
			headRef= headRef.next;
			loc--;
		}
		if(loc>0){
			System.out.println("location not found");
		}
		while(headRef!=null){
			headRef= headRef.next;
			head= head.next;
		}
		
		return head.getData();
	}
	
	int local = 0;
	public int findFromEndRec(ListNode head, int loc){
		int data = 0;
		if(head==null){
			local = loc;
			return 1;
		}
		
		data = findFromEndRec(head.next, loc);
		if(local == 0){
			data = head.getData();
			local--;
		}else{
			local--;
		}
		return data;
	}
	
	
	
	public static void main(String[] args) {
		FindNthNodeFromEndOfLinklist findFromEnd = new FindNthNodeFromEndOfLinklist();
		
		ListNode head = null;
		head = findFromEnd.insertAtFrount(head, 1);
		head = findFromEnd.insertAtFrount(head, 2);
		head = findFromEnd.insertAtFrount(head, 3);
		head = findFromEnd.insertAtFrount(head, 4);
		head = findFromEnd.insertAtFrount(head, 5);
		head = findFromEnd.insertAtFrount(head, 6);
		head = findFromEnd.insertAtFrount(head, 7);
		
		findFromEnd.printLinkList(head);
		
		System.out.println("\nlast 6 : " + findFromEnd.findFromEnd(head, 6));
		
		System.out.println("\nlast 2 : " + findFromEnd.findFromEndRec(head, 3));

	}
}
