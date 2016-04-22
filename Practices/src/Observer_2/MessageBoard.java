package Observer_2;

import java.util.Observable;

public class MessageBoard extends Observable {
	private String message;
	
	public String getMessage(){
		return this.message;
	}
	
	public void changeMessage(String message){
		this.message = message;
		setChanged();
		notifyObservers(message);
	}
	
	public static void main(String[] args){
		MessageBoard mb = new MessageBoard();
		Student bob = new Student();
		Student joe = new Student();
		mb.addObserver(bob);
		mb.addObserver(joe);
		
		mb.changeMessage("More Homework!");
	}
}
