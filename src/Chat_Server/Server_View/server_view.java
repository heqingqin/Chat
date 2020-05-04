package Chat_Server.Server_View;

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

import Chat_Client.chat.Client.Send;
import Chat_Client.chat.View.ReSizeEvent;
import Chat_Client.chat.View.chat_view;
import Model.customeringmodel;
import Model.customerlistmodel;

public class server_view extends JFrame{
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
	JPanel regcuspanel;
	JPanel logcuspanel =new JPanel();
    JLabel chattalknamelabel;
    JLabel hidden;
    JLabel bigorsmall;
    JLabel close;
    JLabel chatLabel;
    JLabel inputLabel;
    JLabel uname;
    JLabel upass;
    JLabel upassagain;
    JLabel logcuslable;
    static JLabel tip;
    JButton delbut;
    JButton addbut;
    JButton loginbut;
    JButton rebut;
    JButton searchbut;
    JButton searclinehbut;
    JButton dellinebut;
    JButton InTbut;
    static JTable table;
    static JTable tableline;
    static JTextArea inputcontent = new JTextArea(4,100);
    JScrollPane contentScroll;
    static JTextArea showcontent = new JTextArea(10,100);;
    static JPasswordField password;
    static JPasswordField repassword;
    JPasswordField passwordagain;
    static TextField tf_name;
    static JTextField searchfield;
    static TextField retf_name;
    JScrollPane showScroll;
    JScrollPane listjs;
    public static String message ="";
    boolean IS = true;
    public static boolean islogin = false;
    public static boolean isLogin = false;
    public static boolean isregin = false;
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�������ڸ�ʽ
	public server_view(){
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
         chattalknamelabel = new JLabel("��������¼ҳ��");
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
	            	  server_main.MinWindow();
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
	            	  try {
						server_main .exit();
					} catch (IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
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
         JButton rebut=new JButton("ȡ��");
         pan4.add(rebut);
         rebut.setFocusPainted(false);
         rebut.setToolTipText("ȡ��");
         rebut.setBackground(Color.WHITE);
         rebut.setForeground(Color.black);
         rebut.setFont(new java.awt.Font("΢���ź�", 1, 15));
         rebut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  password.setText("");
	            	  tf_name.setText("");
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  rebut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	rebut.setBackground(Color.WHITE);
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
	            			 islogin = server_main.Login(username,new String(password.getPassword()));
	            		 }else tip.setText("�û��������벻��Ϊ�գ�");
	            		 password.setText("");
	            		 tf_name.setText("");
						Thread.sleep(100);
						if(islogin) {
							  contentPanelogin.setVisible(false);
							  GUIini();
						}else tip.setText("��¼ʧ�ܣ���������û�����ޣ�");
					} catch (Exception e1) {
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
     
   

	//��ҳ��
    public void GUIini(){
		setTitle("�����������������ϵͳ");//�����
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
         
         //�������
         chattalknamepanel = new JPanel();
         meunPanel.add(chattalknamepanel,BorderLayout.CENTER);
         chattalknamepanel.setBackground(null);
         chattalknamepanel.setOpaque(false);
         chattalknamepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         chattalknamelabel = new JLabel("�������������");
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
	            	  server_main.MinWindow();
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
	              server_main.PanelFullScree(IS);
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
	            	  try {
						server_main .exit();
					} catch (IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
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
         
       //������
      JPanel Managepanel = new JPanel();
      mainpanel.add(Managepanel,BorderLayout.NORTH);
      Managepanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
      Managepanel.setMaximumSize(new Dimension(846,40));
      JLabel regcuslable = new JLabel("ע���˻�����");
      Managepanel.add(regcuslable);
      regcuslable.setToolTipText("ע���˻�����");
      regcuslable.setForeground(Color.GREEN);
      regcuslable.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 //����л�
	            	  isLogin=false;
	            	  regcuslable.setForeground(Color.GREEN);
	            	  logcuslable.setForeground(Color.black);
	            	  regcuspanel.setVisible(true);
	            	  logcuspanel.setVisible(false);
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  regcuslable.setForeground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	if(isLogin) {
	        	  regcuslable.setForeground(Color.black);
	        	}else regcuslable.setForeground(Color.GREEN);
	        }});
      JButton emty1 = new JButton();
      Managepanel.add(emty1);
      emty1.setFocusPainted(false);
      emty1.setBorderPainted(false);
      emty1.setContentAreaFilled(false);
      emty1.setFocusPainted(false);
      JButton emty2 = new JButton();
      Managepanel.add(emty2);  
      emty2.setFocusPainted(false);     
      emty2.setBorderPainted(false);    
      emty2.setContentAreaFilled(false);
      emty2.setFocusPainted(false);     
      regcuslable.setFont(new java.awt.Font("΢���ź�", 1, 35));
      logcuslable = new JLabel("��¼�˻�����");
      Managepanel.add(logcuslable);
      logcuslable.setToolTipText("��¼�˻�����");
      logcuslable.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 //����л�A
	            	  isLogin=true;
	            	  logcuslable.setForeground(Color.GREEN);
	            	  regcuslable.setForeground(Color.black);
	            	  regcuspanel.setVisible(false);
	            	  logcuspanel.setVisible(true);
	            	  logcus();
	           }                
	          }public void mouseEntered(MouseEvent e) {
	        	  logcuslable.setForeground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	if(!isLogin) {
	        	   logcuslable.setForeground(Color.black);
	        	}else logcuslable.setForeground(Color.GREEN);
	        }});
      logcuslable.setForeground(Color.black);
      logcuslable.setFont(new java.awt.Font("΢���ź�", 1, 35));
         
      
    
      

      
      
        //��Ա�б�����
         chatgrappanel = new JPanel();
         chatgrappanel.setLayout(new BorderLayout(10,10));
         chatgrappanel.setPreferredSize(new Dimension(250,500));
         
         //ע���˻�����
         regcuspanel = new JPanel(); 
         mainpanel.add(regcuspanel,BorderLayout.CENTER);
         regcuspanel.setLayout(new BorderLayout(0,0));
         regcuspanel.add(chatgrappanel,BorderLayout.CENTER);
         
        
         //Ⱥ��Ա�б�
         customerlistmodel model = new customerlistmodel();			//��ӱ�
//         customeringmodel modeling = new customeringmodel();	
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
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		table.setShowHorizontalLines(false);
		listjs = new JScrollPane(table);
		listjs.setOpaque(false);
		listjs.getViewport().setOpaque(false);
		chatgrappanel.add(listjs,BorderLayout.CENTER);
		
		//�������
		 JPanel regmegpanel = new JPanel();
		 chatgrappanel.add(regmegpanel,BorderLayout.SOUTH);
		 regmegpanel.setLayout(new BorderLayout(10,10));
		 
		 //��ѯȺ��Ա
        JPanel findpanel = new JPanel();
        regmegpanel.add(findpanel,BorderLayout.CENTER);
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
	            	  if(!text.equals(""))
	            	  server_main.Search(text);
	            	  searchfield.setText("");
	           }                
	          }
	         public void mouseEntered(MouseEvent e) {
	        	  searchbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	 searchbut.setBackground(Color.green);
	        }});

        
        JPanel butpanel = new JPanel();
        regmegpanel.add(butpanel,BorderLayout.SOUTH);
        butpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        
        //��Ӱ�ť
        addbut = new JButton("���");
        butpanel.add(addbut);
        addbut.setToolTipText("���");
        addbut.setFont(new java.awt.Font("����",1, 18));
        addbut.setMaximumSize(new Dimension(110,40));
        addbut.setFocusPainted(false);
        addbut.setBackground(Color.WHITE);
        addbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//����³�Ա
	        	 server_main.Add();  
	          }public void mouseEntered(MouseEvent e) {
	        	  addbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	addbut.setBackground(Color.WHITE);
	        }});
        
        JButton empty1 = new JButton();
        butpanel.add(empty1);
        empty1.setFocusPainted(false);
        empty1.setBorderPainted(false);
        empty1.setContentAreaFilled(false);
        empty1.setFocusPainted(false);
        JButton empty2 = new JButton();
        butpanel.add(empty2);
        empty2.setFocusPainted(false);
        empty2.setBorderPainted(false);
        empty2.setContentAreaFilled(false);
        empty2.setFocusPainted(false);
        
        //ɾ����ť
        delbut = new JButton("ɾ��");
        butpanel.add(delbut);
        delbut.setToolTipText("ɾ��");
        delbut.setFont(new java.awt.Font("����",1, 18));
        delbut.setMaximumSize(new Dimension(110,40));
        delbut.setForeground(Color.black);
        delbut.setFocusPainted(false);
        delbut.setBorderPainted(false);
        delbut.setBackground(Color.WHITE); // ���ñ�����ɫ
        delbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//ɾ����Ա       
	        	 server_main.Dele();
	          }public void mouseEntered(MouseEvent e) {
	        	  delbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	delbut.setBackground(Color.WHITE);
	        }});
	}
	 
	 
	protected void logcus() {
		//�����û�����
       //��¼�˻�����
	   mainpanel.add(logcuspanel,BorderLayout.CENTER);
	   logcuspanel.setLayout(new BorderLayout(0,0));
	   
	   //��Ա�б�����
       chatgrappanel = new JPanel();
       logcuspanel.add(chatgrappanel,BorderLayout.CENTER);
       chatgrappanel.setLayout(new BorderLayout(10,10));
       chatgrappanel.setPreferredSize(new Dimension(250,500));
	   
	   
       //Ⱥ��Ա�б�
       customeringmodel modeling = new customeringmodel();			//��ӱ�
       tableline =new JTable(modeling){ // ����jtable�ĵ�Ԫ��Ϊ͸����
		       public Component prepareRenderer(TableCellRenderer renderer,int row, int column) {
			    Component c = super.prepareRenderer(renderer, row, column);
			    return c;
			   }
			  };
		tableline.setOpaque(false);
		tableline.setRowHeight(30);
		tableline.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
		tableline.setFont(new Font("΢���ź�",1,18));
//      table.getColumnModel().getColumn(0).setPreferredWidth(250);
//		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ����table���ݾ���
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
		tableline.setDefaultRenderer(Object.class, tcr);
		
		tableline.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		tableline.setShowHorizontalLines(false);
		listjs = new JScrollPane(tableline);
		listjs.setOpaque(false);
		listjs.getViewport().setOpaque(false);
		chatgrappanel.add(listjs,BorderLayout.CENTER);
		
		//�������
		 JPanel regmegpanel = new JPanel();
		 chatgrappanel.add(regmegpanel,BorderLayout.SOUTH);
		 regmegpanel.setLayout(new BorderLayout(10,10));
		 
		 //��ѯȺ��Ա
      JPanel findpanel = new JPanel();
      regmegpanel.add(findpanel,BorderLayout.CENTER);
      findpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      searchfield = new JTextField(18);
      findpanel.add(searchfield);
      searchfield.setFont(new java.awt.Font("����",1, 15));
      searclinehbut = new JButton("����");
      findpanel.add(searclinehbut);
      searclinehbut.setToolTipText("����");
      searclinehbut.setForeground(Color.black);
      searclinehbut.setFocusPainted(false);
      searclinehbut.setBorderPainted(false);
      searclinehbut.setBackground(Color.green); // ���ñ�����ɫ
      searclinehbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  String text = searchfield.getText();
	            	  if(!text.equals(""))
	            	  server_main.Searchline(text);
	            	  searchfield.setText("");
	           }                
	          }
	         public void mouseEntered(MouseEvent e) {
	        	  searclinehbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	 searclinehbut.setBackground(Color.green);
	        }});

      
      JPanel butpanel = new JPanel();
      regmegpanel.add(butpanel,BorderLayout.SOUTH);
      butpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
      
      //�жϰ�ť
      InTbut = new JButton("����");
      butpanel.add(InTbut);
      InTbut.setToolTipText("����");
      InTbut.setFont(new java.awt.Font("����",1, 18));
      InTbut.setMaximumSize(new Dimension(110,40));
      InTbut.setFocusPainted(false);
      InTbut.setBackground(Color.WHITE);
      InTbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//����³�Ա
	        	 server_main.InT();  
	          }public void mouseEntered(MouseEvent e) {
	        	  InTbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	InTbut.setBackground(Color.WHITE);
	        }});
      
      JButton empty1 = new JButton();
      butpanel.add(empty1);
      empty1.setFocusPainted(false);
      empty1.setBorderPainted(false);
      empty1.setContentAreaFilled(false);
      empty1.setFocusPainted(false);
      JButton empty2 = new JButton();
      butpanel.add(empty2);
      empty2.setFocusPainted(false);
      empty2.setBorderPainted(false);
      empty2.setContentAreaFilled(false);
      empty2.setFocusPainted(false);
      
      //ɾ����ť
      dellinebut = new JButton("����");
      butpanel.add(dellinebut);
      dellinebut.setToolTipText("����");
      dellinebut.setFont(new java.awt.Font("����",1, 18));
      dellinebut.setMaximumSize(new Dimension(110,40));
      dellinebut.setForeground(Color.black);
      dellinebut.setFocusPainted(false);
      dellinebut.setBorderPainted(false);
      dellinebut.setBackground(Color.WHITE); // ���ñ�����ɫ
      dellinebut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//ɾ����Ա       
	        	 server_main.Deleline();
	          }public void mouseEntered(MouseEvent e) {
	        	  dellinebut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	dellinebut.setBackground(Color.WHITE);
	        }});
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
								 try {
				            		 username = tf_name.getText();
				            		 tip.setText("��¼��....");
				            		 if(!username.equals("") && !new String(password.getPassword()).equals("")) {
				            			 islogin = server_main.Login(username,new String(password.getPassword()));
				            		 }else tip.setText("�û��������벻��Ϊ�գ�");
				            		 password.setText("");
				            		 tf_name.setText("");
									Thread.sleep(100);
									if(islogin) {
										  contentPanelogin.setVisible(false);
										  GUIini();
									}else tip.setText("��¼ʧ�ܣ���������û�����ޣ�");
								} catch (Exception e1) {
								}  
						   }
						    break;
						}
					   case KeyEvent.VK_ESCAPE:{
						 try {
							server_main .exit();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
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
	public static  JTable getTableline() {
		// TODO �Զ����ɵķ������
		return tableline;
	}
	
}
	


