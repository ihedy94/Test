package com.main;

/**
 * Created by My PC on 6.3.2017 г..
 */
public class LoadLevel {

    private Handler handler;

    public LoadLevel(Handler handler){
        this.handler = handler;




        handler.addObject(new Base(7 * 64,10* 64, ID.Base, Direction.Down, handler));

       /* handler.addObject(new NormalWall(13 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 10 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));*/

    }


    public void LoadNewLevel(){
        handler.addObject(new NormalWall(1 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(4 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(4 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(4 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(4 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(4 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(5 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(5 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(5 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(5 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(5 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(6 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(6 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(7 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(7 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(8 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(8 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(9 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(9 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new StrongWall(6 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new StrongWall(7 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new StrongWall(8 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new StrongWall(9 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));



        handler.addObject(new NormalWall(10 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(10 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(10 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(10 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(10 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(11 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(11 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(11 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(11 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(11 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new NormalWall(14 * 64, 1 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(14 * 64, 2 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(14 * 64, 3 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(14 * 64, 4 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(14 * 64, 5 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new StrongWall(0, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(1 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(2 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(3 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));

        handler.addObject(new StrongWall(15 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(14 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(13 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
        handler.addObject(new NormalWall(12 * 64, 7 * 64, ID.NormalWall,Direction.Down, handler));
    }
}
