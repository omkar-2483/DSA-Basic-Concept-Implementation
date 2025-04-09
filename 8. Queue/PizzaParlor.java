import java.util.Scanner;

class CircularQueue {
	//Array used to implement the circular queue
	String[] arrayQueue;
	int size,front,rear,capacity;
	public CircularQueue(int capacity){
		this.capacity=capacity;
		arrayQueue=new String[capacity];
		size=capacity;
		front=-1;
		rear=-1;
	}
	
	//function to place order 
	public void place(String name) {
		if(isFull()) {
			System.out.println("max order limit reached,try after some time");
			return;
		}
		else {
			if(front==-1)
				front++;
			rear=(rear+1)%capacity;
			arrayQueue[rear]=name;
			System.out.println(name+", your oder is placed");
			size--;
		}
	}
	
	//function serve order
	public void serve(){
		if(isEmpty()) {
			System.out.println("No order is place");
			return;
		}
		else {
			String temp=arrayQueue[front];
			front=(front+1)%capacity;
			System.out.println(temp+", Your order is served");
			size++;
		}
	}
	
	//function to get available slots
	public void getSize() {
		System.out.println("Available slots: "+size);
	}
	
	//check empty condition
	public boolean isEmpty() {
		if(size==capacity)
			return true;
		else
			return false;
	}
	
	//check Full condition
	public boolean isFull() {
		if(size==0)
			return true;
		else
			return false;
	}
	
	//Display function
	public void display() {
		if(isEmpty()) {
			System.out.println("No order is placed");
			return;
		}
		System.out.println("Order sequence is: ");
		if(front<=rear) {
			for(int i=front;i<=rear && arrayQueue[i]!=null;i++)
				System.out.print(arrayQueue[i]+"--> ");
			System.out.println();
		}
		else {
			for(int i=front;i<capacity && arrayQueue[i]!=null;i++)
				System.out.print(arrayQueue[i]+"--> ");
			for(int i=0;i<=rear && arrayQueue[i]!=null;i++)
				System.out.print(arrayQueue[i]+"--> ");
			System.out.println();
		}
	}
}

public class PizzaParlor {
	public static void main(String[] args) {
		//set maximum capacity=5
		CircularQueue OrderList=new CircularQueue(5);
		int choice;
		Scanner sc=new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("1.Place Order \n2.Serve Order \n3.Display Order list \n4.show available orders \n5.Exit");
			System.out.println("Enter choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter your name: ");
				String name=sc.next();
				OrderList.place(name);
				break;
			case 2:
				OrderList.serve();
				break;
			case 3:
				OrderList.display();
				break;
			case 4:
				OrderList.getSize();
				break;	
			case 5:
				System.exit(0);
			default:
				System.out.println("INCORRECT INPUT..");
			}
		}
	}
}

