package T14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class DataTable extends JFrame implements ActionListener {
    JButton button = new JButton("添加");
    DAOoperation dao;
    JPanel p1 = new JPanel();
    Vector title = new Vector();
    JTable table;
    JTextField fieldName;
    JTextField fieldNumber;
    DefaultTableModel tableModel;
    public DataTable(DAOoperation dao) {
        super("通讯录");
        title.add("姓名");
        title.add("电话号码");
        Vector data = dao.getData();

        JLabel labelName = new JLabel("姓名");
        fieldName = new JTextField(10);
        JLabel labelNumber = new JLabel("电话号码");
        fieldNumber = new JTextField(10);

        tableModel = new DefaultTableModel();

        tableModel.setDataVector(data, title);

        table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane(table);

        this.add(pane);
        p1.add(labelName);
        p1.add(fieldName);
        p1.add(labelNumber);
        p1.add(fieldNumber);
        p1.add(button);
        this.add("South", p1);
        this.dao = dao;
        button.addActionListener(this);
        this.setSize(500, 200);
    }

    public void actionPerformed(ActionEvent e) {
        dao.addData(fieldName.getText(), fieldNumber.getText());
        Vector nowRow = new Vector();
        nowRow.add(fieldName.getText());
        nowRow.add(fieldNumber.getText());
        fieldName.setText("");
        fieldNumber.setText("");
        tableModel.addRow(nowRow);
    }
}
