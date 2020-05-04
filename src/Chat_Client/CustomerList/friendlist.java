package Chat_Client.CustomerList;

import java.util.ArrayList;

public class friendlist {
	private static ArrayList<friend> list;
	static{
		if (list==null) {
			System.out.println("创建列表");
			list=new ArrayList<friend>();
		}
	}
	
	public static void add(friend fri){
		list.add(fri);
	}
	
	public static ArrayList<friend> getList() {
		return list;
	}
	
}
