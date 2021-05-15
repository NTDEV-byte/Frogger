import java.awt.*;

public class Truck extends Entity{

    public Truck(int x,int y){
        super(x,y,80,40, Color.white);
        image = Map.loadIMG("res/truckL.png");
    }


    @Override
    public void update() {
        bounds.x-=8;
        if(bounds.x <= 0) bounds.x = Map.WIDTH;
    }

    public void render(Graphics g){
         g.drawImage(image , bounds.x , bounds.y, bounds.width , bounds.height, null);
    }
}
