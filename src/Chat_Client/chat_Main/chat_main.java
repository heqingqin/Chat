package Chat_Client.chat_Main;

import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Chat_Client.CustomerList.customerlistmodel;
import Chat_Client.CustomerList.friend;
import Chat_Client.CustomerList.friendlist;
import Chat_Client.chat.Client.chat_client;
import Chat_Client.chat.View.chat_view;

public class chat_main {
	static chat_view frame;
	static int Id=-1;
	public static void main(String[] args){
		  frame = new chat_view();
		  frame.setUndecorated(true);
	       frame.setVisible(true);//放在添加组件后面执行
	}
	public static void exit() {
		// 退出
		System.exit(0);
	}

	public static void MinWindow() {
		// 窗口隐藏
		frame.setExtendedState(JFrame.ICONIFIED);
	}

	public static void PanelFullScree(boolean IS) {
		if(IS) {
		     frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		     frame.getBigorsmall().setIcon(new ImageIcon(chat_view.class.getResource("/images/changesmall.png")));
		}else {
			frame.setExtendedState(Frame.NORMAL);
			frame.getBigorsmall().setIcon(new ImageIcon(chat_view.class.getResource("/images/changebig.png")));
		}
	
	}


	public static void Login(String name, String pwd) throws Exception {
		new chat_client(name,pwd,false);
	}
	
	public static void Regin(String name, String pwd) throws Exception {
		// 注册账户
		new chat_client(name,pwd,true);
		String regin = name+" "+pwd;
		System.out.println(regin);
	}
	
	public static void Search(String text) {
		ArrayList<friend> list = friendlist.getList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(text)) {
				for(int t=0;t<i;t++) {
				   Collections.swap(list,i,t);
				}
				frame.getTable().setModel(new customerlistmodel());
				frame.getTable().setRowSelectionInterval(0, 0); 
				frame.getTable().setSelectionBackground(Color.yellow);
				frame.message="";
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "查不到"+text+"这个人！","错误",JOptionPane.WARNING_MESSAGE);
	}
	public static void ClickList() {
		int id = frame.getTable().getSelectedRow();
		System.out.print("id="+id);
		if(Id==id) {
			frame.message="";
			frame.getTable().setSelectionBackground(Color.WHITE);
			Id=-1;
		}else {
			Id=id;
			frame.getTable().setRowSelectionInterval(Id, Id); 
			frame.getTable().setSelectionBackground(Color.green);
			String string = frame.getTable().getValueAt(Id,0).toString();
			 String name = string.substring(string.indexOf("(")+1,string.indexOf(")"));
			frame.message = "@"+name+":";
			System.out.print(frame.message);
		}
	}
}
