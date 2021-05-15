import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;
import java.util.List;

public class Map extends JPanel {

        public static final char CAR_LEFT = 'a';
        public static final char CAR_RIGHT = 'b';
        public static final char CAR_RIGHT_2 = 'c';
        public static final char TRUCK = 'd';

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
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "...........................b...b....b..b........................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        ".....................................................................d.........." +
                        "...............................................a................................" +
                        ".....................b....b...b...b............................................." +
                        "....................................b.................b...b.....b..............." +
                        "................................................................................" +
                        "................................................................................" +
                        "................................................................................" +
                        "......................................x.........................................";


        public Map(){
            setPreferredSize(new Dimension(CELL_WIDTH * WORLD_WIDTH , CELL_HEIGHT * WORLD_HEIGHT));
            generateWorld();
            background = loadIMG("res/background.png");
        }



    private void generateWorld(){
        for(int y=0;y<WORLD_HEIGHT;y++){
            for(int x=0;x<WORLD_WIDTH;x++){
                char c = map.charAt(x + y * WORLD_WIDTH);
                switch(c){
                    case 'x':

                        entities.add(new Frog(x * CELL_WIDTH , y * CELL_HEIGHT , Color.BLUE));

                        break;

                    case CAR_LEFT:

                        entities.add(new Car(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case CAR_RIGHT:

                        entities.add(new Car(x * CELL_WIDTH , y * CELL_HEIGHT));


                        break;

                    case CAR_RIGHT_2:

                        entities.add(new Car(x * CELL_WIDTH , y * CELL_HEIGHT));

                        break;

                    case TRUCK:
                        entities.add(new Truck(x * CELL_WIDTH , y * CELL_HEIGHT));
                        break;


                    default:

                        break;
                }
            }
        }
    }



    private void renderWorld(Graphics g){
             for(int y=0;y<WORLD_HEIGHT;y++){
                  for(int x=0;x<WORLD_WIDTH;x++){
                      char c = map.charAt(x + y * WORLD_WIDTH);
                      switch(c){
                          case 'x':
                              g.setColor(Color.red);
                              break;

                          case 'a':
                              g.setColor(Color.CYAN);

                              break;

                          case 'b':
                                g.setColor(Color.white);
                              break;

                          case 'c':
                                g.setColor(Color.green);
                              break;

                          case 'd':
                                g.setColor(Color.magenta);
                              break;
                          default:
                              g.setColor(Color.yellow);
                              break;
                      }
                      g.fillRect(x * CELL_WIDTH , y * CELL_HEIGHT , CELL_WIDTH , CELL_HEIGHT);
                  }
             }
        }


        public void paint(Graphics g){
        //    g.setColor(Color.black);
          //  g.fillRect(0,0,getWidth() , getHeight());
            g.drawImage(background,0,0,getWidth(),getHeight(),null);
            for(Entity e : entities){
                e.update();
                e.render(g);
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //renderWorld(g);
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
