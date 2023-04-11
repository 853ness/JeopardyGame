import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;

/**
 * Displays a count-down timer during questions.
 *
 * @author Ed Parrish
 * @version 1.0 12/01/10
 */
public class CountDownTimer extends Actor {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 50;
    private static final int MS_SEC = 1000;
    private static final int DISPLAY_TIME = 15;

    private long delay;
    private Timer timer;
    private int count;
    private boolean running;
    private final Color textColor = Color.WHITE;
    private final Font font = new Font("Avenir", true, false, 30);

    /**
     * Constructs a CountDownTimer.
     *
     * @param seconds The duration in seconds.
     */
    public CountDownTimer(int seconds) {
        setDuration(seconds);
        setImage(new GreenfootImage(WIDTH, HEIGHT));
    }

    /**
     * Sets the duration of the timer.
     *
     * @param seconds The duration in seconds.
     */
    public void setDuration(int seconds) {
        delay = (seconds - DISPLAY_TIME) * MS_SEC;
    }
    
    /**
     * Starts a new timer task.
     */
    public void start() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), delay, MS_SEC);
        count = DISPLAY_TIME;
        running = true;
    }

    /**
     * Returns if the timer is running or not.
     *
     * @return <code>true</code> if the timer is running; otherwise
     *         <code>false</code>.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Stops the time.
     */
    public void stop() {
        running = false;
        if (timer != null) timer.cancel();
        getImage().clear();
    }

    /**
     * The scheduled task.
     *
     * @author Ed Parrish
     * @version 1.0 12/01/10
     */
    private class Task extends TimerTask {
        /**
         * Displays the count-down digits.
         */
        public void run() {
            GreenfootImage img = getImage();
            img.clear();
            if (count <= 0) {
                stop();
                ((GameManager) getWorld()).timeout();
            } else {
                img.setColor(Color.BLUE);
                img.fill();
                img.setColor(Color.WHITE);
                img.setFont(font);
                String text = "" + count;
                int x = 8;
                int y = img.getHeight() - 8;
                img.drawString(text, x, y);
            }
            setImage(img);
            count--;
        }
    }
}

