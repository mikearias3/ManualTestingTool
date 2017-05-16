package UI;

import generators.StringGenerators;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
    private JButton addressGenerateButton;
    private JTextArea textTextArea;
    private JCheckBox textLegibleCheckBox;
    private JSpinner textCharacterCount;
    private JButton textGenerateButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton generateButton;
    private JButton clearButton;
    private JTextArea textArea4;

    //TODO: Research possibility of linking email generate method with slipry.
    //TODO: Name app QA Multitool and add a bike's multitool icon.

    public ManualTestingTool() {
        //-- Generator listeners
        nameGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                name = StringGenerators.getName(nameLegibleCheckBox.isSelected(), (Integer)nameCharacterCount.getValue());
                nameTextField.setText(name);
                copyToClipboard(name);
            }
        });
        emailGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email;
                email = StringGenerators.getEmail(emailLegibleCheckBox.isSelected(), (Integer)emailCharacterCount.getValue());
                emailTextField.setText(email);
                copyToClipboard(email);
            }
        });
        passwordGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password;
                password = StringGenerators.getPassword(passwordLegibleCheckBox.isSelected(), (Integer)passwordCharacterCount.getValue());
                passwordTextField.setText(password);
                copyToClipboard(password);
            }
        });
        numbersGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numbers;
                numbers = StringGenerators.getNumbers(numbersLegibleCheckBox.isSelected(), (Integer)numbersCharacterCount.getValue());
                numbersTextField.setText(numbers);
                copyToClipboard(numbers);
            }
        });
        alphanumericalGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alphaNum;
                alphaNum = StringGenerators.getAlphaNum(alphanumericalLegibleCheckBox.isSelected(), (Integer)alphanumericalCharacterCount.getValue());
                alphanumericalTextField.setText(alphaNum);
                copyToClipboard(alphaNum);
            }
        });
        textGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text;
                StringGenerators stringGenerator = new StringGenerators();
                text = stringGenerator.getText((Integer)textCharacterCount.getValue());
                textTextArea.setLineWrap(true);
                textTextArea.setText(text);
                copyToClipboard(text);
            }
        });

        //-- Scenarios combinator listeners

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void copyToClipboard(String string){
        StringSelection stringSelection = new StringSelection(string);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        msgbox("Text copied to clipboard!");
    }

    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Manual Testing Helper");
        frame.setContentPane(new ManualTestingTool().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
