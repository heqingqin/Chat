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
	System.out.println("-----服务器正在启动-----");
	
	//	1、指定端口 使用ServerSocket创建服务器
	ServerSocket server = new ServerSocket(8888);
//	 CreateFile.Creatfile();
	//	2、阻塞式等待连接 accept
	while(true) {
		Socket client = server.accept();
		Channel c =new Channel(client);
		if(!Channel.isrogin && Channel.ret.length==2) {
			System.out.println("第"+(++clienttotal)+"个客户端创建连接");
			System.out.println("当前客户端数："+clienttotal);
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

