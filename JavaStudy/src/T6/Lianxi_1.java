package T6;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lianxi_1 extends Frame{

	Scrollbar scrollbar;
	Panel panel;
	public Lianxi_1() {

		setTitle("fdnghkd");
		setBackground(Color.CYAN);
		setSize(200, 200);
		panel = new Panel(new GridLayout(1,1));
		scrollbar = new Scrollbar();
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Lianxi_1();
		//System.exit(0);
		Lianxi_1 f = new Lianxi_1();
		f.addWindowListener(f.new Mywindowadapter());
		
	}
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}
	}
}
