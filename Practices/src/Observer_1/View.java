package Observer_1;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

	@Override
	public void update(Observable obs, Object arg) {
		System.out.println("Update ("+ obs + ", "+ arg + ")");
	}

}
