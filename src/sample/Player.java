package sample;

import java.awt.*;
import java.util.Scanner;

public class Player {
    private String name;
    private int wins;
    private String ore;
    private int stoneCount;
    private int num;

    public Player(int num, int stoneCount){
        this.ore = "";
        this.stoneCount = stoneCount;
        this.num = num;
        this.name = "";
    }

    //User input of the row where the stone should be placed
    public int askColumn(){
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ", please enter the row where the stone should be placed!");
        return sc.nextInt();
    }

    //placing the stone in the row which was inputted by the user
    public void placeStone(Playfield playField, int col){
        for(int i = playField.getSizeY()-1; i >= 0; i--){
            if(!playField.getFieldOccupied(i, col)){
                playField.setFieldOccupied(i, col);
                stoneCount--;
                playField.setFieldNum(i, col, num);
                break;
            }
        }
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public String getName(){
        return name;
    }

    public int getNum(){
        return num;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getOre(){
        return ore;
    }

    public void setOre(String ore){
        this.ore = ore;
    }
}
