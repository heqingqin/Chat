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
	static String reuwho ="�û�";
	public static String login_deal(String login) throws ClassNotFoundException, IOException {
	  //����
		String[] dataArray = login.split("&");
		for(String info:dataArray) {
				String[] userInfo =info.split("=");
				if(userInfo[0].equals("uname")) {
					System.out.println("����û���Ϊ:"+userInfo[1]);
					uname = userInfo[1];
				}else if(userInfo[0].equals("upwd")) {
					System.out.println("�������Ϊ:"+userInfo[1]);
					upwd = userInfo[1];
				}else if(userInfo[0].equals("reuname")) {
					System.out.println("��ע����û���Ϊ:"+userInfo[1]);
					reuname = userInfo[1];
				}else if(userInfo[0].equals("reupwd")) {
					System.out.println("��ע�������Ϊ:"+userInfo[1]);
					reupwd = userInfo[1];
					boolean isok = new Datadeal().Dataregin(reuname,reuname,reupwd,reuwho);
					if(isok) {
					   return "ע��ɹ�!";
					}else  return "ע��ʧ��!";
				}
		}
		
		for(Channel other: chat_server.getAll()) {
			if(other.acc.equals(uname)){
				System.out.println(uname+"�Ѿ����ߣ�");
//				return ""; 
				return uname+"�Ѿ�����!"; 
			}
		}
		
		ArrayList<Customer> list = CustomerList.getList();
		for(Customer info:list) {
			if((uname.equals(info.getAcc()) && upwd.equals(info.getPwd()))) { 
//				return uname;    //�ɹ�
				return uname+" ��¼�ɹ�";    //�ɹ�
			}
		}
//		   return"";
        	return "�û������������!";   //ʧ��
	}
}
