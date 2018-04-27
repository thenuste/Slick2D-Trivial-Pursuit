package javagame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

    public String mouse= "No input";
    public int x=100,y=100;

    public SpriteSheet batsheet;
    public Animation batAnimation;


    public Menu(int state){
    }
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        batsheet=new SpriteSheet("res/bat.png",64,64);
        batAnimation=new Animation(batsheet,200);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
            graphics.drawString(mouse,100,100);
            graphics.drawRect(100,200,80,120);
           // graphics.drawOval(200,200,80,80);

            Image face= new Image("res/myface.png");
            graphics.drawImage(face,x,y);
           // batAnimation.draw(x,y);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
            int xpos=Mouse.getX();
            int ypos=Mouse.getY();

            mouse="Mouse position x:"+xpos+ " y: "+ypos;
            batAnimation.update(i);

            Input input=gameContainer.getInput();
            if(input.isKeyDown(Input.KEY_W)){ y-=1; }
        if(input.isKeyDown(Input.KEY_S)){ y+=1; }
        if(input.isKeyDown(Input.KEY_LEFT)){ x-=1; }
        if(input.isKeyDown(Input.KEY_RIGHT)){ x+=1; }

    }
}
