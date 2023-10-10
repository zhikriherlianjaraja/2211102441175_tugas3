import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    /**
     * Act - do whatever the life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int lives;
    public Life(int initialLives) {
        lives = initialLives;
        updateCount();
    }
    public void decreaseLives() {
        lives--;
        updateCount();
    }
    public int getLives() {
        return lives;
    }
    private void updateCount() {
        GreenfootImage image = new GreenfootImage("Lives: " + lives, 24, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    public void act()
    {
        
    }
}
