package com.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by My PC on 6.3.2017 г..
 */
public class FastEnemy  extends Tank {

    // Random r = new Random();
    private Handler handler;
    private float bulletSpeed;
    private float tick = 0.1f;
    private float shootTime = 6.0f;

    private BufferedImage player_image;
    SpriteSheet ss;

    public FastEnemy(float x, float y, ID id, Direction direction, Handler handler){
        super(x, y, id, direction);
        this.handler = handler;
        setMaxBullet(1);
        setHitPoints(1);
        setBulletSpeed(5);
        //bulletSpeed = 5;
        //setVelY(1);

        ss = new SpriteSheet(Game.sprite_sheet);
        player_image = ss.grabImage(1, 5, 64, 64); // 1 5
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 64, 64);
    }

    public void Shoot(){
        if(direction == Direction.Up){
            handler.addObject(new Bullet(x, y - 16, ID.Bullet, direction, getBulletSpeed(), handler, getId()));
        }else if(direction == Direction.Down) {
            handler.addObject(new Bullet(x, y + 17, ID.Bullet, direction, getBulletSpeed(), handler, getId()));
        }else if(direction == Direction.Right) {
            handler.addObject(new Bullet(x + 16, y, ID.Bullet, direction, getBulletSpeed(), handler, getId()));
        }else if(direction == Direction.Left) {
            handler.addObject(new Bullet(x - 16, y, ID.Bullet, direction, getBulletSpeed(), handler, getId()));
        }
    }

    public void tick() {
        x += velX;
        y += velY;

        if(tick >= shootTime){
            //Shoot();
            tick = 0.10f;
        }else{
            tick += 0.10f;
        }




        x = Game.clamp(x, 0, Game.WIDTH - 70);
        y = Game.clamp(y, 0, Game.HEIGHT - 90);

        if(direction == Direction.Up){
            player_image = ss.grabImage(2, 5, 64, 64);
            setDirection(Direction.Up);
        }else if(direction == Direction.Right){
            player_image = ss.grabImage(2, 6, 64, 64);// 1 6
            setDirection(Direction.Right);
        }else if(direction == Direction.Down){
            player_image = ss.grabImage(2, 7, 64, 64);//1 7
            setDirection(Direction.Down);
        }else if(direction == Direction.Left){
            player_image = ss.grabImage(2, 8, 64, 64);
            setDirection(Direction.Left);
        }

        collision();
        //handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 32, 32, 0.02f, handler));

    }

    private void collision(){
        float currentX = x;
        float currentY = y;
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player || tempObject.getId() == ID.NormalWall) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    setVelX(0);
                    setVelY(0);


                    if (direction == Direction.Up) {
                        setVelY(0);
                        // setY(getY() + 1);
                        setY(tempObject.getY() + 64);
                    } else if (direction == Direction.Right) {
                        setVelX(0);
                        //setX(getX() - 1);
                        setX(tempObject.getX() - 64);
                    } else if (direction == Direction.Down) {
                        setVelY(0);
                        //setY(currentY - 1);
                        setY(tempObject.getY() - 64);
                    } else if (direction == Direction.Left) {
                        setVelX(0);
                        setX(getX() + 1);
                        setX(tempObject.getX() + 64);
                    }

                }
            } else if(tempObject.getId() == ID.Bullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    Bullet bul = (Bullet) tempObject;
                    if(bul.shooter == ID.Enemy){
                        System.out.println("Hit");
                        handler.object.remove(tempObject);
                    }else{
                        handler.object.remove(tempObject);
                        handler.object.remove(this);
                    }
                    //collision code

                }
            }
        }
    }

    public void render(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);
//        g2d.draw(getBounds());
//
//        g.setColor(Color.CYAN);
//        g.fillRect((int)x,(int) y, 32, 32);



        g.drawImage(player_image, (int)x, (int)y, null);
    }
}