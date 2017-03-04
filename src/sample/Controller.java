package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Controller {

    //root Anchor Pane which is shown on the main parent window
    @FXML private AnchorPane rootAnchorPane;

    //all the necessary buttons
    @FXML private Button antivirusButton;
    @FXML private Button sshButton;
    @FXML private Button ftpButton;
    @FXML private Button vpnButton;
    @FXML private Button backFromAntiVirus;

    //textArea variables
    @FXML private TextArea taENCText;
    @FXML private TextArea taENCGText;

    //textField variables
    @FXML private TextField tfENCKey;

    //label variables
    @FXML private Label statusLabelENC;

    Boolean vpnIsOn = false;

    //Password related variables
    private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
            (byte) 0x10, (byte) 0x12, };

    //------Navigation---------//

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

    //Function to load Encryption and Decryption Window
    @FXML private void loadENCDECWindow() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/encdec.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //open Encrypt Window
    @FXML private void openEncryptWindow() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/enc.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
        FadeTransition ft = new FadeTransition(Duration.millis(300), rootAnchorPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    //open Decrypt Window
    @FXML private void openDecryptWindow() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("buttonFXML/dec.fxml"));
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

    //!------Navigation---------!//

    //-------AntiVirus-----------//

    //Function which runs the code for AntiVirus
    @FXML private void runTheAntivirusCode(){
        try {
            String workingDir = System.getProperty("user.dir");
            //System.out.println(workingDir);
            String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\antivirus\\antivirus.bat"};
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("Oh Snap!");
        }
    }

    //!-------AntiVirus---------!//

    //--------VPN----------------//

    //Function which connects to a VPN
    @FXML private void runTheVPNCode(ActionEvent actionEvent){
        try {

            String[] commandToRun = {};
            String workingDir = System.getProperty("user.dir");

            System.out.println(((Button) actionEvent.getSource()).getText());

            if(((Button) actionEvent.getSource()).getText().equals("USA VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectUSA.bat"};
                commandToRun = command;
                System.out.println("Reached here");
            }else if(((Button) actionEvent.getSource()).getText().equals("UK VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectUK.bat"};
                commandToRun = command;
                System.out.println("Reached here");
            }else if(((Button) actionEvent.getSource()).getText().equals("Canada VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectCanada.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText().equals("Germany VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectGermany.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText().equals("NetherLands VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectNetherLands.bat"};
                commandToRun = command;
            }else if(((Button) actionEvent.getSource()).getText().equals("Hong Kong VPN")){
                String[] command = {"cmd.exe", "/C", "Start", workingDir+"\\src\\sample\\batFiles\\vpn\\vpnConnectHongKong.bat"};
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

    //!-------VPN---------------!//

    //--------ENC & DEC----------//

    @FXML private void encryptData(){

        String data = "";
        String key = "";
        int goodToGoAhead = 1;

        if(taENCText.getText().isEmpty()){
            statusLabelENC.setText("Please Enter a text");
            goodToGoAhead++;
        }

        if(tfENCKey.getText().isEmpty()){
            statusLabelENC.setText("Please Enter a key");
            goodToGoAhead++;
        }

        if(goodToGoAhead == 1){

            statusLabelENC.setText("");

            key = tfENCKey.getText();
            char[] keyParamater = key.toCharArray();

            data = taENCText.getText();
            String encryptedData = null;
            try {
                encryptedData = encrypt(data, keyParamater);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            taENCGText.setText("Key: "+key+"\n"+"Encrypted Text: " + encryptedData);
            statusLabelENC.setText("Encryption successful!");

        }

    }

    private static String encrypt(String property, char[] key) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey secretKey = keyFactory.generateSecret(new PBEKeySpec(key));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, secretKey, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Encoder().encode(bytes);
    }

    //!-------ENC & DEC---------!//

}
