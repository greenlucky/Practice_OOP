package Thread_3;

public class MyThread3 extends Thread {
	boolean negative = true;
	double pi;
	public void run(){
		
		for(int i = 3 ; i < 100000; i += 2){
			
			if(negative)
				pi -= (1.0/i);
			else
				pi += (1.0/i);
			negative = ! negative;
		}
		
		pi += 1.0;
		pi *= 4.0;
		System.out.println("Finished calculating PI");
	}
}
