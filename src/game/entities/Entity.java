package game.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public static final float DEFAULT_SPEED = 8.0f;


        protected Rectangle bounds;
        protected Color color;
        protected BufferedImage image;

            public Entity(int x,int y,int width,int height,
                          Color color){
                 bounds = new Rectangle(x,y,width,height);
                 this.color = color;
            }

            public Entity(int x,int y,int width,int height,BufferedImage image){
                bounds = new Rectangle(x,y,width,height);
                this.image = image;
            }

            public Entity(Rectangle bounds, BufferedImage image){
                this.bounds = bounds;
                this.image = image;
            }

            protected void showLimits(Graphics g){
                g.setColor(Color.red);
                g.drawRect(bounds.x,bounds.y,bounds.width,bounds.height);
            }

            public boolean collision(Entity e){
                 return bounds.intersects(e.bounds);
            }

            public abstract void update();

            public void render(Graphics g){
                g.setColor(color);
                g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
            }

}
