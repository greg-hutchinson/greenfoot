import greenfoot.*;  
public class Ball extends Actor
{
    private boolean stuck = true;

    protected void addedToWorld(World world) {
        setRotation(333);
    }
        
    public void act() 
    {
        if (isStuck())
            return;
        makeSmoke();
        move(10);
    }
    public void changeXDirection() {
        int current = getRotation();
        setRotation(180 - current);
        move (5);
    }
    public void changeYDirection() {
        int current = getRotation();
        setRotation(360 - current);
        move (5);
    }
    public boolean isStuck() {
        return stuck;
    }
    
    public void struckByPaddle() {
        if (isStuck())
            return;
        if (getRotation() < 180) {
            new GreenfootSound("ping.wav").play();    
            changeYDirection();
        }
    }
    public void becomeUnstuck() {
        stuck = false;
    }
    
    private int smokeX;
    private int smokeY;
    private int count = 0;
    
    private void makeSmoke()
    {
        if (count == 0) {
            smokeX = getX();
            smokeY = getY();
        }
        
        if (count++ >= 2) {
            getWorld().addObject ( new Smoke(), smokeX, smokeY);
            count = 0;
        }
    }
}

