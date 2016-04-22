package Observer_RedDress;

import java.util.ArrayList;
import java.util.Iterator;

public class RedDress implements Observable{
	
	private ArrayList<Observer> users = new ArrayList<Observer>();
	
	private boolean inStock = true;
	
	public boolean isStock(){
		return inStock;
	}
	
	//setter for inStock
	public void setInStock(boolean inStock){
		this.inStock = inStock;
		notifyObserver();
	}
	
	@Override
	public void addObserver(Observer o) {
		users.add(o);	
		
	}

	@Override
	public void removeObserver(Observer o) {
		try{
			users.remove(o);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void notifyObserver() {
		Iterator<Observer> ltr = users.iterator();
		while(ltr.hasNext()){
			Observer user = (Observer) ltr.next();
			users.remove(user);
			user.update();
		}
	}
	
	public int getSize(){
		return users.size();
	}

	
}
