package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public class Background extends BasicGameState {

    private TiledMap map;

    private int x,y;
    private float xc,yc;


    private SpriteSheet MoveRight; // initate a SprtieSheet
    private Animation MoveRightAni; // initate a Animation

    private SpriteSheet MoveLeft; // initate a SprtieSheet
    private Animation MoveLeftAni; // initate a Animation

    private SpriteSheet MoveUp; // initate a SprtieSheet
    private Animation MoveUpAni; // initate a Animation

    private SpriteSheet MoveDown; // initate a SprtieSheet
    private Animation MoveDownAni; // initate a Animation

    private Animation currentImage;

    public Background(int state){

    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        MoveRight = new SpriteSheet("res/char/rosdx.png",62,96); // declare a SpriteSheet and load it into java with its dimentions
        MoveRightAni = new Animation(MoveRight, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        MoveLeft = new SpriteSheet("res/char/rossx.png",62,96); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeftAni = new Animation(MoveLeft, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        MoveUp = new SpriteSheet("res/char/rosup.png",62,96); // declare a SpriteSheet and load it into java with its dimentions
        MoveUpAni = new Animation(MoveUp, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        MoveDown = new SpriteSheet("res/char/rosdwn.png",62,96); // declare a SpriteSheet and load it into java with its dimentions
        MoveDownAni = new Animation(MoveDown, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        currentImage = MoveRightAni;
        currentImage.stop();
        map=new TiledMap("res/map/map_test.tmx","res/map");
        x=0;y=2;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        map.render(0,0);
      //  currentImage.draw(x,y);

        graphics.fillRect(x*32,y*32,32,32);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        int objlayer=map.getLayerIndex("Objects");
        map.getTileId(0,0,objlayer);

        MoveRightAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveUpAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveLeftAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveDownAni.update(delta); // this line makes sure

      /*  Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_W))
        {
            currentImage.start();
            y -= 0.1 * delta;
            currentImage = MoveUpAni;

        }else if (input.isKeyDown(Input.KEY_A))
        {
            currentImage.start();
            x -= 0.1 * delta;
            currentImage = MoveLeftAni;
        }else if (input.isKeyDown(Input.KEY_D))
        {
            currentImage.start();
            x += 0.1 * delta;
            currentImage = MoveRightAni;
        }else if (input.isKeyDown(Input.KEY_S))
        {
            currentImage.start();
            y += 0.1 * delta;
            currentImage = MoveDownAni;
        }else{
            currentImage.restart();
            currentImage.stop();
        }*/



         Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_W))
        {
            if(map.getTileId(x,y-1,objlayer)==0){
               y--;
            }

        }else if (input.isKeyDown(Input.KEY_A))
        {
            if(map.getTileId(x-1,y,objlayer)==0){
                x--;
            }

        }else if (input.isKeyDown(Input.KEY_D))
        {
            if(map.getTileId(x+1,y,objlayer)==0){

                x++;
            }

        }else if (input.isKeyDown(Input.KEY_S))
        {
            if(map.getTileId(x,y+1,objlayer)==0){

                y++;
            }
        }else{
        }
    }
}

