import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class log extends JFrame implements ActionListener {

    JButton start, back;
    JTextField tfname;
    JPasswordField passwordField;

    log() {
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        JLabel heading = new JLabel("QUIZ MASTER") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw shadow
                g2.setColor(new Color(0, 0, 0, 80));
                g2.setFont(new Font("Menlo", Font.BOLD, 40));
                g2.drawString("QUIZ MASTER", 752, 600); 

                // Draw text
                g2.setColor(new Color(30, 144, 254));
                g2.drawString("QUIZ MASTER", 750, 600); 
                super.paintComponent(g);
            }
        };
        heading.setFont(new Font("Menlo", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 20;
        gbc.gridwidth = 20;
        centerPanel.add(heading, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        JLabel name = new JLabel("Enter name");
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        centerPanel.add(name, gbc);

        tfname = new JTextField(20);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gbc.gridx++;
        centerPanel.add(tfname, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Enter password");
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        passwordLabel.setForeground(new Color(30, 144, 254));
        centerPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gbc.gridx++;
        centerPanel.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(255, 255, 255));

        start = new JButton("Start");
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        buttonPanel.add(start);

        back = new JButton("Back");
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        buttonPanel.add(back);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            String name = tfname.getText();
            char[] password = passwordField.getPassword();
            String enteredPassword = new String(password); 

            if (validatePassword(enteredPassword)) {
                setVisible(false);
                new Rules(name);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect password!");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    private boolean validatePassword(String enteredPassword) {
        String correctPassword = "12345"; // Change this to your correct password
        return enteredPassword.equals(correctPassword);
    }

    public static void main(String[] args) {
        new log();
    }
}
