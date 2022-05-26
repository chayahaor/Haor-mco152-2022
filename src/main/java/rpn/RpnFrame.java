package rpn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RpnFrame extends JFrame {
    private JTextField tfInput;
    private JButton btnSubmit;
    private JLabel lblOutput;
    private Rpn rpn;

    public RpnFrame() {
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
        rpn = new Rpn(tfInput.getText());
        lblOutput.setText(rpn.evaluate());
    }

    public static void main(String[] args) {
        RpnFrame frame = new RpnFrame();
        frame.setVisible(true);
    }
}
