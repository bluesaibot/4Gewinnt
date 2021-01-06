package sample;

import java.util.ArrayList;

public class Playfield {
    private ArrayList<ArrayList<Field>> playField = new ArrayList<>();
    private final int sizeX = 7; //spalten
    private final int sizeY = 6; //reihen
    // .get(y).get(x) -> .get(spalte).get(reihe)

    public Playfield(){
        int i = 0;
        int j = 0;

        //Loops for filling up the playfield with empty fields
        for(i = 0; i < sizeY; i++){
            playField.add(new ArrayList<>());
            for(j = 0; j < sizeX; j++){
                playField.get(i).add(new Field());
            }
            j = 0;
        }
    }

    public int getSizeX(){
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    public void setFieldOccupied(int x, int y) {
        playField.get(x).get(y).setOccupied(true);
    }

    public boolean getFieldOccupied(int x, int y){
        return playField.get(x).get(y).getOccupied();
    }

    public void setFieldNum(int x, int y, int num) {
        playField.get(x).get(y).setPlayer(num);
    }

    public int getFieldNum(int x, int y){
        return playField.get(x).get(y).getPlayer();
    }

    public void printPlayfield(){
        int i;
        int j;

        //Loops for printing the playfield, when it is occupied print 1 and when it is not, print 0
        for(i = 0; i < sizeY; i++){
            playField.add(new ArrayList<>());
            for(j = 0; j < sizeX; j++){
                if(playField.get(i).get(j).getOccupied()){
                    if(playField.get(i).get(j).getPlayer() == 1){
                        System.out.print(1 + " ");
                    } else{
                        System.out.print(2 + " ");
                    }
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.print("\n");
            j = 0;
        }
    }
}
