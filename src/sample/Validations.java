package sample;

public class Validations {
    public int checkX(Playfield currentPlayfield, Player player){
        for(int i = 0; i < currentPlayfield.getSizeY(); i++){
            for(int j = 0; j < currentPlayfield.getSizeX(); j++){
                if(j <= currentPlayfield.getSizeX()-3){ //damit nicht in den - bereich überprüft wird
                    if(currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j+1) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j+2) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j+3) == player.getNum()) {
                        return player.getNum();
                    }
               }

                if(j >= 3){ //damit nicht in den - bereich überprüft wird
                    if(currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j-1) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j-2) == player.getNum() &&
                            currentPlayfield.getFieldNum(i, j-3) == player.getNum()) {
                        return player.getNum();
                    }
                }
            }
        }
        return 0;
    }

    public int checkY(Playfield currentPlayfield, Player player){
        for(int i = 0; i < currentPlayfield.getSizeY()-3; i++){
            for(int j = 0; j < currentPlayfield.getSizeX(); j++){
                if (currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i+1, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i+2, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i+3, j) == player.getNum()) {
                    return player.getNum();
                }


                if (currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-1, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-2, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-3, j) == player.getNum()) {
                    return player.getNum();
                }
            }
        }
        return 0;
    }

    public int checkDiagonal(Playfield currentPlayfield, Player player){
        for(int i = 3; i < currentPlayfield.getSizeY(); i++){
            for(int j = 0; j < (currentPlayfield.getSizeX()-3); j++){
                //nach unten von oben rechts
                if(currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-1, j+1) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-2, j+2) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-3, j+3) == player.getNum()) {
                    return player.getNum();
                }
            }
        }

        for(int i = 0; i < currentPlayfield.getSizeY(); i++){
            for(int j = 3; j < currentPlayfield.getSizeX(); j++){
                //nach unten von oben links
                if(currentPlayfield.getFieldNum(i, j) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-1, j-1) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-2, j-2) == player.getNum() &&
                        currentPlayfield.getFieldNum(i-3, j-3) == player.getNum()) {
                    return player.getNum();
                }
            }
        }
        return 0;
    }
}
