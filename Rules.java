import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;
    JTextArea rules;
    JScrollPane scrollPane;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        
        JLabel heading = new JLabel("Welcome " + name + " - QUIZ MASTER");
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);

        
        rules = new JTextArea();
        rules.setFont(new Font("Arial", Font.PLAIN, 16));
        rules.setEditable(false);
        rules.setLineWrap(true);
        rules.setWrapStyleWord(true);
        rules.setText(
            "1. The quiz will start promptly at the scheduled time and will be open for the duration specified in the instructions. No additional time will be allotted beyond the designated interval.\n\n" +
            "2. The navigation feature allowing you to revisit previous questions during the quiz has been disabled. Once you proceed to the next question, you will not be able to return to previous questions for review or modification.\n\n" +
            "3. A timer will be prominently displayed on your screen throughout the duration of the quiz, indicating the remaining time available for completing the quiz.\n\n" +
            "4. The marking scheme for each question will be provided alongside the respective question during the quiz. This will allow you to understand the criteria used for evaluating your responses.\n\n" +
            "5. If you encounter any technical or other issues during the quiz, assistance will be provided by the administrator to resolve the issue. Please remain calm, and any lost time due to technical issues will be compensated for.\n\n" +
            "6. Ensure that you submit your responses within the specified format and guidelines provided. Failure to adhere to submission requirements may result in your answers not being considered for evaluation.\n\n" +
            "7. Verify that you have a stable internet connection throughout the duration of the quiz to prevent disruptions or connectivity issues.\n\n" +
            "8. Manage your time effectively to complete the quiz within the allotted duration. Pace yourself accordingly and allocate sufficient time for each question to avoid rushing or running out of time.\n"
        );
        scrollPane = new JScrollPane(rules);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        
        start = new JButton("Start Quiz");
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Arial", Font.BOLD, 16));
        start.addActionListener(this);
        buttonPanel.add(start);

        
        back = new JButton("Back to Login");
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.addActionListener(this);
        buttonPanel.add(back);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(800, 600); // Initial size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                updateFontSize();
            }
        });
    }

    private void updateFontSize() {
        int width = getSize().width;
        float fontSize = Math.max(12, Math.min(20, width / 50));
        rules.setFont(rules.getFont().deriveFont(fontSize));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to start the quiz?", "Start Quiz", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Quiz(name);
            }
        } else {
            setVisible(false);
            new log();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}

