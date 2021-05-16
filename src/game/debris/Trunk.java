package game.debris;

import game.Map;
import game.entities.Entity;

import java.awt.*;

public class Trunk extends Entity {

            public Trunk(int x,int y){
                super(new Rectangle(x,y,80,30), Map.loadIMG("/res/trunk.png"));
            }

            @Override
            public void update() {
                if(bounds.x <= -bounds.width){
                      bounds.x = Map.WIDTH;
                }
                bounds.x-=2;
            }

        public void render(Graphics g){
            g.drawImage(image , bounds.x,bounds.y,bounds.width,bounds.height , null);
        }
}
