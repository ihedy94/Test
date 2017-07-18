package com.main;

import org.lwjgl.Sys;

import java.util.Random;

/**
 * Created by My PC on 6.3.2017 г..
 */
public class Spawn {

    private Handler handler;
    Random r;
    private int maximumEnemyTanks;
    private int spawnedEnemyTanks;


    private int positionToSpawn = 1;
    private float whenToSpawn = 30;
    private float now = 0;

    private float tick = 0.1f;
    private float time = 0;
    private float timeToSpawn = 50;

    public Spawn(Handler handler){
        this.handler = handler;
        r = new Random();
        maximumEnemyTanks = 6;
        spawnedEnemyTanks = 0;

        handler.addObject(new Player(5 * 64, 11 * 64, ID.Player,Direction.Up, handler)); //5 * 64, 11 * 64
       // handler.addObject(new Enemy(5 * 64, 5 * 64, ID.Enemy,Direction.Right, handler));

        handler.addObject(new StrongEnemy( 0,  0, ID.Enemy,Direction.Down, handler));
        handler.addObject(new Enemy( 7 * 64,  0, ID.Enemy,Direction.Down, handler));
        handler.addObject(new Enemy( 15 * 64,  0, ID.Enemy,Direction.Down, handler));



    }

    public void tick(){
       //System.out.println(time);
        spawnedEnemyTanks = 0;

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Enemy){
                spawnedEnemyTanks++;
            }
        }

        if( now >= timeToSpawn ) {

            if (spawnedEnemyTanks < 3) {
                SpawnEnemyTank();
                //now = 0;
                return;
                //spawnedEnemyTanks++;
            } else if (spawnedEnemyTanks >= 3 && spawnedEnemyTanks < 6) {
                if (time < timeToSpawn) {
                    time += tick;
                } else if (time >= timeToSpawn) {
                    SpawnEnemyTank();
                    //spawnedEnemyTanks ++;
                    time = 0;
                }


            }
            now = 0;
        }else{
            now += tick;
        }





    }

    private void SpawnEnemyTank() {
       // handler.addObject(new FastEnemy(0, 0, ID.Enemy, Direction.Down, handler));
       // int position = r.nextInt(3);
        int tank = r.nextInt(3);
//        if (tank == 0) {
//            if (position == 0) {
//                handler.addObject(new FastEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 1) {
//                handler.addObject(new FastEnemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 2) {
//                handler.addObject(new FastEnemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//            }
//
//           // handler.addObject(new FastEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//        } else if (tank == 1) {
//            if (position == 0) {
//                handler.addObject(new Enemy(0, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 1) {
//                handler.addObject(new Enemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 2) {
//                handler.addObject(new Enemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//            }
//            //handler.addObject(new Enemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//        } else if (tank == 2) {
//            if (position == 0) {
//                handler.addObject(new StrongEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 1) {
//                handler.addObject(new StrongEnemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//            } else if (position == 2) {
//                handler.addObject(new StrongEnemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//            }
//            handler.addObject(new Enemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//        }





//        if (tank == 0) { //working
//            if (positionToSpawn == 1) {
//                handler.addObject(new FastEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 2) {
//                handler.addObject(new FastEnemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 3) {
//                handler.addObject(new FastEnemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn = 1;
//            }
//
//            // handler.addObject(new FastEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//        } else if (tank == 1) {
//            if (positionToSpawn == 1) {
//                handler.addObject(new Enemy(0, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 2) {
//                handler.addObject(new Enemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 3) {
//                handler.addObject(new Enemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn = 1;
//            }
//            //handler.addObject(new Enemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//        } else if (tank == 2) {
//            if (positionToSpawn == 1) {
//                handler.addObject(new StrongEnemy(0, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 2) {
//                handler.addObject(new StrongEnemy(7 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn ++;
//            } else if (positionToSpawn == 3) {
//                handler.addObject(new StrongEnemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//                positionToSpawn = 1;
//            }
//           // handler.addObject(new Enemy(15 * 64, 0, ID.Enemy, Direction.Down, handler));
//        }

    }




}
