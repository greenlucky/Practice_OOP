package Observer_3;

import java.util.Observable;

public class MyObservable extends Observable implements Runnable{
	
	public MyObservable(){
		
	}
	
	public void start(){
		new Thread(this).start();
	}

	@Override
	public void run() {
		int count = 0;
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		count++;
		setChanged();
		notifyObservers(new Integer(count));
	}
}
