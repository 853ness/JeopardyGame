import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    private int speed;
    
    public Rocket(){
        speed = 5;
    }
    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null ){
            turnTowards(mouse.getX(),mouse.getY());
        }
        
        World myWorld = getWorld();
        if (getX() < 0 || getX() > myWorld.getWidth() || 
            getY() < 0 || getY() > myWorld.getHeight()){
                myWorld.removeObject(this);
            }
        
    }    
}
