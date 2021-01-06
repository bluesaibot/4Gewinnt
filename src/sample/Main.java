/*
    --add-modules
    javafx.graphics,javafx.media

    2020.11.26 vormittag: Klassen erstellt, spieler erstellt, playfield befüllt, playfield print, playfield richtige größen notiert
    2020.11.27 vormittag: Game, Player, Playfield die Eingabe ermöglichen und Stein platzieren bzw. stelle auf occupied = true stellen
    2020.11.27 nachmittag: Validations ausprogrammiert
    2020.11.29 nachmittag bis abends: Validations repariert + funktionen getestet
                -> alles funktioniert bis auf diagonal von rechts unten nach links oben
    2020.11.30 vormittag: validations funktionieren alle und grundsätzlicher Spielablauf geht
                -> Konsolenspiel ist fertig
    2020.11.30 mittags: UML upgedated auf das Konsolenspiel
    2020.11.30 abends: Main menü designed + exit und PvP onclick gemacht
    2020.12.03 vormittags: Game Szene und Select Names designed und funktionen einbauen (Labels die über grid pane gehen)
    2020.12.03 vormittags: Main Menü und Select Names funktioniert
    2020.12.04 vormittags: Controller mit Game verbunden (keine membervariablen vom Game im Controller)
    2020.12.04 vormittags: funktioniert grundlegend, bis darauf, dass jedes mal ein neues Spielfeld erstellt wird nach jedem mouseclick
    2020.12.10: vormittags: setzen funktioniert virtuell (in konsole), spielfeld wird nur 1 mal erstellt und Problem mit KLassen gefixt
    2020.12.11: vormittags: Visuelle setzen der Steine mit Validationen und end screen
                -> Spiel ist Grundlegend fertig
    TODO: verschönern, neu designen, end screen anders überlegen + exceptionhandling
*/

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.time.Duration;

public class Main extends Application {
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //music stuff
        /*
        Media sound = new Media(new File("src/sample/music/bg_music.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        */
        //Game game = new Game();

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(new Scene(root, 1024, 576));
        primaryStage.getScene().getStylesheets().add(this.getClass().getResource("styleMainMenu.css").toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
