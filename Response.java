import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;

/**
 * A response displayed after each question.
 *
 * @author Ed Parrish
 * @version 1.0  11/21/10
 */
//public class Response extends Actor implements ActionListener {
public class Response extends Actor {
    private static final int LINE_LENGTH = 60;
    private static GreenfootImage img;
    private Question question;
    private Type type;
    private Button right;
    private Button wrong;
    private GameManager world;
    /** The type of the response. */
    public enum Type { RIGHT, WRONG, SELF }

    /**
     * Create a new response with required information.
     *
     * @param q The Question for this response.
     * @param t The type of this response.
     */
    public Response(Question q, Type t) {
        setQuestion(question);
        setType(t);
        right = new Button("Right", 1);
        right.setFont(GameManager.SMALL_FONT);
        //        right.addActionListener(this);
        wrong = new Button("Wrong", 0);
        wrong.setFont(GameManager.SMALL_FONT);
        //        wrong.addActionListener(this);
    }

    /**
     * Respond to a button being clicked in self-assessment mode.
     * Check for the end of the response.
     */
    public void act() {
        if (right.isClicked()) {
            world.answerSelf(true);
            world.endQuestion();
        } else if (wrong.isClicked()) {
            world.answerSelf(false);
            world.endQuestion();
        } else if (type != Type.SELF && (Greenfoot.isKeyDown("space")
            || Greenfoot.mouseClicked(this))) {
            world.endQuestion();
        }
    }

    /**
     * Sets the Question on which this response is based.
     *
     * @param newQuestion The Question on which this response is based.
     */
    public void setQuestion(Question newQuestion) {
        question = newQuestion;
    }

    /**
     * Changes the response message based on whether the answer
     * was correct, not correct or self-assessed.
     *
     * @param t Set RIGHT if a correct answer, WRONG if a wrong answer, or
     *          SELF if self-assessed.
     */
    public void setType(Type t) {
        type = t;
    }

    /**
     * Clears the display area and removes this object from the world.
     */
    public void clear() {
        GreenfootImage image = getImage();
        image.setColor(Color.BLUE);
        image.fill();
        if (type == Type.SELF) {
            world.removeObject(right);
            world.removeObject(wrong);
        }
        world.removeObject(this);
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
     * Draw the response on the screen.
     */
    private void draw() {
        final int BORDER = 30;
        String answer = question.getFirstCorrectAnswerText();
        String[] explanation =
            GameManager.wordWrap(question.getExplanation(), LINE_LENGTH);
        int amount = question.getValue();
        if (img == null) {
            World w = getWorld();
            img = new GreenfootImage(w.getWidth(), w.getHeight());
        }
        img.setColor(Color.BLUE);
        img.fill();
        img.setColor(Color.WHITE);

        String text = "";
        if (type == Type.RIGHT) {
            text = "Congratulations!";
        } else if (type == Type.WRONG) {
            text = "Sorry!";
        }
        int y = printCentered(text, BORDER + 10, GameManager.LARGE_FONT);
        y = printCentered("The correct question is...", y,
            GameManager.MED_FONT);
        if (answer != null) {
            text = "\"What is " + answer + "\"";
        } else {
            text = "unknown (no answer prepared)";
        }
        y = printCentered(text, y, GameManager.MED_FONT);
        if (type != Type.SELF) {
            text = "You ";
            if (type == Type.RIGHT) {
                text += "won " + amount+ " points";
            } else {
                text += "lost zero points";
                text += " ";
            }
            text += " ";
            y = printCentered(text, y, GameManager.MED_FONT);
        }

        int x = BORDER;
        y += 10;
        img.setFont(GameManager.SMALL_FONT);
        //        Graphics g = img.getAwtImage().getGraphics();
        //        g.setFont(GameManager.SMALL_FONT);
        //        FontMetrics fm = g.getFontMetrics();
        //        int height = Math.round(fm.getHeight());
        int height = GameManager.SMALL_FONT.getSize();
        for (int i = 0; i < explanation.length; i++) {
            img.drawString(explanation[i], x, y);
            y += height;
        }

        if (type != Type.SELF) {
            img.drawString("Press space or click to continue..." , x,
                img.getHeight() - BORDER);
        } else {
            img.drawString("My answer was: " , x, y + 30);
            World w = getWorld();
            w.addObject(right, x + 190, y + 23);
            w.addObject(wrong, x + 270, y + 23);
        }

        setImage(img);
    }

    /**
     * Method printCentered displays a single centered line.
     *
     * @param line The line of text to display.
     * @param y The y location.
     * @param font The font to use.
     * @return The y location for use in the next print operation.
     */
    private int printCentered(String line, int y, Font font) {
        final float LINE_HEIGHT_MULT = 1.15f;
        final float LINE_WIDTH_MULT = 0.52f;
        img.setFont(font);
        // Approximate font metrics 
        int len = line.length();
        len -= (len - line.replaceAll("[.'1!iI \"]","").length()) / 2;
        len *= font.getSize();
        //        Graphics g = img.getAwtImage().getGraphics();
        //        g.setFont(font);
        //        FontMetrics fm = g.getFontMetrics();
        int x = img.getWidth() / 2 - (int)(len * LINE_WIDTH_MULT / 2);
        img.drawString(line, x, y);
        y += Math.round(font.getSize() * LINE_HEIGHT_MULT);
        return y;
    }
}

