package Chat_Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import Chat_Server.Customermsg.CreateFile;
import Model.customering;



public class chat_server{ 
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	static int clienttotal=0;
public void Chat_server() throws Exception{
	System.out.println("-----��������������-----");
	
	//	1��ָ���˿� ʹ��ServerSocket����������
	ServerSocket server = new ServerSocket(8888);
//	 CreateFile.Creatfile();
	//	2������ʽ�ȴ����� accept
	while(true) {
		Socket client = server.accept();
		Channel c =new Channel(client);
		if(!Channel.isrogin && Channel.ret.length==2) {
			System.out.println("��"+(++clienttotal)+"���ͻ��˴�������");
			System.out.println("��ǰ�ͻ�������"+clienttotal);
			all.add(c);
			try {
			   customering.adddata(c);
			}catch(NullPointerException e) {
				
			}
			new Thread(c).start();
	   }else Channel.isrogin = false;
	}
  }
	public static CopyOnWriteArrayList<Channel> getAll() {
		return all;
	}

}

