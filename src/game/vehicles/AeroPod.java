package game.vehicles;

import game.Map;

import java.awt.image.BufferedImage;

public class AeroPod extends Vehicle{

        public AeroPod(int x, int y) {
                super(x, y, Map.loadIMG("/res/carR.png"));
        }

        @Override
        public void update() {
                bounds.x+=DEFAULT_SPEED;
                if(bounds.x >= Map.WIDTH){
                        bounds.x = 0;
                }
        }
}
