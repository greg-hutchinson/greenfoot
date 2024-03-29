import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound sound = new GreenfootSound("laser.mp3");
    public void act()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(180);
            move(5);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
            move(5);
        }
        setRotation(270);
        List <Bullet> bullets = getWorld().getObjects(Bullet.class);
        if (bullets.isEmpty())
            if (Greenfoot.isKeyDown("space")) {
                Bullet bullet = new Bullet();
                bullet.turn(-90);
                getWorld().addObject(bullet,getX(), getY() - 10);  
                sound.play();
            }
    }
    
    public void addedToWorld(World world) {
        setRotation(270);    
    }
}
