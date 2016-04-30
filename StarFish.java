import greenfoot.*;

/**
 * StarFish Object.
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
 */
public class StarFish extends Obstacles
{
    /**
     * Default method in Greenfoot.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // The obstacle arrive from the right of the screen
        this.move( - (OBS_SPEED + 1 ) );
    }    
}
