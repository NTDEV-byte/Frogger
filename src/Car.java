import java.awt.*;

public class Car extends Entity{

        public Car(int x,int y){
            super(x,y,40,20, Color.green);
            image = Map.loadIMG("res/carL.png");
        }

    @Override
    public void update() {
        bounds.x-=8;
        if(bounds.x <= 0) bounds.x = Map.WIDTH;
    }

    public void render(Graphics g){
        g.drawImage(image , bounds.x , bounds.y , bounds.width , bounds.height , null);
        }
}
