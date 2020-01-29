import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Score extends TextActor
{
    private static String SCORE = "Score:";
    public Score() {
        super(getInitialImage(), SCORE, 10, 20);
    }
    private static GreenfootImage getInitialImage() {
        GreenfootImage img = new GreenfootImage(150,20);
        img.setFont(new Font("Courier New",true, true,20));
//      img.setFont(new Font(25));
//      img.setColor(Color.RED);
        return img;
    }
    
    public void act() {
        super.act();
    }
    
    int getScore() {
        return ((Breakout) getWorld()).getScore();
    }
    public String getText() {
        return SCORE + getScore();
    }
}
