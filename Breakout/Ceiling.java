import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 */
public class Ceiling extends Actor
{
    GreenfootImage img;
    
    public void act() 
    {
        Ball ball = (Ball) getOneIntersectingObject(Ball.class);
        if (ball != null) 
            ball.changeYDirection();
    }

    public void addedToWorld(World aWorld) {
        img = new GreenfootImage(aWorld.getWidth(),20);
        img.setColor(Color.CYAN);
        img.fill();
        setImage(img);
    }
}


