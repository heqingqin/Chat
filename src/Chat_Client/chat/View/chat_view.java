package Chat_Client.chat.View;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import Chat_Client.CustomerList.customerlistmodel;
import Chat_Client.chat.Client.Send;
import Chat_Client.chat_Main.chat_main;


public class chat_view extends JFrame{
	static String username="";
	static JPanel contentPane;
	static JPanel contentPanelogin;
	static JPanel contentPaneregin;
	private TableColumn column;
	JPanel meunPanel;
	JPanel chattalknamepanel;
	JPanel syspanel;
	JPanel chatgrappanel;
	JPanel mainpanel;
	JPanel talkmainpanel;
	JPanel showtalkpanel;
	JPanel inputpanel;
	JPanel inputtxtpanel;
	JPanel inputbutpanel;
	JPanel login;
    JLabel chattalknamelabel;
    JLabel hidden;
    JLabel bigorsmall;
    JLabel close;
    JLabel chatLabel;
    JLabel inputLabel;
    JLabel uname;
    JLabel upass;
    JLabel upassagain;
    static JLabel tip;
    JButton sendbut;
    JButton clearbut;
    JButton loginbut;
    JButton newnamebut;
    JButton searchbut;
    static JTable table;
    static JTextArea inputcontent = new JTextArea(4,100);
    JScrollPane contentScroll;
    static JTextArea showcontent = new JTextArea(10,100);;
    static JPasswordField password;
    static JPasswordField repassword;
    JPasswordField passwordagain;
    static TextField tf_name;
    static JTextField searchfield;
    static TextField retf_name;
    static JScrollPane showScroll;
    JScrollPane listjs;
    public static String message ="";
    boolean IS = true;
    public static boolean islogin = false;
    public static boolean isregin = false;
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�������ڸ�ʽ
    public chat_view(){
    	ReSizeEvent dg = new ReSizeEvent(this);        /**�������������**/        
	    this.addMouseListener(dg);        
		this.addMouseMotionListener(dg); 
		setBounds(160,100,550,350);	//���ô��ڴ�С	
		Toolkit tool=this.getToolkit();
     	 Image im=tool.getImage(Frame.class.getResource("/images/chat.png"));
     	 this.setIconImage(im);
 		 keyListner();
     	 contentPanelogin = new JPanel();
     	 setContentPane(contentPanelogin);
     	contentPanelogin.setLayout(new BorderLayout(0, 0));
     	contentPanelogin.setBackground(null);
     	contentPanelogin.setOpaque(false);
		 
		 
		//�˵���
         meunPanel = new JPanel();
         meunPanel.setBackground(new Color(51,51,204)); // ���ô��屳����ɫ
         contentPanelogin.add(meunPanel,BorderLayout.NORTH);
         meunPanel.setPreferredSize(new Dimension(846, 63));//�ؼ�����,����JPanel�Ĵ�С 
         meunPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
         meunPanel.setLayout(new BorderLayout(10, 10));
         
         chattalknamepanel = new JPanel();
         meunPanel.add(chattalknamepanel,BorderLayout.CENTER);
         chattalknamepanel.setBackground(null);
         chattalknamepanel.setOpaque(false);
         chattalknamepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         chattalknamelabel = new JLabel("��¼ҳ��");
         chattalknamepanel.add(chattalknamelabel);
         chattalknamelabel.setForeground(Color.WHITE);
         chattalknamelabel.setFont(new java.awt.Font("΢���ź�", 1, 25));
         //ϵͳ���ư�ť
         syspanel = new JPanel();
         meunPanel.add(syspanel,BorderLayout.EAST);
         syspanel.setBackground(null);
         syspanel.setOpaque(false);
         syspanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
         
         

         hidden = new JLabel("");
         syspanel.add(hidden);
         hidden.setToolTipText("��С��");
         hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/hidden.png")));
         hidden.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  chat_main.MinWindow();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/selecthidden.png")));
	        } public void mouseExited(MouseEvent e) {
	        	 hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/hidden.png")));
	        }});
         
         close = new JLabel("");
         syspanel.add(close);
         close.setToolTipText("�ر�");
         close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
         close.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  chat_main .exit();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	          close.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectclose.png")));
	        } public void mouseExited(MouseEvent e) {
	        	close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
	        }});
         

         login=new JPanel(new GridLayout(7,1));//����һ���µİ���
         contentPanelogin.add(login,BorderLayout.SOUTH);
         
         JLabel Label = new JLabel("��ӭ��¼������",JLabel.CENTER);
         login.add(Label);
         Label.setForeground(Color.gray);
         Label.setFont(new java.awt.Font("΢���ź�", 1, 20));
         Label.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
 
         JPanel pan1 = new JPanel();
         login.add(pan1);
         pan1.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
       
         
         JPanel pan2=new JPanel();//����һ���µİ���
         login.add(pan2);
         pan2.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         uname=new JLabel("�û���:");
         pan2.add(uname);
         uname.setForeground(Color.black);
         uname.setFont(new java.awt.Font("΢���ź�", 1, 15));
         tf_name=new TextField(20);
         tf_name.setText("");
         pan2.add(tf_name);
         tf_name.setForeground(Color.black);
         tf_name.setFont(new java.awt.Font("����", 1, 15));


         JPanel pan3=new JPanel();//����һ���µİ���
         login.add(pan3);
         upass = new JLabel("��     ��:");
         pan3.add(upass);
         pan3.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         upass.setForeground(Color.black);
         upass.setFont(new java.awt.Font("΢���ź�", 1, 15));
         password=new JPasswordField(20);
         password.setEchoChar('*');
         pan3.add(password);
         password.setForeground(Color.black);
         password.setFont(new java.awt.Font("����", 1, 15));


         JPanel pan4 = new JPanel();
         login.add(pan4);
         pan4.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         pan4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         JButton newnamebut=new JButton("ע��");
         pan4.add(newnamebut);
         newnamebut.setFocusPainted(false);
         newnamebut.setToolTipText("ע��");
         newnamebut.setBackground(Color.WHITE);
         newnamebut.setForeground(Color.black);
         newnamebut.setFont(new java.awt.Font("΢���ź�", 1, 15));
         newnamebut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  isregin = true;
	            	  islogin = false;
	            	 login.setVisible(false);
	            	 Regin();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  newnamebut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	newnamebut.setBackground(Color.WHITE);
	        }});
        
         JButton jButton = new JButton("   ");
         pan4.add(jButton);
         jButton.setFocusPainted(false);
         jButton.setBorderPainted(false);
         jButton.setContentAreaFilled(false);
         jButton.setFocusPainted(false);
         JButton loginbut=new JButton("��½");
         pan4.add(loginbut);
         loginbut.setFocusPainted(false);
         loginbut.setToolTipText("��½");
         loginbut.setBackground(Color.green);
         loginbut.setForeground(Color.black);
         loginbut.setFont(new java.awt.Font("΢���ź�", 1, 15));
         loginbut.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 try {
	            		 username = tf_name.getText();
	            		 tip.setText("��¼��....");
	            		 if(!username.equals("") && !new String(password.getPassword()).equals("")) {
						    chat_main.Login(username,new String(password.getPassword()));
	            		 }else tip.setText("�û��������벻��Ϊ�գ�");
	            		 password.setText("");
	            		 tf_name.setText("");
						Thread.sleep(100);
						if(islogin) {
							  contentPanelogin.setVisible(false);
							  GUIini();
						}
					} catch (Exception e1) {
						tip.setText("���ӷ�����ʧ�ܣ�");
						islogin = false;
					}
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  loginbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	loginbut.setBackground(Color.green);
	        }});
        
         
         JPanel pan5 = new JPanel();
         login.add(pan5);
         pan5.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         
         JPanel pan6 = new JPanel(new BorderLayout(0,0));
         login.add(pan6);
         tip = new JLabel("",JLabel.CENTER);
         pan6.add(tip,BorderLayout.CENTER);
         tip.setForeground(Color.black);
         tip.setFont(new java.awt.Font("΢���ź�", 1, 25));
         pan6.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         }
     
    //ע��
    protected void Regin() {
    	contentPaneregin=new JPanel(new GridLayout(7,1));//����һ���µİ���
        contentPanelogin.add(contentPaneregin,BorderLayout.SOUTH);
        
        JLabel Label = new JLabel("���ѽ���ע��ҳ��",JLabel.CENTER);
        contentPaneregin.add(Label);
        Label.setForeground(Color.gray);
        Label.setFont(new java.awt.Font("΢���ź�", 1, 20));
        Label.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ

        JPanel pan1 = new JPanel();
        contentPaneregin.add(pan1);
        pan1.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
      
        
        JPanel pan2=new JPanel();//����һ���µİ���
        contentPaneregin.add(pan2);
        pan2.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
        uname=new JLabel("��      ��      ��:");
        pan2.add(uname);
        uname.setForeground(Color.black);
        uname.setFont(new java.awt.Font("΢���ź�", 1, 15));
        retf_name=new TextField(20);
        retf_name.setText("");
        pan2.add(retf_name);
        retf_name.setForeground(Color.black);
        retf_name.setFont(new java.awt.Font("����", 1, 15));


        JPanel pan3=new JPanel();//����һ���µİ���
        contentPaneregin.add(pan3);
        upass = new JLabel("�� �� �� �� ��:");
        pan3.add(upass);
        pan3.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
        upass.setForeground(Color.black);
        upass.setFont(new java.awt.Font("΢���ź�", 1, 15));
        repassword=new JPasswordField(20);
        repassword.setEchoChar('*');
        pan3.add(repassword);
        repassword.setForeground(Color.black);
        repassword.setFont(new java.awt.Font("����", 1, 15));

        JPanel pan5 = new JPanel();
        contentPaneregin.add(pan5);
        upassagain = new JLabel("������������:");
        pan5.add(upassagain);
        pan5.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
        upassagain.setForeground(Color.black);
        upassagain.setFont(new java.awt.Font("΢���ź�", 1, 15));
        passwordagain = new JPasswordField(20);
        passwordagain.setEchoChar('*');
        pan5.add(passwordagain);
        passwordagain.setForeground(Color.black);
        passwordagain.setFont(new java.awt.Font("����", 1, 15));

        
        
        JPanel pan4 = new JPanel();
        contentPaneregin.add(pan4);
        pan4.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
        pan4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JButton backlogin=new JButton("����");
        pan4.add(backlogin);
        backlogin.setFocusPainted(false);
        backlogin.setToolTipText("����");
        backlogin.setBackground(Color.WHITE);
        backlogin.setForeground(Color.black);
        backlogin.setFont(new java.awt.Font("΢���ź�", 1, 15));
        backlogin.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	//���ص�¼����
	            	  retf_name.setText("");
	            	  repassword.setText("");
	            	  passwordagain.setText("");
	            	  contentPaneregin.setVisible(false);
	            	  login.setVisible(true);
	            	  isregin = false;
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  backlogin.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	backlogin.setBackground(Color.WHITE);
	        }});
       
        JButton jButton = new JButton("   ");
        pan4.add(jButton);
        jButton.setFocusPainted(false);
        jButton.setBorderPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        JButton okbut=new JButton("�ύ");
        pan4.add(okbut);
        okbut.setFocusPainted(false);
        okbut.setToolTipText("�ύ");
        okbut.setBackground(Color.green);
        okbut.setForeground(Color.black);
        okbut.setFont(new java.awt.Font("΢���ź�", 1, 15));
        okbut.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 	//�����뷢�͵�������
	            	  tip.setText("ע����...");
	            	  String repwd = new String(repassword.getPassword());
	            	  String repwdagain = new String(passwordagain.getPassword());
	            	  if(!retf_name.getText().equals("")&&!repwd.equals("")&&repwd.equals(repwdagain)) {
	            		  try {
							chat_main.Regin(retf_name.getText(),repwd);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
	            	  }else {
	            		  tip.setText("�û������������벻����Ҫ��");
	            	  }
	            	  retf_name.setText("");
	            	  repassword.setText("");
	            	  passwordagain.setText("");
	            	  try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
//	            	  if(!isregin) {
	            		  contentPaneregin.setVisible(false);
		            	  login.setVisible(true);
		            	  isregin = false;
//	            	  }
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  okbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	okbut.setBackground(Color.green);
	        }});
       
        
        
        JPanel pan6 = new JPanel(new BorderLayout(0,0));
        contentPaneregin.add(pan6);
        tip = new JLabel("",JLabel.CENTER);
        pan6.add(tip,BorderLayout.CENTER);
        tip.setForeground(Color.black);
        tip.setFont(new java.awt.Font("΢���ź�", 1, 25));
        pan6.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
		
	}

	//��ҳ��
    public void GUIini(){
		setTitle("�������");//�����
		setBounds(160,100,845,850);	//���ô��ڴ�С	
		this.setMinimumSize(new Dimension(510, 500));
		Toolkit tool=this.getToolkit();
      	 Image im=tool.getImage(Frame.class.getResource("/images/chat.png"));
      	 this.setVisible(true);
      	 this.setIconImage(im);
      	 contentPane=new JPanel();
		 setContentPane(contentPane);
		 contentPane.setLayout(new BorderLayout(0, 0));
		 contentPane.setBackground(null);
		 contentPane.setOpaque(false);
			
		//�˵���
         meunPanel = new JPanel();
         meunPanel.setBackground(new Color(51,51,204)); // ���ô��屳����ɫ
         contentPane.add(meunPanel,BorderLayout.NORTH);
         meunPanel.setPreferredSize(new Dimension(846, 63));//�ؼ�����,����JPanel�Ĵ�С 
         meunPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
         meunPanel.setLayout(new BorderLayout(10, 10));
         
         //Ⱥ������
         chattalknamepanel = new JPanel();
         meunPanel.add(chattalknamepanel,BorderLayout.CENTER);
         chattalknamepanel.setBackground(null);
         chattalknamepanel.setOpaque(false);
         chattalknamepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         chattalknamelabel = new JLabel("�ҵ�Ⱥ��");
         chattalknamepanel.add(chattalknamelabel);
         chattalknamelabel.setForeground(Color.WHITE);
         chattalknamelabel.setFont(new java.awt.Font("΢���ź�", 3, 35));
         
         //ϵͳ���ư�ť
         syspanel = new JPanel();
         meunPanel.add(syspanel,BorderLayout.EAST);
         syspanel.setBackground(null);
         syspanel.setOpaque(false);
         syspanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
         
         hidden = new JLabel("");
         syspanel.add(hidden);
         hidden.setToolTipText("��С��");
         hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/hidden.png")));
         hidden.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  chat_main.MinWindow();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/selecthidden.png")));
	        } public void mouseExited(MouseEvent e) {
	        	 hidden.setIcon(new ImageIcon(chat_view.class.getResource("/images/hidden.png")));
	        }});
         
         bigorsmall = new JLabel("");
         syspanel.add(bigorsmall);
         bigorsmall.setToolTipText("���");
         bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/changebig.png")));
         bigorsmall.addMouseListener(new MouseAdapter(){
       	  public void mouseClicked(MouseEvent e) {    
	              chat_main.PanelFullScree(IS);
	              IS = !IS;
	          }public void mouseEntered(MouseEvent e) {
	        	  if(IS) {
	        		  bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectbig.png")));
	        	  }else {
	        		  bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectsmall.png")));
	        	  }
	            } public void mouseExited(MouseEvent e) {
	        	if(IS) {
	        		bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/changebig.png")));
	        		  bigorsmall.setToolTipText("���");
	        	}else {
	        		bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/changesmall.png")));
	        		  bigorsmall.setToolTipText("��С��");
	        	}
	        }});
         
         close = new JLabel("");
         syspanel.add(close);
         close.setToolTipText("�ر�");
         close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
         close.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  chat_main .exit();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	          close.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectclose.png")));
	        } public void mouseExited(MouseEvent e) {
	        	close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
	        }});
         
       //������
         mainpanel = new JPanel();
         contentPane.add(mainpanel,BorderLayout.CENTER);
         mainpanel.setLayout(new BorderLayout(10,10));
         
        //Ⱥ��Ա�б�����Ů
         chatgrappanel = new JPanel();
         mainpanel.add(chatgrappanel,BorderLayout.EAST);
         chatgrappanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
         chatgrappanel.setPreferredSize(new Dimension(250,500));
         
         //��ѯȺ��Ա
         JPanel findpanel = new JPanel();
         chatgrappanel.add(findpanel);
         findpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
         searchfield = new JTextField(18);
         findpanel.add(searchfield);
         searchfield.setFont(new java.awt.Font("����",1, 15));
         searchbut = new JButton("����");
         findpanel.add(searchbut);
         searchbut.setToolTipText("����");
         searchbut.setForeground(Color.black);
         searchbut.setFocusPainted(false);
         searchbut.setBorderPainted(false);
         searchbut.setBackground(Color.green); // ���ñ�����ɫ
         searchbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  String text = searchfield.getText();
	            	  chat_main.Search(text);
	            	  searchfield.setText("");
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  searchbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	 searchbut.setBackground(Color.green);
	        }});
         
         
         //Ⱥ��Ա�б�
         customerlistmodel model = new customerlistmodel();			//��ӱ�
     	 table=new JTable(model){ // ����jtable�ĵ�Ԫ��Ϊ͸����
			   public Component prepareRenderer(TableCellRenderer renderer,int row, int column) {
					    Component c = super.prepareRenderer(renderer, row, column);
					    return c;
					   }
					  };
		table.setOpaque(false);
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
		table.setFont(new Font("΢���ź�",1,18));
//        table.getColumnModel().getColumn(0).setPreferredWidth(250);
//		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ����table���ݾ���
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
		table.setDefaultRenderer(Object.class, tcr);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		table.setShowHorizontalLines(false);
		table.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==2) { 
	            	  chat_main.ClickList();
	           }                
	         }});
		listjs = new JScrollPane(table);
		listjs.setOpaque(false);
		listjs.getViewport().setOpaque(false);
		chatgrappanel.add(listjs);
         
         //�������
         talkmainpanel = new JPanel();
         mainpanel.add(talkmainpanel,BorderLayout.CENTER);
         talkmainpanel.setLayout(new BorderLayout(0,0));
         talkmainpanel.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         
         //������
         inputpanel = new JPanel();
         talkmainpanel.add(inputpanel,BorderLayout.SOUTH);
         inputpanel.setLayout(new BorderLayout(0,0));
         inputpanel.setMaximumSize(new Dimension(857,200));
         inputpanel.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         
         //�����ı����
         inputLabel = new JLabel("������");
         inputpanel.add(inputLabel,BorderLayout.NORTH);
         inputLabel.setFont(new java.awt.Font("����",1, 28));
         inputLabel.setMaximumSize(new Dimension(110,56));
         inputtxtpanel = new JPanel();
         inputpanel.add(inputtxtpanel,BorderLayout.CENTER);
         inputtxtpanel.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         inputtxtpanel.setMaximumSize(new Dimension(857,135));
         inputtxtpanel.setLayout(new BorderLayout(0,0));
         inputcontent.setFont(new java.awt.Font("����",3, 18));
         inputcontent.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         inputcontent.setBorder(null);
         contentScroll = new JScrollPane(inputcontent);
         contentScroll.setBackground(null);
         contentScroll.setOpaque(false);
         inputtxtpanel.add(contentScroll,BorderLayout.CENTER);
         inputcontent.setLineWrap(true);
         //ȡ����ʾˮƽ������
         contentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         //��ʾ��ֱ������
         contentScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         inputcontent.setBorder(BorderFactory.createBevelBorder(1));
         
         //���밴ť���
         inputbutpanel = new JPanel();
         inputpanel.add(inputbutpanel,BorderLayout.SOUTH);
         inputbutpanel.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         inputbutpanel.setMaximumSize(new Dimension(857,65));
         inputbutpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
         
         //�����ť
         clearbut = new JButton("���");
         inputbutpanel.add(clearbut);
         clearbut.setToolTipText("���");
         clearbut.setFont(new java.awt.Font("����",1, 18));
         clearbut.setMaximumSize(new Dimension(110,40));
         clearbut.setFocusPainted(false);
         clearbut.setBackground(Color.WHITE);
         clearbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  inputcontent.setText("");
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  clearbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	clearbut.setBackground(Color.WHITE);
	        }});
         
         
         //���Ͱ�ť
         sendbut = new JButton("����");
         inputbutpanel.add(sendbut);
         sendbut.setToolTipText("����");
         sendbut.setFont(new java.awt.Font("����",1, 18));
         sendbut.setMaximumSize(new Dimension(110,40));
         sendbut.setForeground(Color.white);
         sendbut.setFocusPainted(false);
         sendbut.setBorderPainted(false);
         sendbut.setBackground(Color.blue); // ���ñ�����ɫ
         sendbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1&&!inputcontent.getText().equals("")) {
	            	  message =message+inputcontent.getText();
	            	  Send.Msg(message);
	            	  showcontent.setText(showcontent.getText()+"---��("+username+") "+df.format(new Date())+"---\n  "+inputcontent.getText()+"\n");
	            	  inputcontent.setText("");
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  sendbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	sendbut.setBackground(Color.blue);
	        }});
         
        
         //�����¼��
         chatLabel = new JLabel("�����¼");
         talkmainpanel.add(chatLabel,BorderLayout.NORTH);
         chatLabel.setFont(new java.awt.Font("����",1, 28));
         chatLabel.setMaximumSize(new Dimension(110,76));
         showtalkpanel = new JPanel();
         talkmainpanel.add(showtalkpanel,BorderLayout.CENTER);
         showtalkpanel.setLayout(new BorderLayout(0,0));
         showcontent.setEditable(false);
         showcontent.setFont(new java.awt.Font("����",3, 18));
         showcontent.setBackground(new Color(255,255,255)); // ���ô��屳����ɫ
         showcontent.setBorder(null);
         showScroll = new JScrollPane(showcontent);
         showScroll.setBackground(null);
         showScroll.setOpaque(false);
         showtalkpanel.add(showScroll,BorderLayout.CENTER);
         showcontent.setLineWrap(true);
         //ȡ����ʾˮƽ������
         showScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         //��ʾ��ֱ������
         showScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         showcontent.setBorder(BorderFactory.createBevelBorder(1));
	}
	 
	 
	public JLabel getBigorsmall() {
		// TODO �Զ����ɵķ������
		return bigorsmall;
	}
	 
	public static JPanel getcContentPanelogin() {
		// TODO �Զ����ɵķ������
		return contentPanelogin;
	}
	
	public static JPasswordField getPassword() {
		// TODO �Զ����ɵķ������
		return password;
	}
	public static TextField getTf_named() {
		// TODO �Զ����ɵķ������
		return tf_name;
	}
	public static JLabel getTip() {
		// TODO �Զ����ɵķ������
		return tip;
	}
	public static JTextArea getShowcontent() {
		// TODO �Զ����ɵķ������
		return showcontent;
	}
	
	public static JTextArea getinputcontent() {
		// TODO �Զ����ɵķ������
		return inputcontent;
	}
	
	public void keyListner(){
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent e) {
				// TODO Auto-generated method stub
				if(((KeyEvent)e).getID()==KeyEvent.KEY_PRESSED){
					switch (((KeyEvent)e).getKeyCode()) {
					case KeyEvent.VK_ENTER:{
							if(((KeyEvent)e).isControlDown()) {
								if(!islogin&&!isregin) {
									 try {
					            		 username = tf_name.getText();
					            		 tip.setText("��¼��....");
										chat_main.Login(username,new String(password.getPassword()));
										Thread.sleep(100);
										if(islogin) {
											  contentPanelogin.setVisible(false);
											  GUIini();
										}
									} catch (Exception e1) {
										tip.setText("���ӷ�����ʧ�ܣ�");
										islogin = false;
									}
								}else if(isregin) {
									//�����뷢�͵�������
									  tip.setText("ע����....");
					            	  String repwd = new String(repassword.getPassword());
					            	  String repwdagain = new String(passwordagain.getPassword());
					            	  if(!retf_name.getText().equals("")&&!repwd.equals("")&&repwd.equals(repwdagain)) {
					            		  try {
											chat_main.Regin(retf_name.getText(),repwd);
											Thread.sleep(200);
										} catch (Exception e1) {
											// TODO �Զ����ɵ� catch ��
											e1.printStackTrace();
										}
					            	  }else {
					            		  tip.setText("�û������������벻����Ҫ��");
					            	  }
					            	  retf_name.setText("");
					            	  repassword.setText("");
					            	  passwordagain.setText("");
//					            	  if(!isregin) {
					            		  contentPaneregin.setVisible(false);
						            	  login.setVisible(true);
						            	  isregin = false;
//					            	  }
								}else if(islogin&&!inputcontent.getText().equals("")){
									 Send.Msg(inputcontent.getText());
					            	  showcontent.setText(showcontent.getText()+"---��("+username+") "+df.format(new Date())+"---\n  "+inputcontent.getText()+"\n");
					            	  inputcontent.setText("");
								}
							   
						   }
						    break;
						}
					   case KeyEvent.VK_ESCAPE:{
						 chat_main .exit();
						  break;
					   }
					   case KeyEvent.VK_DELETE:{
						   inputcontent.setText("");
					   }
				}

				}
			}
		}, AWTEvent.KEY_EVENT_MASK);
	}

	public static  JTable getTable() {
		// TODO �Զ����ɵķ������
		return table;
	}

	public static JScrollPane getShowScroll() {
		// TODO �Զ����ɵķ������
		return showScroll;
	}
}
	


