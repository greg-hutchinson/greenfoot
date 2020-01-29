import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlyingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class FlyingActor extends Actor
{
    public void adjustForWorldBoundaries() {
        if (getX() + 1 >= getWorld().getWidth())
            setX(1);
        if (getX() <= 0)
            setX(getWorld().getWidth() - 2);
        if (getY() + 1 >= getWorld().getHeight())
            setY(1);
        if (getY() <= 0)
            setY(getWorld().getHeight() - 2);    
    }
    
    private void setX(int anX) {
        setLocation(anX, getY());
    }
    
    private void setY(int aY) {
        setLocation(getX(), aY);
    }


}
