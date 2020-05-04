package Chat_Server.Customermsg;

import java.util.ArrayList;

public class CustomerList{
private static ArrayList<Customer> list;
	
	static{
		if (list==null) {
			System.out.println("创建列表");
			list=new ArrayList<Customer>();
		}
	}
	
	public static void add(Customer customer){
		
		list.add(customer);
	}
	
	public static ArrayList<Customer> getList() {
		return list;
	}
	
}
