import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

        protected Rectangle bounds;
        protected Color color;
        protected BufferedImage image;

            public Entity(int x,int y,int width,int height,
                          Color color){
                 bounds = new Rectangle(x,y,width,height);
                 this.color = color;
            }

            public abstract void update();

            public void render(Graphics g){
                g.setColor(color);
                g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
            }


}
