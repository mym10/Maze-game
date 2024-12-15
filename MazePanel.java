import java.awt.*;
import javax.swing.JPanel;

public class MazePanel extends JPanel {
    private int[][] maze;
    private int rows;
    private int cols;
    private int cellSize;
    private Player player;

    public MazePanel(int[][] maze, int cellSize, Player player) {
        this.maze = maze;
        this.cellSize = cellSize;
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //Clear the panel before painting

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) { //Wall
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (maze[i][j] == 0) { //Path
                    g.setColor(Color.WHITE);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (maze[i][j] == 2) { //Start
                    g.setColor(Color.GREEN);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (maze[i][j] == 3) { //Exit
                    g.setColor(Color.RED);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }

        //draw the player dynamically
        g.setColor(Color.BLUE);
        g.fillOval(player.getY() * cellSize + cellSize / 4, player.getX() * cellSize + cellSize / 4, cellSize / 2, cellSize / 2);

        //draw grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}



