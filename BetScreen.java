import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//import java.awt.FontMetrics;
//import java.awt.Graphics;

/**
 * Handles betting for the final round.
 *
 * @author Ed Parrish
 * @version 1.0  1/8/2011
 */
//public class BetScreen extends Actor implements ActionListener {
public class BetScreen extends Actor {
    private static final int ERROR_LOC_X = 300;
    private static GreenfootImage img;
    private String category;
    private Button done;
    private GameManager world;
    private Label errorMsg;
    private boolean entered;

    /**
     * BetScreen constructor.
     *
     * @param cat The final round category.
     */
    public BetScreen(String cat) {
        category = cat;

    }

    /**
     * Clears the display area and removes this object from the world.
     */
    public void clear() {
        if (done != null) world.removeObject(done);
        if (errorMsg != null) world.removeObject(errorMsg);
        world.removeObject(this);
    }

    /**
     * Respond to actions like a button being pressed.
     *
     * @param c The component object that caused the action.
     */
    public void act() {
        if (img != null && img == getImage() && !entered) {
            String answer = Greenfoot.ask("Enter your bet: ");
            int bet = 0;
            try {
                bet = Integer.parseInt(answer);
                if (bet < 0) {
                    printErrorMessage("Enter a number greater than zero.");
                } else if (bet > world.getScore()) {
                    printErrorMessage("You cannot bet more than your score.");
                } else {
                    entered = true;
                    world.finalRound(bet);
                }
            } catch (NumberFormatException nfe) {
                printErrorMessage("Please enter an integer number.");
                return;
            }
        }
    }

    /**
     * Prints an error message to the screen.
     *
     * @param msg The error message to print.
     */
    public void printErrorMessage(String msg) {
        if (errorMsg == null) {
            errorMsg = new Label(msg, GameManager.MED_FONT, Color.WHITE);
            world.addObject(errorMsg, ERROR_LOC_X, world.getWidth() / 2);
        } else {
            errorMsg.setText(msg);
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
        img = new GreenfootImage(world.getWidth(), world.getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        img.setColor(Color.WHITE);

        String text = "Final Round";
        int y = printCentered(text, GameManager.LARGE_FONT, 0, BORDER);

        if (category != null && !category.equals("")) {
            text = "Category: " + category;
            y = printCentered(text, GameManager.MED_FONT, 0, y);
        }

        text = "Your current score is " + world.getScore();
        y = printCentered(text, GameManager.MED_FONT, 0, y);
        setImage(img);
    }

    /**
     * Method printCentered displays a single centered line.
     *
     * @param line The line of text to display.
     * @param font The font to use.
     * @param x The x-coordinate offset.
     * @param y The y-coordinate offset.
     * @return The y location for use in the next print operation.
     */
    private int printCentered(String line, Font font, int x, int y) {
        final float LINE_WIDTH_MULT = 0.52f;
        img.setFont(font);
        // Approximate font metrics 
        int len = line.length();
        len -= (len - line.replaceAll("[.'1!iI \"]","").length()) / 2;
        len *= font.getSize();
        //        Graphics g = img.getAwtImage().getGraphics();
        //        g.setFont(font);
        //        FontMetrics fm = g.getFontMetrics();
        //        x += (img.getWidth() - fm.stringWidth(line)) / 2;
        x += img.getWidth() / 2 - (int)(len * LINE_WIDTH_MULT / 2);
        y += Math.round(font.getSize() * 1.2f);
        img.drawString(line, x, y);
        return y;
    }
}

