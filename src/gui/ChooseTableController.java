import client.Client;
import client.GameData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ChooseTableController {
    private static Client client;
    private static Stage stage;
    private static String ID;
    private static boolean flag;

    @FXML
    public Text table1ID1;
    @FXML
    public Text table1ID2;
    @FXML
    public Text table1ID3;
    @FXML
    public Text table1ID4;
    @FXML
    public Text table1ID5;
    @FXML
    public Text table2ID1;
    @FXML
    public Text table2ID2;
    @FXML
    public Text table2ID3;
    @FXML
    public Text table2ID4;
    @FXML
    public Text table2ID5;
    @FXML
    public Text table3ID1;
    @FXML
    public Text table3ID2;
    @FXML
    public Text table3ID3;
    @FXML
    public Text table3ID4;
    @FXML
    public Text table3ID5;
    @FXML
    public Button joinButton0;
    @FXML
    public Button joinButton1;
    @FXML
    public Button joinButton2;

    public void myinit(Client _client, Stage _stage) {
        client = _client;
        stage = _stage;
        flag = false;
    }

    public void exit() {
        System.exit(0);
    }

    public void join0() {
        if(client.select(0)) {
            refresh();
            joinButton0.getStylesheets().add("CSS/wait.css");
            flag = true;
        }
    }

    public void join1() {
        if(client.select(1)) {
            refresh();
            joinButton1.getStylesheets().add("CSS/wait.css");
            flag = true;
        }
    }

    public void join2() {
        if(client.select(2)) {
            refresh();
            joinButton2.getStylesheets().add("CSS/wait.css");
            flag = true;
        }
    }

    public void refresh() {
        System.out.println("refresh");
        ArrayList<ArrayList<String>> table = client.getTable();
        table1ID1.setText(table.get(0).get(0));
        table1ID2.setText(table.get(0).get(1));
        table1ID3.setText(table.get(0).get(2));
        table1ID4.setText(table.get(0).get(3));
        table1ID5.setText(table.get(0).get(4));
        table2ID1.setText(table.get(1).get(0));
        table2ID2.setText(table.get(1).get(1));
        table2ID3.setText(table.get(1).get(2));
        table2ID4.setText(table.get(1).get(3));
        table2ID5.setText(table.get(1).get(4));
        table3ID1.setText(table.get(2).get(0));
        table3ID2.setText(table.get(2).get(1));
        table3ID3.setText(table.get(2).get(2));
        table3ID4.setText(table.get(2).get(3));
        table3ID5.setText(table.get(2).get(4));
        if(flag) {
            System.out.println("if flag");
            flag = !flag;
            client.waitGame();
            System.out.println("after wait game");
            GameData gameData = client.waitInit();
            Parent root;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
            try {
                root = fxmlLoader.load();
            } catch(Exception e) {
                System.err.println("Something wrong");
                e.printStackTrace();
                return;
            }
            MainGameController mainGameController = (MainGameController)fxmlLoader.getController();
            mainGameController.myinit(client, stage, gameData);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
