package javagame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState{
    private SpriteSheet MoveRight; // initate a SprtieSheet
    private Animation MoveRightAni; // initate a Animation

    private SpriteSheet MoveLeft; // initate a SprtieSheet
    private Animation MoveLeftAni; // initate a Animation

    private SpriteSheet MoveUp; // initate a SprtieSheet
    private Animation MoveUpAni; // initate a Animation

    private SpriteSheet MoveDown; // initate a SprtieSheet
    private Animation MoveDownAni; // initate a Animation

    TiledMap map;

    private Animation currentImage;
    public float x = 0;
    public float y = 0;
    float xtogo=0;
    public boolean check=true;

    public Play(int state) throws SlickException {
    }
    @Override
    public int getID() {
        return 1;
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
        map = new TiledMap("res/map/zen_map32b64.tmx","res/map");


    }

    @Override
    public void render(GameContainer gc, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {


        map.render(0,0);
        currentImage.draw(x,y);
        Input input = gc.getInput();


        if(input.isKeyDown(Input.KEY_W)){
            xtogo= (float) (x+2);
            System.out.println(xtogo);
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        MoveRightAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveUpAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveLeftAni.update(delta); // this line makes sure the speed of the Animation is true
        MoveDownAni.update(delta); // this line makes sure the speed of the Animation is true
        boolean go=false;
        currentImage.restart();
        while(x<xtogo){
            go=true;
            x+=0.1*delta;

        }

        if(go){
            currentImage.stop();
            go=false;
        }





      /*  if (input.isKeyDown(Input.KEY_W))
        {
            currentImage.start();
            double g=0.1*3;
            y -=g;
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
        }

        */

    }
}

