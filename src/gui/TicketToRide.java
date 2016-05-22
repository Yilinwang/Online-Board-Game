import client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicketToRide extends Application {
    private static Stage stage;
    private static Scene scene;
    private Client client;

    public static void main(String[] args) {
        launch(args);
    }

    public void init() {
        client = new Client(getParameters().getRaw().get(0), Integer.valueOf(getParameters().getRaw().get(1)));
        client.start();
    }

    public void start(Stage _stage) {
        stage = _stage;
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        try {
            root = fxmlLoader.load();
        } catch(Exception e) {
            System.err.println("Something wrong");
            return;
        }
        LoginController loginController = (LoginController)fxmlLoader.getController();
        loginController.myinit(stage, client);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
