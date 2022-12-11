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
    int score = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("heartbeat.mp3");
    /**
     * Constructor for objects of class SpaceInvadersWorld.
     * 
     */
    public SpaceInvadersWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        prepare();
    }
    
    public void prepare() {
        initializeRocket();
        initialAliens();
        initializeLabel();
    }
    
    public void started() {
        backgroundMusic.playLoop();
    }

    public void stopped() {
        backgroundMusic.stop();
    }
    
    private void initializeRocket() {
        Rocket rocket = new Rocket();
        addObject(rocket, 500, 760);        
    }
        
    private void initialAliens() {
        int spacing = 60;
        for (int y = 100; y <= 200; y = y + 100) {
            for (int x = 200; x < 1000; x = x + spacing) 
            {
                Alien alien = new Alien();
                addObject(alien, x, y);
            }                    
        }
    }
    
    private void initializeLabel() {
        scoreLabel = new Label("Score: 0", 30);
        addObject(scoreLabel, 900, 40);        
    }

    public void addScore(int anIncrement) {
        score = score + anIncrement;
        scoreLabel.setValue("Score: " + score);
    }
    
}
