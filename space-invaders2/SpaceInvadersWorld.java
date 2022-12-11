import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SpaceInvadersWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceInvadersWorld extends World
{
    Label scoreLabel;
    int score = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("heartbeat.mp3");
    private boolean alienStruckWall = false;
    /**
     * Constructor for objects of class SpaceInvadersWorld.
     * 
     */
    public SpaceInvadersWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 1000, 1); 
        prepare();
    }
    
    public void prepare() {
        initializeRocket();
        initializeAliens();
        initializeBarriers();
        initializeLabel();
    }
    
    public void started() {
        backgroundMusic.playLoop();
    }

    public void stopped() {
        backgroundMusic.stop();
    }
    
    public void act() {
        if (alienStruckWall) {
            alienStruckWall = false;
            informAliens();
        }
    }
    
    public void alienStruckWall() {
        alienStruckWall = true;
    }
    
    public void informAliens() {
        for (Alien alien : getObjects(Alien.class))
            alien.drop();
    }

    private void initializeRocket() {
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth() / 2, getHeight() - 30);        
    }
        
    private void initializeAliens() {
        int spacing = 60;
        for (int y = 100; y <= 300; y = y + 75) {
            for (int x = 50; x < getWidth(); x = x + spacing) 
            {
                Alien alien = new Alien();
                addObject(alien, x, y);
            }                    
        }
    }

    private void initializeBarriers() {
        int spacing = 300;
        int y = getHeight() - 200;
        for (int x = 50; x < getWidth(); x = x + spacing) 
        {
            Barrier barrier = new Barrier();
            addObject(barrier, x, y);
        }                    
    }
    
    private void initializeLabel() {
        scoreLabel = new Label("Score: 0", 30);
        addObject(scoreLabel, getWidth() - 100, 40);        
    }

    public void addScore(int anIncrement) {
        score = score + anIncrement;
        scoreLabel.setValue("Score: " + score);
    }
    
}
