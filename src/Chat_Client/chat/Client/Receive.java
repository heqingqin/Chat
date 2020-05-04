package Chat_Client.chat.Client;
/**
 * ʹ�ö��̷߳�װ:���ն�
*  1��������Ϣ
 * 2���ͷ���Դ
 * 3����дrun
 *
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import Chat_Client.CustomerList.customerlistmodel;
import Chat_Client.CustomerList.friend;
import Chat_Client.CustomerList.friendlist;
import Chat_Client.chat.Utils.utils;
import Chat_Client.chat.View.chat_view;

public class Receive implements Runnable {
	private Socket client;
	private boolean isRunning;
	private DataInputStream dis;
	ArrayList<friend> musiclist=friendlist.getList();
	public Receive(Socket client,boolean isregin) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());
			if(isregin) {
				String regin = "";
				regin = dis.readUTF();
				System.out.println(regin);
				chat_view.getTip().setText(regin);
				release();
			}
		} catch (IOException e) {
			System.out.println("1������Ϣʧ��");
			release();
		}
	}

		//�ͷ���Դ
		private void release() {
			this.isRunning = false;
			utils.close(dis,client);
		}
		
	@Override
	public void run() {
		while(isRunning) {
			 String msg = receive();
			    String[] people = null;
			    people =  msg.split(",&&,");
				if(!msg.equals("")) {
					if(people[0].equals("login")) {
						//�������
						chat_view.getTip().setText(people[1]);
						chat_view.islogin = false;
						System.out.println(people[1]);
					}else if(people[0].equals("regin")) {
						//ע�����
						if(people[1].equals("ע��ɹ�!")) {
							chat_view.getTip().setText(people[1]);
							chat_view.isregin = false;
						}else {
							chat_view.getTip().setText(people[1]);
							chat_view.isregin = true;
						}
						System.out.println(people[1]);
					}else if(people[0].equals("��ӭ��ĵ���")){
						leadinlist("��",chat_client.uname);
							for(int t=1;t<people.length;t++) {
								if(!people[t].equals(chat_client.uname))
								leadinlist(people[t],people[t]);
							}
						chat_view.islogin = true;
						 chat_view.	getShowcontent().setText("---ϵͳ��ʾ---\n  "+chat_view.getShowcontent().getText()+"  ��ӭ��ĵ���\n");
					     System.out.println("��ӭ��ĵ���");
					}else {
						 System.out.println(msg);
						 String temp="";
						 String[] s = msg.split(" ");
						 if(s[0].equals("---ϵͳ��ʾ---\n") && s[s.length-1].equals("����������\n")) {
							 for(int i=1;i<s.length-1;i++) {
								 temp=temp+s[i];
							 }
							 leadinlist(temp,temp);
							 chat_view.getTable().setModel(new customerlistmodel());
						 }
						 if(s[0].equals("---ϵͳ��ʾ---\n") && s[s.length-1].equals("�뿪���ͥ...\n")) {
							 for(int i=1;i<s.length-1;i++) {
								 temp=temp+s[i];
							 }
							for(int i=0;i<musiclist.size();i++) {
								 if(temp.equals(musiclist.get(i).getName()))
									 musiclist.remove(i);
								 chat_view.getTable().setModel(new customerlistmodel());
							 }
						 }
						 chat_view.	getShowcontent().setText(chat_view.getShowcontent().getText()+msg);
						 try {
							Thread.sleep(10);
							chat_view.getShowScroll().getVerticalScrollBar().setValue(chat_view.getShowScroll().getVerticalScrollBar().getMaximum());
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
					}
				}
		}
	}
	
	
	private void leadinlist(String name, String custm) {
		friend f = new friend();
		f.setName(name);
		f.setCustm(custm);
		musiclist.add(f);	
	}

	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("2������Ϣʧ��");
			release();
		}
		return msg;
	}
	

}
