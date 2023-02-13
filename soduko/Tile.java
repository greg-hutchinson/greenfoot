import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
//        getImage().drawImage(getImage(), 0, 0);
        getImage().clear();
        int number = Greenfoot.getRandomNumber(9) + 1;
        getImage().drawString(""+ number, 0, 20);
    }
    
    public void addedToWorld(World world) {
        getImage().scale(50,50);
    }
}
