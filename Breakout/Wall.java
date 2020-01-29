import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    GreenfootImage img;
    
    public void act() 
    {
        Ball ball = (Ball) getOneIntersectingObject(Ball.class);
        if (ball != null) 
            ball.changeXDirection();
    }

    public void addedToWorld(World aWorld) {
        img = new GreenfootImage(20,aWorld.getHeight());
        img.setColor(Color.CYAN);
        img.fill();
        setImage(img);
    }
}
