package dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ScrabbleFrame extends JFrame {

    private JLabel scoreLabel;
    private JLabel[] tileLabels;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel output;
    JPanel verticalPanel;
    private final ScrabblePresenter presenter;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this, scrabbleGame);

        setLayout(new FlowLayout());
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel();

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);

        submitButton = new JButton();
        submitButton.setText("Submit Word");
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);

        scoreLabel = new JLabel();
        scoreLabel.setText("0");
        verticalPanel.add(scoreLabel);

        output = new JLabel();
        verticalPanel.add(output);
    }

    private void addTilesPanel() {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tileLabels = new JLabel[7];
        for (int i = 0; i < tileLabels.length; i++)
        {
            tileLabels[i] = new JLabel();
            tilesPanel.add(tileLabels[i]);
        }
        presenter.fillTiles();
        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent event) {
        String word = inputField.getText();
        presenter.playWord(word);
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }

    public void setScore(String score) {
        scoreLabel.setText(score);
    }

    public void clearInput() {
        inputField.setText("");
    }

    public void setOutput(String outputtingString) {
        output.setText(outputtingString);
    }

    public void setTiles(List<Character> tiles) {
        for (int i = 0; i < tiles.size(); i++)
        {
            tileLabels[i].setText(tiles.get(i).toString());
        }
    }


}
