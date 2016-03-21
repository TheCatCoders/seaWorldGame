import greenfoot.*;

/**
 * Write a description of class StarFish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarFish extends Obstacles
{
    /**
     * Act - do whatever the StarFish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Move faster then the obstacle speed
        this.move( - (OBS_SPEED + 1 ) );
    }    
}
