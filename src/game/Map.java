package game;

import game.debris.Trunk;
import game.vehicles.*;
import game.entities.Entity;
import game.entities.Frog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Map extends JPanel {

        public static final char FROGGO = 'f';
        public static final char AEROPOD = 'a';
        public static final char BONESHAKER = 'b';
        public static final char CARBONATOR = 'c';
        public static final char RAMBO  = 'r';  // Truck
        public static final char TRUNK  = 't';  // Trunk

        public static final int CELL_WIDTH = 16;
        public static final int CELL_HEIGHT = 16;

        public static final int WORLD_WIDTH = 80;
        public static final int WORLD_HEIGHT = 40;


        public static final int WIDTH = WORLD_WIDTH * CELL_WIDTH;
        public static final int HEIGHT = WORLD_HEIGHT * CELL_HEIGHT;


        private BufferedImage background;
        private List<Entity> entities = new ArrayList<>();
        private String map =
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        ".........................t......................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "....................................r..........................................." +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "..................c......c....c.....c.............c.....c......................." +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "............b........b.............b.........b..........a......................." +
                        "................................................................................" +
                        "................................................................................" +
                        ".....................a....a........a......a....a...a....b......................." +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "......................................f.........................................";


        public Map(){
            setPreferredSize(new Dimension(CELL_WIDTH * WORLD_WIDTH , CELL_HEIGHT * WORLD_HEIGHT));
            generateWorld();
            background = loadIMG("/res/background.png");
        }

    private void generateWorld(){
        for(int y=0;y<WORLD_HEIGHT;y++){
            for(int x=0;x<WORLD_WIDTH;x++){
                char c = map.charAt(x + y * WORLD_WIDTH);
                switch(c){
                    case 'f':

                        entities.add(new Frog(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case AEROPOD:

                        entities.add(new AeroPod(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case BONESHAKER:

                        entities.add(new BoneShaker(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case CARBONATOR:

                        entities.add(new Carbonator(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case RAMBO:
                        entities.add(new Rambo(x * CELL_WIDTH , y * CELL_HEIGHT));
                        break;

                    case TRUNK:
                        entities.add(new Trunk(x * CELL_WIDTH , y * CELL_HEIGHT));
                        break;

                    default:

                        break;
                }
            }
        }
    }

        public void paint(Graphics g){
            g.drawImage(background,0,0,getWidth(),getHeight(),null);
            for(Entity e : entities){
                e.update();
                e.render(g);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

        public static BufferedImage loadIMG(String path){
            try {
                BufferedImage image = ImageIO.read(Map.class.getResourceAsStream(path));
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
}
