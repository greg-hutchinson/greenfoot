import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Breakout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breakout extends World
{
    int score = 0;
    Paddle paddle;
 
    public Breakout()
    {    
        super(800, 600, 1); 
        prepare();
    }

    private void prepare()
    {
        paddle = new Paddle();
        addObject(paddle, getWidth() / 2, getHeight() - 15);
        Ceiling ceiling = new Ceiling();
        addObject(ceiling, getWidth() / 2, 0);
        addObject(new Floor(), getWidth() / 2, getHeight() - 1);
        Wall wall = new Wall();
        addObject(wall, 0, 299);
        Wall wall2 = new Wall();
        addObject(wall2, getWidth(), 299);
        initializeBricks();
        Score score = new Score();
        addObject(score, 730, 30);
        //setImage(map.getImage());
    }
    
    public void addBall(Ball aBall, int anX, int aY) {
        addObject(aBall, anX, aY);
    }
    
    void addToScore(int anInt) {
        score = score + anInt;
    }
    int getScore() {
        return score;
    }
    
    public void ballStruckFloor(Ball aBall) {
        removeObject(aBall);
        paddle.newBall();
    }
    
    private void initializeBricks() {
        int y = 110;
        int yIncrement =  new Brick().getImage().getHeight();
        
        for (int rows = 1; rows < 4; rows++) {
            int x = 40;
            for (int i=0;i<13; i++) {
                Brick brick = new Brick();
                addObject(brick, x, y);
                x = x + 60;
            }
            y = y + yIncrement;
        }
    }
    
    int i = 0;
    public void act() {
        showText("Act number: " + i++, 90, 25);

    }
}
