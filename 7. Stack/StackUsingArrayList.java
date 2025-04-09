class StackArray{
	private int maxSize;
	private int stackArray[];
	private int top;
	
	//constructor to initialize objects
	StackArray(int size){
		this.maxSize=size;
		this.stackArray=new int[maxSize];
		this.top=-1;     //initially empty list
	}
	
	//function to push element
	public void push(int num) {
		if(top==maxSize-1) {
			System.out.println("Stack is full, can not push more elements");
		}
		else {
			top++;
			stackArray[top]=num;
			System.out.println(num+" is pushed");
		}
	}
	
	//function to pop element
	public int pop() {
		if(top==-1) {
			System.out.println("Stack is empty");
			return 0;
		}
		else {
			int temp=stackArray[top];
			System.out.println(stackArray[top]+" is popped");
			top--;
			return temp;
		}
	}
	
	//function to display stack
	public void display() {
		if(top==-1)
			System.out.println("Stack is empty");
		else {
			System.out.println("Stack elements are: ");
			for(int i=top;i>=0;i--) {
				System.out.print(stackArray[i]+" ");
			}
		}
	}
}

public class StackUsingArrayList {	
	public static void main(String[] args) {
		//create object to create stack
		StackArray Stack=new StackArray(100);
		System.out.println("Stack before push operation: ");
		Stack.display();
		Stack.push(1);
		Stack.push(2);
		Stack.push(3);
		Stack.push(4);
		Stack.push(5);
		System.out.println("Stack before pop operation: ");
		Stack.display();
		System.out.println();
		Stack.pop();
		Stack.pop();
		System.out.println("Stack after pop operation: ");
		Stack.display();
	}
}
