//Code By: Yuri Alfrance G. Egipto
package encaps;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Infos {

    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("Document Request App");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel mainTitleLabel = new JLabel("Pamantasan ng Lungsod ng Maynila");
        mainTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainTitleLabel.setBounds(20, 10, 360, 30);
        mainTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel subTitleLabel = new JLabel("Document Request App");
        subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitleLabel.setBounds(20, 40, 360, 20);
        subTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 80, 80, 20);

        JLabel studentNumberLabel = new JLabel("Student Number:");
        studentNumberLabel.setBounds(20, 110, 120, 20);

        JLabel collegeLabel = new JLabel("College:");
        collegeLabel.setBounds(20, 140, 80, 20);

        JLabel documentLabel = new JLabel("Document Requesting:");
        documentLabel.setBounds(20, 170, 150, 20);

        JLabel degreeProgramLabel = new JLabel("Degree Program:");
        degreeProgramLabel.setBounds(20, 200, 120, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 230, 80, 20);

        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(20, 260, 120, 20);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(150, 80, 200, 20);

        JTextField studentNumberTextField = new JTextField();
        studentNumberTextField.setBounds(150, 110, 200, 20);

        String[] colleges = {"College of Engineering", "College of Nursing", "College of Education", "College of Science", "Business School"};
        JComboBox<String> collegeComboBox = new JComboBox<>(colleges);
        collegeComboBox.setBounds(150, 140, 200, 20);

        String[] documents = {"Certified True Copy of Diploma", "Certificate of Grades", "Certified True Copy of Transcript of Records", "Certification for NSTP Serial Number", "Certification of Enrollment/Attendance"};
        JComboBox<String> documentComboBox = new JComboBox<>(documents);
        documentComboBox.setBounds(150, 170, 250, 20);

        JTextField degreeProgramTextField = new JTextField();
        degreeProgramTextField.setBounds(150, 200, 200, 20);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(150, 230, 200, 20);

        JTextField mobileNumberTextField = new JTextField();
        mobileNumberTextField.setBounds(150, 260, 200, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(200, 290, 100, 30);

        frame.add(mainTitleLabel);
        frame.add(subTitleLabel);
        frame.add(nameLabel);
        frame.add(studentNumberLabel);
        frame.add(collegeLabel);
        frame.add(documentLabel);
        frame.add(degreeProgramLabel);
        frame.add(emailLabel);
        frame.add(mobileNumberLabel);
        frame.add(nameTextField);
        frame.add(studentNumberTextField);
        frame.add(collegeComboBox);
        frame.add(documentComboBox);
        frame.add(degreeProgramTextField);
        frame.add(emailTextField);
        frame.add(mobileNumberTextField);
        frame.add(submitButton);

        frame.setLayout(null);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                JFrame confirmationFrame = new JFrame("Confirmation");
                confirmationFrame.setSize(400, 250);
                confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

                JPanel titlePanel = new JPanel();
                titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
                titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel titleLabel = new JLabel("Thank You!");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

                JLabel subTitleLabel = new JLabel("Your Document Request has been submitted.");
                subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                titlePanel.add(titleLabel);
                titlePanel.add(subTitleLabel);

                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Create labels to display the entered information
                JLabel nameLabel = new JLabel("Name: " + nameTextField.getText());
                JLabel studentNumberLabel = new JLabel("Student Number: " + studentNumberTextField.getText());
                JLabel collegeLabel = new JLabel("College: " + collegeComboBox.getSelectedItem());
                JLabel documentLabel = new JLabel("Document Requested: " + documentComboBox.getSelectedItem());
                JLabel degreeProgramLabel = new JLabel("Degree Program: " + degreeProgramTextField.getText());
                JLabel emailLabel = new JLabel("Email: " + emailTextField.getText());
                JLabel mobileNumberLabel = new JLabel("Mobile Number: " + mobileNumberTextField.getText());

                infoPanel.add(nameLabel);
                infoPanel.add(studentNumberLabel);
                infoPanel.add(collegeLabel);
                infoPanel.add(documentLabel);
                infoPanel.add(degreeProgramLabel);
                infoPanel.add(emailLabel);
                infoPanel.add(mobileNumberLabel);

                JPanel confirmationPanel = new JPanel();
                confirmationPanel.setLayout(new BoxLayout(confirmationPanel, BoxLayout.Y_AXIS));
                confirmationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                confirmationPanel.add(titlePanel);
                confirmationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                confirmationPanel.add(infoPanel);

                confirmationFrame.add(confirmationPanel);

                confirmationFrame.setLocation(dim.width / 2 - confirmationFrame.getSize().width / 2, dim.height / 2 - confirmationFrame.getSize().height / 2);

                confirmationFrame.setVisible(true);
            }
        });
    }
}
