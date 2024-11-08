package javaapplication2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletStudentFrame extends JFrame {
    private JTextField idField;
    private JButton deleteButton;

    public DeletStudentFrame() {
        setTitle("Delete Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

       
        idField = new JTextField(20);
        deleteButton = new JButton("Delete Student");

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Student ID (14 digits):"));
        panel.add(idField);
        panel.add(deleteButton);

        add(panel);

      
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText().trim();

               
                boolean deleted = JavaApplication2.deleteStudent(studentId);
                if (deleted) {
                    JOptionPane.showMessageDialog(DeletStudentFrame.this, "Student deleted successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(DeletStudentFrame.this, "Student not found!");
                }
            }
        });
    }

    
}
