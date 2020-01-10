import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//����˶��߳���,�ͻ���ÿ���ӷ���˾ʹ���һ���߳̽��з���˺Ϳͻ���֮���ͨ��
//�Ӷ�ʵ�ֺͶ���ͻ��˽���TCPͨ��
class ServiceThread implements Runnable {

	private Socket client = null;
	private String name = "";// �����Ϊÿ���ͻ�������������

	// ���캯��
	public ServiceThread(Socket client, String name) {
		this.client = client;
		this.name = name;
		System.out.println("�ͻ���: " + this.name + " ����...");
	}

	public void run() {
		PrintStream out = null;
		BufferedReader buf = null;
		BufferedReader in = null;// ����BufferedReader����

		try {
			// �õ��ͻ��˵�������Ϣ
			buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// ʵ�����ͻ��˵������
			out = new PrintStream(client.getOutputStream());
			// ���ôӼ��̽�������
			in = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			while (flag) {
				// ���ϵĶ�ȡ�ͻ����������Ϣ
				InputStream inputStream = client.getInputStream();
				BufferedInputStream bufferInput = new BufferedInputStream(
						inputStream);
				byte[] bty = new byte[1024];
				int len = bufferInput.read(bty);
				String str = new String(bty, 0, len);

				System.out.println("�ͻ���: " + this.name + ": " + str);
				// ���ͻ������� �� �� end ʱ��ʾ����
				if (str == null || "".equals(str)
						|| "end".equalsIgnoreCase(str)) {
					flag = false;
					System.out.println("�ͻ���: " + this.name + " ����...");
				} else {
					System.out.println("������Ҫ���͸��ͻ���" + this.name + "����Ϣ...");
					String sInput = in.readLine();// �Ӽ��̽�������
					out.println(sInput);// ��ͻ��� ������Ϣ
				}
			}
			out.close();// �ر������
			client.close();// �رտͻ���
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

};

public class Service {

	/**
	 * �������
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {
		ServerSocket server = null; // ����ServerSocket����
		Socket client = null;// ����Socket����,��ʾ�ͻ���
		try {

			server = new ServerSocket(8888);// ��������˿� 10000
			System.out.println("������������,�ȴ��ͻ�������...");
			// һֱִ��,���տͻ�������
			while (true) {
				client = server.accept();// �ȴ��ͻ�������
				PrintStream out = new PrintStream(client.getOutputStream());

				// Ϊÿ���ͻ����������һ������
				int number = (int) (Math.random() * 100);
				String name = "client" + number;
				// ����һ���̶߳���
				new Thread(new ServiceThread(client, name)).start();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			// ������˲�Ϊnull,��رշ����ʵ��
			if (server != null) {
				server.close();
			}
		} catch (IOException e2) {

		}
	}

}
