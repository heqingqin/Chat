package Chat_Client.chat.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import Chat_Client.chat.Utils.utils;


public class Send implements Runnable {
	private BufferedReader console ;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String LoginorRegin;
	static String Msg="";
	public Send(Socket client, String LoginorRegin,boolean isregin) throws InterruptedException {
		this.client =client;
		this.isRunning = true;
		this.LoginorRegin = LoginorRegin;
		try {
			dos =new DataOutputStream(client.getOutputStream());
			//发送名称
			send(LoginorRegin);
			if(isregin) {
			dos.close();
			}
		} catch (IOException e) {
			System.out.println("发送身份验证信息");
			this.release();
		}	
	}
	
	//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("发送信息失败");
				release();
			}finally {
				Msg = "";
			}
		}
		
	
		
	@Override
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(!Msg.equals("")) {
				send(Msg);	
			 }
	    	}
		}
	//释放资源
		private void release() {
			this.isRunning = false;
			utils.close(dos,client);
		}
		
		public static void Msg(String content) {
			Msg = content;
		}
	
}
