import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket extends FlyingActor
{
    private static final int MAX_SPEED = 20;
    private static final int BULLET_WAIT = 25;
    private double speed = 0;
    private int count = BULLET_WAIT;
    private GreenfootSound thrusters = new GreenfootSound("thrustersClip.wav");
    
    public void act() 
    {
        possiblyRotate();
        possiblyFire();
        possiblyAdjustSpeed();
        move((int)speed); 
        adjustForWorldBoundaries();
        detectAsteroidCollision();
    }
    private boolean isLeftKeyPressed() {
        return Greenfoot.isKeyDown ("left");
    }
    private boolean isRightKeyPressed() {
        return Greenfoot.isKeyDown ("right");
    }
    private boolean isUpKeyPressed() {
        return Greenfoot.isKeyDown ("up");
    }
    private boolean isDownKeyPressed() {
        return Greenfoot.isKeyDown ("down");
    }

    private void possiblyRotate() {
        if (isLeftKeyPressed())
            setRotation(getRotation() - 3);
        if (isRightKeyPressed())
            setRotation(getRotation() + 3);
    }
    private void possiblyAdjustSpeed() {
        boolean keyPressed = false;
        if (isUpKeyPressed()) {
            keyPressed = true;
            thrusters.play();
            if (speed <= MAX_SPEED)
                speed = speed + 0.05;
        }
        if (isDownKeyPressed()) {
            keyPressed = true;
            thrusters.play();
            if (speed > 0)
                speed = speed - 0.05;
        }
        if (!keyPressed)
            thrusters.stop();
    }
    private void possiblyFire() {
         if (shouldFire())
            fireBullet();
    }
    
    private void detectAsteroidCollision() {
        Asteroid asteroid = getIntersectingAsteroid(); 
        if (asteroid == null) {
            return;
        }
        getWorld().rocketDestroyed();
        thrusters.stop();
    }
    
    public Asteroids getWorld() {
        return (Asteroids) super.getWorld();
    }
    
    private Asteroid getIntersectingAsteroid() {
        return (Asteroid) getOneIntersectingObject(Asteroid.class);
    }

    
    public void fireBullet() {
        count = BULLET_WAIT;
        Bullet bullet = new Bullet(getRotation(), (int) speed + Bullet.SPEED);
        getWorld().addObject(bullet, getX(), getY());
        bullet.move(getImage().getWidth() / 2);
    }

    public void addedToWorld(World aWorld) {
        Greenfoot.setSpeed(50);
    }


    private boolean shouldFire() {
        count--;
        if (!Greenfoot.isKeyDown ("space"))
            return false;
        return count <= 0;
    }
    
}
