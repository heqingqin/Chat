package JButtonTableExample;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

      public JComponent getTableCellRendererComponent(JTable table, Object value,
          boolean isSelected, boolean hasFocus, int row, int column) {
          //value Դ��editor
          String text = (value == null) ? "" : value.toString();
          //��ť����
          setText(text);
          //��Ԫ����ʾ
          setToolTipText(text);
          //����ɫ
          setBackground(Color.BLACK);
          //ǰ��ɫ
          setForeground(Color.green);
        return this;
      }
    }