package Chat_Server.Loginserver;

import java.io.IOException;
import java.util.ArrayList;
import Chat_Server.Customermsg.Customer;
import Chat_Server.Customermsg.CustomerList;
import Chat_Server.Customermsg.customerLeadin;
import Chat_Server.Server_View.server_view;
import Model.customerlistmodel;

public class Datadeal {
	ArrayList<Customer> list = CustomerList.getList();
	public boolean Dataregin(String reacc,String rename, String reupwd ,String Who) throws ClassNotFoundException, IOException {
		Customer customer = new Customer();
		for(Customer info:list) {
			if(info.getAcc().equals(reacc)) {
				System.out.println("该用户名已经存在！");
				return false;
			}
		}
		customer.setAcc(reacc);
		customer.setName(rename);
		customer.setPwd(reupwd);
		customer.setWho(Who);
		list.add(customer);
		server_view.getTable().setModel(new customerlistmodel());
		customerLeadin.writeCustomer();
		return true;
	}

}
