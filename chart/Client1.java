import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {

	/**
	 * 客户端类
	 */
	public static void main(String[] args) {
		Socket client = null;// 定义Socket对象
		BufferedReader buf = null;// 接收服务端发送回来的信息
		PrintStream out = null;// 向服务端发送信息
		BufferedReader input = null;// 定义BufferedReader对象
		try {
			// 这里指定连接服务端的ip 和 端口,
			// ip就是服务端的ip,这里 在本地模拟,所以用localhost
			// 端口要和服务端类中设置的监听端口一致
			client = new Socket("localhost", 8888);
			// 获取服务端ip
			InetAddress ip = client.getInetAddress();
			// 设置从键盘接收数据
			input = new BufferedReader(new InputStreamReader(System.in));
			// 向服务端输出信息
			out = new PrintStream(client.getOutputStream());
			// 接收服务端输入信息
			buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			boolean flag = true;
			while (flag) {
				System.out.println("请输入要发送给服务端" + ip + "信息,当输入 end 时退出...");
				String str = input.readLine();// 从键盘接收数据
				out.print(str);// 向服务端输入数据
				// 当客户端输入 空 或 end 时表示结束
				if (str == null || "".equals(str)
						|| "end".equalsIgnoreCase(str)) {
					flag = false;
				} else {
					String ss = buf.readLine();
					System.out.println("服务端 " + ip + ": " + ss);
				}
			}
		} catch (Exception e1) {
		}
		try {
			if (client != null) {
				client.close();
			}
			if (buf != null) {
				buf.close();
			}

		} catch (Exception e2) {
		}

	}

}
