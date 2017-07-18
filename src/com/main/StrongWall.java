package com.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by My PC on 6.3.2017 г..
 */
public class StrongWall extends  GameObject {

    private Handler handler;
    private BufferedImage wall_image;
    private SpriteSheet ss;

    public StrongWall(float x, float y, ID id, Direction direction, Handler handler) {
        super(x, y, id, direction);

        this.handler = handler;
        ss = new SpriteSheet(Game.sprite_sheet);
        wall_image = ss.grabImage(4, 1, 64,64); // col 3 row 1
    }


    public void tick() {
        this.collision();
    }


    public void render(Graphics g) {
        g.drawImage(wall_image, (int)x, (int) y, null);

    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 64, 64);
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet)
                if (getBounds().intersects(tempObject.getBounds())) {

                   /* if(hitPoints == 0){
                        handler.object.remove(this);
                    }else{
                        hitPoints--;
                    }*/
                    //collision code
                    //System.out.println("Hit");
                    handler.object.remove(tempObject);
                }

        }


    }

}
