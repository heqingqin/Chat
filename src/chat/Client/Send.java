package chat.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import chat.Utils.utils;

public class Send implements Runnable {
	private BufferedReader console ;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	public Send(Socket client, String name) {
		this.client =client;
		console =new BufferedReader(new InputStreamReader(System.in));
		this.isRunning = true;
		this.name = name;
		try {
			dos =new DataOutputStream(client.getOutputStream());
			//��������
			send(name);
		} catch (IOException e) {
			System.out.println("==1==");
			this.release();
		}	
	}

	//������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println(e);
				System.out.println("===3==");
				release();
			}
		}
		
		/**
		 * �ӿ���̨��ȡ��Ϣ
		 * @return
		 */
		private String getStrFromConsole() {
			try {
				return  console.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}
	@Override
	public void run() {
		while(isRunning) {
			String msg = getStrFromConsole();
			if(!msg.equals("")) {
				send(msg);
			 }
	    	}
		}
	//�ͷ���Դ
		private void release() {
			this.isRunning = false;
			utils.close(dos,client);
		}
}
