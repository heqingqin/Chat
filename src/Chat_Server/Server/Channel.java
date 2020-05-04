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

//一个客户代表一个Channel
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
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
	public Channel(Socket client) throws ClassNotFoundException {
		  this.client = client;
		  try {
			 //接收
			 dis = new DataInputStream(client.getInputStream());
			 this.LoginorRegin = receive();
			 //身份验证
			 ret = Login_deal.login_deal(LoginorRegin).split(" ");
			 this.acc = ret[0]; 
			 dos = new DataOutputStream(client.getOutputStream());
			 if(ret[0].equals("注册失败!")||ret[0].equals("注册成功!")) {  //注册信息返回
				 isrogin=true; 
				 System.out.println(ret[0]);
				 this.send("regin"+",&&,"+ret[0]);
				 return;
			 }
			 //发送
			 if(ret.length==2) {     //登录信息返回
				 String people="欢迎你的到来";
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
			 sendOthers("---"+"系统提示"+"---\n "+this.acc+" 来了聊天室\n",true);
			 isRunning =true;
		} catch (IOException e) {
			System.out.println(this.acc+"连接服务器失败");
			release(false);			
		}
	}
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("发送"+this.acc +"的消息失败");
			release(true);
		} 
		
	}

	private String receive() {
		String msg ="";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("接收"+this.acc +"的消息失败");
			release(true);
		}
		return msg;
	}

	        //释放资源
		private void release(boolean pwderror) {
			this.isRunning = false;
			utils.close(dis,dos,client);
			//退出
			chat_server.getAll().remove(this);
			customering.dele(this.acc);
			sendOthers("---"+"系统提示"+"---\n "+this.acc+" 离开大家庭...\n",true);
			if(pwderror) {
			  --chat_server.clienttotal;
		 	}
			System.out.println("当前客户端数："+chat_server.clienttotal);
		}
		
		/**
		 * 群聊：获取自己的消息，发给其他人
		 *  私聊: 约定数据格式: @xxx:msg
		 * @param msg
		 */
	private void sendOthers(String msg, boolean isSys) {
		for(String intna:intok) {
			if(intna.equals(this.acc)) {
				return;
			}	
		}
		boolean isPrivate = msg.startsWith("@");
		if(isPrivate) { //私聊
			int idx =msg.indexOf(":");
			//获取目标和数据
			String targetname = msg.substring(1,idx);
			msg = msg.substring(idx+1);
			for(Channel other: chat_server.getAll()) {
				if(other.acc.equals(targetname)) {//目标
					other.send("---"+this.acc+"私聊您  "+df.format(new Date())+"---\n  "+msg+"\n");
					break;
				}
			}
		}else {	
	      for(Channel other: chat_server.getAll()) {
			if(other==this) { //自己
				continue;
			}
			if(!isSys) {
				other.send("---"+this.acc+" "+df.format(new Date())+"---\n  "+msg+"\n");//群聊消息
				System.out.println("---"+this.acc+df.format(new Date())+"---\n  "+msg+"\n");
			}else {
				other.send(msg); //系统消息
			}
		
	      }
	      }
	}
	
	@Override
	public void run() {
		//发送群聊消息
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
					//禁言
					System.out.println("禁言"+intname);
					intok.add(intname);
					 for(Channel info: chat_server.getAll()) {
							if(info==other) { //自己
								info.send("---"+"系统提示"+"---\n "+"您"+" 已经被禁言了...\n"); //系统消息
							}else {
								info.send("---"+"系统提示"+"---\n "+other.acc+" 已经被禁言了...\n"); //系统消息
							}
					 }
				}else {
					//解除禁言
					intok.remove(intname);
					 for(Channel info: chat_server.getAll()) {
							if(info==other) { //自己
								info.send("---"+"系统提示"+"---\n "+"您"+" 已经被解除禁言了...\n"); //系统消息
							}else {
								info.send("---"+"系统提示"+"---\n "+other.acc+" 已经被解除禁言了...\n"); //系统消息
							}
					 }
				}
			}
		}

	}
	public static void DeleLine(Channel channel) {
		// 管理员要你下线
		 for(Channel info: chat_server.getAll()) {
				if(info==channel) { //自己
					info.send("---"+"系统提示"+"---\n "+"您"+" 已经被踢出群聊了...\n"); //系统消息
				}else {
					info.send("---"+"系统提示"+"---\n "+channel.acc+" 已经被踢出群聊了...\n"); //系统消息
				}
		 }
		 channel.isRunning = false;
		 utils.close(channel.dis,channel.dos,channel.client);
		 
	}
	public static void Dele(String acc2) {
		 for(Channel info: chat_server.getAll()) {
			 if(info.acc.equals(acc2)) {
				 info.send("---"+"系统提示"+"---\n "+"您"+" 已经被删除账号了...\n"); //系统消息
				 DeleLine(info);
			 }
		 }
		
	}
	
}
