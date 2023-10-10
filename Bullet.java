import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor {
    private int speed = 5;

    public Bullet() {
        GreenfootImage img = getImage();
        img.scale(30, 30);
        setImage(img);
    }

    public Bullet(int bulletSpeed) {
        GreenfootImage img = getImage();
        img.scale(20, 20);
        setImage(img);
        speed = bulletSpeed;
    }

    public void act() {
        move(speed);
        if (isAtEdge()) {
            World world = getWorld();
            world.removeObject(this);
            missBullet missBullet = (missBullet) world.getObjects(missBullet.class).get(0);
            missBullet.increaseMissBulletCount();
        } 
        else {
            checkHitEnemy();
            
        }
        
    }
    private void checkHitEnemy(){
    Actor enemy = getOneIntersectingObject(Enemy.class);
    if (enemy != null){
        World world = getWorld();
        world.removeObject(this);
        ScoreBoard scoreBoard = (ScoreBoard) world.getObjects(ScoreBoard.class).get(0);
        scoreBoard.addScore(1);
        }
    }
}
