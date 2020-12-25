package core.save;


public class LevelSave {
    private int totalTimesPlayed;
    private int topLevelNumber;
    private int highScore;
    private boolean isGameWon;

    public LevelSave(int totalTimesPlayed, int topLevelNumber, int highScore, boolean isGameWon) {
        this.totalTimesPlayed = totalTimesPlayed;
        this.topLevelNumber = topLevelNumber;
        this.highScore = highScore;
        this.isGameWon = isGameWon;
    }

    public int getTotalTimesPlayed() {
        return totalTimesPlayed;
    }

    public void setTotalTimesPlayed(int totalTimesPlayed) {
        this.totalTimesPlayed = totalTimesPlayed;
    }

    public int getTopLevelNumber() {
        return topLevelNumber;
    }

    public void setTopLevelNumber(int topLevelNumber) {
        this.topLevelNumber = topLevelNumber;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }
}
