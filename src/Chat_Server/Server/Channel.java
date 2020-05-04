package Chat_Server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import Chat_Server.Loginserver.Login_deal;
import Chat_Server.Utils.utils;
import Model.Customerline;
import Model.customering;

//һ���ͻ�����һ��Channel
public class Channel implements Runnable {
	private boolean pwderror=true;
	static boolean isrogin=false;
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean isRunning;
	private String LoginorRegin;
	static ArrayList<String> intok = new ArrayList<String>();
	public String acc;
	static String[] ret;
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�������ڸ�ʽ
	public Channel(Socket client) throws ClassNotFoundException {
		  this.client = client;
		  try {
			 //����
			 dis = new DataInputStream(client.getInputStream());
			 this.LoginorRegin = receive();
			 //�����֤
			 ret = Login_deal.login_deal(LoginorRegin).split(" ");
			 this.acc = ret[0]; 
			 dos = new DataOutputStream(client.getOutputStream());
			 if(ret[0].equals("ע��ʧ��!")||ret[0].equals("ע��ɹ�!")) {  //ע����Ϣ����
				 isrogin=true; 
				 System.out.println(ret[0]);
				 this.send("regin"+",&&,"+ret[0]);
				 return;
			 }
			 //����
			 if(ret.length==2) {     //��¼��Ϣ����
				 String people="��ӭ��ĵ���";
				 for(Channel other: chat_server.getAll()) {
					 people=people+",&&,"+other.acc;
				 }
				 this.send(people);
			 }else {
				 System.out.println(ret[0]);
				 this.send("login"+",&&,"+ret[0]);	
				 isRunning = false;
				 release(false);	
				 return;
			 }
			 sendOthers("---"+"ϵͳ��ʾ"+"---\n "+this.acc+" ����������\n",true);
			 isRunning =true;
		} catch (IOException e) {
			System.out.println(this.acc+"���ӷ�����ʧ��");
			release(false);			
		}
	}
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("����"+this.acc +"����Ϣʧ��");
			release(true);
		} 
		
	}

	private String receive() {
		String msg ="";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("����"+this.acc +"����Ϣʧ��");
			release(true);
		}
		return msg;
	}

	        //�ͷ���Դ
		private void release(boolean pwderror) {
			this.isRunning = false;
			utils.close(dis,dos,client);
			//�˳�
			chat_server.getAll().remove(this);
			customering.dele(this.acc);
			sendOthers("---"+"ϵͳ��ʾ"+"---\n "+this.acc+" �뿪���ͥ...\n",true);
			if(pwderror) {
			  --chat_server.clienttotal;
		 	}
			System.out.println("��ǰ�ͻ�������"+chat_server.clienttotal);
		}
		
		/**
		 * Ⱥ�ģ���ȡ�Լ�����Ϣ������������
		 *  ˽��: Լ�����ݸ�ʽ: @xxx:msg
		 * @param msg
		 */
	private void sendOthers(String msg, boolean isSys) {
		for(String intna:intok) {
			if(intna.equals(this.acc)) {
				return;
			}	
		}
		boolean isPrivate = msg.startsWith("@");
		if(isPrivate) { //˽��
			int idx =msg.indexOf(":");
			//��ȡĿ�������
			String targetname = msg.substring(1,idx);
			msg = msg.substring(idx+1);
			for(Channel other: chat_server.getAll()) {
				if(other.acc.equals(targetname)) {//Ŀ��
					other.send("---"+this.acc+"˽����  "+df.format(new Date())+"---\n  "+msg+"\n");
					break;
				}
			}
		}else {	
	      for(Channel other: chat_server.getAll()) {
			if(other==this) { //�Լ�
				continue;
			}
			if(!isSys) {
				other.send("---"+this.acc+" "+df.format(new Date())+"---\n  "+msg+"\n");//Ⱥ����Ϣ
				System.out.println("---"+this.acc+df.format(new Date())+"---\n  "+msg+"\n");
			}else {
				other.send(msg); //ϵͳ��Ϣ
			}
		
	      }
	      }
	}
	
	@Override
	public void run() {
		//����Ⱥ����Ϣ
		while(isRunning) {
	       String msg = receive();
			if(!msg.equals("")) {
				System.out.println(msg);
				sendOthers(msg,false);
			}
		}
		
	}
	
	public static void isINT(String intname,boolean isno) {
		for(Channel other: chat_server.getAll()) {
			if(intname.equals(other.acc)) {
				if(isno) {
					//����
					System.out.println("����"+intname);
					intok.add(intname);
					 for(Channel info: chat_server.getAll()) {
							if(info==other) { //�Լ�
								info.send("---"+"ϵͳ��ʾ"+"---\n "+"��"+" �Ѿ���������...\n"); //ϵͳ��Ϣ
							}else {
								info.send("---"+"ϵͳ��ʾ"+"---\n "+other.acc+" �Ѿ���������...\n"); //ϵͳ��Ϣ
							}
					 }
				}else {
					//�������
					intok.remove(intname);
					 for(Channel info: chat_server.getAll()) {
							if(info==other) { //�Լ�
								info.send("---"+"ϵͳ��ʾ"+"---\n "+"��"+" �Ѿ������������...\n"); //ϵͳ��Ϣ
							}else {
								info.send("---"+"ϵͳ��ʾ"+"---\n "+other.acc+" �Ѿ������������...\n"); //ϵͳ��Ϣ
							}
					 }
				}
			}
		}

	}
	public static void DeleLine(Channel channel) {
		// ����ԱҪ������
		 for(Channel info: chat_server.getAll()) {
				if(info==channel) { //�Լ�
					info.send("---"+"ϵͳ��ʾ"+"---\n "+"��"+" �Ѿ����߳�Ⱥ����...\n"); //ϵͳ��Ϣ
				}else {
					info.send("---"+"ϵͳ��ʾ"+"---\n "+channel.acc+" �Ѿ����߳�Ⱥ����...\n"); //ϵͳ��Ϣ
				}
		 }
		 channel.isRunning = false;
		 utils.close(channel.dis,channel.dos,channel.client);
		 
	}
	public static void Dele(String acc2) {
		 for(Channel info: chat_server.getAll()) {
			 if(info.acc.equals(acc2)) {
				 info.send("---"+"ϵͳ��ʾ"+"---\n "+"��"+" �Ѿ���ɾ���˺���...\n"); //ϵͳ��Ϣ
				 DeleLine(info);
			 }
		 }
		
	}
	
}
