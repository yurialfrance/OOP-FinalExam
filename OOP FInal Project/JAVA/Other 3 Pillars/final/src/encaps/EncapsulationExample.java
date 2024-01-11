package encaps;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncapsulationExample extends JFrame {
    private JLabel myLabel;

    public EncapsulationExample() {
   
        setTitle("Encapsulation Example");
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        myLabel = new JLabel("Hello, Encapsulation!");
        myLabel.setFont(new Font("Arial", Font.BOLD, 16)); 

        JButton changeTextButton = new JButton("Click this");
        changeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLabelText();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 

        panel.add(myLabel, gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(changeTextButton, gbc);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    private void changeLabelText() {
        myLabel.setText("Hello Pipol");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EncapsulationExample().setVisible(true);
            }
        });
    }
}
