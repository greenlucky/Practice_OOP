package Observer_3;

public class TwoObserverPattern {
	public static void main(String[] args){
		MyObservable observable = new MyObservable();
		Observer1 obs1 = new Observer1();
		
		observable.addObserver(obs1);
		
		observable.start();
		Observer2 obs2 = new Observer2();
		observable.addObserver(obs2);
		observable.start();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
