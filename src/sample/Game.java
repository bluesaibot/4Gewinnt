package sample;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Game {

    private Playfield playField = new Playfield();
    private Validations validation = new Validations();
    private Player player1 = new Player(1, 21);
    private Player player2 = new Player(2, 21);
    private int win = 0;

    public Game(){
        //initializing the playfield and the players with the stone count calculated

        /*
        //placing the stone at the destined position
        while(player1.getStoneCount() > 0) {
            if(win != 0) break;
            //player 1 stuff
            System.out.println(player1.getName() + "'s remaining stones to place: " + player1.getStoneCount());
            player1.placeStone(playField, (player1.askColumn())-1);
            playField.printPlayfield();

            win = validation.checkX(playField, player1);
            if(win == 0){
                win = validation.checkY(playField, player1);
                if(win == 0) win = validation.checkDiagonal(playField, player1);
            }

            if(win != 0) break;
            //player2 stuff
            System.out.println(player2.getName() + "'s remaining stones to place: " + player2.getStoneCount());
            player2.placeStone(playField, (player2.askColumn())-1);
            playField.printPlayfield();

            win = validation.checkX(playField, player2);
            if(win == 0){
                win = validation.checkY(playField, player2);
                if(win == 0) win = validation.checkDiagonal(playField, player2);
            }
        }

        System.out.println("GAME OVER");
        System.out.println("WINNER: " + win);

         */
    }

    public void setPlayerName(String name, Player player){
        player.setName(name);
    }

    public Player getPlayer(int num){
        if(num == 1) return player1;
        else return player2;
    }

    public Playfield getPlayField(){
        return playField;
    }

    public void placeStone(Player player, int col){
        player.placeStone(playField, col);
        playField.printPlayfield();
    }

    public void validation(Player player) {
        win = validation.checkX(playField, player);
        if (win == 0) {
            win = validation.checkY(playField, player);
            if (win == 0) win = validation.checkDiagonal(playField, player);
        }
    }

    public int getWin(){
        return win;
    }

    public void setPlayerOre(String ore, Player player){
        player.setOre(ore);
    }
}
