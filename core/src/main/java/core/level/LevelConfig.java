package core.level;


import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class LevelConfig {
    private int levelId;
    private String[][] levelMap;
    private int blackoutStartTime;
    private int blackoutIntervals;
    private ArrayList<String> texts;
    private ArrayList<Integer> listOfPowerUps;



    public Vector2 getPlayerInitialPosition(){
        return getElementPosition("1").get(0);
    }

    public Vector2 getExitPosition(){
        return getElementPosition("9").get(0);
    }

    public ArrayList<Vector2> getAsteroids(){
        return getElementPosition("7");
    }


    private ArrayList<Vector2> getElementPosition(String element){

        ArrayList<Vector2> elements = new ArrayList<>();

        for(int i = 0; i <= levelMap.length - 1; i++) {
            for (int j = 0; j <= levelMap[i].length - 1; j++) {
                if (levelMap[i][j].equals(element)) {
                    elements.add(new Vector2(j, levelMap.length - i - 1));
                }
            }
        }
        return elements;
    }


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
