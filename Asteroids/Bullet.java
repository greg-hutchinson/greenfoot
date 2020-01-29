import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends FlyingActor
{
    public static int SPEED = 15;
    private int speed = 0;
    private int distance = 0;

    public Bullet(int aRotation) {
        this(aRotation, SPEED);
    }
    
    public Bullet(int aRotation, int aSpeed) {
        setRotation(aRotation);
        speed = aSpeed;
        distance = 50;
    }
    
    public void act() 
    {
        move(speed);
        distance--;
        adjustForWorldBoundaries();
        if (distance <= 0) {
            getWorld().removeObject(this);
            return;
        }
    }    
}