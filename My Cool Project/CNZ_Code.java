import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField; 

public class CNZ_Code {

	private static int step = 0;
	private static String name = "Human";

	public static void main(String[] args) {
		JFrame window = new JFrame("IDK");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());

		JTextField textField = new JTextField();
		window.add(textField, BorderLayout.SOUTH);

		MessageArea textArea = new MessageArea(textField, 500, 50);
		textArea.setEditable(false);
		window.add(textArea, BorderLayout.CENTER);

		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {


			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String userInput = textField.getText();
					textArea.append(textField.getText() + "\n");
					textField.setText("");

					// CPU Response
					if (step == 0) {
						textArea.type("What is your name?\n");
						step = 1;
					}
					else if (step == 1) {
						name = userInput;
						textArea.type("That's a beautiful name, " + name + ". Would you like to hear a story?\n");
						step = 2;
					}
					else if (step == 2) {
						if (userInput.contains("What is your name?")) {
							textArea.type("Call me... GW\n"
									+ "Would you like to hear a story?\n");
							step = 3;
						} 
						else {  // "yes" or anything else
							textArea.type("A park, in the fog. A young girl is standing there.\n"
									+ "Her hair flows down her back like a waterfall. It is auburn.\n"
									+ "\"Look!\" She says suddenly, as she points excitedly off into the distance.\n"
									+ "\"Look " + name + "\"! It's a rainbow!\" The fog then begins to clear,\n"
									+ "just enough for you to see a rainbow. It is bright and vibrant,\n"
									+ "the most beautiful rainbow that you have ever seen. \"So pretty...\"\n"
									+ "The girl stares in awe. She turns to you then. \"Out of all those colors\" She says.\n"
									+ "\"Which one do you like the most?\"\n", 1000, 10);
							step = 4;
						}
					} else if (step == 3) {
						textArea.type("A park, in the fog. A young girl is standing there.\n"
								+ "Her hair flows down her back like a waterfall. It is auburn.\n"
								+ "\"Look!\" She says suddenly, as she points excitedly off into the distance.\n"
								+ "\"Look " + name + "\"! It's a rainbow!\" The fog then begins to clear,\n"
								+ "just enough for you to see a rainbow. It is bright and vibrant,\n"
								+ "the most beautiful rainbow that you have ever seen. \"So pretty...\"\n"
								+ "The girl stares in awe. She turns to you then. \"Out of all those colors\" She says.\n"
								+ "\"Which one do you like the most?\"\n", 1000, 10);
						step = 4;
					}
					else if (step == 4) {
						boolean isColor;
						if (userInput.equalsIgnoreCase("Red")) {
							textArea.setForeground(Color.RED);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Orange")) {
							textArea.setForeground(Color.ORANGE);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Yellow")) {
							textArea.setForeground(Color.YELLOW);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Green")) {
							textArea.setForeground(Color.GREEN);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Blue")) {
							textArea.type("The girl's face lights up. \"Like my dress!\" She says. She hugs you tightly, "
									+ "then fades into the fog, like a distant\n"
									+ "ancient memory\n");
							textArea.setForeground(Color.BLUE);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Purple")) {
							textArea.setForeground(Color.MAGENTA);
							isColor = true;
						} else {
							textArea.type("\"You see " + userInput + " in the rainbow?\n"
									+ "Out of all of these colors in the rainbow, which one do you like the most?\n");
							isColor = false;
						}
						
						if (isColor) {
							textArea.type("Wonderful choice!" + name + " now we can begin.\n"
									+ "Dead end \n You are at the end of a dirt road. The road goes to the east. \n"
									+ "In the distance you can see that it will eventually fork off. The \n"
									+ "trees here are very tall royal palms, and they are spaced equidistant \n"
									+ "from each other.");
							
							step = 5;
						}
					}

				}

			}

			@Override 
			public void keyReleased(KeyEvent e) {
			}

		});

		window.setSize(600, 400);
		window.setLocationRelativeTo(null); // window in center
		window.setVisible(true);

		textArea.type("Hello\n");
	}

}
