package com.main;

import java.awt.*;

/**
 * Created by My PC on 6.3.2017 г..
 */
public abstract class Tank extends GameObject {

    protected int maxBullet;
    protected float bulletSpeed;
    protected int hitPoints;



    public Tank(float x, float y, ID id, Direction direction) {
        super(x, y, id, direction);
    }

    public abstract void tick();


    public abstract void render(Graphics g);


    public abstract Rectangle getBounds();


    public void Shoot() {

    }

    public int getMaxBullet() {
        return maxBullet;
    }

    public void setMaxBullet(int maxBullet) {
        this.maxBullet = maxBullet;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(float bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }


}
