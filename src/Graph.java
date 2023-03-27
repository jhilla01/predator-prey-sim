import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

    public class Graph extends JPanel {
        private final ArrayList<Integer> rabbitCount;
        private final ArrayList<Integer> foxCount;

        public Graph(ArrayList<Integer> r, ArrayList<Integer> f) {
            rabbitCount = r;
            foxCount = f;
        }
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(10));
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(30, 670, 1500, 670);
            g2.drawLine(30, 670, 30, 30);

            g2.setColor(Color.BLUE);
            lineDraw(g2, rabbitCount);

            g2.setColor(Color.ORANGE);
            lineDraw(g2, foxCount);

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1));

        for(int i = 10; i <= 250; i = i + 10) {
            g2.drawString(String.valueOf(i), 12 + i*5, 700);
        }

        for(int i = 10; i <= 610; i = i + 20) {
            g2.drawString(String.valueOf(i), 5, 650 - (i - 10));
        }

        g2.setFont(new Font("Arial Black", Font.BOLD, 15));
        g2.setColor(Color.BLUE);
        g2.drawString("Rabbits:", 1200, 730);
        g2.fillOval(1180, 720, 10, 10);
        g2.setColor(Color.ORANGE);
        g2.drawString("Foxes:", 1200, 750);
        g2.fillOval(1180, 740, 10, 10);

        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        g2.setColor(Color.RED);
        g2.drawString("Generation #", 700, 750);

        g2.setFont(new Font("Arial Black", Font.BOLD, 25));
        g2.drawString("Rabbit-Fox Population Graph", 600, 50);

        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        AffineTransform at = new AffineTransform();
        at.rotate(-Math.PI / 2);

        g2.setTransform(at);
        g2.drawString("Population:", -800, 20);
    }

        private void lineDraw(Graphics2D g2, ArrayList<Integer> rabbitCount) {
            for (int i = 0; i < rabbitCount.size() - 1; i++) {
                g2.drawLine(12 + (i + 1) * 5, 650 - (rabbitCount.get(i) - 10), 12 + (i + 2) * 5, 650 - (rabbitCount.get(i + 1) - 10));
            }
        }
    }
