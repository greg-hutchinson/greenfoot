import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Alien extends Actor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x = -1;
    public void act()
    {
        int currentX = getX();
        int newX = currentX + x;
        int currentY = getY();
        if (newX <= 1) {
            x = -x;
            currentY = getY() + 30;
        }
        if (newX >= getWorld().getWidth() - 1) {
            x = -x;
            currentY = getY() + 30;
        }
        setLocation(newX, currentY);
            
    }
    public abstract int getValue();
    public void addedToWorld(World world) {
       turn(90); 
    }

}
