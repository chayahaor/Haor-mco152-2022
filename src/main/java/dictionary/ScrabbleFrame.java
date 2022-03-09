package dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScrabbleFrame extends JFrame {
    private int score = 0;
    private JLabel scoreLabel;
    private JLabel[] tiles;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel output;
    JPanel verticalPanel;
    private ScrabbleGame scrabbleGame;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        scrabbleGame=new ScrabbleGame(dictionary, letterPool);


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
        tiles = new JLabel[7];
        for (int i = 0; i < tiles.length; i++)
        {
            tiles[i] = new JLabel(scrabbleGame.tiles.get(i).toString());
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent event) {
        String word= inputField.getText();
        if(scrabbleGame.playWord(word)){
            score++;
            scoreLabel.setText(String.valueOf(score));
            inputField.setText("");
            output.setText(scrabbleGame.dictionaryAndTilesFound);
        }
        else{
            output.setText(scrabbleGame.dictionaryAndTilesFound);
        }
        for (int i = 0; i < tiles.length; i++)
        {
            tiles[i].setText(scrabbleGame.tiles.get(i).toString());
        }

    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
