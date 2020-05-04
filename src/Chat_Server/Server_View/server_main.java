package Chat_Server.Server_View;

import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Chat_Client.CustomerList.friend;
import Chat_Client.CustomerList.friendlist;
import Chat_Client.chat.View.chat_view;
import Chat_Server.Customermsg.CreateFile;
import Chat_Server.Customermsg.Customer;
import Chat_Server.Customermsg.CustomerList;
import Chat_Server.Customermsg.customerLeadin;
import Chat_Server.Server.Channel;
import Chat_Server.Server.chat_server;
import Model.Customerline;
import Model.customering;
import Model.customeringmodel;
import Model.customerlistmodel;

public class server_main {
	 static server_view frame;
	public static void main(String[] args) throws Exception {
		  new Thread(new RunServer()).start();
		frame = new server_view();
		  frame.setUndecorated(true);
	       frame.setVisible(true);//放在添加组件后面执行
	       CreateFile.Creatfile();
	       new customering();
	}
    
	
	public static void MinWindow() {
		// 窗口隐藏
				frame.setExtendedState(JFrame.ICONIFIED);
		
	}

	public static void exit() throws IOException {
		// 退出
		customerLeadin.Clear();
		customerLeadin.writeCustomer();
		System.exit(0);
		
	}

	public static boolean Login(String useracc, String upwd) {
		// 登录
		ArrayList<Customer> list = CustomerList.getList();
		for(Customer info:list) {
			if(("管理员").equals(info.getWho())&&(useracc.equals(info.getAcc()) && upwd.equals(info.getPwd()))) { 
//				return uname;    //成功
				return true;    //成功
			}
		}
//		   return"";
        	return false;   //失败
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

	public static void Search(String text) {
		// 搜索
		ArrayList<Customer> list = CustomerList.getList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAcc().equals(text)||list.get(i).getName().equals(text)) {
				for(int t=0;t<i;t++) {
				   Collections.swap(list,i,t);
				}
				frame.getTable().setModel(new customerlistmodel());
				frame.getTable().setRowSelectionInterval(0, 0); 
				frame.getTable().setSelectionBackground(Color.yellow);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "查不到"+text+"这个人！","错误",JOptionPane.WARNING_MESSAGE);
	}

	public static void Dele() {
		// 删除
		int index = frame.getTable().getSelectedRow();
		System.out.println(index);
		Channel.Dele(CustomerList.getList().get(index).getAcc());
		CustomerList.getList().remove(index);
		frame.getTable().setModel(new customerlistmodel());
	}

	public static void Add() {
		// 添加
		new AddData();
	}

	public static void InT() {
		int index = frame.getTableline().getSelectedRow();
		System.out.println("InT"+index);
		if(customering.getList().get(index).getIsline().equals("正常")) {
			Channel.isINT(customering.getList().get(index).getAcc(),true);
		     customering.getList().get(index).setIsline("禁言");
		     System.out.println(customering.getList().get(index).getAcc()+"禁言");
		 	 frame.getTableline().setModel(new customeringmodel());
		}else {
			Channel.isINT(customering.getList().get(index).getAcc(),false);
		     customering.getList().get(index).setIsline("正常");
		     System.out.println(customering.getList().get(index).getAcc()+"取消禁言");
		 	 frame.getTableline().setModel(new customeringmodel());
		}
	}

	public static void Deleline() {
		// 删除
		int index = frame.getTableline().getSelectedRow();
		System.out.println("Deleline"+index);
		String delacc = customering.getList().get(index).getAcc();
		for(int i=0;i<chat_server.getAll().size();i++) {
			if(chat_server.getAll().get(i).acc.equals(delacc)) {
				Channel.DeleLine(chat_server.getAll().get(i));
				chat_server.getAll().remove(i);
				break;
			}
		}
		customering.getList().remove(index);
		frame.getTableline().setModel(new customeringmodel());
		
	}


	public static void Searchline(String text) {
		// 搜索
				ArrayList<Customerline> list = customering.getList();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getAcc().equals(text)||list.get(i).getName().equals(text)) {
						for(int t=0;t<i;t++) {
						   Collections.swap(list,i,t);
						}
						frame.getTableline().setModel(new customeringmodel());
						frame.getTableline().setRowSelectionInterval(0, 0); 
						frame.getTableline().setSelectionBackground(Color.yellow);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "查不到"+text+"这个人！","错误",JOptionPane.WARNING_MESSAGE);
	}

}


class RunServer implements Runnable {
	@Override
	public void run() {
		try {
			new chat_server().Chat_server();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
	
}