import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public abstract class TextActor extends Actor
{
    GreenfootImage image;
    int x = 0;
    int y = 0;
    
    public TextActor(GreenfootImage anImage, String aText)
    {
        this(anImage, aText, 10);
    }
    public TextActor(GreenfootImage anImage, String aText, int aYPosition)
    {
        this(anImage, aText, 0, aYPosition);
    }
    
    public TextActor(GreenfootImage anImage, String aText, int aX, int aY)
    {
        String text = "";
        if (aText != null)
            text = aText;
        image = anImage;
        x = aX;
        y = aY;
        image.drawString(text,x,y);
        setImage(image);
    }
    
    
    public void act() 
    {
        image.clear();
        image.drawString(getText(),x,y);
    }
    
    public abstract String getText();
    
}
