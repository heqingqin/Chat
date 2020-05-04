package chat.Client;
/**
 * ʹ�ö��̷߳�װ:���ն�
*  1��������Ϣ
 * 2���ͷ���Դ
 * 3����дrun
 *
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import chat.Utils.utils;
public class Receive implements Runnable {
	private Socket client;
	private boolean isRunning;
	private DataInputStream dis;
	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			System.out.println("������Ϣʧ��");
			release();
		}
	}

	//�ͷ���Դ
		private void release() {
			this.isRunning = false;
			utils.close(dis,client);
		}
		
	@Override
	public void run() {
		while(isRunning) {
				String msg = receive();
				if(!msg.equals("")) {
					System.out.println(msg);
				}
		}
	}

	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("������Ϣʧ��");
			release();
		}
		return msg;
	}

}
