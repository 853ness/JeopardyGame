import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays flashing screens.
 *
 * @author Ed Parrish
 * @version 1.0  1/12/2011
 */
public class SplashScreen extends Actor {
    public static final int FLASH_WIDTH = 85;
    public static final int FLASH_HEIGHT = 61;
    public static final Color FLASH_COLOR = new Color(0, 0x99, 0xFF);
    // Images for the flasher
    private static GreenfootImage onImage;
    private static GreenfootImage offImage;
    // Flash duration
    private static final long DELAY = 70;
    // Keep track of flash duration
    private long lastFlashTime;
    // Reference to the world to which this instance is added
    private GameManager world;
    // Title for the splash screen
    private Label title;
    // Grid of flashers
    private Flasher[][] grid = new Flasher[GameManager.ROWS][GameManager.COLS];

    /**
     * SplashScreen constructor.
     */
    public SplashScreen() { }

    /**
     * Trigger the flashes.
     */
    public void act() {
        // Time the flashes
        if (System.currentTimeMillis() - lastFlashTime < DELAY) {
            return;
        }
        lastFlashTime = System.currentTimeMillis();
        // Trigger flashers
        int row = Greenfoot.getRandomNumber(GameManager.ROWS);
        int col = Greenfoot.getRandomNumber(GameManager.COLS);
        grid[row][col].startFlash(100);
    }

    /**
     * Save the world and draw it.
     *
     * @param w the world.
     */
    public void addedToWorld(World w) {
        world = (GameManager) w;
        draw();
    }

    /**
     * Clears the display area and removes this object from the world.
     */
    public void clear() {
        world.removeObject(title);
        for (int row = 0; row < GameManager.ROWS; row++) {
            for (int col = 0; col < GameManager.COLS; col++) {
                world.removeObject(grid[row][col]);
            }
        }
        world.removeObject(this);
    }

    /**
     * Draw the screen objects.
     */
    private void draw() {
        if (onImage == null) {
            onImage = new GreenfootImage(FLASH_WIDTH, FLASH_HEIGHT);
            onImage.setColor(FLASH_COLOR);
            onImage.fill();
        }
        if (offImage == null) {
            offImage = new GreenfootImage(FLASH_WIDTH, FLASH_HEIGHT);
        }
        title = new Label(new GreenfootImage("greenfoot_jeopardy.gif"));
        world.addObject(title, 302, 45);
        for (int row = 0; row < GameManager.ROWS; row++) {
            for (int col = 0; col < GameManager.COLS; col++) {
                grid[row][col] = new Flasher();
                world.addObject(grid[row][col], 66 + 94 * col, 128 + row * 68);
            }
        }
    }

    /**
     * Screen flashes.
     *
     * @author Ed Parrish
     * @version 1.0  1/12/2011
     */
    public class Flasher extends Actor {
        // Flash duration time in milliseconds
        private long flashTime;
        // Timer variable used to prevent keystrokes from going too fast
        private long startTime;

        /**
         * Flasher constructor.
         */
        public Flasher() {
            setImage(offImage);
        }

        /**
         * Check to see if it is time to turn off the flash.
         */
        public void act() {
            if (System.currentTimeMillis() - startTime < flashTime) {
                return;
            }
            setImage(offImage);
        }

        /**
         * Start the flash.
         *
         * @param duration The length of the flash.
         */
        public void startFlash(long duration) {
            flashTime = duration;
            setImage(onImage);
            startTime = System.currentTimeMillis();
        }
    }
}
