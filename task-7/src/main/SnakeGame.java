package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The SnakeGame implements the actual control structures to run the game loop
 */
public class SnakeGame implements ActionListener, MouseListener {
    /**
     * The colors that are supported by the game.
     */
    public static Color snakeHead = new Color(220, 100, 200); // crimson
    public static Color snakeBody = new Color(150, 0, 24); // carmine

    public static Color foodBasic = new Color(62, 180, 137); // mint
    public static Color foodSuper = new Color(116, 195, 101); // mantis
    public static Color foodUltra = new Color(192, 255, 0); // lime

    public static Color arenaBackground = new Color(204, 204, 255); // periwinkle
    public static Color arenaBarrier = new Color(64, 0, 255); // ultramarine

    /**
     * The snake object, controllable with key inputs.
     */
    private Snake snake;

    /**
     * The food object, can be eaten for length gain and respawns.
     */
    private Food food;

    /**
     * The barrier object, surrounds the game area and contact should be avoided.
     */
    private Barrier barrier;

    /**
     * The timer controls the game speed by iteratively invoking action events -
     * which in turn result in the execution of one step of the snake.
     */
    private Timer timer;

    /**
     * Specifies if the game is currently running (i.e. time is ticking) or not.
     */
    private boolean isRunning = false;

    /**
     * The game area in Rectangle format.
     */
    private Rectangle gameArea;

    /**
     * The control area - where the speed should be shown.
     */
    private Rectangle controlArea;

    /**
     * area within the game area where the snake "lives"
     */
    private Rectangle snakeArea;

    /**
     * The panel in which all this happens.
     */
    private JPanel myPanel;

    /**
     * the actual current width=height of a tile
     */
    private int tileSize;

    /**
     * Number of Grid rows of the grid game area.
     */
    public int numRows;

    /**
     * Number of grid columns of the grid game area.
     */
    public int numColumns;

    /**
     * The direction towards which the snake is heading. Note: the snake is always
     * moving! Direction Code: 0 := Up; 1 := Left; 2 := Down; 3 := Right
     */
    private int snakeDirection = 0;

    /**
     * Initial direction vector of the snake.
     */
    public static Vector initialSnakeDir = new Vector(0, -1);

    /**
     * Initial direction vector of the snake.
     */
    public Vector initialSnakePos;

    /**
     * Initial length of the snake.
     */
    public int initialSnakeLength = 5;

    /**
     * Number of iterations played in the game.
     */
    public int iteration = 0;

    /**
     * Number of food items that were eaten.
     */
    private int foodEaten = 0;

    /**
     * Number of barrier items added per level.
     */
    public static int barrierPerLevel = 2;

    /**
     * Maximum food item value (length gain)
     */
    public static int maxFoodValue = 10;

    /**
     * Number of lives the snake initially has.
     */
    private final int snakeLives = 5;

    /**
     * Number of foot items to win.
     */
    private final int FOOD_ITEM_GOAL = 5;

    /**
     * Snake length that wins the game.
     */
    private final int SNAKE_LENGTH_GOAL = 20;

    /**
     * The initial game speed when a game is reset.
     */
    private int initialGameSpeed = 150;

    /**
     * Every currenGameSpeed Milliseconds, the snake moves a step.
     */
    private int currentGameSpeed = 150;

    /**
     * The minimum game speed allowed.
     */
    private int minGameSpeed = 50;

    /**
     * The maximum game speed allowed.
     */
    private int maxGameSpeed = 200;

    /**
     * The level the snake is currently in.
     */
    private int level = 1;

    /**
     * The snake key adapter that monitors for key events.
     */
    private SnakeKeyAdapter mySKA;

    /**
     * Reference to the frame in which the game is played.
     */
    private JFrame inFrame;

    /**
     * Constructor for this game. Constructs the game and starts it immediately.
     *
     * @param inFrame     Reference to the frame within this game is played. Needed
     *                    to register key events and to be able to remove the key
     *                    listener again at the end of the game.
     * @param yourPanel   the panel within the game is played. Needed to invoke
     *                    repaint()
     * @param gameArea    The game area within the panel.
     * @param controlArea The control area within the panel.
     */
    public SnakeGame(JFrame inFrame, JPanel yourPanel, Rectangle gameArea, Rectangle controlArea) {
        this.gameArea = new Rectangle(gameArea);
        this.controlArea = new Rectangle(controlArea);

        this.myPanel = yourPanel;

        tileSize = MainFrame.tileSize;
        timer = new Timer(initialGameSpeed, this);

        initFullSnakeGamePanel();

        this.inFrame = inFrame;
        this.myPanel.addMouseListener(this);

        mySKA = new SnakeKeyAdapter();
        inFrame.addKeyListener(mySKA);
        inFrame.setFocusable(true); // from now on the board has the keyboard input, explicit call is needed
    }

    /**
     * Initializes the game - especially the grid area, the current snake location,
     * its body, resets the points and iteration counters and activates the time to
     * start the snake.
     */
    private void initFullSnakeGamePanel() {
        // rows and colunms -2 for the border
        numRows = gameArea.height / tileSize - 2;
        numColumns = gameArea.width / tileSize - 2;
        initialSnakePos = new Vector(numColumns / 2, numRows / 2);

        snakeArea = new Rectangle(gameArea.x + tileSize, gameArea.y + tileSize, gameArea.width - tileSize * 2,
                gameArea.height - tileSize * 2);

        level = 1;
        currentGameSpeed = initialGameSpeed;
        resetGameState();
    }

    /**
     * Reset the snake's position, length and direction, create a new barrier and
     * food, reset iteration count and pause the game.
     */
    private void resetGameState() {
        foodEaten = 0;
        snakeDirection = 0;
        iteration = 0;

        isRunning = false; // start paused
        timer.stop();
        timer.setDelay(currentGameSpeed);

        snake = new Snake(initialSnakePos.x, initialSnakePos.y, snakeLives, initialSnakeLength);
        barrier = new Barrier(gameArea, level - 1);
        spawnFood();

        myPanel.repaint();
    }

    /**
     * Create food on a random position - not in the snake or barrier.
     */
    private void spawnFood() {
       int x,y;
        do {
            x = ThreadLocalRandom.current().nextInt(numColumns + 1);
            y = ThreadLocalRandom.current().nextInt(numRows + 1);
        } while (snake.isOccupied(x,y) || barrier.isOccupied(x,y));
        food = new Food(x, y);
    }

    /**
     * Closes the game by stopping the time and removing the key listener.
     */
    public void closeGame() {
        timer.stop();
        timer = null;
        inFrame.removeKeyListener(mySKA);
        myPanel.removeMouseListener(this);
        mySKA = null;
        inFrame = null;
    }

    /**
     * Pauses or resumes the game if triggered.
     */
    private void pauseOnOff() {
        if (isRunning)
            timer.stop();
        else timer.start();
        isRunning = !isRunning;
    }

    /**
     * Invokes the next level
     */
    public void nextLevel() {
        level++;

        maxGameSpeed *= .9;
        minGameSpeed *= .9;
        currentGameSpeed = (minGameSpeed + maxGameSpeed) / 2;
        resetGameState();
    }

    /**
     * A game iteration in which the snake moves forward in its current heading
     * direction one step. Invoked currently by an action event, which is
     * periodically invoked when the timer is active.
     */
    private void nextStep() {

        if (snake.isAlive()) {
            Vector newDirection = new Vector(0, 0);
            switch (snakeDirection) {
                case 0: // Up
                    newDirection.x = 0;
                    newDirection.y = -1;
                    break;
                case 1: // Left
                    newDirection.x = 1;
                    newDirection.y = 0;
                    break;
                case 2: // Down
                    newDirection.x = 0;
                    newDirection.y = 1;
                    break;
                case 3: // Right
                    newDirection.x = -1;
                    newDirection.y = 0;
                    break;
            }
            snake.changeDirection(newDirection);

            if (snake.move(food, barrier)) {
                spawnFood();
                foodEaten++;
            }
        }

        iteration++;
        myPanel.repaint();
        Toolkit.getDefaultToolkit().sync(); // animation is laggy on some unix systems without this o_O

        if (snake.isAlive()) {
            if (foodEaten == FOOD_ITEM_GOAL * level || snake.getLength() >= SNAKE_LENGTH_GOAL * level) {
                // level done, show dialog and proceed to the next
                JOptionPane.showMessageDialog(myPanel,
                        "Congratulations - You totally sweeped this level!!!\n" + "After " + iteration
                                + " steps you have reached a \n" + "snake length of " + snake.getLength()
                                + " by eating " + foodEaten + " items.\n" + "READY for the NEXT LEVEL?");
                nextLevel();
            }
        } else {
            // snake is dead, show dialog and restart
            JOptionPane.showMessageDialog(myPanel,
                    "Ouch - that hurt :-(\n" + "You stayed alive for " + iteration + " steps in level " + level + "\n"
                            + "and have eaten " + foodEaten + " itmes.\n" + "T R Y    A G A I N   !!!");
            initFullSnakeGamePanel();
        }
    }

    /**
     * Creates a game score object that reflects the current score.
     */
    public GameScore getScores() {
        return new GameScore(new String[]{"Snake Length", "Food eaten", "Lives left"},
                new int[]{snake.getLength(), foodEaten, snake.getLives()},
                new int[]{SNAKE_LENGTH_GOAL * level, FOOD_ITEM_GOAL * level, snakeLives});
    }

    /**
     * Returns the name of the game.
     */
    public String getName() {
        return "SnakeGame";
    }

    /**
     * Action Performed is invoked by the Timer object.
     */
    public void actionPerformed(ActionEvent arg0) {
        nextStep();
    }

    /**
     * This method paints the game area and the border.
     *
     * @param g The graphics object to paint in.
     */
    public void paintGameArea(Graphics2D g) {
        g.setColor(arenaBackground);
        g.fillRect(snakeArea.x, snakeArea.y, snakeArea.width, snakeArea.height);

        barrier.draw(g, snakeArea, tileSize);
        food.draw(g, snakeArea, tileSize); // TODO: activate when implemented
        snake.draw(g, snakeArea, tileSize);
    }

    public void paintControlArea(Graphics2D g) {
        g.setColor(Color.black);
        g.drawRect(controlArea.x, controlArea.y, controlArea.width / 2, controlArea.height);
        g.drawString("Game Speed: " + (1000 - currentGameSpeed), controlArea.x + 5,
                controlArea.y + controlArea.height / 3 + g.getFont().getSize() / 2);
        g.drawString("Current Level: " + level, controlArea.x + 5,
                controlArea.y + 2 * controlArea.height / 3 + g.getFont().getSize() / 2);
        g.drawRect(controlArea.x + controlArea.width / 2, controlArea.y, controlArea.width / 2, controlArea.height);
        if (this.isRunning) {
            g.drawString("Click to Pause Game", controlArea.x + controlArea.width / 2 + 5,
                    controlArea.y + controlArea.height / 2 + g.getFont().getSize() / 2);
        } else {
            g.drawString("Click to Start / Resume Game", controlArea.x + controlArea.width / 2 + 5,
                    controlArea.y + controlArea.height / 2 + g.getFont().getSize() / 2);
        }
    }

    /**
     * Called by the JPanel-"Listener" when the mouse is clicked within the frame.
     *
     * @parm The MouseEvent encodes the location of the click.
     */
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (mouseX > controlArea.x && mouseX < controlArea.x + controlArea.width && mouseY > controlArea.y
                && mouseY < controlArea.y + controlArea.height) {
            if (mouseX - controlArea.x > controlArea.width / 2) {
                pauseOnOff();
            }
        }
    }

    /*
     * Other methods required by the MouseListener, but not used, therefore empty.
     */
    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    /**
     * Extend the KeyAdapter to catch key presses: Up, Right, Left, Down to control
     * the snake and +/- to adjust the game speed and P to trigger pause.
     */
    class SnakeKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            // TODO: add a pause button 'P'

            switch (e.getKeyCode()) {
                case KeyEvent.VK_P:
                    pauseOnOff();
                case KeyEvent.VK_UP:
                    snakeDirection = 0;
                    break;
                case KeyEvent.VK_RIGHT:
                    snakeDirection = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    snakeDirection = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    snakeDirection = 3;
                    break;
                case KeyEvent.VK_PLUS:
                    if (currentGameSpeed - 5 >= minGameSpeed) {
                        currentGameSpeed -= 5;
                        timer.setDelay(currentGameSpeed);
                    }
                    break;
                case KeyEvent.VK_MINUS:
                    if (currentGameSpeed + 5 <= maxGameSpeed) {
                        currentGameSpeed += 5;
                        timer.setDelay(currentGameSpeed);
                    }
                    break;
                default:
                    System.out.println("Key Pressed: " + e + " " + e.getKeyCode());
            }
        }
    }

}