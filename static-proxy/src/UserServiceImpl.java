
public class UserServiceImpl implements IuserService{

	public void printInfo(User user) {
		System.out.println(String.format("%s�Ѿ�%d����", user.getName(),user.getAge()));
		
	}
}
