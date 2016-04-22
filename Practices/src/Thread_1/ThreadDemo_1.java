package Thread_1;

public class ThreadDemo_1 {
	public static void main(String[] args){
		MyThread1 mt = new MyThread1();
		mt.start();
		
		for(int i = 0; i < 50; i++){
			System.out.println("i = "+ i + ", i*i = "+ i*i);
		}
	}
}
