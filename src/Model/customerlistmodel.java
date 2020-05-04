package Model;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Chat_Server.Customermsg.CustomerList;

public class customerlistmodel extends AbstractTableModel{

	//��ʼ��
	Vector rowData, columnNames;
	JTable jt = null;
	
	JScrollPane jsp = null;
	
	private CustomerList list;
	
	
	public customerlistmodel() {
		columnNames = new Vector<String>();
		//��������
		columnNames.add("�˺�");
		columnNames.add("�û���");
		columnNames.add("����");
		columnNames.add("���");
		rowData = new Vector<String>();
			
			for (int i = 0; i < list.getList().size(); i++) {
				Vector hang=new Vector<String>();
				hang.add(list.getList().get(i).getAcc());
				hang.add(list.getList().get(i).getName());
				hang.add(list.getList().get(i).getPwd());
				hang.add(list.getList().get(i).getWho());
				rowData.add(hang);
			}
	}
	//������

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
