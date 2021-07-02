import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MessageArea extends JTextArea {
	
	private JTextField textField = null;
	private int initialDelay = 0;
	private int typingDelay = 50;
	
	public MessageArea(JTextField inputField, int initialDelay, int typeingDelay) {
		this.typingDelay = typeingDelay;
		this.initialDelay = initialDelay;
		this.textField = inputField;
	}
	
	public MessageArea() {
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public int getInitialDelay() {
		return initialDelay;
	}

	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

	public int getTypingDelay() {
		return typingDelay;
	}

	public void setTypingDelay(int typingDelay) {
		this.typingDelay = typingDelay;
	}

	public void type(String message, int initialDelay, int typingDelay) {
		boolean editable = textField != null && textField.isEditable();
		if (editable)
			textField.setEditable(false);
		
		Timer timer = new Timer(typingDelay, null);
		timer.setInitialDelay(initialDelay);
		timer.addActionListener(new ActionListener() {
			int i = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (i < message.length()) {
					MessageArea.this.append(message.substring(i, i + 1));
					i++;
				} else {
					timer.stop();
					if (editable)
						textField.setEditable(true);
				}
			}
		});
		timer.start();
	}
	
	public void type(String message) {
		type(message, initialDelay, typingDelay);
	}
	
}
