package Chat_Server.Customermsg;


import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
//����customer�ļ���
public class CreateFile {
	public static void Creatfile() throws ClassNotFoundException, IOException {
		String Newfile = System.getProperty("user.dir");
		String customerfile1 = Newfile + "\\customer";
		System.out.println(customerfile1);
		File filecustomer = new File(customerfile1);
		if (!filecustomer.exists()) { // ����ļ��в�����
			filecustomer.mkdir();// ����customer�ļ���
		}		
		if(filecustomer.exists()) {
			customerLeadin.readCustomer();
			}else //�ļ��д���ʧ��
				JOptionPane.showMessageDialog(null, "�û��ļ��в�����!", "����", JOptionPane.ERROR_MESSAGE);
	}
	  
}
