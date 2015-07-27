package com.dsandalgo.linklist;

public class StackUsingLinkList {
	ListNode top = null;
	LinkList ll = new LinkList();
	
	public ListNode push(int nodeData){
		top = ll.insertAtFrount(top, nodeData);
		return top;
	}
	
	public int pop(){
		if(top==null){
			System.out.println("cant pop as stack is already empty");
		}
		ListNode temp = top;
		top = ll.deleteAtFrount(top);
		return temp.getData();
	}
	
	public void printStack(){
		ll.printLinkList(top);
	}
	
	public static void main(String[] args) {
		StackUsingLinkList stack = new StackUsingLinkList();
		
		stack.push(1);
		stack.push(2);
		
		System.out.println("1 : ");
		stack.printStack();
		
		stack.pop();
		
		System.out.println("1 : ");
		stack.printStack();
	}
}
