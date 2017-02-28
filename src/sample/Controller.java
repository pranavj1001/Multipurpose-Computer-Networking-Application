package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
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

    Boolean vpnIsOn = false;

    //Function to load AntiVirus
    @FXML private void loadAntiVirusWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/antivirus.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load SSH
    @FXML private void loadSSHWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/ssh.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load VPN
    @FXML private void loadVPNWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/vpn.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //Function to load FTP
    @FXML private void loadFTPWindow() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/ftp.fxml"));
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

    //Function which runs the code for AntiVirus
    @FXML private void runTheAntivirusCode(){
        try {
            String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\antivirus\\antivirus.bat"};
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("Oh Snap!");
        }
    }

    //Function which connects to a VPN
    @FXML private void runTheVPNCode(ActionEvent actionEvent){
        try {

            String[] commandToRun = {};

            System.out.println(((Button) actionEvent.getSource()).getText());

            if(((Button) actionEvent.getSource()).getText() == "USA VPN"){
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectUSA.bat"};
                commandToRun = command;
                System.out.println("Reached here");
            }else if(((Button) actionEvent.getSource()).getText() == "UK VPN"){
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectUK.bat"};
                commandToRun = command;
                System.out.println("Reached here");
            }else if(((Button) actionEvent.getSource()).getText() == "Canada VPN"){
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectCanada.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText() == "Germany VPN"){
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectGermany.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText() == "NetherLands VPN"){
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectNetherLands.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText() == "Hong Kong VPN") {
                String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnConnectHongKong.bat"};
                commandToRun = command;
            }
            if(commandToRun.length != 0)
                Runtime.getRuntime().exec(commandToRun);
            vpnIsOn = true;
        } catch (IOException e) {
            System.out.println("Oh Snap!");
        }
    }

    //Function which disconnects from a VPN
    @FXML private void disconnectTheVPNService(){
        try {
            String[] command = {"cmd.exe", "/C", "Start", "D:\\PRANAV\\Project\\MainApplication\\src\\sample\\batFiles\\vpn\\vpnDisconnect.bat"};
            Runtime.getRuntime().exec(command);
            vpnIsOn = false;
        } catch (IOException e) {
            System.out.println("Oh Snap!");
        }
    }

}
