import java.util.*;

public class Maze {
    private int[][] maze;
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
    }

    public void generateMaze() {
        //fill everything black and carving path with white
        for (int[] row : maze) {
            Arrays.fill(row, 1);
        }
        carvePath(1, 1);
    }

    private void carvePath(int x, int y) {
        //up, down, left, right
        int[][] directions = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
        List<int[]> directionList = Arrays.asList(directions);
        Collections.shuffle(directionList);

        for (int[] dir : directionList) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValidCell(newX, newY)) {
                maze[newX][newY] = 0;
                maze[x + dir[0] / 2][y + dir[1] / 2] = 0;
                carvePath(newX, newY);
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x > 0 && x < rows - 1 && y > 0 && y < cols - 1 && maze[x][y] == 1;
    }

    public int[][] getMazeArray() {
        return this.maze;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setCell(int x, int y, int value) {
        maze[x][y] = value;
    }

    public int getCell(int x, int y) {
        return maze[x][y];
    }

    public void setStartAndExit() {
        setCell(1, 1, 2); //2 represents start
        setCell(rows - 2, cols - 2, 3); //3 represents exit
    }
}
