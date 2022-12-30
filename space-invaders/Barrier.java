import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int hitThreshold = 5;
    public void act()
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (bullet != null) {
            getWorld().removeObject(bullet);
        }
        Bomb bomb = (Bomb) getOneIntersectingObject(Bomb.class);
        if (bomb == null) {
            return;
        }
        hitThreshold--;
        getWorld().removeObject(bomb);
        if (hitThreshold <= 0)
            getWorld().removeObject(this);
        
    }
    public void addedToWorld(World world) 
    {
        
    }
}
