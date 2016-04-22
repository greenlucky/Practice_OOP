package observable;

import java.util.Observable;
import java.util.Observer;

public class ObservableObject {
	public int value;

	private Observable observable = new Observable() {
		@Override
		public void notifyObservers(Object arg) {
			setChanged();
			super.notifyObservers(arg);
		}
	};

	public ObservableObject() {
	}

	public int getValue() {
		return value;
	}

	public void addObserver(Observer o) {
		observable.addObserver(o);
	}

	public void setValue(int value) {
		this.value = value;
		// notify all of its observers
		observable.notifyObservers(this);
	}

	public static void main(String[] args) {
		ObservableObject obser = new ObservableObject();
		obser.addObserver(new Observer() {
			@Override
			public void update(Observable arg0, Object arg1) {
				ObservableObject o = (ObservableObject) arg1;
				System.out.println("Value changed to " + o.getValue());
			}
		});

		obser.setValue(8);
		obser.setValue(7);

	}

}
