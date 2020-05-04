package chat.Client;
/**
 * 使用多线程封装:接收端
*  1、接收消息
 * 2、释放资源
 * 3、重写run
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
			System.out.println("接收消息失败");
			release();
		}
	}

	//释放资源
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
			System.out.println("接收消息失败");
			release();
		}
		return msg;
	}

}
