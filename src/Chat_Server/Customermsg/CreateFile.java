package Chat_Server.Customermsg;


import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
//创建customer文件夹
public class CreateFile {
	public static void Creatfile() throws ClassNotFoundException, IOException {
		String Newfile = System.getProperty("user.dir");
		String customerfile1 = Newfile + "\\customer";
		System.out.println(customerfile1);
		File filecustomer = new File(customerfile1);
		if (!filecustomer.exists()) { // 如果文件夹不存在
			filecustomer.mkdir();// 创建customer文件夹
		}		
		if(filecustomer.exists()) {
			customerLeadin.readCustomer();
			}else //文件夹创建失败
				JOptionPane.showMessageDialog(null, "用户文件夹不存在!", "错误", JOptionPane.ERROR_MESSAGE);
	}
	  
}
