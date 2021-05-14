import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

        public static final int CELL_WIDTH = 16;
        public static final int CELL_HEIGHT = 16;

        public static final int WORLD_WIDTH = 80;
        public static final int WORLD_HEIGHT = 40;

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
                        "..............................................................................c." +
                        "......................................x.........................................";


        public Map(){
            setPreferredSize(new Dimension(CELL_WIDTH * WORLD_WIDTH , CELL_HEIGHT * WORLD_HEIGHT));
        }


        private void renderWorld(Graphics g){
             for(int y=0;y<WORLD_HEIGHT;y++){
                  for(int x=0;x<WORLD_WIDTH;x++){
                      char c = map.charAt(x + y * WORLD_WIDTH);
                      switch(c){
                          case 'x':
                              g.setColor(Color.red);
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
            g.setColor(Color.black);
            g.fillRect(0,0,getWidth() , getHeight());
            renderWorld(g);
            repaint();
        }



}
