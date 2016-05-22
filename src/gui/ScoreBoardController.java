import client.Client;
import client.GameData;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by YilinWang on 2016/1/20.
 */
public class ScoreBoardController {
    private static Stage stage;
    private static Client client;

    @FXML
    Text name0;
    @FXML
    Text name1;
    @FXML
    Text name2;
    @FXML
    Text name3;
    @FXML
    Text name4;
    @FXML
    Text score0;
    @FXML
    Text score1;
    @FXML
    Text score2;
    @FXML
    Text score3;
    @FXML
    Text score4;

    void myinit(Stage _stage, Client _client, GameData gameData) {
        stage = _stage;
        client = _client;
        name0.setText(gameData.getPlayerName().get(0));
        name1.setText(gameData.getPlayerName().get(1));
        name2.setText(gameData.getPlayerName().get(2));
        name3.setText(gameData.getPlayerName().get(3));
        name4.setText(gameData.getPlayerName().get(4));
        score0.setText(Integer.toString(gameData.getColors().get(0)));
        score1.setText(Integer.toString(gameData.getColors().get(1)));
        score2.setText(Integer.toString(gameData.getColors().get(2)));
        score3.setText(Integer.toString(gameData.getColors().get(3)));
        score4.setText(Integer.toString(gameData.getColors().get(4)));
    }
}
