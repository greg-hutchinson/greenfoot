import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PartAlien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartAlien extends Actor
{
    int count = 25;
    /**
     * Act - do whatever the PartAlien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(3);
        count--;
        if (count <= 0)
            getWorld().removeObject(this);
    }

    public void addedToWorld(World world) {
        int rotation = Greenfoot.getRandomNumber​(360);
        setRotation(rotation);    
    }

}
