package Observer_RedDress;

public class User implements Observer {
	
	private Observable observable = null;
	private String name;
	
	public User(Observable observable, String name){
		this.observable = observable;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void update() {
		buyDress();
		//unsubscribe();
	}
	
	public void buyDress(){
		System.out.println("Inform " + name + " got my new Red Dress");
	}
	
	public void unsubscribe(){
		System.out.println(this.getName());
		//observable.removeObserver(this);
	}
}
