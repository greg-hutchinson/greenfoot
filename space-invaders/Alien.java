import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    public static int DELAY_PERIOD = 50;
    int x = -14;
    int degrees = 20;
    int delay = DELAY_PERIOD;
    int numberOfSecondsToDropBomb = Greenfoot.getRandomNumber(20) + 5;
    long lastDroppedTime = System.currentTimeMillis() / 1000;

    public void act()
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (bullet != null) {
            SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
            world.addScore(10);
            world.removeObject(bullet);
            explodeAlien();
            world.removeObject(this);
            return;
        }

        if (delay-- > 0) {
            return;
        }
        delay = DELAY_PERIOD;
        int currentX = getX();
        int newX = currentX + x;
        int currentY = getY();
        setLocation(newX, currentY);
        SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
        if (getX() <= 5) {
            world.alienStruckWall();
        }
        if (getX() >= getWorld().getWidth() - 5) {
            world.alienStruckWall();
        }
        long current = System.currentTimeMillis() / 1000;
        if (lastDroppedTime + numberOfSecondsToDropBomb <= current) {
            Bomb bomb = new Bomb();
            bomb.setRotation(90);
            getWorld().addObject(bomb, getX(),getY()+40);
            lastDroppedTime = current;
        }
            
    }
    private void explodeAlien() {
        SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
        PartAlien alien = new PartAlien();
        alien.setImage(new GreenfootImage("green-alien-part1.png"));
        world.addObject(alien, getX(), getY());
            
        alien = new PartAlien();
        alien.setImage(new GreenfootImage("green-alien-part2.png"));
        world.addObject(alien, getX(), getY());
            
        alien = new PartAlien();
        alien.setImage(new GreenfootImage("green-alien-part3.png"));
        world.addObject(alien, getX(), getY());
    }
    
    public void drop() {
        int currentX = getX();
        x = -x;
        int newX = currentX + x;
        int currentY = getY() + 30;
        setLocation(newX, currentY);
       
    }
    public void addedToWorld(World world) {
//        getImage().rotate(-degrees / 2);
    }
}
