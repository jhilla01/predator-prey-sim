import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

    public class Graph extends JPanel {
        // Two ArrayLists of integers for storing the count of rabbits and foxes
        private final ArrayList<Integer> rabbitCount;
        private final ArrayList<Integer> foxCount;

        public Graph(ArrayList<Integer> r, ArrayList<Integer> f) {
            rabbitCount = r;
            foxCount = f;
        }
        // Override of the paintComponent method that draws the graph on the panel
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            // Set the stroke of the Graphics2D object to 10 and 2
            g2.setStroke(new BasicStroke(10));
            g2.setStroke(new BasicStroke(2));
            // Draw horizontal and vertical lines for the graph
            g2.drawLine(30, 670, 1500, 670);
            g2.drawLine(30, 670, 30, 30);
            // Set the color of the Graphics2D object to blue and draw the line for the rabbit count
            g2.setColor(Color.BLUE);
            lineDraw(g2, rabbitCount);
            // Set the color of the Graphics2D object to orange and draw the line for the fox count
            g2.setColor(Color.ORANGE);
            lineDraw(g2, foxCount);
            // Set the color of the Graphics2D object to black and the stroke to 1
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1));
        // Draw the horizontal labels for the graph
        for(int i = 10; i <= 250; i = i + 10) {
            g2.drawString(String.valueOf(i), 12 + i*5, 700);
        }
        // Draw the vertical labels for the graph
        for(int i = 10; i <= 610; i = i + 20) {
            g2.drawString(String.valueOf(i), 5, 650 - (i - 10));
        }
        // Set the font of the Graphics2D object to Arial Black, bold, and size 15
        g2.setFont(new Font("Arial Black", Font.BOLD, 15));
        // Set the color of the Graphics2D object to blue and draw the line for the rabbit count
        g2.setColor(Color.BLUE);
        g2.drawString("Rabbits:", 1200, 730);
        g2.fillOval(1180, 720, 10, 10);
        // Set the color of the Graphics2D object to orange and draw the line for the fox count
        g2.setColor(Color.ORANGE);
        g2.drawString("Foxes:", 1200, 750);
        g2.fillOval(1180, 740, 10, 10);
        // Set the font of the Graphics2D object to Arial Black, bold, and size 20, and set the color to red. Draw the label for the generation number
        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        g2.setColor(Color.RED);
        g2.drawString("Generation #", 700, 750);
        // Set the font of the Graphics2D object to Arial Black, bold, and size 25, and draw the title of the graph
        g2.setFont(new Font("Arial Black", Font.BOLD, 25));
        g2.drawString("Rabbit-Fox Population Graph", 600, 50);
        // Set the font of the Graphics2D object to Arial Black, bold, and size 20, and rotate the text by 90 degrees to draw the vertical label for the population
        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        AffineTransform at = new AffineTransform();
        at.rotate(-Math.PI / 2);
        g2.setTransform(at);
        g2.drawString("Population:", -800, 20);
    }

    // Private method for drawing the lines for the rabbit and fox counts
        private void lineDraw(Graphics2D g2, ArrayList<Integer> rabbitCount) {
            for (int i = 0; i < rabbitCount.size() - 1; i++) {
                g2.drawLine(12 + (i + 1) * 5, 650 - (rabbitCount.get(i) - 10), 12 + (i + 2) * 5, 650 - (rabbitCount.get(i + 1) - 10));
            }
        }
    }
