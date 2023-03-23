import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;

/**
 * Displays the game settings and allows the user to adjust them.
 *
 * @author Ed Parrish
 * @version 1.0  1/12/2011
 */
public class SettingsScreen extends Actor {
    private static final Color BACKGROUND = new Color(0xC6, 0xD6, 0xE0, 236);
    private static final Color FOREGROUND = new Color(0x30, 0x58, 0x7E);
    private static final int WIDTH = 340;
    private static final int HEIGHT = 200;
    private static final String DEFAULT_FILE = "basics.txt";

    private GameManager world;
    private static GreenfootImage img;
    private Button timerButton;
    private Button choicesButton;
    private Button continueButton;
    private Button basicsButton;
    private Button basics2Button;
    private Button l33tButton;
    private String file = DEFAULT_FILE;
    private int level = 1;

    /**
     * SettingsScreen constructor.
     */
    public SettingsScreen() { }

    /**
     * Returns the question level selected by the user.
     *
     * @return The file name entered by the user.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Clears the display area and removes this object from the world.
     */
    public void clear() {
        world.removeObject(timerButton);
        world.removeObject(choicesButton);
        world.removeObject(basicsButton);
        world.removeObject(basics2Button);
        world.removeObject(l33tButton);
        world.removeObject(continueButton);
        world.removeObject(this);
        level = 1;
    }

    /**
     * Respond to a actions like a button being pressed.
     */
    public void act() {
        if (timerButton.isClicked()) {
            if (world.getProvideTimer()) {
                timerButton.setText("Off");
                world.setProvideTimer(false);
            } else {
                timerButton.setText("On");
                world.setProvideTimer(true);
            }
        } else if (choicesButton.isClicked()) {
            if (world.getProvideChoices()) {
                choicesButton.setText("Off");
                world.setProvideChoices(false);
            } else {
                choicesButton.setText("On");
                world.setProvideChoices(true);
            }
        } else if (basicsButton.isClicked()) {
            basicsButton.setText("On");
            basics2Button.setText("Off");
            l33tButton.setText("Off");
            level = 1;
        } else if (basics2Button.isClicked()) {
            basicsButton.setText("Off");
            basics2Button.setText("On");
            l33tButton.setText("Off");
            level = 2;
        } else if (l33tButton.isClicked()) {
            basicsButton.setText("Off");
            basics2Button.setText("Off");
            l33tButton.setText("On");
            level = 3;
        } else if (continueButton.isPressed()) {
            world.startRound();
        }
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
     * Draw the screen.
     */
    private void draw() {
        final int BORDER = 30;
        final int INSET = 3;
        final int THICKNESS = 3;
        final int BUTTON_WIDTH = 42;
        final int BUTTON_HEIGHT = 30;
        final int X_OFFSET = 126;
        final int LEFT = 64;

        if (img == null) {
            img = new GreenfootImage(WIDTH, HEIGHT);
        }
        img.setColor(BACKGROUND);
        img.fill();
        img.setColor(FOREGROUND);
        // Draw border
        for (int i = 0; i < THICKNESS; i++)  {
            img.drawRect(i + INSET, i + INSET,
                img.getWidth() - i - i - 1 - INSET - INSET,
                img.getHeight() - i - i - 1 - INSET - INSET);
        }
        // Draw test on background image
        img.setFont(GameManager.MED_FONT);
        img.drawString("Game Settings", 100, 32);
        img.setFont(GameManager.SMALL_FONT);
        img.drawString("Use Timer", LEFT, 61);
        img.drawString("Display multiple choices", LEFT, 100);
        img.drawString("Math Trivia", LEFT, 139);
        setImage(img);
        // Place button relative to world
        timerButton = new Button("On", GameManager.SMALL_FONT, FOREGROUND);
        world.addObject(timerButton, getX() - X_OFFSET, 216);
        choicesButton = new Button("On", GameManager.SMALL_FONT, FOREGROUND);
        world.addObject(choicesButton, getX() - X_OFFSET, 256);
        basicsButton = new Button("On", GameManager.SMALL_FONT, FOREGROUND);
        world.addObject(basicsButton, getX() - X_OFFSET, 296);
        basics2Button = new Button("Off", GameManager.SMALL_FONT, FOREGROUND);
        //world.addObject(basics2Button, 274, 296);
        l33tButton = new Button("Off", GameManager.SMALL_FONT, FOREGROUND);
        //world.addObject(l33tButton, 384, 296);
        continueButton = new Button("Continue", GameManager.SMALL_FONT, FOREGROUND);
        world.addObject(continueButton, getX(), getY() + 70);
    }
}
