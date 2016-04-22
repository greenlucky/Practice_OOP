package Thread_3;

public class testMyThread3 {

	public static void main(String[] args) {
		
		MyThread3 mt = new MyThread3();
		mt.start();
		//while(mt.isAlive())
			try{
				//Thread.sleep(10); // Sleep for 10 milliseconds
				mt.join();
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		
		
		System.out.println("pi = "+ mt.pi);
	}

}
