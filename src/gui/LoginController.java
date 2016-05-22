import client.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private static Client client;
    private static Stage stage;
    @FXML
    TextField textField;

    public void myinit(Stage _stage, Client _client) {
        client = _client;
        stage = _stage;
    }

    public void setID() {
        String ID = textField.getText();
        System.err.println("At setID, ID = "+ID);
        client.setUserName(ID);

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseTable.fxml"));
        try {
            root = fxmlLoader.load();
        } catch(Exception e) {
            System.err.println("Something wrong");
            return;
        }
        ChooseTableController chooseTableController = (ChooseTableController)fxmlLoader.getController();
        chooseTableController.myinit(client, stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
