
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MyApp {
  private static ArrayList<String> tasks = new ArrayList<>();
     public static void main(String[] args) {
        JFrame frame = new JFrame("Utility App");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton calculatorBtn = new JButton("Calculator");
        JButton todoBtn = new JButton("To-Do List");
        JButton passwordBtn = new JButton("Password Generator");
        calculatorBtn.setBounds(120, 50, 160, 40);
        todoBtn.setBounds(120, 120, 160, 40);
        passwordBtn.setBounds(120, 190, 160, 40);
        frame.add(calculatorBtn);
        frame.add(todoBtn);
        frame.add(passwordBtn);
        //             Event bindings
        calculatorBtn.addActionListener(e -> openCalculator());
        todoBtn.addActionListener(e -> openTodo());
        passwordBtn.addActionListener(e -> generatePassword());
        frame.setVisible(true);
    }
    //
    //                   CALCULATOR
    //
    private static void openCalculator() {
        try {
            double num1 = Double.parseDouble(
                    JOptionPane.showInputDialog("Enter first number:")
            );
            double num2 = Double.parseDouble(
                    JOptionPane.showInputDialog("Enter second number:")
            );
            String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose operation",
                    "Calculator",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    operations,
                    operations[0]
            );
            double result = 0;

            switch (choice) {
                case 0:
                    result = num1 + num2;
                    break;
                case 1:
                    result = num1 - num2;
                    break;
                case 2:
                    result = num1 * num2;
                    break;
                case 3:
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    return;
            }
    JOptionPane.showMessageDialog(null, "Result: " + result);
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers.");
        }
    }
    //                      TODO LIST
    //
    private static void openTodo() {

        String[] options = {"Add Task", "View Tasks", "Delete Task"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Select an option",
                "To-Do Manager",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
 case 0:
 //   
 // Add
                String task = JOptionPane.showInputDialog("Enter task:");
                if (task != null && !task.trim().isEmpty()) {
                    tasks.add(task.trim());
                }
                break;

            case 1: // View
                if (tasks.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No tasks available.");
                } else {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < tasks.size(); i++) {
                        builder.append(i + 1)
                               .append(". ")
                               .append(tasks.get(i))
                               .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, builder.toString());
                }
                break;
        case 2: // Delete
                try {
                    int index = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter task number to delete:")
                    ) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.remove(index);
                        JOptionPane.showMessageDialog(null, "Task deleted.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid task number.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
                break;
        }
    }

    //                       PASSWORD GENERATOR 
    private static void generatePassword() {
        try {
            int length = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter password length:")
            );

            String characters =
                    "abcdefghijklmnopqrstuvwxyz" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "0123456789" +
                    "!@#$%^&*";
            Random random = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                password.append(characters.charAt(index));
            }

            JOptionPane.showMessageDialog(null, "Generated Password: " + password);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid length.");
        }
    }
}

