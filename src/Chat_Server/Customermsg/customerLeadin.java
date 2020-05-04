package Chat_Server.Customermsg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class customerLeadin {
	private static String path = System.getProperty("user.dir")+"\\customer\\customer.txt";
	public static void writeCustomer() throws IOException {
		// 将歌曲文件路径记录
		ArrayList<String> list = new ArrayList<>();
		Clear();
		for(int i=0;i<CustomerList.getList().size();i++) {
			list.add(CustomerList.getList().get(i).getAcc()+",,"+CustomerList.getList().get(i).getName()+",,"+CustomerList.getList().get(i).getPwd()+",,"+CustomerList.getList().get(i).getWho());
		}
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.close();
	}

	
	public static void readCustomer() throws ClassNotFoundException, IOException {
		File f = new File(path);
		ArrayList<Customer> List=CustomerList.getList();
		if (!f.exists() || f.length() == 0) {
			System.out.println("文件为空！");
		} else {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<String> list = (ArrayList<String>) ois.readObject();
			ois.close();
			for(int i=0; i<list.size(); i++) {
			 String[] chars = list.get(i).split(",,"); 
			 Customer customer= new Customer();
			 customer.setAcc(chars[0]);
			 customer.setName(chars[1]);
			 customer.setPwd(chars[2]);
			 customer.setWho(chars[3]);
			 List.add(customer);
			}
		}
	}
	
	
	  public static void  Clear(){
		  File filename = new File(path); // 输入要删除的文件位置
			if(filename.exists())
				filename.delete();
	  }
	
}
