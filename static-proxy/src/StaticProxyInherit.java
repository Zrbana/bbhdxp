
public class StaticProxyInherit extends UserServiceImpl {

	public void printInfo(User user) {
		System.out.println("before to  do something");
		super.printInfo(user);
		System.out.println("after to  do something");
	}
	
}
