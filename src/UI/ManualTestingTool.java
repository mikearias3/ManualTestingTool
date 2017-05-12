package UI;

import generators.StringGenerators;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mikearias on 5/9/17.
 */
public class ManualTestingTool {
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JTextField nameTextField;
    private JCheckBox nameLegibleCheckBox;
    private JButton nameGenerateButton;
    private JTextField emailTextField;
    private JCheckBox emailLegibleCheckBox;
    private JButton emailGenerateButton;
    private JTextField passwordTextField;
    private JCheckBox passwordLegibleCheckBox;
    private JButton passwordGenerateButton;
    private JTextField numbersTextField;
    private JCheckBox numbersLegibleCheckBox;
    private JSpinner nameCharacterCount;
    private JSpinner emailCharacterCount;
    private JSpinner passwordCharacterCount;
    private JSpinner numbersCharacterCount;
    private JButton numbersGenerateButton;
    private JTextField alphanumericalTextField;
    private JCheckBox alphanumericalLegibleCheckBox;
    private JSpinner alphanumericalCharacterCount;
    private JButton alphanumericalGenerateButton;
    private JTextField addressTextField;
    private JCheckBox addressLegibleCheckBox;
    private JSpinner addressCharacterCount;
    private JButton addressGenerateButton;
    private JTextArea textTextArea;
    private JCheckBox textLegibleCheckBox;
    private JSpinner textCharacterCount;
    private JButton textGenerateButton;

    //TODO: Research possibility of linking email generate method with slipry.
    //TODO: Name app QA Multitool and add a bike's multitool icon.

    public ManualTestingTool() {
        nameGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                name = StringGenerators.getName(nameLegibleCheckBox.isSelected(), (Integer)nameCharacterCount.getValue());
                nameTextField.setText(name);
            }
        });
        emailGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email;
                email = StringGenerators.getEmail(emailLegibleCheckBox.isSelected(), (Integer)emailCharacterCount.getValue());
                emailTextField.setText(email);
            }
        });
        passwordGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password;
                password = StringGenerators.getPassword(passwordLegibleCheckBox.isSelected(), (Integer)passwordCharacterCount.getValue());
                passwordTextField.setText(password);
            }
        });
        numbersGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numbers;
                numbers = StringGenerators.getNumbers(numbersLegibleCheckBox.isSelected(), (Integer)numbersCharacterCount.getValue());
                numbersTextField.setText(numbers);
            }
        });
        alphanumericalGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alphaNum;
                alphaNum = StringGenerators.getAlphaNum(alphanumericalLegibleCheckBox.isSelected(), (Integer)alphanumericalCharacterCount.getValue());
                alphanumericalTextField.setText(alphaNum);
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Manual Testing Helper");
        frame.setContentPane(new ManualTestingTool().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
