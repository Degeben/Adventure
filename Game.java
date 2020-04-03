package game;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/*
 * CREATED BY BENNETT DEGEORGE AND CAL SCHMITT
 * 
 * 
 */

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, playerPanel, imagePanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, moneyLabel, moneyAmount, imageLabel;
	Font titleFont = new Font("Impact", Font.PLAIN, 64);
	Font textFont = new Font("Impact", Font.PLAIN, 20);
	Font statFont = new Font("Times New Roman", Font.PLAIN, 20);
	Font choiceFont = new Font("Retro Gaming", Font.PLAIN, 12);
	JButton startButton, choice1, choice2, choice3,choice4;
	JTextArea mainTextArea;
	int playerHP, monHP, monAtk, silverRing, ratHP, ratAtk, money;
	String weapon, position, userName;
	ImageIcon image;
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler cHandler = new ChoiceHandler();

	public static void main(String[] args) {
		
		new Game();
	}
	
	public Game() {
		
		window = new JFrame();
		window.setSize(850, 650);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
	
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(315, 500, 250, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("AAAAAAAAAAAAAAAAAA");
		startButton.setFont(textFont);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setSize(450, 200);
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		startButtonPanel.add(startButton);

		
		imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 850, 650);
		
		imageLabel = new JLabel();
		
		image = new ImageIcon(".//res/gamescreen.gif");
		
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		
		con.add(imagePanel);
		con.add(startButtonPanel);
		
	}
	public void createGameScreen() {
		
		startButtonPanel.setVisible(false);
		imagePanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 350, 430, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area. This game is text based.");
		mainTextArea.setBounds(50, 350, 430, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(textFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(500, 350, 250, 150);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4, 1));
		con.add(choicePanel);
		
		choice1 = new JButton("CHOICE 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(choiceFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choicePanel.add(choice1);
		
		choice2 = new JButton("CHOICE 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(choiceFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choicePanel.add(choice2);
		
		choice3 = new JButton("CHOICE 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(choiceFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choicePanel.add(choice3);
		
		choice4 = new JButton("CHOICE 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(choiceFont);
		choice1.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choicePanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(525, 150, 300, 175);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(3, 3));
		con.add(playerPanel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(statFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(statFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("WEAPON: ");
		weaponLabel.setFont(statFont);;
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(statFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		moneyLabel = new JLabel("GOLD: ");
		moneyLabel.setFont(statFont);;
		moneyLabel.setForeground(Color.white);
		playerPanel.add(moneyLabel);
		moneyAmount = new JLabel();
		moneyAmount.setFont(statFont);
		moneyAmount.setForeground(Color.white);
		playerPanel.add(moneyAmount);
		
		imagePanel = new JPanel();
		imagePanel.setBounds(50, 50, 400, 250);
		imagePanel.setBackground(Color.black);
		
		imageLabel = new JLabel();
		
		image = new ImageIcon(".//res/gate-icon.png");
		
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		
		
		con.add(imagePanel);
		
		playerSetup();
		
	}
	public void playerSetup() {
		playerHP = 15;
		monHP = 12;
		ratHP = 20;
		ratAtk = 4;
		monAtk = 3;
		money = 0;
		weapon = "KNIFE";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		moneyAmount.setText("" + money);
	
		townGate();
	}
	public void townGate() {
		image = new ImageIcon(".//res//gate-icon.png");
		imageLabel.setIcon(image);
		
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. A guard is standing \nbefore you. \n\nWhat do you do?");
		choice1.setText("Talk to the guard");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void talkGuard() {
		image = new ImageIcon(".//res//townGuard.png");
		imageLabel.setIcon(image);
		
		position = "talkGuard";
		mainTextArea.setText("Hello traveler, I have not seen you \naround here before. \n\nWhat's your name?");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void talkGuard2() {
		image = new ImageIcon(".//res//townGuard.png");
		imageLabel.setIcon(image);
		
		String userName = new String(JOptionPane.showInputDialog(this,"Please enter a username"));
		
		position = "talkGuard2";
		mainTextArea.setText("I see. So your name is " + userName + "." + "\n\nUnforunately I can't let you through for the \ntime being.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void townGate2() {
		image = new ImageIcon(".//res//gate-icon.png");
		imageLabel.setIcon(image);
		
		position = "townGate2";
		mainTextArea.setText("What do you do?");
		choice1.setText("Talk to the guard again");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
		
	}
	public void talkGuardF() {
		image = new ImageIcon(".//res//townGuardF.png");
		imageLabel.setIcon(image);
		
		position = "talkGuardF";
		mainTextArea.setText("I have nothing else \nfor you, please leave.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void attackGuard() {
		image = new ImageIcon(".//res//townGuard.png");
		imageLabel.setIcon(image);
		
		position = "attackGuard";
		mainTextArea.setText("Don't be dumb. \n\nThe guard fought back and hit you hard. \n(You recieve 3 damage)");
		playerHP = playerHP -3;
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad() {
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad. \n\n(If you go south you will return to town.)");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void north() {
		image = new ImageIcon(".//res//river.png");
		imageLabel.setIcon(image);
		
		position = "north";
		
		playerHP = playerHP + 3;
		hpLabelNumber.setText("" + playerHP);
		
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(HP is recovered by 3.)");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void crossRoad2() {
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		
		position = "crossRoad2";
		mainTextArea.setText("You are at a crossroad. \n\n(If you go south you will return to town.)");
		choice1.setText(" X ");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void east() {
		image = new ImageIcon(".//res//longsword.png");
		imageLabel.setIcon(image);
		
		position = "east";
		weapon = "LONG SWORD";
		weaponLabelName.setText(weapon);
		
		mainTextArea.setText("You walk into a forest and found a Long Sword! \n\nATK: 0-7\n\n(You obtained a Long Sword.)");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad3() {
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		
		position = "crossRoad3";
		mainTextArea.setText("You are at a crossroad. \n\n(If you go south you will return to town.)");
		choice1.setText("Go north");
		choice2.setText(" X ");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void west() {
		image = new ImageIcon(".//res//goblin.png");
		imageLabel.setIcon(image);
		
		position = "west";
		
		mainTextArea.setText("You encounter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad4() {
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		
		position = "crossRoad4";
		mainTextArea.setText("You are at a crossroad. \n\n(If you go south you will return to town.)");
		choice1.setText("Go north");
		choice2.setText(" X ");
		choice3.setText("Go south");
		choice4.setText(" X ");
	}
	public void crossRoadF() {
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		
		position = "crossRoadF";
		mainTextArea.setText("You are at a crossroad. \n\n(If you go south you will return to town.)");
		choice1.setText(" X ");
		choice2.setText(" X ");
		choice3.setText("Go south");
		choice4.setText(" X ");
	}
	public void fight() {
		image = new ImageIcon(".//res//goblin.png");
		imageLabel.setIcon(image);
		
		position = "fight";
		
		mainTextArea.setText("Monster HP: " + monHP + "\nMonster ATK: " + monAtk + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDmg = 0;
		
		if(weapon.equals("KNIFE")) {
			playerDmg = new java.util.Random().nextInt(4);
		}
		else if(weapon.contentEquals("LONG SWORD")) {
			playerDmg = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attack! \nYou deal " + playerDmg + " damage");
		
		monHP = monHP - playerDmg;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monDmg = 0;
		
		monDmg = new java.util.Random().nextInt(3);
		
		mainTextArea.setText("The goblin attacked! \nYou took " + monDmg + " damage!");
		
		playerHP = playerHP - monDmg;
		hpLabelNumber.setText("" + playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void win() {	
		image = new ImageIcon(".//res//deadgoblin.png");
		imageLabel.setIcon(image);
		
		position = "win";
		
		mainTextArea.setText("You defeated the Goblin! \nThe Goblin dropped a ring! \n\n(You obtained a Silver \nRing and 1 gold.)");
		
		silverRing = 1;
		money = money + 2;
		moneyAmount.setText("" + money);
		
		choice1.setText("Return to crossroad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose() {
		image = new ImageIcon(".//res//gameover.png");
		imageLabel.setIcon(image);
		
		position = "lose";
		
		mainTextArea.setText("You are dead! \n\nGAME OVER");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void outerTown() {
		image = new ImageIcon(".//res//guardwin.png");
		imageLabel.setIcon(image);
		
		
		position = "outerTown";
		
		mainTextArea.setText("That's a nice ring you have there. If you give me that \nI will let you through to the town.");
		choice1.setText("Proceed towards town");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void insideTown() {
		image = new ImageIcon(".//res//insidetown.png");
		imageLabel.setIcon(image);
		
		position = "insideTown";
		
		mainTextArea.setText("You enter the town square. \n\n Where do you want to go?");
		choice1.setText("The Town Inn");
		choice2.setText("The Stables");
		choice3.setText("The Theater");
		choice4.setText("The Tavern");
				
	}
	public void theStables() {
		image = new ImageIcon(".//res//stables.png");
		imageLabel.setIcon(image);
		
		position = "theStables";
		
		mainTextArea.setText("(Smell of manure fills the air)");
		choice1.setText("To the Inn");
		choice2.setText("To the Theater");
		choice3.setText("Return to square");
		choice4.setText("");
	}
	public void theTheater() {
		image = new ImageIcon(".//res//theater.png");
		imageLabel.setIcon(image);
		
		position = "theTheater";
	
		mainTextArea.setText("(There are no shows right now.)");
		choice1.setText("To the Inn");
		choice2.setText("To the Stables");
		choice3.setText("Return to square");
		choice4.setText("");
	}
	public void theInn() {
		image = new ImageIcon(".//res//innkeeper.png");
		imageLabel.setIcon(image);
		
		position = "theInn";
		
		mainTextArea.setText("Welcome to the Inn! \n\nHow can I help you?");
		choice1.setText("Rest");
		choice2.setText("Eat");
		choice3.setText("Return to square");
		choice4.setText("");
	}
	public void rest() {
		image = new ImageIcon(".//res//innkeeper.png");
		imageLabel.setIcon(image);
		
		position = "rest";
		
		mainTextArea.setText("It appears you don't have \nenough money, please leave or return \nwith 5 gold to rest.");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void eat() {
		image = new ImageIcon(".//res//innkeeper.png");
		imageLabel.setIcon(image);
		
		position = "eat";
		
		mainTextArea.setText("It appears you don't have \nenough money, please leave or return \nwith 3 gold to eat.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void theTavern() {
		image = new ImageIcon(".//res//tavbar.png");
		imageLabel.setIcon(image);
		
		position = "theTavern";
		
		mainTextArea.setText("What can I get for ya?");
		choice1.setText("Frost Meed (1g)");
		choice2.setText("Bog Grog (3g)");
		choice3.setText("Shamrock Shake (5g)");
		choice4.setText("Nothing");
	}
	public void theTavern2() {
		image = new ImageIcon(".//res//tavbar.png");
		imageLabel.setIcon(image);
		
		position = "theTavern2";
		playerHP = playerHP + 2;
		hpLabelNumber.setText("" + playerHP);
		
		mainTextArea.setText("Enjoy. \n\nYou drink the Frost Meed. \nIt's surprisingly delicious. \n(HP is recovered by 2)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void theTavernNoMoney() {
		image = new ImageIcon(".//res//tavbarang.png");
		imageLabel.setIcon(image);
		
		position = "theTavernNoMoney";
		
		mainTextArea.setText("You ain't got enough for that.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void tavernInfo() {
		image = new ImageIcon(".//res//tavbarcon.png");
		imageLabel.setIcon(image);
		
		position = "tavernInfo";
		
		mainTextArea.setText("There's been this awful group \nof giant rats that come during the nights \nhere and terrorize the town. Would recommend \nfinding somewhere to stay inside for the night.");
		choice1.setText("Thank him and leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void outsideTavern() {
		image = new ImageIcon(".//res//sunset.png");
		imageLabel.setIcon(image);
		
		position = "outsideTavern";
		
		mainTextArea.setText("You notice it's almost sunset. \n\nWhat do you do?");
		choice1.setText("Stop the rats");
		choice2.setText("Leave town");
		choice3.setText("");
		choice4.setText("");

	}
	public void leave1() {
		image = new ImageIcon(".//res//gameoverLeave.png");
		imageLabel.setIcon(image);
		
		position = "leave1";
		
		mainTextArea.setText("You leave town and go on \nmany fun adventures. But the town continued to be \nattacked each night by the rat king, until \nnothing remained. With too much guilt on your \nconscious, you let yourself be killed by the Rat King \n\nGAME OVER");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

	}
	public void investigationStart() {
		image = new ImageIcon(".//res//forge.png");
		imageLabel.setIcon(image);
		
		position = "investigationStart";
		
		mainTextArea.setText("You see a local blacksmith. \n\nYou decide to talk to him.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void blacksmith() {
		image = new ImageIcon(".//res//blacksmith.png");
		imageLabel.setIcon(image);
		
		position = "blacksmith";
		
		mainTextArea.setText("What can I do for ya?");
		choice1.setText("Ask about the rats");
		choice2.setText("Ask for a new sword");
		choice3.setText("Leave");
		choice4.setText("");

	}
	public void blacksmithInfo() {
		image = new ImageIcon(".//res//blacksmithE.png");
		imageLabel.setIcon(image);
		
		position = "blacksmithInfo";
		
		mainTextArea.setText("They travel with the rat king who \ncalls the shots. Lot of folks \nsay if you take him out, they'll leave.");
		choice1.setText("Thank him and leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void blacksmithBlade() {
		image = new ImageIcon(".//res//blacksmith.png");
		imageLabel.setIcon(image);
		
		position = "blacksmithBlade";
		
		mainTextArea.setText("New blade will run ya' \nabout 20 gold.");
		choice1.setText("Get new blade");
		choice2.setText("Nevermind");
		choice3.setText("");
		choice4.setText("");

	}
	public void blacksmithNoMoney() {
		image = new ImageIcon(".//res//blacksmithS.png");
		imageLabel.setIcon(image);
		
		position = "blacksmithNoMoney";
		
		mainTextArea.setText("You don't got the money for that.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void setup() {
		image = new ImageIcon(".//res//approach.png");
		imageLabel.setIcon(image);
		
		position = "setup";
		
		mainTextArea.setText("You talk to more villagers to pass some time. \nAll of the sudden, you hear them approach. \nWhat do you do?");
		choice1.setText("Stay and fight the king");
		choice2.setText("Leave town");
		choice3.setText("");
		choice4.setText("");

	}
	public void leave2() {
		image = new ImageIcon(".//res//gameoverLeave.png");
		imageLabel.setIcon(image);
		
		position = "leave2";
		
		mainTextArea.setText("You leave town and go on \nmany fun adventures. But the town continued to be \nattacked each night by the rat king, until \nnothing remained. With too much guilt on your \nconscious, you let yourself be killed by the Rat King \n\nGAME OVER");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
	}
	public void ratking() {
		image = new ImageIcon(".//res//ratking.png");
		imageLabel.setIcon(image);
		
		position = "ratking";
		
		mainTextArea.setText("You are now in front of the Rat King. \n\nWhat do you do now?");
		choice1.setText("Stay and fight the king");
		choice2.setText("Join him");
		choice3.setText("");
		choice4.setText("");

	}
	public void ratkingJoin() {
		image = new ImageIcon(".//res//gameoverBite.png");
		imageLabel.setIcon(image);
		
		position = "ratkingJoin";
		
		mainTextArea.setText("You tell the rat you'll join \nhim and his crew, when you approach, he \neats you in one bite. \n\nHe doesn't appeciate cowards... GAME OVER");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

	}
	public void ratkingFight() {
		image = new ImageIcon(".//res//ratking.png");
		imageLabel.setIcon(image);
		
		position = "ratkingFight";
		
		mainTextArea.setText("Rat King HP: " + ratHP + "\nRat King ATK: " + ratAtk + "\n\nWhat do you do?");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");

	}
	public void ratkingRun() {
		image = new ImageIcon(".//res//ratking.png");
		imageLabel.setIcon(image);
		
		position = "ratkingNotReady";
		
		mainTextArea.setText("You can't run!");
		choice1.setText("Fight");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}
	public void playerAttackKing() {
		
		position = "playerAttackKing";
		
		int playerDmg = 0;
		
		if(weapon.equals("KNIFE")) {
			playerDmg = new java.util.Random().nextInt(4);
		}
		else if(weapon.contentEquals("LONG SWORD")) {
			playerDmg = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attack! \nYou deal " + playerDmg + " damage");
		
		ratHP = ratHP - playerDmg;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void ratAttack() {
		
		position = "ratAttack";
		
		int ratDmg = 0;
		
		ratDmg = new java.util.Random().nextInt(5);
		
		mainTextArea.setText("The king attacked! \nYou took " + ratDmg + " damage!");
		
		playerHP = playerHP - ratDmg;
		hpLabelNumber.setText("" + playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void victory() {	
		
		image = new ImageIcon(".//res//victory.png");
		imageLabel.setIcon(image);
		
		position = "victory";
		
		mainTextArea.setText("You defeated the Rat King! \nYou have saved the village and \nare now the king of the village!");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
	}
	public void defeat() {
		
		image = new ImageIcon(".//res//gameover.png");
		imageLabel.setIcon(image);
		
		position = "defeat";
		
		mainTextArea.setText("You are dead! \n\nGAME OVER");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1": 
					if(silverRing == 1) {
						outerTown();
					}
					else {
						talkGuard(); 
					}
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": talkGuard2(); break;
				}
				break;
			case "talkGuard2":
				switch(yourChoice) {
				case "c1": townGate2();
				}
				break;
			case "townGate2":
				switch(yourChoice) {
				case "c1":
					if(silverRing == 1) {
						outerTown();
					}
					else {
						talkGuardF();
					}
					break;
				case "c2": attackGuard(); break;
				case "c3": crossRoad();
				}
				break;
			case "talkGuardF":
				switch(yourChoice) {
				case "c1": townGate2();
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1": townGate2(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate2(); break;
				case "c4": west(); break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad2(); break;
				}
				break;
			case "crossRoad2":
				switch(yourChoice) {
				case "c1": break;
				case "c2": east(); break;
				case "c3": townGate2(); break;
				case "c4": west(); 
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad3(); break;
				}
				break;
			case "crossRoad3":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": break;
				case "c3": townGate2();
				case "c4": west();
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1": fight(); break;
				case "c2": crossRoad(); 
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": crossRoad4(); break;
				}
				break;
			case "crossRoad4":
				switch(yourChoice){
				case "c1": north();
				case "c2": break;
				case "c3": townGate2();
				case "c4": west();
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c1": 
					if(monHP < 1) {
						win();
					}
					else {
						monsterAttack(); 
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c1": 
					if(playerHP < 1) {
						lose(); 
					}
					else {
						fight();
						}
					}
					break;
			case "win":
				switch(yourChoice) {
				case "c1": crossRoadF();
				}
				break;
			case "crossRoadF":
				switch(yourChoice) {
				case "c1": break; 
				case "c2": break;
				case "c3": townGate2();
				case "c4": 
				}
				break;
			case "outerTown":
				switch(yourChoice) {
				case "c1": insideTown();
				}
				break;
			case "insideTown":
				switch(yourChoice) {
				case "c1": theInn(); break;
				case "c2": theStables(); break;
				case "c3": theTheater(); break;
				case "c4": theTavern();
				}
				break;
			case "theStables":
				switch(yourChoice) {
				case "c1": theInn(); break;
				case "c2": theTheater(); break;
				case "c3": insideTown();
				}
				break;
			case "theTheater":
				switch(yourChoice) {
				case "c1": theInn(); break;
				case "c2": theStables(); break;
				case "c3": insideTown();
				}
				break;
			case "theInn":
				switch(yourChoice) {
				case "c1": rest(); break;
				case "c2": eat(); break;
				case "c3": insideTown(); 
				}
				break;
			case "rest":
				switch(yourChoice) {
				case "c1": theInn();
				}
				break;
			case "eat":
				switch(yourChoice) {
				case "c1": theInn();
				}
				break;
			case "theTavern":
				switch(yourChoice) {
				case "c1": theTavern2(); break;
				case "c2": theTavernNoMoney(); break;
				case "c3": theTavernNoMoney(); break;
				case "c4": insideTown();
				}
				break;
			case "theTavern2":
				switch(yourChoice) {
				case "c1": tavernInfo();
				}
				break;
			case "tavernInfo":
				switch(yourChoice) {
				case "c1": outsideTavern();
				}
				break;
			case "theTavernNoMoney":
				switch(yourChoice) {
				case "c1": theTavern(); 
				}
				break;
			case "outsideTavern":
				switch(yourChoice) {
				case "c1": investigationStart(); break;
				case "c2": leave1();
				}
				break;
			case "investigationStart":
				switch(yourChoice) {
				case "c1": blacksmith();
				}
				break;
			case "blacksmith":
				switch(yourChoice) {
				case "c1": blacksmithInfo(); break;
				case "c2": blacksmithBlade(); break;
				case "c3": outsideTavern();
				}
				break;
			case "blacksmithInfo":
				switch(yourChoice) {
				case "c1": setup();
				}
				break;
			case "blacksmithBlade":
				switch(yourChoice) {
				case "c1": blacksmithNoMoney(); break;
				case "c2": blacksmith();
				}
				break;
			case "blacksmithNoMoney":
				switch(yourChoice) {
				case "c1": blacksmithBlade();
				}
				break;
			case "setup":
				switch(yourChoice) {
				case "c1": ratking(); break;
				case "c2": leave2();
				}
				break;
			case "ratking":
				switch(yourChoice) {
				case "c1": ratkingFight(); break;
				case "c2": ratkingJoin();
				}
				break;
			case "ratkingFight":
				switch(yourChoice) {
				case "c1": playerAttackKing();  break;
				case "c2": ratkingRun();
				}
				break;
			case "ratkingRun":
				switch(yourChoice) {
				case "c1": playerAttackKing();
				}
				break;
			case "playerAttackKing":
				switch(yourChoice) {
				case "c1":
					if(ratHP < 1) {
						victory();
					}
					else {
						ratAttack(); 
					}
					break;
				}
				break;
			case "ratAttack":
				switch(yourChoice) {
				case "c1":
					if(playerHP < 1) {
						defeat();
					}
					else {
						ratkingFight(); 
					}
					break;
				}
			}
		}
	}
}
