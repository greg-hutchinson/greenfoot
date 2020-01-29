import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    int count = 0;
    public void act() 
    {
        getImage().clear();
        getImage().drawString("Score: " + count++, 0, 20);
    }  
    
    public void addedToWorld(World aWorld) {
        GreenfootImage img = new GreenfootImage(100, 80);
        img.setColor(Color.RED);
        img.setFont(img.getFont().deriveFont(16f));
//      img.setFont(new Font("Times New Roman", 16));
        img.drawString("Score: " + 0, 0, 20);
        setImage(img);
    }

}
