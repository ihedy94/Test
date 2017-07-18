package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by My PC on 5.3.2017 г..
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keyDown = new boolean[5];
    private boolean isOnetherKeyPressed = false;
    Player player;

    Game game;

    public KeyInput(Handler handler, Game game){
        this.handler = handler;
        this.game = game;

        keyDown[0] = false;//W
        keyDown[1] = false;//S
        keyDown[2] = false;//D
        keyDown[3] = false;//A
        keyDown[4] = false;//Space
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player && !isOnetherKeyPressed){
                //key event for player 1
                if(key == KeyEvent.VK_W && !isOnetherKeyPressed){
                    tempObject.setVelY(-4);
                    keyDown[0] = true;
                    tempObject.direction = Direction.Up;
                    isOnetherKeyPressed = true;
                }
                if(key == KeyEvent.VK_S && !isOnetherKeyPressed){
                    tempObject.setVelY(4);
                    keyDown[1] = true;
                    tempObject.direction = Direction.Down;
                    isOnetherKeyPressed = true;
                }
                if(key == KeyEvent.VK_D && !isOnetherKeyPressed){
                    tempObject.setVelX(4);
                    keyDown[2] = true;
                    tempObject.direction = Direction.Right;
                    isOnetherKeyPressed = true;
                }
                if(key == KeyEvent.VK_A && !isOnetherKeyPressed){
                    tempObject.setVelX(-4);
                    keyDown[3] = true;
                    tempObject.direction = Direction.Left;
                    isOnetherKeyPressed = true;
                }
                if(key == KeyEvent.VK_SPACE){
                    player = (Player) tempObject;
                    player.Shoot();
                    keyDown[4] = true;
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
//        System.out.println(key);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player /*|| tempObject.getId() == ID.Enemy*/){
                //key events for player 1
                if (key == KeyEvent.VK_W) {
                    keyDown[0] = false;//tempObject.setVelY(0);}
                    isOnetherKeyPressed = false;
                }

                if (key == KeyEvent.VK_S) {
                    keyDown[1] = false;//tempObject.setVelY(0);}
                    isOnetherKeyPressed = false;
                }

                    if (key == KeyEvent.VK_D) {
                     keyDown[2] = false;//tempObject.setVelX(0);
                        isOnetherKeyPressed = false;
                    }
                    if (key == KeyEvent.VK_A){
                        keyDown[3] = false;//tempObject.setVelX(0);
                        isOnetherKeyPressed = false;
                    }
                    if (key == KeyEvent.VK_SPACE) keyDown[4] = false;

                    //vertial movement
                    if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);

                    //horizontal movement
                    if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);


                }
        }

    }
}
