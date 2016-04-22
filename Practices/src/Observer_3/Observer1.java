package Observer_3;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer{

	@Override
	public void update(Observable o, Object arg){
		Integer count = (Integer)arg;
		System.out.println("Observer 1: "+count);
	}
}
