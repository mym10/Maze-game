//package project;

public class Player {
    private int x, y;

    // Constructor
    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    //can only move in valid cells
    public boolean canMove(int newX, int newY, int[][] maze) {
        return maze[newX][newY] == 0 || maze[newX][newY] == 3; //path or exit
    }
}
