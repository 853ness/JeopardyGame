import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A generic button for a game or other application.
 *
 * @author Ed Parrish
 * @version 1 on 11/25/2017
 */
public class Button extends Actor
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Font DEFAULT_FONT = new Font("Dialog", false, false, 12);
    private String text;
    private Font font = DEFAULT_FONT;
    //    private int size;
    private Color textColor;
    private Color bgColor = null;
    private Style style;
    // An identifying number for this component.
    private int id;
    public enum Style { NONE, RECTANGLE, ROUNDED, CIRCLE };
    // Button image in normal (up) state
    private GreenfootImage up;
    // Button image in pressed (down) state
    private GreenfootImage down;
    // Button image in mouseover (hover) state
    private GreenfootImage hover;

    /**
     *  Creates a button with default text and settings.
     */
    public Button() {
        this("Button");
    }

    /**
     *  Creates a button with the specified text and default settings.
     */
    public Button(String text) {
        this(text, 24);
    }

    /**
     * Constructs a button of the specified size with black text
     * on a transparent background.
     *
     * @param text The text to display on the button
     * @param textSize The size of the text in pixels.
     */
    public Button(String text, int textSize) {
        this(text, textSize, Color.BLACK);
    }

    /**
     * Constructs a button of the specified size and text color.
     *
     * @param text The text to display on the button
     * @param size The font size with which to display the text.
     * @param textColor The color to use for displaying text.
     */
    public Button(String text, int textSize, Color textColor) {
        this(text, textSize, Color.BLACK, Style.RECTANGLE);
    }

    /**
     * Constructs a button of the specified size and text color
     * on a transparent background.
     *
     * @param text The text to display on the button
     * @param size The font size with which to display the text.
     * @param textColor The color to use for displaying text.
     * @param Style One of Button.Style.RECTANGLE, ROUNDED, CIRCLE
     */
    public Button(String text, int textSize, Color textColor, Style type) {
        this.text = text;
        font = font.deriveFont(textSize);
        this.textColor = textColor;
        style = type;
        paint();
    }

    /**
     * Constructs a button with text of the specified font and color.
     *
     * @param text The text displayed on the button.
     * @param font The font used to write on this component.
     * @param textColor The color to use for displaying text.
     */
    public Button(String text, Font font, Color textColor) {
        this(text, font, textColor, Button.Style.RECTANGLE);
    }

    /**
     * Constructs a button with text of the specified color on a background
     * of the specified color.
     *
     * @param text The text displayed on the button.
     * @param font The font used to write on this component.
     * @param textColor The color to use for displaying text.
     * @param Style One of Button.Style.RECTANGLE, ROUNDED, CIRCLE
     */
    public Button(String text, Font font, Color textColor, Style type) {
        this(text, font.getSize(), textColor, type);
    }

    /**
     * Constructs a button with text of the specified color on a background
     * of the specified color.
     *
     * @param text The text displayed on the button.
     * @param font The font used to write on this component.
     * @param textColor The color to use for displaying text.
     * @param bgColor The desired background color.
     */
    public Button(String text, Font font, Color textColor, Color bgColor) {
        //super(text, font, textColor, bgColor);
        this.text = text;
        this.font = font;
        this.textColor = textColor;
        this.bgColor = bgColor;
        style = Style.NONE;
        paint();
    }

    /**
     * React to the mouse including rollovers and button clicks.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(hover);
        }
        else if (Greenfoot.mouseMoved(null))
        {
            setImage(up);
        }
        if (Greenfoot.mousePressed(this))
        {
            setImage(down);
        }
        if (Greenfoot.mouseClicked(null)
        || Greenfoot.mouseDragEnded(null))
        {
            setImage(up);
        }
        if (Greenfoot.mouseClicked(this))
        {
            setImage(hover);
            //fireActionEvent();
        }
    }

    /**
     * Returns true if this button is currently down (pressed), otherwise
     * returns false.
     *
     * @return <code>true</code> if this button is currently pressed, otherwise
     * <code>false</code>.
     */
    public boolean isPressed()
    {
        return down == getImage();
    }

    /**
     * Returns true if this button has been pressed and released, otherwise
     * returns false.
     *
     * @return <code>true</code> if this button is clicked, otherwise
     * <code>false</code>.
     */
    public boolean isClicked()
    {
        return down == getImage() && Greenfoot.mouseClicked(this);
    }

    /**
     * Return the ID number of this button.
     *
     * @return The ID number for this button.
     */
    public int getID() {
        return id;
    }

    /**
     * Set an ID number for this button.
     *
     * @param idNumber An identifier number.
     */
    public void setID(int idNumber) {
        id = idNumber;
    }

    /**
     * Returns the text for this button.
     *
     * @return The text displayed on this button.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text to be displayed.
     *
     * @param newText The new text to be displayed on this button.
     */
    public void setText(String newText)
    {
        text = newText;
        paint();
    }

    /**
     * Set the font to use for writing the Button text.
     *
     * @param newFont The font used to write on this Button.
     */
    public void setFont(Font newFont) {
        Font oldFont = font;
        font = newFont;
        if (newFont != null) getImage().setFont(newFont);
        if (font != oldFont) paint();
    }

    /**
     * Returns the current font used by this Button, or null if
     * no font has been set.
     *
     * @return The current font or null if not font has been set.
     */
    public Font getFont() {
        if (font != null) {
            return font;
        }
        return getImage().getFont();
    }

    /**
     * Draws three images for each button state: up, down, hover.
     */
    private void paint()
    {
        int size = font.getSize();
        if (style == Style.RECTANGLE)
        {
            up = new GreenfootImage("rectbtn-up.jpg");
            down = new GreenfootImage("rectbtn-down.jpg");
            hover = new GreenfootImage("rectbtn-hover.jpg");
        }
        else if (style == Style.ROUNDED)
        {
            up = new GreenfootImage("roundedbtn-up.png");
            down = new GreenfootImage("roundedbtn-down.png");
            hover = new GreenfootImage("roundedbtn-hover.png");
        }
        else if (style == Style.CIRCLE)
        {
            up = new GreenfootImage("roundbtn-up.png");
            down = new GreenfootImage("roundbtn-down.png");
            hover = new GreenfootImage("roundbtn-hover.png");
        }
        else if (style == Style.NONE)
        {
            up = new GreenfootImage(50, 50);
            down = new GreenfootImage(50, 50);
            hover = new GreenfootImage(50, 50);
        }
        GreenfootImage img = new GreenfootImage(text, size, textColor,
                TRANSPARENT);
        int width = (int)(img.getWidth() * 1.2);
        int height = (int)(img.getHeight() * 1.2);
        if (style == Style.CIRCLE)
        {
            height = width;
        }
        up.scale(width, height);
        down.scale(width, height);
        hover.scale(width, height);
        int x = (width - img.getWidth()) / 2; // center
        int lines = countLines(text);
        int y = (height - size * lines) / 2; // center
        up.drawImage(img, x, y);
        down.drawImage(img, x + 1, y + 1);
        hover.drawImage(img, x, y);
        setImage(up);
    }

    /**
     * Sets a new background color for this button. Use a low alpha
     * value for a tint.
     *
     * @param color The new color.
     */
    public void setBackgroundColor(Color color)
    {
        up.setColor(color);
        up.fill();
        down.setColor(color);
        down.fill();
        hover.setColor(color);
        hover.fill();
    }

    /**
     * Counts the number of newlines in a string object.
     *
     * @param str The string to test.
     * @return The number of '\n' characters found.
     */
    private int countLines(String str)
    {
        if(str == null || str.isEmpty())
        {
            return 0;
        }
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0)
        {
            lines++;
        }
        return lines;
    }
}

