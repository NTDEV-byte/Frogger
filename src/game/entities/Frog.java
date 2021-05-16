package game.entities;

import game.FroggerGame;
import game.Input;
import game.Map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Frog extends Entity {

    private Input input = FroggerGame.inputHandler;
    public static final int STEP_SIZE = 3;


            public Frog(int x, int y, Color color){
                    super(x,y,8,8,color);
            }


            public Frog(int x, int y){
                super(new Rectangle(x,y,30,30) , Map.loadIMG("/res/frogUp.png"));
            }


    @Override
    public void update() {

        if(input.isKeyDown(KeyEvent.VK_UP)){
            bounds.y-=STEP_SIZE;
        }
        if(input.isKeyDown(KeyEvent.VK_RIGHT)){
            bounds.x+=STEP_SIZE;
        }

        if(input.isKeyDown(KeyEvent.VK_DOWN)){
            bounds.y+=STEP_SIZE;
        }

        if(input.isKeyDown(KeyEvent.VK_LEFT)){
            bounds.x-=STEP_SIZE;
        }
    }


    public void render(Graphics g){
                g.drawImage(image , bounds.x,bounds.y,bounds.width,bounds.height,null);
    }
}
