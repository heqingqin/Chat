package chat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class chat_client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���:");
		String name =br.readLine();
		//1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
		Socket client =new Socket("169.254.10.146",8888);
		//2���ͻ��˷�����Ϣ
		new Thread(new Send(client,name)).start();  
		new Thread(new Receive(client)).start();
	}
}
