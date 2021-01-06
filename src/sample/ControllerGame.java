package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ControllerGame {
    @FXML private Label firstPlaceName;
    @FXML private Label secondPlace;
    @FXML private Label firstPlace;
    @FXML private ImageView imageViewBackgroundEndMenu;
    @FXML private Button buttonShowWinner;
    @FXML private GridPane gridPane;
    @FXML private Label labelRemainingStones;
    @FXML private Label labelTurn;
    @FXML private Button buttonPvP;
    @FXML private Button buttonSelectNames;
    @FXML private Button buttonExit;
    @FXML private Button buttonConfirm;
    @FXML private TextField textFieldPlayer2;
    @FXML private TextField textFieldPlayer1;
    @FXML private ComboBox comboBoxPlayer1;
    @FXML private ComboBox comboBoxPlayer2;

    private int turn = 1;

    private static Game game = new Game();

    public ControllerGame() throws IOException {
    }

    //Main Menu button
    public void buttonPvPOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonPvP.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage.setTitle("Game");
        stage.setScene(new Scene(root, 1024, 576));
    }

    //Main menu Button
    public void buttonSelectNamesOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonSelectNames.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SelectNames.fxml"));
        stage.setTitle("Select Names");
        stage.setScene(new Scene(root, 1024, 576));
        stage.getScene().getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());
    }

    //Main menu Button
    public void buttonExitOnMouseClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }

    //Select Players Button
    public void buttonConfirmedOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonConfirm.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage.setTitle("Game");
        stage.setScene(new Scene(root, 1024, 576));
        stage.getScene().getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());

        //setting player names
        game.setPlayerName(textFieldPlayer1.getText(), game.getPlayer(1));
        game.setPlayerName(textFieldPlayer2.getText(), game.getPlayer(2));

        //setting player ores
        game.setPlayerOre(comboBoxPlayer1.getValue().toString(), game.getPlayer(1));
        game.setPlayerOre(comboBoxPlayer2.getValue().toString(), game.getPlayer(2));
    }

    //Placing stone in a row
    public void labelSpalte1OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(0);
    }

    public void labelSpalte2OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(1);
    }

    public void labelSpalte3OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(2);
    }

    public void labelSpalte4OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(3);
    }

    public void labelSpalte5OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(4);
    }

    public void labelSpalte6OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(5);
    }

    public void labelSpalte7OnMouseClick(MouseEvent mouseEvent) throws IOException {
        setVirtualStone(6);
    }

    //used for the LabelOnMouseClick to write less code
    public void setVirtualStone(int col) throws IOException {
        //game.validation(game.getPlayer(1));
        //game.validation(game.getPlayer(2));

        if(turn == 1 && game.getWin() == 0) {
            game.placeStone(game.getPlayer(1), col);
            game.validation(game.getPlayer(1));
            turn = 2;
            labelTurn.setText("Turn: " + game.getPlayer(2).getName());
            labelRemainingStones.setText("Remaining Ores: " + game.getPlayer(1).getStoneCount());
        }
        else if(turn == 2 && game.getWin() == 0) {
            game.placeStone(game.getPlayer(2), col);
            game.validation(game.getPlayer(2));
            turn = 1;
            labelTurn.setText("Turn: " + game.getPlayer(1).getName());
            labelRemainingStones.setText("Remaining Ores: " + game.getPlayer(2).getStoneCount());
        }
        setVisualStone();
        if(game.getWin() != 0){
            winScene();
        }
    }

    //used for setting the stone on the gridpane
    private void setVisualStone() throws IOException {
        int i = 0;
        int j = 0;
        for(i = 0; i < game.getPlayField().getSizeY(); i++){
            for(j = 0; j < game.getPlayField().getSizeX(); j++){
                if(game.getPlayField().getFieldOccupied(i, j)){
                    Rectangle rectangle = new Rectangle();
                    rectangle.setHeight(70.0f);
                    rectangle.setWidth(75.0f);

                    if(game.getPlayField().getFieldNum(i, j) == 1){
                        //if its player 1
                        FileInputStream inputstream = assignOres(game.getPlayer(1));
                        Image image = new Image(inputstream);

                        rectangle.setFill(new ImagePattern(image));
                        gridPane.add(rectangle, j, i);
                    } else{
                        //if its player 2
                        FileInputStream inputstream = assignOres(game.getPlayer(2));
                        Image image = new Image(inputstream);

                        rectangle.setFill(new ImagePattern(image));
                        gridPane.add(rectangle, j, i);
                    }
                }
            }
            j = 0;
        }
    }

    private void winScene() throws IOException {
        Stage stage = (Stage) labelRemainingStones.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("EndMenu.fxml"));
        stage.setTitle("End");
        stage.setScene(new Scene(root, 1024, 576));
        stage.getScene().getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());
    }

    public void buttonShowWinnerOnMouseClicked(MouseEvent mouseEvent) {
        buttonShowWinner.setOpacity(0.0f);
        buttonShowWinner.setDisable(true);

        imageViewBackgroundEndMenu.setVisible(true);
        firstPlaceName.setVisible(true);
        firstPlace.setVisible(true);
        secondPlace.setVisible(true);

        switch(game.getWin()){
            case 1 -> {
                firstPlaceName.setText(game.getPlayer(1).getName());
                firstPlace.setText("P" + game.getPlayer(1).getNum());
                secondPlace.setText("P" + game.getPlayer(2).getNum());
            }

            case 2 -> {
                firstPlaceName.setText(game.getPlayer(2).getName());
                firstPlace.setText("P" + game.getPlayer(2).getNum());
                secondPlace.setText("P" + game.getPlayer(2).getNum());
            }
        }
    }

    //assigning ores based on the one selected in the comboBox
    public FileInputStream assignOres(Player player) throws FileNotFoundException {
        return switch (player.getOre()) {
            case "Coal Ore" -> new FileInputStream("G:\\Meine Ablage\\school\\HTL_thirdClass\\POS\\java\\javafx\\4gewinnt\\src\\sample\\img\\coal.png");
            case "Iron Ore" -> new FileInputStream("G:\\Meine Ablage\\school\\HTL_thirdClass\\POS\\java\\javafx\\4gewinnt\\src\\sample\\img\\iron.png");
            case "Gold Ore" -> new FileInputStream("G:\\Meine Ablage\\school\\HTL_thirdClass\\POS\\java\\javafx\\4gewinnt\\src\\sample\\img\\gold.png");
            case "Diamond Ore" -> new FileInputStream("G:\\Meine Ablage\\school\\HTL_thirdClass\\POS\\java\\javafx\\4gewinnt\\src\\sample\\img\\diamond.png");
            default -> new FileInputStream("");
        };
    }
}
