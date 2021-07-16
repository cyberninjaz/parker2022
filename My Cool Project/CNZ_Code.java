import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField; 

public class CNZ_Code {
	
	private static int step = 0;
	private static String name = "User";

	public static void main(String[] args) {
		JFrame window = new JFrame("VERITAS_EVAL");
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
						String message = "";
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
							message += "The girl's face lights up. \"Like my dress!\" She says. She hugs you tightly, "
									+ "then fades into the fog, like a distant\n"
									+ "ancient memory\n";
							textArea.setForeground(Color.BLUE);
							isColor = true;
						} else if (userInput.equalsIgnoreCase("Purple")) {
							textArea.setForeground(Color.MAGENTA);
							isColor = true;
						} else {
							message += "\"You see " + userInput + " in the rainbow?\n"
									+ "Out my nuts itch  of all of these colors in the rainbow, which one do you like the most?\n";
							isColor = false;
						}

						if (isColor) {
							message += "Wonderful choice! " + name + " now we can begin.\n"
									+ "Dead end \n You are at the end of a dirt road. A thick fog envelopes \n"
									+ "you. The road goes to the east. \n"
									+ "In the distance you can see that it will eventually fork off. The \n"
									+ "trees here are very tall royal palms, and they are spaced equidistant \n"
									+ "from each other.";

							textArea.type(message);
							step = 5;
						}

					}
					else if (step == 5) {
						if (userInput.matches("(?).*\\beast\\b.*")) {
							textArea.type("Dirt road \n"
									+ "You are on the continuation of a dirt road. \n"
									+ "There are more trees on both sides of you.  \n"
									+ "The road continues to the west."
									+ "You hear a voice off in the distance.");

							step = 6; 
						}
						else { textArea.type("A thick fog envelopes the path. You cannot go that way."); }
					}
					else if (step == 6) {
						if(userInput.matches("(?).*\\bwest\\b.*")) {
							textArea.type("You enter a small clearing. An old man in red fishes in a pond. \n"
									+ " He looks up at you. \"There is a path to the north of here.\" \n"
									+ " He says. \"After awhile you will come to a fork in the path. \n"
									+ " On one side there is a knight, he only tells the truth. On the \n"
									+ " other side there is a knave, she only lies. You can ask only one \n"
									+ " question to either, but they will only answer in YES or NO. \n"
									+ "You will not be able to tell which is which."
									+ "In order to pass you must figure who is knight and who is knave. \n"
									+ "Listen to me child, you MUST ask it: \"What will be your answer if \n"
									+ "I ask you whether the path to my left is the safe path?\" \"Ask, just \n"
									+ "like that, no typos. Trust me child!\""
									+ "The old man resumes fishing.");

							step = 7; 
						}
						else { textArea.type("A thick fog envelopes the path. You cannot go that way."); }
					}
					else if (step == 7) {
						if(userInput.matches("(?).*\\bnorth\\b.*")) {
							textArea.type("After a few hours of walking, you come upon a fork in the path. \n"
									+ "You decide to rest yourself here. \"HALT!\" A voice commands. \n"
									+ "You look up to see two armor clad guards. You can't tell which \n"
									+ " is which. You suddenly remember what the Old Man in Red told \n"
									+ " you to do. You turn to one of the guards. \n"
									+ "What question do you ask it? \n");
							step = 8; 
						}
						else { textArea.type("A thick fog envelopes the path. You cannot go that way."); }
					}
					else if (step == 8) {
						if(userInput.equals("What will be your answer if I ask you whether the path to my left is the safe path?")) {
							textArea.type("The guard looks at you. \"YES\" It says, in a robotic tone. \n"
									+ "Do you trust the guard and take the left path?");
							step = 9;
						}
						else { textArea.type("That's not the right question!"); }
						// Make it so it reads input again? //
					}
					else if (step == 9) {
						if(userInput.matches("(?).*\\bYes\\b.*")) {
							textArea.type("The guard lets you pass. You enter through the gate into a city \n"
									+ " full of riches, and prosper till the end of your days.");
							step = 10; 

						}
						else { if(userInput.matches("(?)).*\\bno\\b.*")) {
							textArea.type("You decide to take the right path. You walk down it, but before \n "
									+ " you can enter the gate, you feel a sharp pain. You look down to \n"
									+ " see a knife protruding from your back through your stomach. \n"
									+ "YOU HAVE DIED \n"
									+ "              \n"
									+ "Congratulations" + name + "you've almost completed the evaluation! \n"
									+ "Just one more thing: \n"
									+ "Do you trust me? \n"
									+ "Am I a knight, or a knave? \n"
									+ "Do you trust... the company, " + name + "?");

							step = 10; 
						}
						}

					} 
					else if (step == 10) { 
						if(userInput.matches("(?)).*\\bno\\b.*")) {
							textArea.type("Interesting.... /n"
									+ "Please email [INSERT EMAIL HERE] with your evaluation results. Have a good day " + name);
						}

					} else {
						textArea.type("Correct! /n"
								+ "Please email [INSERT EMAIL HERE] with your evaluation results. Have a nice day!");
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
