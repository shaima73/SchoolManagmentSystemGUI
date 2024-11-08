package javaapplication2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollCourseFrame extends JFrame {
    private JComboBox<Course> courseComboBox;
    private JTextField studentIdField;
    private JButton enrollButton;

    public EnrollCourseFrame() {
        setTitle("Enroll in Course");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // إنشاء الحقول والأزرار
        studentIdField=new JTextField(16);
        courseComboBox = new JComboBox<>(JavaApplication2.courses);  // قائمة بالكورسات المتاحة
        enrollButton = new JButton("Enroll in Course");

        // ترتيب العناصر في اللوحة
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Student ID (14 digits):"));
        panel.add(studentIdField);
        panel.add(new JLabel("Select Course:"));
        panel.add(courseComboBox);
        panel.add(enrollButton);

        add(panel);

        // إضافة مستمع الحدث للزر
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText().trim();

                // التحقق من وجود الطالب في المصفوفة
                Student student = findStudentById(studentId);
                if (student != null) {
                    Course selectedCourse = (Course) courseComboBox.getSelectedItem();
                    if (selectedCourse != null) {
                        student.enrollCourse(selectedCourse);  // تسجيل الطالب في الكورس
                        JOptionPane.showMessageDialog(EnrollCourseFrame.this, "Student enrolled in course successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(EnrollCourseFrame.this, "Student not found!");
                }
            }
        });
    }

    // دالة للبحث عن الطالب باستخدام ID
    private Student findStudentById(String studentId) {
        for (int i = 0; i < JavaApplication2.studentCount; i++) {
            if (JavaApplication2.students[i].getId().equals(studentId)) {
                return JavaApplication2.students[i];
            }
        }
        return null;
    }
}