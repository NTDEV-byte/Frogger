package game.vehicles;

import game.Map;

import java.awt.image.BufferedImage;

public class Carbonator extends Vehicle{


    public Carbonator(int x, int y) {
        super(x, y, Map.loadIMG("/res/carL.png"));
    }

    @Override
    public void update() {
            bounds.x-=DEFAULT_SPEED;
            if(bounds.x <= 0){
                bounds.x = Map.WIDTH;
            }
        }
}
