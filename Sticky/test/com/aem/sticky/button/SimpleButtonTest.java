package com.aem.sticky.button;

import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;

import com.aem.sticky.StickyListener;
import com.aem.sticky.button.Button;
import com.aem.sticky.button.SimpleButton;
import com.aem.sticky.button.events.ButtonListener;
import com.aem.sticky.button.events.ClickListener;

public class SimpleButtonTest extends BasicGame {

    private LinkedList<String> messages;
    private String status;
    private Button button;
    private StickyListener listener;

    public SimpleButtonTest() {
        super("Simple Button Test");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        listener = new StickyListener();
        container.getInput().addListener(listener);
        
        messages = new LinkedList<String>();
        messages.add("Button idle");
        
        status = "Button empty";
        
        createButton(container);
        listener.add(button);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        button.update(container, delta);
    }

    public void render(GameContainer container, Graphics g)
            throws SlickException {
        for (int i = 1; i < 11 && i < messages.size(); i ++) {
            String m = messages.get(messages.size() - i);
            g.drawString(m, 20, 50 + i * 10);
        }
        g.drawString(status, container.getWidth() - 120, 50);
        button.render(container, g);
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer c = new AppGameContainer(new SimpleButtonTest());
            c.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    private void createButton(GameContainer container) throws SlickException {
        float x = container.getWidth() / 2 - 60;
        float y = container.getHeight() / 2 - 20;
        Image up = new Image("test/example/up.png");
        Image down = new Image("test/example/down.png");
        Sound click = new Sound("test/example/click.ogg");
        button = new SimpleButton(new Rectangle(x, y, 120, 40), up, down, click);
        
        button.addListener(new ClickListener() {

            public void onClick(Button clicked, float mx, float my) {
                messages.add("Button clicked");
            }

            public void onDoubleClick(Button clicked, float mx, float my) {
                messages.add("Button double clicked");
            }

            public void onRightClick(Button clicked, float mx, float my) {
                messages.add("Button right clicked");
            }

        });
        
        button.addListener(new ButtonListener() {

            public void onMouseEnter(Button b) {
                status = "Button occupied";
            }

            public void onMouseExit(Button b) {
                status = "Button empty";
            }
            
        });
    }


}
