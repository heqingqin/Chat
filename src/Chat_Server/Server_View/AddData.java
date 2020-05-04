package Chat_Server.Server_View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Chat_Client.chat.View.chat_view;
import Chat_Client.chat_Main.chat_main;
import Chat_Server.Loginserver.recustome;
import Model.customerlistmodel;

public class AddData extends JFrame{
	AddData(){
		
		this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		this.setLocation(200, 300);
		this.setSize(300, 300);
		this.setTitle("�˺�ע��");
		 JPanel contentPane = new JPanel();
		 setContentPane(contentPane);
		 contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		 
		JPanel mainpanel = new JPanel();
		contentPane.add(mainpanel);
		mainpanel.setBorder(new EmptyBorder(30, 10, 10, 10));
		BoxLayout boxLayout = new BoxLayout(mainpanel, BoxLayout.Y_AXIS);
		mainpanel.setLayout(boxLayout);
		mainpanel.setAlignmentX(CENTER_ALIGNMENT);
		
		mainpanel.add(new JLabel("�˺�ע��"));
		JPanel accpanel = new JPanel();
		mainpanel.add(accpanel);
		accpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel acclabel = new JLabel("* �˺�:");
		accpanel.add(acclabel);
		JTextField accTextField = new JTextField(15);
		accpanel.add(accTextField);
		
		JPanel namedpanel = new JPanel();
		mainpanel.add(namedpanel);
		namedpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel namelabel = new JLabel("�û���:");
		namedpanel.add(namelabel);
		JTextField nameTextField = new JTextField(15);
		namedpanel.add(nameTextField);
		
		JPanel pwdpanel = new JPanel();
		mainpanel.add(pwdpanel);
		pwdpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel pwdlabel = new JLabel("* ����:");
		pwdpanel.add(pwdlabel);
		JTextField pwdTextField = new JTextField(15);
		pwdpanel.add(pwdTextField);
		
		JPanel whopanel = new JPanel();
		mainpanel.add(whopanel);
		whopanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel wholabel = new JLabel("  ���:");
		whopanel.add(wholabel);
		String str1[] = {"�û�", "����Ա"};  
		JComboBox who = new JComboBox(str1);
		whopanel.add(who);
		
		JPanel butpanel = new JPanel();
		butpanel.setLayout(new BorderLayout(10,10));
		contentPane.add(butpanel);
		JButton but1 = new JButton("ȡ��");
		butpanel.add(but1,BorderLayout.WEST);
		but1.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  accTextField.setText("");
	            	  nameTextField.setText("");
	            	  pwdTextField.setText("");
	            	  who.setSelectedIndex(0);
	           }                
	       }});
        
		
		JButton but2 = new JButton("�ύ");
		butpanel.add(but2,BorderLayout.EAST);
		but2.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	   String  Who ="�û�";
	            	   String acctext = accTextField.getText();
	            	   String nametext = nameTextField.getText();
	            	   String pwdtext = pwdTextField.getText();
	            	   if(who.getSelectedIndex()==1) {
	            		   Who = "����Ա";
	            	   }
	            	   if(!acctext.equals("")||!pwdtext.equals("")) {
	            	       try {
							boolean isok = new recustome().Recustome(acctext,nametext,pwdtext,Who);
						     if(!isok) {
						    	 JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ����ܸ��˺��Ѵ���","����",JOptionPane.WARNING_MESSAGE);
						     }else server_view.getTable().setModel(new customerlistmodel());
	            	       } catch (ClassNotFoundException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
	            	   }else  JOptionPane.showMessageDialog(null, "�˺Ż����벻��Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE);
	            	  accTextField.setText("");
	            	  nameTextField.setText("");
	            	  pwdTextField.setText("");
	            	  who.setSelectedIndex(0);
	           }                
	       }});
		
		this.setVisible(true);
	}
}
