import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor {
    GreenfootImage img;
    
    public void act() 
    {
        Ball ball = (Ball) getOneIntersectingObject(Ball.class);
        if (ball == null)
            return;
        getWorld().ballStruckFloor(ball);
    }

    public void addedToWorld(World aWorld) {
        img = new GreenfootImage(aWorld.getWidth(),20);
        img.setColor(Color.CYAN);
        img.fill();
        setImage(img);
    }
    
    public Breakout getWorld() {
        return (Breakout) super.getWorld();
    }


}
