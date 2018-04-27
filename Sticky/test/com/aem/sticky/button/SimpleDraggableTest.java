package com.aem.sticky.button;

import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.aem.sticky.StickyListener;
import com.aem.sticky.button.Button;
import com.aem.sticky.button.Draggable;
import com.aem.sticky.button.SimpleDraggable;
import com.aem.sticky.button.events.ClickListener;
import com.aem.sticky.button.events.DragListener;

public class SimpleDraggableTest extends BasicGame {

    private LinkedList<String> messages;
    private Draggable button1, button2;
    private StickyListener listener;

    public SimpleDraggableTest() {
        super("Simple Draggable Button Test");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        listener = new StickyListener();
        container.getInput().addListener(listener);
        
        messages = new LinkedList<String>();
        messages.add("Button 1 idle");

        createButtonOne();
        listener.add(button1);
        
        createButtonTwo();        
        listener.add(button2);
    }


    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        button1.update(container, delta);
        button2.update(container, delta);
    }

    public void render(GameContainer container, Graphics g)
            throws SlickException {
        for (int i = 1; i < 11 && i < messages.size(); i++) {
            String m = messages.get(messages.size() - i);
            g.drawString(m, 20, 50 + i * 10);
        }
        button1.render(container, g);
        button2.render(container, g);
    }
    
    private void createButtonTwo() {
        button2 = new SimpleDraggable(new Rectangle(400, 300, 120, 60));
        button2.addListener(new ClickListener() {

            public void onClick(Button clicked, float mx, float my) {
                messages.add("Button 2 clicked");
            }

            public void onDoubleClick(Button clicked, float mx, float my) {
                messages.add("Button 2 double clicked");
            }

            public void onRightClick(Button clicked, float mx, float my) {
                messages.add("Button 2 right clicked");
            }

        });
        
        button2.addListener(new DragListener() {

            public void onDrag(Button b, float mx, float my) {
                // don't display this it will flood the screen
            }

            public void onDragStart(Button b, float mx, float my) {
                messages.add("Button 2 dragged");
            }

            public void onDragStop(Button b, float mx, float my) {
                messages.add("Button 2 free");
            }

        });
    }

    private void createButtonOne() {
        button1 = new SimpleDraggable(new Rectangle(200, 100, 120, 60));
        button1.addListener(new ClickListener() {

            public void onClick(Button clicked, float mx, float my) {
                messages.add("Button 1 clicked");
            }

            public void onDoubleClick(Button clicked, float mx, float my) {
                messages.add("Button 1 double clicked");
            }

            public void onRightClick(Button clicked, float mx, float my) {
                messages.add("Button 1 right clicked");
            }

        });
        
        button1.addListener(new DragListener() {

            public void onDrag(Button b, float mx, float my) {
                // don't display this it will flood the screen
            }

            public void onDragStart(Button b, float mx, float my) {
                messages.add("Button 1 dragged");
            }

            public void onDragStop(Button b, float mx, float my) {
                messages.add("Button 1 free");
            }

        });
    }

    public static void main(String[] args) {
        try {
            AppGameContainer c = new AppGameContainer(
                    new SimpleDraggableTest());
            c.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
