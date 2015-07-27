package com.dsandalgo.linklist;

public class ReverseLinkList extends LinkList {
	
	public ListNode reverse(ListNode head){
		ListNode headRef = head, nextNode = null, preNode = null;
		
		if(headRef.next == null){
			return headRef;
		}
		while(headRef != null){
			nextNode = headRef.next;
			headRef.setNext(preNode);
			preNode = headRef;
			headRef = nextNode;
		}
		return preNode;
	}
	
	// Tough one - reference stack overflow
	public ListNode reverseRec(ListNode list){	  
		
		if (list == null) return null; // first question

	    if (list.next == null) return list; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    ListNode secondElem = list.next;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.next = null;

	    // then we reverse everything from the second element on
	    ListNode reverseRest = reverseRec(secondElem);

	    // then we join the two lists
	    secondElem.next = list;

	    return reverseRest;
	}
	
	public ListNode reversePairRec(ListNode node){	  
		if(node==null){
			return null;
		}
		if(node.next == null){
			return node;
		}
		ListNode nextPair = node.next.next;
		ListNode startNode = node.next;
		node.next.setNext(node);
		node.setNext(reversePairRec(nextPair));
		return startNode;
	}

	public static void main(String[] args) {
		ListNode head = null;
		ReverseLinkList rll = new ReverseLinkList();
		
		head = rll.insertAtLast(head, 1);
		head = rll.insertAtLast(head, 2);
		head = rll.insertAtLast(head, 3);
		head = rll.insertAtLast(head, 4);
		head = rll.insertAtLast(head, 5);
		head = rll.insertAtLast(head, 6);
		head = rll.insertAtLast(head, 7);
		head = rll.insertAtLast(head, 8);
		head = rll.insertAtLast(head, 9);
		
		rll.printLinkList(head);
		
		head = rll.reverse(head);
		System.out.println("\nafter reverse");
		rll.printLinkList(head);
		
		head = rll.reverseRec(head);
		System.out.println("\nafter reverse recc");
		rll.printLinkList(head);
		
		head = rll.reversePairRec(head);
		System.out.println("\nafter pair recc");
		rll.printLinkList(head);
		
		
	}
}
