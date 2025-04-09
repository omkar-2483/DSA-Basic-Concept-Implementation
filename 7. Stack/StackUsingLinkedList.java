//Notes:
//while using linked list there is no limitation on size in Linked List 
//we can't access direct element
//

//write a java program to implement stack using Linked List
//1. push an element on stack 2.pop an element from stack 3. display stack 

import java.util.Scanner;

//create class to create node of linked list
class Node {
    int data;
    Node next;

    //constructor i.e. function to create node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

//class for creating stack using linked list
class LinkedListStack {
    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    // Push operation to add an element to the top of the stack
    public void push(Node newNode) {
    	if(top==null) {
    		top = newNode;
    	}
    	else {
    		newNode.next=top;
    		top=newNode;
    	}
    }

    // Pop operation to remove and return the top element from the stack
    public void pop() {
        if (top==null) {
            System.out.println("Stack is empty. Cannot pop.");
            } 
        else {
            int data = top.data;
            top = top.next;
            System.out.println("element "+data+" is popped");
        }
    }

    // Display the elements of the stack
    public void displayStack() {
        Node current = top;
        System.out.print("Stack: ");
        if(top==null) {
        	System.out.println("stack is empty");
        }
        else {
        	while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            }
        	System.out.println();
        }
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        int choice,num;
        Scanner sc=new Scanner(System.in);
        while(true) {
        	System.out.println("Enter choice: \n1 for push\n2 for pop \n3 for display stack:");
        	choice=sc.nextInt();
        	switch(choice) {
        	case 1:{
        		System.out.println("Enter a number: ");
        		num=sc.nextInt();
        		Node newNode=new Node(num);
        		stack.push(newNode);
        		break;
        	}
        	case 2:{
        		stack.pop();
        		break;
        	}
        	case 3:{
        		stack.displayStack();
        		break;
        	}
        	default:{
        		System.out.println("Invalid choice");
        	}
        	}
        }
    }
}


