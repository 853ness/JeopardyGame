import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A simple label for writing text.
 *
 * @author Ed Parrish
 * @version 2 on 11/25/2017
 */
public class Label extends Actor
{
    // Label backgrounds are transparent by default
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Font DEFAULT_FONT = new Font("Dialog", false, false, 12);
    public static final Color DEFAULT_FG = Color.BLACK;
    public static final Color DEFAULT_BG = TRANSPARENT;
    private String text;
    private Font font = DEFAULT_FONT;
    private Color textColor = DEFAULT_FG;
    private Color bgColor = DEFAULT_BG;
    // Flag to test if background image was set by user
    private boolean hasBGImage;

    /**
     * Constructs a label with a default message and settings.
     */
    public Label() {
        this ("Label", 18, DEFAULT_FG, DEFAULT_BG);
    }

    /**
     * Constructs a label with the specified text using default settings.
     *
     * @param text The text to display on the label
     */
    public Label(String text) {
        this (text, 18, DEFAULT_FG, DEFAULT_BG);
    }

    /**
     * Constructs a label with black text of the specified text size
     * on a clear background.
     *
     * @param text The text to display on the label
     * @param textSize The size of the text in pixels.
     */
    public Label(String text, int textSize) {
        this (text, textSize, DEFAULT_FG, DEFAULT_BG);
    }

    /**
     * Constructs a label of the specified size and text color
     * on a clear background.
     *
     * @param text The text to display on the label
     * @param textSize The size of the text in pixels.
     * @param textColor The color to use for displaying text.
     */
    public Label(String text, int textSize, Color textColor) {
        this (text, textSize, textColor, DEFAULT_BG);
    }

    /**
     * Constructs a label with text of the specified size and color on a
     * background of the specified color.
     *
     * @param text The text to display on the label
     * @param textSize The size of the text in pixels.
     * @param textColor The color to use for displaying text.
     * @param bgColor The desired background color.
     */
    public Label(String text, int textSize, Color textColor, Color bgColor) {
        this.text = text;
        font = font.deriveFont(textSize);
        this.textColor = textColor;
        this.bgColor = bgColor;
        paint();
    }

    /**
     * Constructs a label with the specified text and font using the default
     * text color on a transparent background.
     *
     * @param text The text to display on the label
     * @param font The font with which to write the text.
     */
    public Label(String text, Font font) {
        this (text, font, DEFAULT_FG);
    }

    /**
     * Constructs a label with text of the specified color and font on a
     * transparent background.
     *
     * @param text The text to display on the label
     * @param font The font with which to display the text.
     * @param textColor The color to use for displaying text.
     */
    public Label(String text, Font font, Color textColor) {
        this(text, font, textColor, TRANSPARENT);
    }

    /**
     * Constructs a label with text of the specified color on a background
     * of the specified color.
     *
     * @param text The text to display on the label
     * @param font The font with which to display the text.
     * @param textColor The color to use for displaying text.
     * @param bgColor The desired background color.
     */
    public Label(String text, Font font, Color textColor, Color bgColor) {
        if (text == null) text = "";
        this.text = text;
        this.font = font;
        this.textColor = textColor;
        this.bgColor = bgColor;
        paint();
    }

    /**
     * Constructs a label with the specified background image. The image may
     * be written upon by calling <code>setText()</code>.
     *
     * @param img The background image to display.
     */
    public Label(GreenfootImage img) {
        hasBGImage = true;
        setImage(img);
    }


    /**
     * Returns the text for this label.
     *
     * @return The text displayed on this label.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text to be displayed.
     *
     * @param newText The new text to be displayed on this label.
     */
    public void setText(String newText)
    {
        text = newText;
        paint();
    }

    /**
     * Sets a new background color for this lavel.
     *
     * @param color The new color.
     */
    public void setBackgroundColor(Color color)
    {
        bgColor = color;
        paint();
    }

    /**
     * Returns the current height of this label.
     *
     * @return The height of this label.
     */
    public int getHeight() 
    {
        return getImage().getHeight();  
    }

    /**
     * Returns the current width of this label.
     *
    // * @return The weight of this label.
     */
    public int getWidth() 
    {
        return getImage().getWidth();
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
     * Draws this label.
     */
    private void paint()
    {
        if (hasBGImage) return;
        int size = font.getSize();
        GreenfootImage img = new GreenfootImage(text, size,
                textColor, bgColor);
        GreenfootImage display = img;
        if (!bgColor.equals(TRANSPARENT) || text.equals(""))
        {
            int width = (int)(img.getWidth() * 1.2);
            int height = (int)(img.getHeight() * 1.1);
            display = new GreenfootImage(width, height);
            display.setColor(bgColor);
            display.fill();
            int x = (width - img.getWidth()) / 2;
            int lines = countLines(text);
            int y = (height - size * lines) / 2; // center
            display.drawImage(img, x, y);
        }
        setImage(display);

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

