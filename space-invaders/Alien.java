import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    int x = -3;
    public void act()
    {
        int currentX = getX();
        int newX = currentX + x;
        int currentY = getY();
        if (newX <= 1) {
            x = -x;
            currentY = getY() + 30; //
        }
        if (newX >= getWorld().getWidth() - 1) {
            x = -x;
            currentY = getY() + 30;
        }
        setLocation(newX, currentY);
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (bullet != null) {
            SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
            world.addScore(10);
            world.removeObject(bullet);
            world.removeObject(this);
        }

            
    }
}
