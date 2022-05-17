package dictionary;

public class ScrabblePresenter {
    private ScrabbleFrame view;
    private ScrabbleGame model;
    private int score;

    public ScrabblePresenter(ScrabbleFrame view, ScrabbleGame model) {
        this.view = view;
        this.model = model;
    }

    public void playWord(String word) {
        if (model.playWord(word))
        {
            score++;
            view.setScore(score + "");
            view.setTiles(model.getTiles());
        }
        view.setOutput(model.getDictionaryAndTilesFound());
        view.clearInput();
    }

    public void fillTiles() {
        view.setTiles(model.getTiles());
    }

}
