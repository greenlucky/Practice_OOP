package Observer_RedDress;

public class testObsRedDress {
	public static void main(String[] args){
		RedDress rd = new RedDress();
		User user1 = new User(rd, "Lam");
		User user2 = new User(rd, "Minh");
		User user3 = new User(rd, "An");
		rd.addObserver(user1);
		rd.addObserver(user2);
		rd.addObserver(user3);
		System.out.println(rd.getSize());
		rd.setInStock(true);
	}
}
