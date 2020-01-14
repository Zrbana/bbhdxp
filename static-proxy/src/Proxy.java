
public class Proxy {

	private static void staticProxy() {
		User user = new User();
		user.setAge(11);
		user.setName("Jack");
		
		StaticProxyInherit staticProxyInherit = new StaticProxyInherit();
		staticProxyInherit.printInfo(user);
		
		StaticProxy staticProxy = new StaticProxy(new UserServiceImpl());
		staticProxy.printInfo(user);
	}
	public static void main(String[] args) {
		staticProxy();
	}
}
