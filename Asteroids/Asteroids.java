import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Asteroids extends World
{
    private static final int WAIT = 200;
    private int count = WAIT;
    private Rocket rocket;
    private boolean deadRocket = false;
    private int deadRocketCount = 0;
    private int rocketX = 0;
    private int rocketY = 0;
    
    public Asteroids()
    {    
        super(1200 ,800, 1); 
        prepare();
    }
    public void act() {
        if (deadRocket) {
            deadRocketCount--;
            if (deadRocketCount <=0) {
                addObject(rocket, rocketX, rocketY);
                deadRocket = false;
            }
        }
        if (shouldCreateAsteroid()) {
            addAsteroid(createNewAsteroid(), getRandomX()  , getRandomY());
        }
    }
    
    public void addAsteroid(Asteroid anAsteroid, int x, int y) {
        addObject(anAsteroid, x, y );
    }
    public Asteroid createNewAsteroid() {
        int number = Greenfoot.getRandomNumber(3);
        if (number == 0)
            return new BigAsteroid();
        if (number == 1)
            return new MediumAsteroid();
        return new SmallAsteroid();
    }
    public void rocketDestroyed() {
        deadRocket = true;
        deadRocketCount = 100;
        rocketX = rocket.getX();
        rocketY = rocket.getY();
        removeObject(rocket);
    }
        
    private int getRandomX() {
        return Greenfoot.getRandomNumber(getWidth());
    }
    private int getRandomY() {
        return Greenfoot.getRandomNumber(getHeight());
    }
    private boolean shouldCreateAsteroid() {
        if (count-- >= 0)
            return false;
        count = WAIT;
        return true;
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        rocket = new Rocket();
        addObject(rocket, 275, 265);
        addObject(new Score(), getWidth() - 60, 50);
    }

}
