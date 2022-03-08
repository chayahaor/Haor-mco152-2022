package RPN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNFrame extends  JFrame{
    private JTextField tfInput;
    private JButton btnSubmit;
    private JLabel lblOutput;
    private RPN rpn;

    public RPNFrame() {
        setTitle("RPN Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        tfInput = new JTextField();
        tfInput.setPreferredSize(new Dimension(60, 25));
        verticalPanel.add(tfInput);

        btnSubmit = new JButton();
        btnSubmit.setText("Submit Expression");
        btnSubmit.addActionListener(this::onSubmitClicked);
        verticalPanel.add(btnSubmit);

        lblOutput = new JLabel();
        verticalPanel.add(lblOutput);
    }

    private void onSubmitClicked(ActionEvent event) {
        rpn = new RPN(tfInput.getText());
        lblOutput.setText(rpn.evaluate());
    }

    public static void main(String[] args) {
        RPNFrame frame = new RPNFrame();
        frame.setVisible(true);
    }
}
