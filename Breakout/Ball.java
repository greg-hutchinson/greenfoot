
import greenfoot.*;  
public class Ball extends Actor
{    private boolean stuck = true;

    public void addedToWorld(World aWorld) {
        setRotation(45);
    }
    public void act() 
    {
        move(10);
        
        
        if (getX() >= 799)
            setRotation(180 - getRotation());
        if (getX() < 1)
            setRotation(180 - getRotation());
            
        if (getY() >= 599)
            setRotation(- getRotation());
        if (getY() < 1)
            setRotation( - getRotation());
//        System.out.println(getWidth());
    }
    
    public Breakout getBreakout() {
        return (Breakout) getWorld();
    }
    
    public int getWidth() {
        return getBreakout().getWidth();
    }

}
    

