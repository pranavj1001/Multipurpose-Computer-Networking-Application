package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {

    //root Anchor Pane which is shown on the main parent window
    @FXML private AnchorPane rootAnchorPane;

    //all the necessary buttons
    @FXML private Button antivirusButton;
    @FXML private Button sshButton;
    @FXML private Button ftpButton;
    @FXML private Button vpnButton;
    @FXML private Button backFromAntiVirus;

    //Function to load AntiVirus
    @FXML private void loadAntiVirusWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("antivirus.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load SSH
    @FXML private void loadSSHWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ssh.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load VPN
    @FXML private void loadVPNWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("vpn.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load FTP
    @FXML private void loadFTPWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ftp.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to go back to Root Page
    @FXML private void goBackToRoot() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("rootScene.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

}
