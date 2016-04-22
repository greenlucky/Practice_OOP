package Observer_1;

import java.util.Observable;

public class Model extends Observable{
	
	private int old;
	
	public void setOld(int old){
		this.old = old;
		changeObs();
	}
	
	public int getOld(){
		return this.old;
	}
	
	public void changeObs(){
		
		setChanged();
		notifyObservers();
	}
}
