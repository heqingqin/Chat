package Chat_Server.Loginserver;

import java.io.IOException;
import java.util.ArrayList;

import Chat_Server.Customermsg.Customer;
import Chat_Server.Customermsg.CustomerList;
import Chat_Server.Server.Channel;
import Chat_Server.Server.chat_server;


public class Login_deal {
	static String uname ="";
	static String upwd ="";
	static String reuacc ="";
	static String reupwd ="";
	static String reuname ="";
	static String reuwho ="用户";
	public static String login_deal(String login) throws ClassNotFoundException, IOException {
	  //分析
		String[] dataArray = login.split("&");
		for(String info:dataArray) {
				String[] userInfo =info.split("=");
				if(userInfo[0].equals("uname")) {
					System.out.println("你的用户名为:"+userInfo[1]);
					uname = userInfo[1];
				}else if(userInfo[0].equals("upwd")) {
					System.out.println("你的密码为:"+userInfo[1]);
					upwd = userInfo[1];
				}else if(userInfo[0].equals("reuname")) {
					System.out.println("你注册的用户名为:"+userInfo[1]);
					reuname = userInfo[1];
				}else if(userInfo[0].equals("reupwd")) {
					System.out.println("你注册的密码为:"+userInfo[1]);
					reupwd = userInfo[1];
					boolean isok = new Datadeal().Dataregin(reuname,reuname,reupwd,reuwho);
					if(isok) {
					   return "注册成功!";
					}else  return "注册失败!";
				}
		}
		
		for(Channel other: chat_server.getAll()) {
			if(other.acc.equals(uname)){
				System.out.println(uname+"已经在线！");
//				return ""; 
				return uname+"已经在线!"; 
			}
		}
		
		ArrayList<Customer> list = CustomerList.getList();
		for(Customer info:list) {
			if((uname.equals(info.getAcc()) && upwd.equals(info.getPwd()))) { 
//				return uname;    //成功
				return uname+" 登录成功";    //成功
			}
		}
//		   return"";
        	return "用户名或密码错误!";   //失败
	}
}
