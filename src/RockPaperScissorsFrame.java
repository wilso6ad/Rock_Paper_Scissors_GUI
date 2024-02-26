import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
public class RockPaperScissorsFrame extends JFrame {

      public static final int WIDTH = 600;
      public static final int HEIGHT = 600;

      Random rand = new Random();
      int playerWins = 0;
      int computerWins = 0;
      int ties = 0;

      JPanel outerPanel;
      JPanel topPanel;
      JPanel midPanel;
      JPanel botPanel;

      JLabel titleLabel;

      JButton quitButton;
      JButton rock;
      JButton paper;
      JButton scissors;

      JTextField nameField;

      JLabel PlayerWinsLabel;
      JLabel ComputerWinsLabel;
      JLabel TiesLabel;

      JTextArea rpsArea;

      JScrollPane rpsScroller;

      public RockPaperScissorsFrame() throws HeadlessException {

            outerPanel = new JPanel();
            topPanel = new JPanel();
            midPanel = new JPanel();
            botPanel = new JPanel();

            titleLabel = new JLabel("");

            quitButton = new JButton("Quit");

            rock = new JButton("Rock");
            paper = new JButton("Paper");
            scissors = new JButton("Scissors");

            PlayerWinsLabel = new JLabel("Player wins: 0");
            ComputerWinsLabel = new JLabel("Computer wins: 0");
            TiesLabel = new JLabel("Ties: 0");

            nameField = new JTextField();
            nameField.setColumns(15);

            rpsArea = new JTextArea(10, 50);
            rpsArea.setEditable(false);

            rpsScroller = new JScrollPane(rpsArea);

            rock.addActionListener(new ClickListenerRock());
            paper.addActionListener(new ClickListenerPaper());
            scissors.addActionListener(new ClickListenerScissors());
            quitButton.addActionListener((ActionEvent actionEvent) -> System.exit(0));

            setSize(WIDTH, HEIGHT);
            setTitle("Rock Paper Scissors The complete Edition");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
            add(outerPanel);

            // Adding borders to panels
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            topPanel.setBorder(BorderFactory.createTitledBorder(border, "Statistics"));
            botPanel.setBorder(BorderFactory.createTitledBorder(border, "Game Controls"));

            outerPanel.add(topPanel);
            topPanel.add(PlayerWinsLabel);
            topPanel.add(ComputerWinsLabel);
            topPanel.add(TiesLabel);

            outerPanel.add(midPanel);
            midPanel.add(rpsScroller);

            outerPanel.add(botPanel);
            botPanel.add(quitButton);
            botPanel.add(rock);
            botPanel.add(paper);
            botPanel.add(scissors);

            setVisible(true);
      }

      public class ClickListenerRock implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  rpsArea.append("You play: Rock\n");
                  computerLogic(0);
            }
      }

      public class ClickListenerPaper implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  rpsArea.append("You play: Paper\n");
                  computerLogic(1);

            }
      }

      public class ClickListenerScissors implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  rpsArea.append("You play: Scissors\n");
                  computerLogic(2);
            }
      }

      private void computerLogic(int playerMove) {
            int computerMove = rand.nextInt(3);
        /*
        0 = rock
        1 = paper
        2 = scissors
        */

            if (computerMove == playerMove) {
                  if (computerMove == 0) {
                        rpsArea.append("Computer plays: Rock\n It's a tie!\n");
                  } else if (computerMove == 1) {
                        rpsArea.append("Computer plays: Paper\n It's a tie!\n");
                  } else {
                        rpsArea.append("Computer plays: Scissors\n It's a tie!\n");
                  }
                  ties++;
                  TiesLabel.setText("Ties: " + ties);
            } else if (computerMove == 0 && playerMove == 1) {
                  rpsArea.append("Computer plays: Rock\nYou win!\n");
                  playerWins++;
            } else if (computerMove == 0 && playerMove == 2) {
                  rpsArea.append("Computer plays: Rock\nYou lose!\n");
                  computerWins++;
            } else if (computerMove == 1 && playerMove == 0) {
                  rpsArea.append("Computer plays: Paper\nYou lose!\n");
                  computerWins++;
            } else if (computerMove == 1 && playerMove == 2) {
                  rpsArea.append("Computer plays: Paper\nYou win!\n");
                  playerWins++;
            } else if (computerMove == 2 && playerMove == 0) {
                  rpsArea.append("Computer plays: Scissors\nYou win!\n");
                  playerWins++;
            } else if (computerMove == 2 && playerMove == 1) {
                  rpsArea.append("Computer plays: Scissors\nYou lose!\n");
                  computerWins++;
            }

            PlayerWinsLabel.setText("Player wins: " + playerWins);
            ComputerWinsLabel.setText("Computer wins: " + computerWins);
      }

      public static void main(String[] args) {
            new RockPaperScissorsFrame();
      }
}
