package Thread_2;

public class MyThread2 extends Thread {
	
	MyThread2(){
		
	}
	
	MyThread2(String name){
		super(name); // Pass name to Thread superclass
	}
	
	public void run(){
		System.out.println("My name is: "+ getName());
	}
	
}
