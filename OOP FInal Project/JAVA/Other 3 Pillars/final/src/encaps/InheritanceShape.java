// Code By: Yuri Alfrance Egipto
package encaps;

import javax.swing.*;
import java.awt.*;

class Shape {
    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(50, 50, 100, 100);
    }
}

class Circle extends Shape {
    void draw(Graphics g) {
        super.draw(g);  
    }
}

class Rectangle extends Shape {
    void draw(Graphics g) {
        super.draw(g);  
        g.setColor(Color.RED);
        g.fillRect(200, 50, 100, 100);
    }
}

class ShapePanel extends JPanel {

    private Shape[] shapes;

    ShapePanel(Shape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

public class InheritanceShape {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Shapes GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        Shape[] shapes = {new Circle(), new Rectangle()};
        ShapePanel shapePanel = new ShapePanel(shapes);
        frame.add(shapePanel);

        frame.setVisible(true);
    }
}
