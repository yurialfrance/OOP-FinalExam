package encaps;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


abstract class Transportation {
    String name;

    Transportation(String name) {
        this.name = name;
    }


    abstract String move();


    String stop() {
        return name + " has stopped";
    }
}

interface FuelConsumable {
    String consumeFuel();
}


class Car extends Transportation implements FuelConsumable {
    Car(String name) {
        super(name);
    }


    @Override
    String move() {
        return name + " is moving on the road";
    }

    @Override
    public String consumeFuel() {
        return name + " is consuming fuel";
    }
}

class Bicycle extends Transportation {
    Bicycle(String name) {
        super(name);
    }


    @Override
    String move() {
        return name + " is moving on the bike path";
    }
}


public class VehicleGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Transportation GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton carButton = new JButton("Car");
        JButton bicycleButton = new JButton("Bicycle");

        JTextArea resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(carButton);
        panel.add(bicycleButton);

        frame.getContentPane().add(panel);
        frame.getContentPane().add(new JScrollPane(resultTextArea));

        // Add action listeners to the buttons
        carButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
                Car car = new Car("Toyota");
                resultTextArea.append(car.move() + "\n");
                resultTextArea.append(car.consumeFuel() + "\n");
                resultTextArea.append(car.stop() + "\n");
            }
        });

        bicycleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          
                Bicycle bicycle = new Bicycle("Mountain Bike");
                resultTextArea.append(bicycle.move() + "\n");
                resultTextArea.append(bicycle.stop() + "\n");
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
