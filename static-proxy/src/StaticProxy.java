
public class StaticProxy implements IuserService {

	private UserServiceImpl userService;
	
	public StaticProxy(UserServiceImpl userServiceImpl) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInfo(User user) {
		System.out.println("before to do something");
		userService.printInfo(user);
		System.out.println("after to do something");
		
	}
	

}
