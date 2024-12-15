# Dynamic Maze Game Documentation

## **1. What is the Game?**
The **Dynamic Maze Game** is an interactive puzzle game where players navigate through a maze. The objective is to reach the exit within a time limit. The game becomes progressively more challenging as players advance through levels. Each level features:
- A new, randomly generated maze.
- Increasing maze size.
- Decreasing time limits.

---

## **2. How to Play the Game?**

### **Steps to Play:**
1. **Start the Game:**
   - Launch the game to view a maze with a timer and level indicator at the top.
2. **Navigate the Maze:**
   - Use the **W, A, S, D** keys to move the player **up, left, down, or right**. Movement is restricted to one tile at a time.
3. **Reach the Exit:**
   - Navigate through the maze to reach the exit located at the **bottom-right corner** within the time limit.
4. **Level Progression:**
   - After reaching the exit, advance to the next level with a larger maze and a shorter time limit.
5. **Game Over:**
   - If the timer runs out, the game ends, and a **"Game Over"** message appears.

### **Controls:**
- **W**: Move Up
- **A**: Move Left
- **S**: Move Down
- **D**: Move Right

---

## **3. How Did I Make It?**

### **Technologies Used:**
- **Java:** The game is built using the Java programming language.
- **Swing:** Used for creating the graphical user interface (GUI), including the maze grid, player controls, and timer.
- **Graphics:** The maze is drawn using basic graphics elements in Java, with dynamic tile sizing for responsiveness.

### **Key Components:**
1. **Maze Generation:**
   - Dynamic generation of random mazes with a start point, exit, and walls.
2. **Player Movement:**
   - Tracks player position and restricts movement to valid paths within the maze.
3. **Timer:**
   - A countdown timer adds urgency, decreasing with each level.
4. **Level Progression:**
   - Generates larger mazes with shorter time limits as levels progress.
5. **Dynamic Tile Size:**
   - Adjusts maze tile size based on window dimensions, ensuring proper display regardless of window size.

---

## **4. What Were the Challenges?**

### **1. Maze Generation:**
- Creating random, solvable, and scalable mazes for each level required ensuring a valid path always existed from start to exit.

### **2. Dynamic Tile Size:**
- Calculating tile sizes to fit the window dynamically was complex, especially when transitioning between levels with different maze sizes.

### **3. Keyboard Input:**
- Implementing real-time keyboard input for smooth movement while ensuring valid paths and restricting movement through walls was challenging.

---

## **5. What Bugs Still Exist?**

### **1. Tile Size Bug:**
- The tile size calculation has issues, especially when resizing the window:
  - It works well in the first level but fails during level transitions.
  - Causes movement inaccuracies (e.g., two steps per key press in Level 2).
- This affects the game's responsiveness and graphical consistency.

---

## **6. Future Improvements**

1. **Fixing Tile Size Calculation:**
   - Ensure tiles fit consistently within the window and are scaled correctly during level transitions.
2. **Sound and Graphics:**
   - Add background music and sound effects to enhance player experience.
3. **Multiplayer Functionality:**
   - Introduce real-time multiplayer functionality for competition or collaboration to reach the exit.

---

Thank you for playing the **Dynamic Maze Game**! 🚀
