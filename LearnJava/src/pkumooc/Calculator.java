package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liuwenchen
 * @create 2020-07-12 21:12
 */
public class Calculator extends JFrame implements ActionListener {
    private final String[] strings={
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            ".","0","=","+"};

    JButton[] jButtons=new JButton[strings.length];
    JButton reset=new JButton("CE");
    JTextField display=new JTextField("0");

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator()
    {
        super("Calculator");
        Font font=new Font("Consolas",Font.BOLD,18);

        // add components
        JPanel panelHead=new JPanel(new BorderLayout());
        panelHead.add(display,BorderLayout.CENTER);
        panelHead.add(reset,BorderLayout.EAST);

        display.setFont(font);
        reset.setFont(font);

        JPanel panelBody=new JPanel(new GridLayout(4,4));
        for(int i=0;i<strings.length;i++)
        {
            jButtons[i]=new JButton(strings[i]);
            jButtons[i].setFont(font);
            panelBody.add(jButtons[i]);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("North",panelHead);
        getContentPane().add("Center",panelBody);

        // register listeners
        for(int i=0;i<strings.length;i++)
        {
            jButtons[i].addActionListener(this);
        }
        reset.addActionListener(this);
        display.addActionListener(this);

        // set frame properties
        setSize(300,280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        // set frame displayed in the center
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object target=e.getSource();
        String cmd=e.getActionCommand();

        String numberString = "0123456789.";

        if(target == reset) {
            handleReset();
        } else if(numberString.contains(cmd)) {
            handleNumber(cmd);
        } else {
            handleOperator(cmd);
        }
    }

    boolean isFirstDigit=true;
    double number=0.0;
    String operator="=";

    public void handleReset()
    {
        display.setText("0");
        isFirstDigit=true;
        operator="=";
    }

    public void handleNumber(String key)
    {
        String decimalPoint = ".";

        if(isFirstDigit) {
            display.setText(key);
        } else if(!decimalPoint.equals(key)) {
            display.setText(display.getText() + key);
        } else if(!display.getText().contains(decimalPoint)) {
            display.setText(display.getText() + decimalPoint);
        }
        isFirstDigit=false;
    }

    public void handleOperator(String cmd)
    {
        double dDisplay=Double.parseDouble(display.getText());
        switch(operator)
        {
            case "+": number += dDisplay;
                break;
            case "-": number -= dDisplay;
                break;
            case "*": number *= dDisplay;
                break;
            case "/": number /= dDisplay;
                break;
            case "=": number = dDisplay;
                break;
            default:
        }
        display.setText(String.valueOf(number));
        operator=cmd;
        isFirstDigit=true;
    }
}
