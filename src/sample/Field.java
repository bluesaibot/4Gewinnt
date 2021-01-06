package sample;

public class Field {
    private int player;
    private Boolean occupied = false;

    public boolean getOccupied(){
        return occupied;
    }

    public void setOccupied(Boolean occupied){
        this.occupied = occupied;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player){
        this.player = player;
    }
}
