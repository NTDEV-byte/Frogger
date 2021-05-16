package game.vehicles;

import game.Map;
import game.entities.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Vehicle extends Entity {





        public Vehicle(int x, int y, BufferedImage image){
            super(x,y,40,30, Color.green);
            this.image = image;
        }

    @Override
    public abstract void update();



    public void render(Graphics g){
        g.drawImage(image , bounds.x , bounds.y , bounds.width , bounds.height , null);
        }
}
