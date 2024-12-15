import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private Maze maze;
    private Player player;
    private MazePanel mazePanel;
    private JLabel timerLabel, levelLabel;
    private Timer timer;
    private int timeRemaining;
    private int currentLevel = 1;
    private final int maxLevel = 5;
    private final int windowSize = 600;
    private int tileSize;

    public GameFrame(int rows, int cols, int timeLimit) {
        setupLevel(rows, cols, timeLimit);
    }

    private void setupLevel(int rows, int cols, int timeLimit) {
        this.maze = new Maze(rows, cols);
        maze.generateMaze();
        this.player = new Player(1, 1);
        maze.setStartAndExit();

        this.timeRemaining = timeLimit;
        tileSize = (windowSize / rows);

        //Maze panel
        mazePanel = new MazePanel(maze.getMazeArray(), tileSize, player);
        mazePanel.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));

        //Timer label
        timerLabel = new JLabel("Time: " + timeRemaining, SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Level label
        levelLabel = new JLabel("Level: " + currentLevel, SwingConstants.CENTER);
        levelLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Layout
        setLayout(new BorderLayout());
        add(mazePanel, BorderLayout.CENTER);
        add(timerLabel, BorderLayout.NORTH);
        add(levelLabel, BorderLayout.SOUTH);

        startTimer();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                int x = player.getX();
                int y = player.getY();
                switch (e.getKeyCode()) {
                    case java.awt.event.KeyEvent.VK_W: //up
                        if (player.canMove(x - 1, y, maze.getMazeArray())) player.move(x - 1, y);
                        break;
                    case java.awt.event.KeyEvent.VK_S: //down
                        if (player.canMove(x + 1, y, maze.getMazeArray())) player.move(x + 1, y);
                        break;
                    case java.awt.event.KeyEvent.VK_A: //left
                        if (player.canMove(x, y - 1, maze.getMazeArray())) player.move(x, y - 1);
                        break;
                    case java.awt.event.KeyEvent.VK_D: //right
                        if (player.canMove(x, y + 1, maze.getMazeArray())) player.move(x, y + 1);
                        break;
                }
                mazePanel.repaint();
                checkWin();
            }
        });
        

        setFocusable(true);
        setTitle("Dynamic Maze Game");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time: " + timeRemaining);

                if (timeRemaining <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(GameFrame.this, "Time's up! Game Over.");
                    System.exit(0);
                }
            }
        });
        timer.start();
    }

    private void checkWin() {
        if (player.getX() == maze.getMaze().length - 2 && player.getY() == maze.getMaze()[0].length - 2) {
            timer.stop();
            if (currentLevel < maxLevel) {
                JOptionPane.showMessageDialog(this, "Great job! Moving to the next level!");
                currentLevel++;
                int newRows = 15 + (currentLevel * 2);
                int newCols = 15 + (currentLevel * 2);
                int newTime = 30 + (2 * (maxLevel - currentLevel)); //Adjust time limit
                getContentPane().removeAll(); //Clear previous level components
                setupLevel(newRows, newCols, newTime);
            } else {
                JOptionPane.showMessageDialog(this, "Congratulations! You completed all levels!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame(15, 15, 30).setVisible(true));
    }
}
