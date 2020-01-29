import greenfoot.*; 

public class Paddle extends Actor
{
    int offset = 0;
    Ball myBall;
    int deltaX = 9;
    public void act() 
    {
       if (shouldMoveLeft()) 
           move(-deltaX);
       if (shouldMoveRight()) 
           move(deltaX);
       if (shouldLaunchBall()) {
           myBall.becomeUnstuck();
           myBall = null;
           return;
       }
        
       Ball ball = (Ball) getOneIntersectingObject(Ball.class);
       if (ball != null) {
           ball.struckByPaddle();
        }
       updateBallPosition();
    } 
    public void addedToWorld(World aWorld) {
        newBall();
    }

    private Wall getIntersectingLeftWall() {
           return (Wall) getOneIntersectingObject(LeftWall.class);
    }
    private Wall getIntersectingRightWall() {
           return (Wall) getOneIntersectingObject(RightWall.class);
    }
    
    private boolean shouldLaunchBall() {
        return Greenfoot.isKeyDown ("space") && myBall != null;
    }
    
    private boolean shouldMoveLeft() {
        return Greenfoot.isKeyDown ("left") && getIntersectingLeftWall() == null;
    }
    
    private boolean shouldMoveRight() {
        return Greenfoot.isKeyDown ("right") && getIntersectingRightWall() == null;
    }
    private void updateBallPosition() {
        if (myBall == null)
            return;
        myBall.setLocation(getX(), getNewBallY());
    }
    private int getNewBallY() {
        return getY()-20;
    }
    public void newBall() {
        myBall = new Ball();
        getWorld().addBall (myBall, getX(), getNewBallY());
    }

    
    public Breakout getWorld() {
        return (Breakout) super.getWorld();
    }
}
