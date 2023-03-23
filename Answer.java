import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * An answer - several of these are displayed per question.
 *
 * @author Michael Berry (mjrb4)
 * @author Ed Parrish
 * @version 1.1  12/01/10
 */
public class Answer extends Actor {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 25;
    private static final int ASCENT = 20;
    private String text;
    private boolean correct;
    private GameManager world;

    /**
     * Construct a new answer.
     *
     * @param answerText The text to display.
     * @param answerCorrect Set <code>true</code> if the answer is correct,
     *        otherwise set <code>false</code>.
     */
    public Answer(String answerText, boolean answerCorrect) {
        text = answerText;
        correct = answerCorrect;
    }

    /**
     * Highlight when hovered over, and tell GameManager when
     * we've been clicked on along with whether we're right
     * or wrong.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (correct) {
                world.answerResponse(true);
            } else {
                world.answerResponse(false);
            }
        }

        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return;

        if (mouse.getActor() == this) {
            draw(Color.GREEN);
        } else {
            draw(Color.WHITE);
        }
    }

    /**
     * Returns whether the answer is correct or not.
     *
     * @return <code>true</code> if correct; otherwise <code>false</code>.
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Returns the answer text.
     *
     * @return The answer text.
     */
    public String getText() {
        return text;
    }

    /**
     * When added to the world, draw.
     *
     * @param w the world.
     */
    public void addedToWorld(World w) {
        world = (GameManager) w;
        draw(Color.WHITE);
    }

    /**
     * Draw the answer to screen.
     *
     * @param colour The color in which to draw the answer.
     */
    private void draw(Color colour) {
        Question question = world.getCurrentQuestion();
        int answerNumber = question.getIndex(this);
        String answerID = Character.toString((char) ('a' + answerNumber));
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(colour);
        image.setFont(GameManager.SMALL_FONT);
        image.drawString(answerID + ". " + text, 0, ASCENT);
        setImage(image);
    }
}
