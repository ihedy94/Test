package com.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by My PC on 5.3.2017 г..
 */
public class Base extends GameObject {

    private Handler handler;
    private BufferedImage base_image;
    private BufferedImage base_image1;
    private BufferedImage base_image2;
    private BufferedImage base_image3;
    SpriteSheet ss;

    public Base(float x, float y, ID id, Direction direction,Handler handler) {
        super(x, y, id, direction);

        this.handler = handler;

        ss = new SpriteSheet(Game.sprite_sheet);
        base_image = ss.grabImage(3, 2, 64, 64);
        base_image1 = ss.grabImage(3, 3, 64, 64);
        base_image2 = ss.grabImage(4, 2, 64, 64);
        base_image3 = ss.grabImage(4, 3, 64, 64);

        handler.addObject(new NormalWall(6 * 64, 11 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(6 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(6 * 64, 9 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(7 * 64, 9 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(8 * 64, 9 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(9 * 64, 9 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(9 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(9 * 64, 11 * 64, ID.NormalWall,Direction.Down, handler));
    }

    public void tick() {
        collision();
    }


    public void render(Graphics g) {
        g.drawImage(base_image, (int)x, (int)y, null);
        g.drawImage(base_image1, (int)x + 64, (int)y, null);
        g.drawImage(base_image2, (int)x , (int)y + 64, null);
        g.drawImage(base_image3, (int)x + 64, (int)y + 64, null);

    }


    public Rectangle getBounds() {
        return  new Rectangle((int)x, (int)y, 128, 128);
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet)
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    //System.out.println("Hit");
                    handler.object.remove(tempObject);
                }

        }
    }


}
