package game.vehicles;

import game.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rambo extends Vehicle {


    public Rambo(int x, int y) {
        super(x, y, Map.loadIMG("/res/truckL.png"));
        bounds = new Rectangle(x,y,120,40);
    }

    @Override
    public void update() {
        bounds.x-=DEFAULT_SPEED;
        if(bounds.x <= 0){
            bounds.x = Map.WIDTH;
        }
    }


    public void render(Graphics g){
        g.drawImage(image , bounds.x , bounds.y , bounds.width , bounds.height , null);
    }
}
