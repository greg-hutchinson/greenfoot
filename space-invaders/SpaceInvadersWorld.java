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
        super(600, 400, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab();
        addObject(crab, 450,50);
        Rocket rocket = new Rocket();
        rocket.turn(-90);
        addObject(rocket, 200, 360);
        scoreLabel = new Label("       ", 20);
        addObject(scoreLabel, getWidth() - 70, 20);
        addScore(0);
    }
    public void addScore(int anIncrement) {
        score = score + anIncrement;
        scoreLabel.setValue("Score: " + score);
    }
}
