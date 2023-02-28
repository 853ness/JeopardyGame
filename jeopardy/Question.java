import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


/**
 * A question the user is asked.
 *
 * @author Michael Berry (mjrb4)
 * @author Ed Parrish
 * @version 1.1  12/01/10
 */
public class Question extends Actor {
    private static final GreenfootImage DEFAULT_IMG = new GreenfootImage(1, 1);
    private static final int LINE_LENGTH = 60;
    private String[] text;
    private List<Answer> answers;
    private String explanation = "";
    private int value;
    private static GreenfootImage img;
    private boolean displayAnswers = true;
    private GameManager world;

    /**
     * Create a new question.
     *
     * @param question The question text.
     * @param questionValue The value of the question.
     */
    public Question(String question, int questionValue) {
        text = GameManager.wordWrap(question, LINE_LENGTH);
        answers = new ArrayList<Answer>();
        value = questionValue;
    }

    /**
     *  Create a copy of a Question from another Question.
     *
     * @param original The Question to copy from.
     */
    public Question(final Question original) {
        text = new String[original.text.length];
        for (int i = 0; i < original.text.length; i++) {
            text[i] = original.text[i];
        }
        answers = new ArrayList(original.answers);
        explanation = original.explanation;
        value = original.value;
        img = new GreenfootImage(original.img);
    }

    /**
     * Check for the end of the question on self-assessed questions.
     */
    public void act() {
        if ((!displayAnswers || answers.size() == 0)
            && (Greenfoot.isKeyDown("space")
            || Greenfoot.mouseClicked(this))) {
            world.selfResponse();
        }
    }

    /**
     * Adds an anser for this question.
     *
     * @param answerText The answer text.
     * @param correct Set <code>true</code> if the answer is correct;
     *        otherwise <code>false</code>.
     */
    public void addAnswer(String answerText, boolean correct) {
        answers.add(new Answer(answerText, correct));
    }

    /**
     * Randomly permutes the list of answers.
     */
    public void shuffleAnswers() {
        Collections.shuffle(answers);
    }

    /**
     * Returns the index of the first occurrence of the specified answer,
     * or -1 if the answer does not exist.
     *
     * @param answer The Answer to find the index of.
     *
     * @return The index of the answer in the list of answers, or -1 if the
     * answer does not exist.
     */
    public int getIndex(Answer answer) {
        return answers.indexOf(answer);
    }

    /**
     * Enables or disables the display of the multiple choice answer list.
     *
     * @param b Set <code>true</code> to enable the display, otherwise set to
     *        <code>false</code>.
     */
    public void setDisplayAnswers(boolean b) {
        displayAnswers = b;
    }

    /**
     * Set the optional explanation for this question.
     *
     * @param explanatoryText The explanation for this question.
     */
    public void setExplanation(String explanatoryText) {
        if (explanatoryText == null) explanatoryText = "";
        explanation = explanatoryText;
    }

    /**
     * Get the explanation for this question.
     *
     * @return The explanation for the question.
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Determine whether this question has an explanation.
     *
     * @return <code>true</code> if the explanation has an answer;
     *         otherwise <code>false</code>.
     */
    public boolean hasExplanation() {
        return explanation != null;
    }

    /**
     * Returns the first correct Answer on the list.
     *
     * Multiple correct answers are allowed.
     *
     * @return The first correct answer on the list.
     */
    public String getFirstCorrectAnswerText() {
        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            if (answer.isCorrect()) {
                return answer.getText();
            }
        }
        return null; // error
    }

    /**
     * Sets the "value" for this question.
     *
     * @param newValue The new value for this question.
     */
    public void setValue(int newValue) {
        value = newValue;
    }

    /**
     * Returns the current value for this question.
     *
     * @return The current value for this question.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the object for debugging purposes.
     *
     * @return The string representation of the object.
     */
    public String toString() {
        return "" + value + ": " + text[0];
    }

    /**
     * Clears the display area and removes this object from the world.
     */
    public void clear() {
        getWorld().removeObjects(answers);
        for (int i = 0; i < answers.size(); i++) {
            Answer a = answers.get(i);
            a.setImage(DEFAULT_IMG);
        }
        img.setColor(Color.BLUE);
        img.fill();
        getWorld().removeObject(this);
    }

    /**
     * Save the world and draw it.
     *
     * @param w the world.
     */
    public void addedToWorld(World w) {
        world = (GameManager) w;
        draw();
        world.startTimer();
    }

    /**
     * Draw the question screen.
     */
    private void draw() {
        final int BORDER = 30;
        if (img == null) {
            World w = getWorld();
            img = new GreenfootImage(w.getWidth(), w.getHeight());
        }
        img.setColor(Color.BLUE);
        img.fill();
        img.setFont(GameManager.SMALL_FONT);
        img.setColor(Color.WHITE);

        for (int i = 0; i < text.length; i++) {
            img.drawString(text[i], 30, 40 + (i * 20));
        }

        setImage(img);

        if (displayAnswers && answers.size() != 0) {
            World w = getWorld();
            for (int i = 0; i < answers.size(); i++) {
                w.addObject(answers.get(i), world.getWidth() / 2,
                    (text.length * 25 + LINE_LENGTH) + i * 40);
            }
        } else {
            img.drawString("Press space or click to continue..." , BORDER,
                img.getHeight() - BORDER);
        }
    }
}
