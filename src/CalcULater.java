import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalcULater implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, multiButton, divButton;
    JButton decButton, equalButton, delButton, clrButton, emptyButton, negButton;
    JPanel panel;

    Font myFont = new Font("Roboto-Mono", Font.BOLD, 25);

    double num1=0,num2=0,result=0;
    char operator;

    CalcULater(){

        frame = new JFrame("Calc U Later");
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 450);
        frame.setLayout(null);

        JLabel labelLogo = new JLabel();
        labelLogo.setText("<html><span style='font-size:25px'>"+"👋👋"+"</span></html>");
        labelLogo.setSize(300, 300);
        labelLogo.setBounds(88, 0, 200, 50);
        frame.add(labelLogo);

        textField = new JTextField();
        textField.setBackground(Color.lightGray);
        textField.setBounds(25, 50, 200, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        emptyButton = new JButton("");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = emptyButton;
        functionButtons[9] = negButton;


        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(25,350,50,45);
        delButton.setBounds(78,350,55,45);
        clrButton.setBounds(136,350,88,45);

        panel = new JPanel();
        panel.setBounds(25,110,200,225);
        panel.setLayout(new GridLayout (4,6,5,5));
        panel.setBackground(Color.darkGray);


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);


        frame.add(panel);

        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);

        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        CalcULater calc = new CalcULater();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == multiButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

    }
}