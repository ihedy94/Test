package com.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by My PC on 5.3.2017 г..
 */
public class Bullet extends GameObject {
    private float bulletSpeed;
    private Handler handler;
    private SpriteSheet ss ;
    private BufferedImage bullet;
    public ID shooter;

    public Bullet(float x, float y, ID id, Direction direction, float bulletSpeed, Handler handler, ID shooter){
        super(x, y, id, direction);

       // this.direction = direction;
        this.bulletSpeed = bulletSpeed;
        this.handler = handler;
        this.shooter = shooter;
        ss = new SpriteSheet(Game.sprite_sheet);


        if (direction == Direction.Up) {
            velY = bulletSpeed  * (-1);
            velX = 0;
            bullet = ss.grabImage(2, 1, 64, 64);
        } else if (direction == Direction.Down) {
                velY = bulletSpeed;
                velX = 0;
                bullet = ss.grabImage(2, 3, 64, 64);
            // System.out.println("Down");
        } else if (direction == Direction.Left) {
                velX = bulletSpeed * (-1);
                velY = 0;
                bullet = ss.grabImage(2, 4, 64, 64);
               // System.out.println("Left");
        } else if (direction == Direction.Right) {
            velX = bulletSpeed;
            velY = 0;
            bullet = ss.grabImage(2, 2, 64, 64);
            //System.out.println("Right");
        }

    }

    public Rectangle getBounds(){
        if(getDirection() == Direction.Up){
            return new Rectangle((int)x + 23, (int)y, 16, 16);
        }else if(getDirection() == Direction.Right){
            return new Rectangle((int)x + 48, (int)y + 23, 16, 16);
        }else if(getDirection() == Direction.Left){
            return new Rectangle((int)x , (int)y + 23, 16, 16);
        }else {
            return new Rectangle((int)x + 23 , (int)y + 47 , 16, 16);
        }
    }

    public void tick(){
        x += velX;
        y += velY;



        if (x > Game.WIDTH  || x < 0 || y > Game.HEIGHT || y < 0) {
            handler.removeObject(this);
            //System.out.println("Bullet removed");
            //System.out.println("X : " + x + " Y : " + y);
        }
        this.collision();

    }

    public void render(Graphics g){

       /* Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g2d.draw(getBounds());*/

        //g.setColor(Color.black);
        //g.fillRect((int) x + 23, (int) y, 16, 16); //up x +23    down y + 46
        g.drawImage(bullet, (int)x, (int)y, null);
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet && tempObject.direction != this.direction) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(this);
                    handler.removeObject(tempObject);
                   // System.out.println("2 bullets hit");
                 }
            }
        }


    }

}
