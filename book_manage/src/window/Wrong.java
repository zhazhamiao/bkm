package window;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

public class Wrong {
	public static Wrong showmessage = new Wrong();
	Frame wrong = new Frame("´íÎó");	
		public Wrong() {
			wrong.addWindowListener(new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					wrong.setVisible(false);
				}
			});
		}
		public void show(JLabel message) {
			message.setFont(new Font("Î¢ÈíÑÅºÚ", 1, 21));
			wrong.add(message);
			wrong.setSize(360, 90);
			wrong.setLocation(790, 420);
			wrong.setVisible(true);
		}
}

