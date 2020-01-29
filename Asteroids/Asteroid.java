import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Asteroid extends FlyingActor
{
    private int speed = Greenfoot.getRandomNumber(6) + 1;
    public void act() 
    {
        move(speed);
        Bullet bullet = getIntersectingBullet(); 
        if (bullet != null) {
            bulletDetected();
            getWorld().removeObject(bullet);
            getWorld().removeObject(this);
            return;
        }
        adjustForWorldBoundaries();
    }
    public void addedToWorld(World aWorld) {
        setRotation(Greenfoot.getRandomNumber(360) + 1);
    }
    
    public void bulletDetected() {
    }
    
    public void createMediumAsteroid() {
        MediumAsteroid asteroid = new MediumAsteroid();
        getWorld().addAsteroid(asteroid, getX(), getY());
    }
    public void createSmallAsteroid() {
        SmallAsteroid asteroid = new SmallAsteroid();
        getWorld().addAsteroid(asteroid, getX(), getY());
    }

    public Asteroids getWorld() {
        return (Asteroids) super.getWorld();
    }
    private Bullet getIntersectingBullet() {
        return (Bullet) getOneIntersectingObject(Bullet.class);
    }

    

    
}
