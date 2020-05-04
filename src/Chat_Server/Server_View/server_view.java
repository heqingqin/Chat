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
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
	public server_view(){
	   	ReSizeEvent dg = new ReSizeEvent(this);        /**添加两个监听器**/        
	    this.addMouseListener(dg);        
		this.addMouseMotionListener(dg); 
		setBounds(160,100,550,350);	//设置窗口大小	
		Toolkit tool=this.getToolkit();
     	 Image im=tool.getImage(Frame.class.getResource("/images/chat.png"));
     	 this.setIconImage(im);
 		 keyListner();
     	 contentPanelogin = new JPanel();
     	 setContentPane(contentPanelogin);
     	contentPanelogin.setLayout(new BorderLayout(0, 0));
     	contentPanelogin.setBackground(null);
     	contentPanelogin.setOpaque(false);
		 
		 
		//菜单栏
         meunPanel = new JPanel();
         meunPanel.setBackground(new Color(51,51,204)); // 设置窗体背景颜色
         contentPanelogin.add(meunPanel,BorderLayout.NORTH);
         meunPanel.setPreferredSize(new Dimension(846, 63));//关键代码,设置JPanel的大小 
         meunPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
         meunPanel.setLayout(new BorderLayout(10, 10));
         
         chattalknamepanel = new JPanel();
         meunPanel.add(chattalknamepanel,BorderLayout.CENTER);
         chattalknamepanel.setBackground(null);
         chattalknamepanel.setOpaque(false);
         chattalknamepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         chattalknamelabel = new JLabel("服务器登录页面");
         chattalknamepanel.add(chattalknamelabel);
         chattalknamelabel.setForeground(Color.WHITE);
         chattalknamelabel.setFont(new java.awt.Font("微软雅黑", 1, 25));
         //系统控制按钮
         syspanel = new JPanel();
         meunPanel.add(syspanel,BorderLayout.EAST);
         syspanel.setBackground(null);
         syspanel.setOpaque(false);
         syspanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
         
         

         hidden = new JLabel("");
         syspanel.add(hidden);
         hidden.setToolTipText("最小化");
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
         close.setToolTipText("关闭");
         close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
         close.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  try {
						server_main .exit();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
	           }                
	          }public void mouseEntered(MouseEvent e) {
	          close.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectclose.png")));
	        } public void mouseExited(MouseEvent e) {
	        	close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
	        }});
         

         login=new JPanel(new GridLayout(7,1));//生成一个新的版面
         contentPanelogin.add(login,BorderLayout.SOUTH);
         
         JLabel Label = new JLabel("欢迎登录聊天室",JLabel.CENTER);
         login.add(Label);
         Label.setForeground(Color.gray);
         Label.setFont(new java.awt.Font("微软雅黑", 1, 20));
         Label.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
 
         JPanel pan1 = new JPanel();
         login.add(pan1);
         pan1.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
       
         
         JPanel pan2=new JPanel();//生成一个新的版面
         login.add(pan2);
         pan2.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
         uname=new JLabel("用户名:");
         pan2.add(uname);
         uname.setForeground(Color.black);
         uname.setFont(new java.awt.Font("微软雅黑", 1, 15));
         tf_name=new TextField(20);
         tf_name.setText("");
         pan2.add(tf_name);
         tf_name.setForeground(Color.black);
         tf_name.setFont(new java.awt.Font("宋体", 1, 15));


         JPanel pan3=new JPanel();//生成一个新的版面
         login.add(pan3);
         upass = new JLabel("密     码:");
         pan3.add(upass);
         pan3.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
         upass.setForeground(Color.black);
         upass.setFont(new java.awt.Font("微软雅黑", 1, 15));
         password=new JPasswordField(20);
         password.setEchoChar('*');
         pan3.add(password);
         password.setForeground(Color.black);
         password.setFont(new java.awt.Font("宋体", 1, 15));


         JPanel pan4 = new JPanel();
         login.add(pan4);
         pan4.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
         pan4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         JButton rebut=new JButton("取消");
         pan4.add(rebut);
         rebut.setFocusPainted(false);
         rebut.setToolTipText("取消");
         rebut.setBackground(Color.WHITE);
         rebut.setForeground(Color.black);
         rebut.setFont(new java.awt.Font("微软雅黑", 1, 15));
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
         JButton loginbut=new JButton("登陆");
         pan4.add(loginbut);
         loginbut.setFocusPainted(false);
         loginbut.setToolTipText("登陆");
         loginbut.setBackground(Color.green);
         loginbut.setForeground(Color.black);
         loginbut.setFont(new java.awt.Font("微软雅黑", 1, 15));
         loginbut.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 try {
	            		 username = tf_name.getText();
	            		 tip.setText("登录中....");
	            		 if(!username.equals("") && !new String(password.getPassword()).equals("")) {
	            			 islogin = server_main.Login(username,new String(password.getPassword()));
	            		 }else tip.setText("用户名或密码不能为空！");
	            		 password.setText("");
	            		 tf_name.setText("");
						Thread.sleep(100);
						if(islogin) {
							  contentPanelogin.setVisible(false);
							  GUIini();
						}else tip.setText("登录失败，密码错误或没有期限！");
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
         pan5.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
         
         JPanel pan6 = new JPanel(new BorderLayout(0,0));
         login.add(pan6);
         tip = new JLabel("",JLabel.CENTER);
         pan6.add(tip,BorderLayout.CENTER);
         tip.setForeground(Color.black);
         tip.setFont(new java.awt.Font("微软雅黑", 1, 25));
         pan6.setBackground(new Color(255,255,255)); // 设置窗体背景颜色
         }
     
   

	//主页面
    public void GUIini(){
		setTitle("聊天软件服务器管理系统");//软件名
		setBounds(160,100,845,850);	//设置窗口大小	
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
			
		//菜单栏
         meunPanel = new JPanel();
         meunPanel.setBackground(new Color(51,51,204)); // 设置窗体背景颜色
         contentPane.add(meunPanel,BorderLayout.NORTH);
         meunPanel.setPreferredSize(new Dimension(846, 63));//关键代码,设置JPanel的大小 
         meunPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
         meunPanel.setLayout(new BorderLayout(10, 10));
         
         //软件名字
         chattalknamepanel = new JPanel();
         meunPanel.add(chattalknamepanel,BorderLayout.CENTER);
         chattalknamepanel.setBackground(null);
         chattalknamepanel.setOpaque(false);
         chattalknamepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
         chattalknamelabel = new JLabel("服务器管理界面");
         chattalknamepanel.add(chattalknamelabel);
         chattalknamelabel.setForeground(Color.WHITE);
         chattalknamelabel.setFont(new java.awt.Font("微软雅黑", 3, 35));
         
         //系统控制按钮
         syspanel = new JPanel();
         meunPanel.add(syspanel,BorderLayout.EAST);
         syspanel.setBackground(null);
         syspanel.setOpaque(false);
         syspanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
         
         hidden = new JLabel("");
         syspanel.add(hidden);
         hidden.setToolTipText("最小化");
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
         bigorsmall.setToolTipText("最大化");
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
	        		  bigorsmall.setToolTipText("最大化");
	        	}else {
	        		bigorsmall.setIcon(new ImageIcon(chat_view.class.getResource("/images/changesmall.png")));
	        		  bigorsmall.setToolTipText("最小化");
	        	}
	        }});
         
         close = new JLabel("");
         syspanel.add(close);
         close.setToolTipText("关闭");
         close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
         close.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	  try {
						server_main .exit();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
	           }                
	          }public void mouseEntered(MouseEvent e) {
	          close.setIcon(new ImageIcon(chat_view.class.getResource("/images/selectclose.png")));
	        } public void mouseExited(MouseEvent e) {
	        	close.setIcon(new ImageIcon(chat_view.class.getResource("/images/close.png")));
	        }});
         
       //主板面
         mainpanel = new JPanel();
         contentPane.add(mainpanel,BorderLayout.CENTER);
         mainpanel.setLayout(new BorderLayout(10,10));
         
       //功能栏
      JPanel Managepanel = new JPanel();
      mainpanel.add(Managepanel,BorderLayout.NORTH);
      Managepanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
      Managepanel.setMaximumSize(new Dimension(846,40));
      JLabel regcuslable = new JLabel("注册账户管理");
      Managepanel.add(regcuslable);
      regcuslable.setToolTipText("注册账户管理");
      regcuslable.setForeground(Color.GREEN);
      regcuslable.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 //点击切换
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
      regcuslable.setFont(new java.awt.Font("微软雅黑", 1, 35));
      logcuslable = new JLabel("登录账户管理");
      Managepanel.add(logcuslable);
      logcuslable.setToolTipText("登录账户管理");
      logcuslable.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	              if (e.getClickCount()==1) {  	
	            	 //点击切换A
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
      logcuslable.setFont(new java.awt.Font("微软雅黑", 1, 35));
         
      
    
      

      
      
        //成员列表区域
         chatgrappanel = new JPanel();
         chatgrappanel.setLayout(new BorderLayout(10,10));
         chatgrappanel.setPreferredSize(new Dimension(250,500));
         
         //注册账户管理
         regcuspanel = new JPanel(); 
         mainpanel.add(regcuspanel,BorderLayout.CENTER);
         regcuspanel.setLayout(new BorderLayout(0,0));
         regcuspanel.add(chatgrappanel,BorderLayout.CENTER);
         
        
         //群成员列表
         customerlistmodel model = new customerlistmodel();			//添加表
//         customeringmodel modeling = new customeringmodel();	
     	 table=new JTable(model){ // 设置jtable的单元格为透明的
			   public Component prepareRenderer(TableCellRenderer renderer,int row, int column) {
					    Component c = super.prepareRenderer(renderer, row, column);
					    return c;
					   }
					  };
		table.setOpaque(false);
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
		table.setFont(new Font("微软雅黑",1,18));
//        table.getColumnModel().getColumn(0).setPreferredWidth(250);
//		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		table.setShowHorizontalLines(false);
		listjs = new JScrollPane(table);
		listjs.setOpaque(false);
		listjs.getViewport().setOpaque(false);
		chatgrappanel.add(listjs,BorderLayout.CENTER);
		
		//功能面板
		 JPanel regmegpanel = new JPanel();
		 chatgrappanel.add(regmegpanel,BorderLayout.SOUTH);
		 regmegpanel.setLayout(new BorderLayout(10,10));
		 
		 //查询群成员
        JPanel findpanel = new JPanel();
        regmegpanel.add(findpanel,BorderLayout.CENTER);
        findpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        searchfield = new JTextField(18);
        findpanel.add(searchfield);
        searchfield.setFont(new java.awt.Font("宋体",1, 15));
        searchbut = new JButton("搜索");
        findpanel.add(searchbut);
        searchbut.setToolTipText("搜索");
        searchbut.setForeground(Color.black);
        searchbut.setFocusPainted(false);
        searchbut.setBorderPainted(false);
        searchbut.setBackground(Color.green); // 设置背景颜色
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
        
        //添加按钮
        addbut = new JButton("添加");
        butpanel.add(addbut);
        addbut.setToolTipText("添加");
        addbut.setFont(new java.awt.Font("宋体",1, 18));
        addbut.setMaximumSize(new Dimension(110,40));
        addbut.setFocusPainted(false);
        addbut.setBackground(Color.WHITE);
        addbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//添加新成员
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
        
        //删除按钮
        delbut = new JButton("删除");
        butpanel.add(delbut);
        delbut.setToolTipText("删除");
        delbut.setFont(new java.awt.Font("宋体",1, 18));
        delbut.setMaximumSize(new Dimension(110,40));
        delbut.setForeground(Color.black);
        delbut.setFocusPainted(false);
        delbut.setBorderPainted(false);
        delbut.setBackground(Color.WHITE); // 设置背景颜色
        delbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//删除成员       
	        	 server_main.Dele();
	          }public void mouseEntered(MouseEvent e) {
	        	  delbut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	delbut.setBackground(Color.WHITE);
	        }});
	}
	 
	 
	protected void logcus() {
		//在线用户管理
       //登录账户管理
	   mainpanel.add(logcuspanel,BorderLayout.CENTER);
	   logcuspanel.setLayout(new BorderLayout(0,0));
	   
	   //成员列表区域
       chatgrappanel = new JPanel();
       logcuspanel.add(chatgrappanel,BorderLayout.CENTER);
       chatgrappanel.setLayout(new BorderLayout(10,10));
       chatgrappanel.setPreferredSize(new Dimension(250,500));
	   
	   
       //群成员列表
       customeringmodel modeling = new customeringmodel();			//添加表
       tableline =new JTable(modeling){ // 设置jtable的单元格为透明的
		       public Component prepareRenderer(TableCellRenderer renderer,int row, int column) {
			    Component c = super.prepareRenderer(renderer, row, column);
			    return c;
			   }
			  };
		tableline.setOpaque(false);
		tableline.setRowHeight(30);
		tableline.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
		tableline.setFont(new Font("微软雅黑",1,18));
//      table.getColumnModel().getColumn(0).setPreferredWidth(250);
//		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		tableline.setDefaultRenderer(Object.class, tcr);
		
		tableline.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		tableline.setShowHorizontalLines(false);
		listjs = new JScrollPane(tableline);
		listjs.setOpaque(false);
		listjs.getViewport().setOpaque(false);
		chatgrappanel.add(listjs,BorderLayout.CENTER);
		
		//功能面板
		 JPanel regmegpanel = new JPanel();
		 chatgrappanel.add(regmegpanel,BorderLayout.SOUTH);
		 regmegpanel.setLayout(new BorderLayout(10,10));
		 
		 //查询群成员
      JPanel findpanel = new JPanel();
      regmegpanel.add(findpanel,BorderLayout.CENTER);
      findpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      searchfield = new JTextField(18);
      findpanel.add(searchfield);
      searchfield.setFont(new java.awt.Font("宋体",1, 15));
      searclinehbut = new JButton("搜索");
      findpanel.add(searclinehbut);
      searclinehbut.setToolTipText("搜索");
      searclinehbut.setForeground(Color.black);
      searclinehbut.setFocusPainted(false);
      searclinehbut.setBorderPainted(false);
      searclinehbut.setBackground(Color.green); // 设置背景颜色
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
      
      //中断按钮
      InTbut = new JButton("禁言");
      butpanel.add(InTbut);
      InTbut.setToolTipText("禁言");
      InTbut.setFont(new java.awt.Font("宋体",1, 18));
      InTbut.setMaximumSize(new Dimension(110,40));
      InTbut.setFocusPainted(false);
      InTbut.setBackground(Color.WHITE);
      InTbut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//添加新成员
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
      
      //删除按钮
      dellinebut = new JButton("下线");
      butpanel.add(dellinebut);
      dellinebut.setToolTipText("下线");
      dellinebut.setFont(new java.awt.Font("宋体",1, 18));
      dellinebut.setMaximumSize(new Dimension(110,40));
      dellinebut.setForeground(Color.black);
      dellinebut.setFocusPainted(false);
      dellinebut.setBorderPainted(false);
      dellinebut.setBackground(Color.WHITE); // 设置背景颜色
      dellinebut.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e) {    
	        	//删除成员       
	        	 server_main.Deleline();
	          }public void mouseEntered(MouseEvent e) {
	        	  dellinebut.setBackground(Color.red);
	        } public void mouseExited(MouseEvent e) {
	        	dellinebut.setBackground(Color.WHITE);
	        }});
	}



	public JLabel getBigorsmall() {
		// TODO 自动生成的方法存根
		return bigorsmall;
	}
	 
	public static JPanel getcContentPanelogin() {
		// TODO 自动生成的方法存根
		return contentPanelogin;
	}
	
	public static JPasswordField getPassword() {
		// TODO 自动生成的方法存根
		return password;
	}
	public static TextField getTf_named() {
		// TODO 自动生成的方法存根
		return tf_name;
	}
	public static JLabel getTip() {
		// TODO 自动生成的方法存根
		return tip;
	}
	public static JTextArea getShowcontent() {
		// TODO 自动生成的方法存根
		return showcontent;
	}
	
	public static JTextArea getinputcontent() {
		// TODO 自动生成的方法存根
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
				            		 tip.setText("登录中....");
				            		 if(!username.equals("") && !new String(password.getPassword()).equals("")) {
				            			 islogin = server_main.Login(username,new String(password.getPassword()));
				            		 }else tip.setText("用户名或密码不能为空！");
				            		 password.setText("");
				            		 tf_name.setText("");
									Thread.sleep(100);
									if(islogin) {
										  contentPanelogin.setVisible(false);
										  GUIini();
									}else tip.setText("登录失败，密码错误或没有期限！");
								} catch (Exception e1) {
								}  
						   }
						    break;
						}
					   case KeyEvent.VK_ESCAPE:{
						 try {
							server_main .exit();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
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
		// TODO 自动生成的方法存根
		return table;
	}
	public static  JTable getTableline() {
		// TODO 自动生成的方法存根
		return tableline;
	}
	
}
	


