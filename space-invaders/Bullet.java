import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move (5);
        if (getY() <= 1) {
            getWorld().removeObject(this);
            return;
        }
    }
    
    public boolean isInWorld() {
        return getWorld().getObjects(Alien.class).contains(this);  
    }
}
