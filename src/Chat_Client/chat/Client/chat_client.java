package Chat_Client.chat.Client;

import java.net.Socket;

public class chat_client {
	static String uname="";
	public chat_client(String uname,String upwd,boolean isre) throws Exception {
		this.uname=uname;
		//1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
		Socket client =new Socket("localhost",8888);
		//2���ͻ��˷�����Ϣ
		//�ж��Ƿ�Ϊע���˻�
		if(isre) {
			new Send(client,"reuname="+uname+"&"+"reupwd="+upwd,true);
			new Receive(client,true);
		}else {
			new Thread(new Send(client,"uname="+uname+"&"+"upwd="+upwd,false)).start();  
			new Thread(new Receive(client,false)).start();
		}
	}
}