import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Smoke  extends Actor
{
    private GreenfootImage image;   
    private int fade;               // the rate of fading

    public Smoke()
    {
        image = getImage();
        fade = Greenfoot.getRandomNumber(4) + 1;  // 1 to 4
        if (fade > 3) {
          fade = 2;  
        }
    }
    
    public void act() 
    {
        shrink();
    }    
    
    private void shrink()
    {
        if(getImage().getWidth() < 10) {
            getWorld().removeObject(this);
            return;
        }
        GreenfootImage img = new GreenfootImage(image);
        img.scale ( getImage().getWidth()-fade, getImage().getHeight()-fade );
        img.setTransparency ( getImage().getTransparency() - (fade*5) );
        setImage (img);
    }
}
