package game.entities;

import game.FroggerGame;
import game.Input;
import game.Map;
import game.debris.Trunk;
import game.vehicles.Vehicle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Frog extends Entity {

    private Input input = FroggerGame.inputHandler;
    public static final int STEP_SIZE = 8;
    public static final int STREAM_FORCE = 2;

    private boolean inRiver = false;
    private boolean died = false;
    private Map map;


            public Frog(int x, int y, Color color){
                    super(x,y,8,8,color);
            }


            //death's only not the right way (lazy ?)
            //well indeed
            public Frog(int x, int y){
                super(x,y,8,8,Color.BLUE);
                image = Map.loadIMG("/res/died.jpg");
            }


            public Frog(int x, int y,Map map){
                super(new Rectangle(x,y,30,30) , Map.loadIMG("/res/frogUp.png"));
                this.map = map;
            }


    @Override
    public void update() {

        if(input.isKeyUp(KeyEvent.VK_UP) || input.isKeyUp(KeyEvent.VK_Z)){
            bounds.y-=STEP_SIZE;
        }
        if(input.isKeyUp(KeyEvent.VK_RIGHT) || input.isKeyUp(KeyEvent.VK_D) && !inRiver){
            bounds.x+=STEP_SIZE / 2;
        }

        if(input.isKeyUp(KeyEvent.VK_DOWN) || input.isKeyUp(KeyEvent.VK_S)){
            bounds.y+=STEP_SIZE;
        }

        if(input.isKeyUp(KeyEvent.VK_LEFT) || input.isKeyUp(KeyEvent.VK_Q) && !inRiver){
            bounds.x-=STEP_SIZE / 2;
        }

    if(stepsOnRiver()) {
        if(isOnATrunck()){
            bounds.x-=STREAM_FORCE;
            inRiver = false;
        }
        else{
            bounds.x-=STREAM_FORCE;
            inRiver = true;
        }
    }
    else{
        inRiver = false;
        }

    if(hitedByObject()){
         respawn();
        }
    }


    private void respawn(){
        bounds.x = Map.WIDTH / 2;
        bounds.y = Map.HEIGHT - 20;
    }

    private boolean hitedByObject(){
                List<Entity> entities = map.getEntities();
                for(Entity e: entities){
                    if(e instanceof Vehicle){
                        if(this.collision(e)){
                            return true;
                        }
                    }
                }
                return false;
    }


    private boolean isOnATrunck(){
        List<Entity> entities = map.getEntities();
        for(Entity e: entities){
            if(e instanceof Trunk){
                if(this.collision(e)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean stepsOnRiver(){
                return bounds.y <= 272 && bounds.y >= 40;
    }

    public void render(Graphics g){
                g.drawImage(image , bounds.x,bounds.y,bounds.width,bounds.height,null);
              //  showLimits(g);
    }
}
