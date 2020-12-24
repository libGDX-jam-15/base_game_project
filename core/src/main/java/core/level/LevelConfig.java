package core.level;


import java.util.ArrayList;

public class LevelConfig {
    private int levelId;
    private String[][] levelMap;
    private int blackoutStartTime;
    private int blackoutIntervals;
    private ArrayList<String> texts;
    private ArrayList<Integer> listOfPowerUps;

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String[][] getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(String[][] levelMap) {
        this.levelMap = levelMap;
    }

    public int getBlackoutStartTime() {
        return blackoutStartTime;
    }

    public void setBlackoutStartTime(int blackoutStartTime) {
        this.blackoutStartTime = blackoutStartTime;
    }

    public int getBlackoutIntervals() {
        return blackoutIntervals;
    }

    public void setBlackoutIntervals(int blackoutIntervals) {
        this.blackoutIntervals = blackoutIntervals;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public void setTexts(ArrayList<String> texts) {
        this.texts = texts;
    }

    public ArrayList<Integer> getListOfPowerUps() {
        return listOfPowerUps;
    }

    public void setListOfPowerUps(ArrayList<Integer> listOfPowerUps) {
        this.listOfPowerUps = listOfPowerUps;
    }
}
