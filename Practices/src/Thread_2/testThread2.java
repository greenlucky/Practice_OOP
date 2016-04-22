package Thread_2;

public class testThread2 {
	public static void main(String[] args){
		MyThread2 mt2;
		
		if(args.length == 0)
			mt2 = new MyThread2();
		else
			mt2 = new MyThread2("Test Thread");
		mt2.start();
	}
}
