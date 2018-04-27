package javagame;
import javagame.com.menu.MainMenu;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame{

    public static final String gamename= "Ham Blaster!";
    public static final int menu=0;
    public static final int play=1;
    public static final int backg=2;

    public Game(String gamename) throws Exception {
        super(gamename);
        this.addState(new MainMenu(menu));
        try {
            this.addState(new Trivia(play));
        } catch (SlickException e) {
            e.printStackTrace();
        }
       // this.addState(new Background(backg));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //gamecontainer main game window loop; inizializza schermate del gioco
        this.getState(menu).init(gameContainer,this);
        this.getState(play).init(gameContainer,this);
 //       this.getState(backg).init(gameContainer,this);
        this.enterState(play);
    }

    public static void main(String[] args) throws Exception {
        AppGameContainer appgc;
        try{
            appgc=new AppGameContainer(new Game(gamename));
            appgc.setDisplayMode(1280,720,false);
            appgc.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }


}
