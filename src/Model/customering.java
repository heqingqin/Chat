package Model;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import Chat_Server.Customermsg.Customer;
import Chat_Server.Customermsg.CustomerList;
import Chat_Server.Server.Channel;
import Chat_Server.Server.chat_server;
import Chat_Server.Server_View.server_main;
import Chat_Server.Server_View.server_view;

public class customering{
private static ArrayList<Customerline> list;
    public customering(){
    	CopyOnWriteArrayList<Channel> all = chat_server.getAll();
    	for(int index = 0;index<all.size();index++) {
    		adddata(all.get(index));
    	}
   }
    
	public static void adddata(Channel c) {
		boolean t=false;
		ArrayList<Customer> list2 = CustomerList.getList();
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i).getAcc().equals(c.acc)) {
				Customerline customerline = new Customerline();
	    		customerline.setAcc(c.acc);
	    		customerline.setName(list2.get(i).getName());
	    		customerline.setWho(list2.get(i).getWho());
	    		list.add(customerline);
	    		System.out.println(c.acc+"����");
	    		server_view.getTableline().setModel(new customeringmodel());
	    		t=true;
			}
		}	
		if(!t) {
			System.out.println("�ó�Ա��δע���˺�!");
		}
	}
	
	static{
		if (list==null) {
			System.out.println("�����б�");
			list=new ArrayList<Customerline>();
		}
	}
	
	public static void add(Channel c){
		adddata(c);
	}
	
	public static void dele(String acc){
		for(int t=0;t<list.size();t++) {
			if(list.get(t).getAcc().equals(acc)) {
				list.remove(t);
				server_view.getTableline().setModel(new customeringmodel());
				return;
			}
			System.out.println(acc+"������");
		}
	    
	}
	
	public static ArrayList<Customerline> getList() {
		return list;
	}
}
