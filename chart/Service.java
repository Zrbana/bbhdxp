import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//服务端多线程类,客户端每连接服务端就创建一个线程进行服务端和客户端之间的通信
//从而实现和多个客户端进行TCP通信
class ServiceThread implements Runnable {

	private Socket client = null;
	private String name = "";// 服务端为每个客户端命名的名称

	// 构造函数
	public ServiceThread(Socket client, String name) {
		this.client = client;
		this.name = name;
		System.out.println("客户端: " + this.name + " 上线...");
	}

	public void run() {
		PrintStream out = null;
		BufferedReader buf = null;
		BufferedReader in = null;// 定义BufferedReader对象

		try {
			// 得到客户端的输入信息
			buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// 实例化客户端的输出流
			out = new PrintStream(client.getOutputStream());
			// 设置从键盘接收数据
			in = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			while (flag) {
				// 不断的读取客户端输入的信息
				InputStream inputStream = client.getInputStream();
				BufferedInputStream bufferInput = new BufferedInputStream(
						inputStream);
				byte[] bty = new byte[1024];
				int len = bufferInput.read(bty);
				String str = new String(bty, 0, len);

				System.out.println("客户端: " + this.name + ": " + str);
				// 当客户端输入 空 或 end 时表示结束
				if (str == null || "".equals(str)
						|| "end".equalsIgnoreCase(str)) {
					flag = false;
					System.out.println("客户端: " + this.name + " 下线...");
				} else {
					System.out.println("请输入要发送给客户端" + this.name + "的信息...");
					String sInput = in.readLine();// 从键盘接收数据
					out.println(sInput);// 向客户端 回显消息
				}
			}
			out.close();// 关闭输出流
			client.close();// 关闭客户端
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

};

public class Service {

	/**
	 * 服务端类
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {
		ServerSocket server = null; // 定义ServerSocket对象
		Socket client = null;// 定义Socket对象,表示客户端
		try {

			server = new ServerSocket(8888);// 定义监听端口 10000
			System.out.println("服务器已运行,等待客户端连接...");
			// 一直执行,接收客户端连接
			while (true) {
				client = server.accept();// 等待客户端连接
				PrintStream out = new PrintStream(client.getOutputStream());

				// 为每个客户端随机生成一个名字
				int number = (int) (Math.random() * 100);
				String name = "client" + number;
				// 启动一个线程对象
				new Thread(new ServiceThread(client, name)).start();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			// 若服务端不为null,则关闭服务端实例
			if (server != null) {
				server.close();
			}
		} catch (IOException e2) {

		}
	}

}
