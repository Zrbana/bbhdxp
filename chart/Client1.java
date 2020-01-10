import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {

	/**
	 * �ͻ�����
	 */
	public static void main(String[] args) {
		Socket client = null;// ����Socket����
		BufferedReader buf = null;// ���շ���˷��ͻ�������Ϣ
		PrintStream out = null;// �����˷�����Ϣ
		BufferedReader input = null;// ����BufferedReader����
		try {
			// ����ָ�����ӷ���˵�ip �� �˿�,
			// ip���Ƿ���˵�ip,���� �ڱ���ģ��,������localhost
			// �˿�Ҫ�ͷ�����������õļ����˿�һ��
			client = new Socket("localhost", 8888);
			// ��ȡ�����ip
			InetAddress ip = client.getInetAddress();
			// ���ôӼ��̽�������
			input = new BufferedReader(new InputStreamReader(System.in));
			// �����������Ϣ
			out = new PrintStream(client.getOutputStream());
			// ���շ����������Ϣ
			buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			boolean flag = true;
			while (flag) {
				System.out.println("������Ҫ���͸������" + ip + "��Ϣ,������ end ʱ�˳�...");
				String str = input.readLine();// �Ӽ��̽�������
				out.print(str);// ��������������
				// ���ͻ������� �� �� end ʱ��ʾ����
				if (str == null || "".equals(str)
						|| "end".equalsIgnoreCase(str)) {
					flag = false;
				} else {
					String ss = buf.readLine();
					System.out.println("����� " + ip + ": " + ss);
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
