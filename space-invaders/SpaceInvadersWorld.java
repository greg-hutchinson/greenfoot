import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceInvadersWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceInvadersWorld extends World
{
    Label scoreLabel;
    int score;
    /**
     * Constructor for objects of class SpaceInvadersWorld.
     * 
     */
    public SpaceInvadersWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
//        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void addScore(int anIncrement) {
        score = score + anIncrement;
        scoreLabel.setValue("Score: " + score);
    }
}
