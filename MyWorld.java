import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public Player player;
    private ScoreBoard scoreBoard;
    private missBullet missBullet;
    protected Life lifeDisplay;
    private int playerLives = 3;
    private int respawnDelay = 100;
    private int respawnTimer = 0;

    public MyWorld() {    
        super(1200, 600, 1);
        spawnPlayer();
        spawnEnemies();
        initializeScoreBoard();
        initializeMissBullet();
        initializeLife();
        prepare();
    }

    private void spawnPlayer() {
        player = new Player(playerLives);
        addObject(player, getWidth() / 2, getHeight() - 30);
    }

    private void spawnEnemies() {
        Random rnd = new Random();
        for (int i = 0; i < rnd.nextInt(5); i++) {
            Enemy enemy = new Enemy(player);
            addObject(enemy, rnd.nextInt(getWidth() - 30), 5);
        }
    }

    private void initializeScoreBoard() {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 100, 50);
    }

    private void initializeMissBullet(){    
        missBullet missBullet = new missBullet();
        addObject(missBullet, 100, 100);
    }

    private void initializeLife() {
        lifeDisplay = new Life(3);
        addObject(lifeDisplay, 80, 120);
    }

    public void act() {
        List<Enemy> enemies = getObjects(Enemy.class);
        if (enemies.isEmpty()) {
            spawnEnemies();
        }
        if (playerLives <= 0){
            if (respawnTimer <= 0) {
                spawnPlayer();
                respawnTimer = respawnDelay;
            } else {
                respawnTimer--;
            }
        }
    }

    private void showEndGameMessage() {
        GreenfootImage messageImage = new GreenfootImage("kalah", 48, Color.RED, null);
        getBackground().drawImage(messageImage, getWidth() / 2 - messageImage.getWidth() / 2, getHeight() / 2 - messageImage.getHeight() / 2);;
    }

    private void prepare()
    {
    }
}       