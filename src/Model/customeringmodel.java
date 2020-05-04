package Model;

import java.io.Serializable;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Chat_Server.Customermsg.CustomerList;
import Chat_Server.Server.chat_server;

public class customeringmodel extends AbstractTableModel{

	//初始化
	Vector rowData, columnNames;
	JTable jt = null;
	
	JScrollPane jsp = null;
	
	private customering list;
	

	public customeringmodel() {
		columnNames = new Vector<String>();
		//设置列名
		columnNames.add("账号");
		columnNames.add("用户名");
		columnNames.add("身份");
		columnNames.add("状态");
		rowData = new Vector();
			for (int i = 0; i < list.getList().size(); i++) {
				Vector hang=new Vector<String>();
				hang.add(list.getList().get(i).getAcc());
				System.out.println(list.getList().get(i).getAcc());
				hang.add(list.getList().get(i).getName());
				System.out.println(list.getList().get(i).getName());
				hang.add(list.getList().get(i).getWho());
				System.out.println(list.getList().get(i).getWho());
				hang.add(list.getList().get(i).getIsline());
				System.out.println(list.getList().get(i).getIsline());
				rowData.add(hang);
			}
	}
	//设置列

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(column);
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(arg0);
	}
	

}
