
public class UserServiceImpl implements IuserService{

	public void printInfo(User user) {
		System.out.println(String.format("%sÒÑ¾­%dËêÁË", user.getName(),user.getAge()));
		
	}
}
