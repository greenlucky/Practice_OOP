package Observer_1;

public class Controller {
	
	View view;
	Model model;
	
	public Controller(){
		
		view = new View();
		
		model = new Model();
		model.addObserver(view);
	}
	
	public void demo(){
		model.setOld(10);
		
		model.setOld(15);
	}
	
	public static void main(String[] args){
		
		Controller cl = new Controller();
		cl.demo();
		
	}
}
