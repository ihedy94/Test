package com.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by My PC on 4.3.2017 г..
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 2499297730426041683L;

    public static final int WIDTH = 1024 + 8; // 1024 - 58
    public static final int HEIGHT = 795; //768  795

    private Thread thread;
    private boolean running = false;
    public Handler handler;
    private LoadLevel level;
    private Spawn spawn;

    public static BufferedImage sprite_sheet;
    //public static BufferedImage bullet_image;
    private BufferedImage background_image;

    public Game(){
        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet = loader.loadImage("/Tank_SpriteSheet8.png");
        SpriteSheet ss = new SpriteSheet(sprite_sheet);

      /*  bullet_image = loader.loadImage("/bullet1.png");
        BulletSpriteSheet bss = new BulletSpriteSheet(bullet_image);*/

        background_image = ss.grabImage(5, 4, 64, 64); // 10 1    5 2

        handler = new Handler();

        this.addKeyListener(new KeyInput(handler, this));

        new Window(WIDTH, HEIGHT, "Tank Game", this);
        level = new LoadLevel(handler);
        level.LoadNewLevel();
        spawn = new Spawn(handler);



//        handler.addObject(new Player(10 * 64, 5 * 64, ID.Player,Direction.Left, handler));
//
//        handler.addObject(new Enemy(5 * 64, 5 * 64, ID.Enemy,Direction.Right, handler));
//
//        handler.addObject(new NormalWall(13 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
//        handler.addObject(new NormalWall(1 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
//        handler.addObject(new NormalWall(1 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));


    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus(); // SET FOCUS TO the new screen
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

       // p.render(g);
        for (int i = 0; i < 16; i++){   // Show background image
            for (int j = 0; j < 12; j++){
                g.drawImage(background_image, i * 64,j * 64, null);
            }
        }

        handler.render(g);

        //g.drawImage(background_image, 10, 10, null);





        g.dispose();
        bs.show();


    }

    private void tick(){

        handler.tick();
        spawn.tick();
    }

    public static float clamp(float var, float min, float max) {
        if(var > max)
            return var = max;
        else if(var < min)
            return var = min;
        else
            return var;
    }

    public static void main(String[] args) {
        new Game();
    }
}
