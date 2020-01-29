import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MediumAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediumAsteroid extends Asteroid
{
    public void bulletDetected() {
        createSmallAsteroid();
    }

}
