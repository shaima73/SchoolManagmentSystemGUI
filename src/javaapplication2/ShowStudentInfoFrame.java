package javaapplication2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStudentInfoFrame extends JFrame {
    private JTextField idField;
    private JTextArea infoArea;
    private JButton showInfoButton;

    public ShowStudentInfoFrame() {
        setTitle("Show Student Info");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // إنشاء الحقول والأزرار
        idField = new JTextField(14);
        infoArea = new JTextArea(10,20);
        infoArea.setEditable(false);
        showInfoButton = new JButton("Show Info");

        // ترتيب العناصر في اللوحة
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Student ID (14 digits):"));
        panel.add(idField);
        panel.add(showInfoButton);
        panel.add(new JScrollPane(infoArea));  // Scrollable info area

        add(panel);

        // إضافة مستمع الحدث للزر
        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText().trim();

                // استدعاء دالة البحث عن الطالب
                Student student = findStudentById(studentId);
                if (student != null) {
                    infoArea.setText(student.getInfo());  // عرض معلومات الطالب
                } else {
                    JOptionPane.showMessageDialog(ShowStudentInfoFrame.this, "Student not found!");
                }
            }
        });
    }

    private Student findStudentById(String studentId) {
        for (int i = 0; i < JavaApplication2.studentCount; i++) {
            if (JavaApplication2.students[i].getId().equals(studentId)) {
                return JavaApplication2.students[i];
            }
        }
        return null;
    }

   
}