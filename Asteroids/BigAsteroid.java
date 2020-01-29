import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigAsteroid extends Asteroid
{
    public void bulletDetected() {
        createMediumAsteroid();
        createSmallAsteroid();
    }

    
}
