import client.Client;
import client.GameData;
import game.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainGameController {
    private static Stage stage;
    private static Client client;
    private static ArrayList<ArrayList<Button> > buttons;
    private static ArrayList<ArrayList<Text> > playerInfoText;
    private static ArrayList<Text> playerNameText;
    private static ArrayList<Button> ticketButton;
    private static ArrayList<Button> ticketForDrawButton;
    private static ArrayList<Text> myInfoText;
    private static ArrayList<ArrayList<Text> > missionText;
    private static ArrayList<Button> playerInfoButton;
    private static int missionIndex;

    @FXML
    Button roadButton00;
    @FXML
    Button roadButton10;
    @FXML
    Button roadButton20;
    @FXML
    Button roadButton21;
    @FXML
    Button roadButton22;
    @FXML
    Button roadButton30;
    @FXML
    Button roadButton40;
    @FXML
    Button roadButton50;
    @FXML
    Button roadButton51;
    @FXML
    Button roadButton52;
    @FXML
    Button roadButton53;
    @FXML
    Button roadButton60;
    @FXML
    Button roadButton61;
    @FXML
    Button roadButton62;
    @FXML
    Button roadButton63;
    @FXML
    Button roadButton64;
    @FXML
    Button roadButton65;
    @FXML
    Button roadButton70;
    @FXML
    Button roadButton71;
    @FXML
    Button roadButton72;
    @FXML
    Button roadButton73;
    @FXML
    Button roadButton74;
    @FXML
    Button roadButton80;
    @FXML
    Button roadButton81;
    @FXML
    Button roadButton82;
    @FXML
    Button roadButton83;
    @FXML
    Button roadButton84;
    @FXML
    Button roadButton90;
    @FXML
    Button roadButton91;
    @FXML
    Button roadButton92;
    @FXML
    Button roadButton93;
    @FXML
    Button roadButton94;
    @FXML
    Button roadButton95;
    @FXML
    Button roadButton100;
    @FXML
    Button roadButton101;
    @FXML
    Button roadButton102;
    @FXML
    Button roadButton110;
    @FXML
    Button roadButton112;
    @FXML
    Button roadButton113;
    @FXML
    Button roadButton120;
    @FXML
    Button roadButton121;
    @FXML
    Button roadButton122;
    @FXML
    Button roadButton123;
    @FXML
    Button roadButton124;
    @FXML
    Button roadButton130;
    @FXML
    Button roadButton131;
    @FXML
    Button roadButton132;
    @FXML
    Button roadButton133;
    @FXML
    Button roadButton134;
    @FXML
    Button roadButton140;
    @FXML
    Button roadButton141;
    @FXML
    Button roadButton150;
    @FXML
    Button roadButton151;
    @FXML
    Button roadButton152;
    @FXML
    Button roadButton160;
    @FXML
    Button roadButton161;
    @FXML
    Button roadButton162;
    @FXML
    Button roadButton163;
    @FXML
    Button roadButton164;
    @FXML
    Button roadButton165;
    @FXML
    Button roadButton170;
    @FXML
    Button roadButton171;
    @FXML
    Button roadButton172;
    @FXML
    Button roadButton173;
    @FXML
    Button roadButton180;
    @FXML
    Button roadButton181;
    @FXML
    Button roadButton182;
    @FXML
    Button roadButton183;
    @FXML
    Button roadButton184;
    @FXML
    Button roadButton185;
    @FXML
    Button roadButton190;
    @FXML
    Button roadButton191;
    @FXML
    Button roadButton192;
    @FXML
    Button roadButton200;
    @FXML
    Button roadButton201;
    @FXML
    Button roadButton202;
    @FXML
    Button roadButton210;
    @FXML
    Button roadButton211;
    @FXML
    Button roadButton212;
    @FXML
    Button roadButton220;
    @FXML
    Button roadButton221;
    @FXML
    Button roadButton222;
    @FXML
    Button roadButton230;
    @FXML
    Button roadButton231;
    @FXML
    Button roadButton232;
    @FXML
    Button roadButton233;
    @FXML
    Button roadButton234;
    @FXML
    Button roadButton240;
    @FXML
    Button roadButton241;
    @FXML
    Button roadButton242;
    @FXML
    Button roadButton250;
    @FXML
    Button roadButton251;
    @FXML
    Button roadButton252;
    @FXML
    Button roadButton260;
    @FXML
    Button roadButton261;
    @FXML
    Button roadButton262;
    @FXML
    Button roadButton263;
    @FXML
    Button roadButton270;
    @FXML
    Button roadButton271;
    @FXML
    Button roadButton272;
    @FXML
    Button roadButton273;
    @FXML
    Button roadButton280;
    @FXML
    Button roadButton281;
    @FXML
    Button roadButton282;
    @FXML
    Button roadButton283;
    @FXML
    Button roadButton284;
    @FXML
    Button roadButton285;
    @FXML
    Button roadButton290;
    @FXML
    Button roadButton291;
    @FXML
    Button roadButton292;
    @FXML
    Button roadButton293;
    @FXML
    Button roadButton294;
    @FXML
    Button roadButton300;
    @FXML
    Button roadButton301;
    @FXML
    Button roadButton310;
    @FXML
    Button roadButton311;
    @FXML
    Button roadButton312;
    @FXML
    Button roadButton313;
    @FXML
    Button roadButton320;
    @FXML
    Button roadButton321;
    @FXML
    Button roadButton322;
    @FXML
    Button roadButton323;
    @FXML
    Button roadButton330;
    @FXML
    Button roadButton331;
    @FXML
    Button roadButton332;
    @FXML
    Button roadButton333;
    @FXML
    Button roadButton340;
    @FXML
    Button roadButton341;
    @FXML
    Button roadButton342;
    @FXML
    Button roadButton343;
    @FXML
    Button roadButton350;
    @FXML
    Button roadButton351;
    @FXML
    Button roadButton360;
    @FXML
    Button roadButton361;
    @FXML
    Button roadButton362;
    @FXML
    Button roadButton370;
    @FXML
    Button roadButton371;
    @FXML
    Button roadButton372;
    @FXML
    Button roadButton373;
    @FXML
    Button roadButton374;
    @FXML
    Button roadButton380;
    @FXML
    Button roadButton381;
    @FXML
    Button roadButton382;
    @FXML
    Button roadButton383;
    @FXML
    Button roadButton390;
    @FXML
    Button roadButton391;
    @FXML
    Button roadButton392;
    @FXML
    Button roadButton393;
    @FXML
    Button roadButton394;
    @FXML
    Button roadButton395;
    @FXML
    Button roadButton400;
    @FXML
    Button roadButton401;
    @FXML
    Button roadButton402;
    @FXML
    Button roadButton403;
    @FXML
    Button roadButton410;
    @FXML
    Button roadButton411;
    @FXML
    Button roadButton412;
    @FXML
    Button roadButton413;
    @FXML
    Button roadButton414;
    @FXML
    Button roadButton415;
    @FXML
    Button roadButton420;
    @FXML
    Button roadButton430;
    @FXML
    Button roadButton440;
    @FXML
    Button roadButton441;
    @FXML
    Button roadButton442;
    @FXML
    Button roadButton443;
    @FXML
    Button roadButton444;
    @FXML
    Button roadButton450;
    @FXML
    Button roadButton451;
    @FXML
    Button roadButton452;
    @FXML
    Button roadButton460;
    @FXML
    Button roadButton461;
    @FXML
    Button roadButton462;
    @FXML
    Button roadButton463;
    @FXML
    Button roadButton464;
    @FXML
    Button roadButton465;
    @FXML
    Button roadButton470;
    @FXML
    Button roadButton480;
    @FXML
    Button roadButton490;
    @FXML
    Button roadButton491;
    @FXML
    Button roadButton492;
    @FXML
    Button roadButton493;
    @FXML
    Button roadButton500;
    @FXML
    Button roadButton510;
    @FXML
    Button roadButton520;
    @FXML
    Button roadButton521;
    @FXML
    Button roadButton530;
    @FXML
    Button roadButton531;
    @FXML
    Button roadButton540;
    @FXML
    Button roadButton550;
    @FXML
    Button roadButton560;
    @FXML
    Button roadButton561;
    @FXML
    Button roadButton570;
    @FXML
    Button roadButton571;
    @FXML
    Button roadButton580;
    @FXML
    Button roadButton581;
    @FXML
    Button roadButton590;
    @FXML
    Button roadButton591;
    @FXML
    Button roadButton600;
    @FXML
    Button roadButton601;
    @FXML
    Button roadButton610;
    @FXML
    Button roadButton611;
    @FXML
    Button roadButton620;
    @FXML
    Button roadButton621;
    @FXML
    Button roadButton622;
    @FXML
    Button roadButton623;
    @FXML
    Button roadButton624;
    @FXML
    Button roadButton630;
    @FXML
    Button roadButton631;
    @FXML
    Button roadButton640;
    @FXML
    Button roadButton641;
    @FXML
    Button roadButton651;
    @FXML
    Button roadButton652;
    @FXML
    Button roadButton653;
    @FXML
    Button roadButton680;
    @FXML
    Button roadButton690;
    @FXML
    Button roadButton691;
    @FXML
    Button roadButton692;
    @FXML
    Button roadButton700;
    @FXML
    Button roadButton701;
    @FXML
    Button roadButton702;
    @FXML
    Button roadButton703;
    @FXML
    Button roadButton704;
    @FXML
    Button roadButton710;
    @FXML
    Button roadButton711;
    @FXML
    Button roadButton712;
    @FXML
    Button roadButton720;
    @FXML
    Button roadButton721;
    @FXML
    Button roadButton722;
    @FXML
    Button roadButton730;
    @FXML
    Button roadButton731;
    @FXML
    Button roadButton732;
    @FXML
    Button roadButton733;
    @FXML
    Button roadButton740;
    @FXML
    Button roadButton741;
    @FXML
    Button roadButton742;
    @FXML
    Button roadButton743;
    @FXML
    Button roadButton750;
    @FXML
    Button roadButton751;
    @FXML
    Button roadButton752;
    @FXML
    Button roadButton753;
    @FXML
    Button roadButton754;
    @FXML
    Button roadButton755;
    @FXML
    Button roadButton760;
    @FXML
    Button roadButton761;
    @FXML
    Button roadButton762;
    @FXML
    Button roadButton763;
    @FXML
    Button roadButton771;
    @FXML
    Button roadButton772;
    @FXML
    Button roadButton780;
    @FXML
    Button roadButton790;
    @FXML
    Button roadButton791;
    @FXML
    Button roadButton792;
    @FXML
    Button roadButton800;
    @FXML
    Button roadButton801;
    @FXML
    Button roadButton810;
    @FXML
    Button roadButton811;
    @FXML
    Button roadButton820;
    @FXML
    Button roadButton821;
    @FXML
    Button roadButton830;
    @FXML
    Button roadButton831;
    @FXML
    Button roadButton840;
    @FXML
    Button roadButton841;
    @FXML
    Button roadButton850;
    @FXML
    Button roadButton851;
    @FXML
    Button roadButton860;
    @FXML
    Button roadButton861;
    @FXML
    Button roadButton870;
    @FXML
    Button roadButton871;
    @FXML
    Button roadButton880;
    @FXML
    Button roadButton881;
    @FXML
    Button roadButton890;
    @FXML
    Button roadButton891;
    @FXML
    Button roadButton900;
    @FXML
    Button roadButton901;
    @FXML
    Button roadButton910;
    @FXML
    Button roadButton911;
    @FXML
    Button roadButton912;
    @FXML
    Button roadButton913;
    @FXML
    Button roadButton914;
    @FXML
    Button roadButton920;
    @FXML
    Button roadButton921;
    @FXML
    Button roadButton930;
    @FXML
    Button roadButton931;
    @FXML
    Button roadButton940;
    @FXML
    Button roadButton941;
    @FXML
    Button roadButton942;
    @FXML
    Button roadButton950;
    @FXML
    Button roadButton951;
    @FXML
    Button roadButton960;
    @FXML
    Button roadButton961;
    @FXML
    Button roadButton970;
    @FXML
    Button roadButton971;
    @FXML
    Button roadButton980;
    @FXML
    Button roadButton981;
    @FXML
    Button roadButton990;
    @FXML
    Button roadButton991;
    @FXML
    Button roadButton992;
    @FXML
    Button roadButton993;
    @FXML
    Button roadButton770;
    @FXML
    Button roadButton650;

    @FXML
    Text playerInfo00;
    @FXML
    Text playerInfo01;
    @FXML
    Text playerInfo02;
    @FXML
    Text playerInfo03;
    @FXML
    Text playerInfo10;
    @FXML
    Text playerInfo11;
    @FXML
    Text playerInfo12;
    @FXML
    Text playerInfo13;
    @FXML
    Text playerInfo20;
    @FXML
    Text playerInfo21;
    @FXML
    Text playerInfo22;
    @FXML
    Text playerInfo23;
    @FXML
    Text playerInfo30;
    @FXML
    Text playerInfo31;
    @FXML
    Text playerInfo32;
    @FXML
    Text playerInfo33;

    @FXML
    Text playerName0;
    @FXML
    Text playerName1;
    @FXML
    Text playerName2;
    @FXML
    Text playerName3;

    @FXML
    Button ticket0;
    @FXML
    Button ticket1;
    @FXML
    Button ticket2;
    @FXML
    Button ticket3;
    @FXML
    Button ticket4;
    @FXML
    Button ticket5;

    @FXML
    Button ticketOrange;
    @FXML
    Button ticketYellow;
    @FXML
    Button ticketGreen;
    @FXML
    Button ticketBlue;
    @FXML
    Button ticketDarkblue;
    @FXML
    Button ticketWhite;
    @FXML
    Button ticketPink;
    @FXML
    Button ticketRanbow;
    @FXML
    Button ticketRed;

    @FXML
    Text myInfo0;
    @FXML
    Text myInfo1;
    @FXML
    Text myInfo2;
    @FXML
    Text myInfo3;

    @FXML
    Text missionText00;
    @FXML
    Text missionText01;
    @FXML
    Text missionText02;
    @FXML
    Text missionText10;
    @FXML
    Text missionText11;
    @FXML
    Text missionText12;
    @FXML
    Text missionText20;
    @FXML
    Text missionText21;
    @FXML
    Text missionText22;
    @FXML
    Text missionText30;
    @FXML
    Text missionText31;
    @FXML
    Text missionText32;
    @FXML
    Text missionText40;
    @FXML
    Text missionText41;
    @FXML
    Text missionText42;

    @FXML
    Text actionText;

    @FXML
    Button playerInfoButton0;
    @FXML
    Button playerInfoButton1;
    @FXML
    Button playerInfoButton2;
    @FXML
    Button playerInfoButton3;

    @FXML
    Button myInfo;

    public void doRefresh(GameData gameData) {
        if(gameData.isFinish()) {
            Parent root;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoreBoard.fxml"));
            try {
                root = fxmlLoader.load();
            } catch(Exception e) {
                System.err.println("Something Wrong.");
                return;
            }
            ScoreBoardController scoreBoardController = (ScoreBoardController)fxmlLoader.getController();
            scoreBoardController.myinit(stage, client, gameData);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            return;
        }

        ArrayList<ArrayList<String>> playerInfo = gameData.getPlayerInfo();
        ArrayList<String> playerName = gameData.getPlayerName();
        ArrayList<String> ticket = gameData.getTicket();
        ArrayList<Integer> ticketForDraw = gameData.getTicketForDraw();
        ArrayList<String> myInfo = client.getSelfData();
        ArrayList<Integer> playerColor = gameData.getColors();
        int newRoadID = gameData.getRoadID();
        int newRoadColor = gameData.getRoadColor();

        String CSS = "CSS/bicycleBLUE.css";
        if(newRoadID != -1) {
            switch (newRoadColor) {
                case 0:
                    CSS = "CSS/bicycleBLUE.css";
                    break;
                case 1:
                    CSS = "CSS/bicycleGreen.css";
                    break;
                case 2:
                    CSS = "CSS/bicycleOrange.css";
                    break;
                case 3:
                    CSS = "CSS/bicyclePink.css";
                    break;
                case 4:
                    CSS = "CSS/bicycleRed.css";
                    break;
            }
            for (Button button : buttons.get(newRoadID))
                button.getStylesheets().add(CSS);
        }

        for(int i = 0; i < 4; i++) {
            CSS = "CSS/playerinfoBlue.css";
            switch(playerColor.get(i)) {
                case 0:
                    CSS = "CSS/playerinfoBlue.css";
                    break;
                case 1:
                    CSS = "CSS/playerinfoGreen.css";
                    break;
                case 2:
                    CSS = "CSS/playerinfoOrange.css";
                    break;
                case 3:
                    CSS = "CSS/playerinfoPink.css";
                    break;
                case 4:
                    CSS = "CSS/playerinfoRed.css";
                    break;
            }
            playerInfoButton.get(i).getStylesheets().add(CSS);
        }

        for(int i = 0; i < 4; i++)
            myInfoText.get(i).setText(myInfo.get(i));
        for(int i = 0; i < 4; i++) {
            playerNameText.get(i).setText(playerName.get(i));
            for(int j = 0; j < 4; j++)
                playerInfoText.get(i).get(j).setText(playerInfo.get(i).get(j));
        }

        for(int i = 0; i < 9; i++)
            ticketButton.get(i).setText(ticket.get(i));
        for(int i = 0; i < 5; i++) {
            switch(ticketForDraw.get(i)) {
                case Ticket.BLUE:
                    CSS = "CSS/ticketBlue.css";
                    break;
                case Ticket.DARKBLUE:
                    CSS = "CSS/ticketDarkblue.css";
                    break;
                case Ticket.GREEN:
                    CSS = "CSS/ticketGreen.css";
                    break;
                case Ticket.ORANGE:
                    CSS = "CSS/ticketOrange.css";
                    break;
                case Ticket.PINK:
                    CSS = "CSS/ticketPink.css";
                    break;
                case Ticket.RANBOW:
                    CSS = "CSS/ticketRanbow.css";
                    break;
                case Ticket.RED:
                    CSS = "CSS/ticketRed.css";
                    break;
                case Ticket.WHITE:
                    CSS = "CSS/ticketWhite.css";
                    break;
                case Ticket.YELLOW:
                    CSS = "CSS/ticketYellow.css";
                    break;
                default:
                    CSS = "";
            }
            ticketForDrawButton.get(i).getStylesheets().add(CSS);
        }
        String action = client.getAction();
        if(action == null)
            action = "";
        actionText.setText(action);
    }

    public void refresh() {
        GameData gameData = client.getGameData();
        if(gameData != null)
            doRefresh(gameData);
    }

    public void drawTicket0() {
        if(client.ticketPressed(0))
            refresh();
    }

    public void drawTicket1() {
        if(client.ticketPressed(1))
            refresh();
    }

    public void drawTicket2() {
        if(client.ticketPressed(2))
            refresh();
    }

    public void drawTicket3() {
        if(client.ticketPressed(3))
            refresh();
    }

    public void drawTicket4() {
        if(client.ticketPressed(4))
            refresh();
    }

    public void drawTicket5() {
        if(client.ticketPressed(5))
            refresh();
    }

    public void drawMission() {
        if(missionIndex == 5)
            return;
        game.Mission mission = client.drawMission();
        if(mission == null)
            return;
        missionText.get(missionIndex).get(0).setText(mission.getCityOneName());
        missionText.get(missionIndex).get(1).setText(mission.getCityTwoName());
        missionText.get(missionIndex).get(2).setText(Integer.toString(mission.getValue()));
        missionIndex++;
    }

    public void myinit(Client _client, Stage _stage, GameData gameData) {
        client = _client;
        stage = _stage;
        buttons = new ArrayList<>();
        playerNameText = new ArrayList<>();
        playerInfoText = new ArrayList<>();
        ticketButton = new ArrayList<>();
        ticketForDrawButton = new ArrayList<>();
        myInfoText = new ArrayList<>();
        missionText = new ArrayList<>();
        playerInfoButton = new ArrayList<>();
        missionIndex = 0;

        String CSS = "CSS/playerinfoBlue.css";
        switch(client.getColor()) {
            case 0:
                CSS = "CSS/myPlayerinfoBlue.css";
                break;
            case 1:
                CSS = "CSS/myPlayerinfoGreen.css";
                break;
            case 2:
                CSS = "CSS/myPlayerinfoOrange.css";
                break;
            case 3:
                CSS = "CSS/myPlayerinfoPink.css";
                break;
            case 4:
                CSS = "CSS/myPlayerinfoRed.css";
                break;
        }
        myInfo.getStylesheets().add(CSS);

        playerInfoButton.add(playerInfoButton0);
        playerInfoButton.add(playerInfoButton1);
        playerInfoButton.add(playerInfoButton2);
        playerInfoButton.add(playerInfoButton3);

        ArrayList<Text> missionBuffer = new ArrayList<>();
        missionBuffer.clear();
        missionBuffer.add(missionText00);
        missionBuffer.add(missionText01);
        missionBuffer.add(missionText02);
        missionText.add(new ArrayList<>(missionBuffer));
        missionBuffer.clear();
        missionBuffer.add(missionText10);
        missionBuffer.add(missionText11);
        missionBuffer.add(missionText12);
        missionText.add(new ArrayList<>(missionBuffer));
        missionBuffer.clear();
        missionBuffer.add(missionText20);
        missionBuffer.add(missionText21);
        missionBuffer.add(missionText22);
        missionText.add(new ArrayList<>(missionBuffer));
        missionBuffer.clear();
        missionBuffer.add(missionText30);
        missionBuffer.add(missionText31);
        missionBuffer.add(missionText32);
        missionText.add(new ArrayList<>(missionBuffer));
        missionBuffer.clear();
        missionBuffer.add(missionText40);
        missionBuffer.add(missionText41);
        missionBuffer.add(missionText42);
        missionText.add(new ArrayList<>(missionBuffer));


        myInfoText.add(myInfo0);
        myInfoText.add(myInfo1);
        myInfoText.add(myInfo2);
        myInfoText.add(myInfo3);

        ticketForDrawButton.add(ticket0);
        ticketForDrawButton.add(ticket1);
        ticketForDrawButton.add(ticket2);
        ticketForDrawButton.add(ticket3);
        ticketForDrawButton.add(ticket4);

        playerNameText.add(playerName0);
        playerNameText.add(playerName1);
        playerNameText.add(playerName2);
        playerNameText.add(playerName3);

        ticketButton.add(ticketWhite);
        ticketButton.add(ticketYellow);
        ticketButton.add(ticketBlue);
        ticketButton.add(ticketGreen);
        ticketButton.add(ticketRed);
        ticketButton.add(ticketDarkblue);
        ticketButton.add(ticketOrange);
        ticketButton.add(ticketPink);
        ticketButton.add(ticketRanbow);

        ArrayList<Text> textBuffer = new ArrayList<>();
        textBuffer.clear();
        textBuffer.add(playerInfo00);
        textBuffer.add(playerInfo01);
        textBuffer.add(playerInfo02);
        textBuffer.add(playerInfo03);
        playerInfoText.add(new ArrayList<>(textBuffer));
        textBuffer.clear();
        textBuffer.add(playerInfo10);
        textBuffer.add(playerInfo11);
        textBuffer.add(playerInfo12);
        textBuffer.add(playerInfo13);
        playerInfoText.add(new ArrayList<>(textBuffer));
        textBuffer.clear();
        textBuffer.add(playerInfo20);
        textBuffer.add(playerInfo21);
        textBuffer.add(playerInfo22);
        textBuffer.add(playerInfo23);
        playerInfoText.add(new ArrayList<>(textBuffer));
        textBuffer.clear();
        textBuffer.add(playerInfo30);
        textBuffer.add(playerInfo31);
        textBuffer.add(playerInfo32);
        textBuffer.add(playerInfo33);
        playerInfoText.add(new ArrayList<>(textBuffer));

        ArrayList<Button> tmp = new ArrayList<>();
        tmp.add(roadButton00);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton10);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton20);
        tmp.add(roadButton21);
        tmp.add(roadButton22);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton30);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton40);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton50);
        tmp.add(roadButton51);
        tmp.add(roadButton52);
        tmp.add(roadButton53);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton60);
        tmp.add(roadButton61);
        tmp.add(roadButton62);
        tmp.add(roadButton63);
        tmp.add(roadButton64);
        tmp.add(roadButton65);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton70);
        tmp.add(roadButton71);
        tmp.add(roadButton72);
        tmp.add(roadButton73);
        tmp.add(roadButton74);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton80);
        tmp.add(roadButton81);
        tmp.add(roadButton82);
        tmp.add(roadButton83);
        tmp.add(roadButton84);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton90);
        tmp.add(roadButton91);
        tmp.add(roadButton92);
        tmp.add(roadButton93);
        tmp.add(roadButton94);
        tmp.add(roadButton95);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton100);
        tmp.add(roadButton101);
        tmp.add(roadButton102);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton110);
        tmp.add(roadButton112);
        tmp.add(roadButton113);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton120);
        tmp.add(roadButton121);
        tmp.add(roadButton122);
        tmp.add(roadButton123);
        tmp.add(roadButton124);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton130);
        tmp.add(roadButton131);
        tmp.add(roadButton132);
        tmp.add(roadButton133);
        tmp.add(roadButton134);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton140);
        tmp.add(roadButton141);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton150);
        tmp.add(roadButton151);
        tmp.add(roadButton152);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton160);
        tmp.add(roadButton161);
        tmp.add(roadButton162);
        tmp.add(roadButton163);
        tmp.add(roadButton164);
        tmp.add(roadButton165);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton170);
        tmp.add(roadButton171);
        tmp.add(roadButton172);
        tmp.add(roadButton173);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton180);
        tmp.add(roadButton181);
        tmp.add(roadButton182);
        tmp.add(roadButton183);
        tmp.add(roadButton184);
        tmp.add(roadButton185);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton190);
        tmp.add(roadButton191);
        tmp.add(roadButton192);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton200);
        tmp.add(roadButton201);
        tmp.add(roadButton202);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton210);
        tmp.add(roadButton211);
        tmp.add(roadButton212);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton220);
        tmp.add(roadButton221);
        tmp.add(roadButton222);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton230);
        tmp.add(roadButton231);
        tmp.add(roadButton232);
        tmp.add(roadButton233);
        tmp.add(roadButton234);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton240);
        tmp.add(roadButton241);
        tmp.add(roadButton242);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton250);
        tmp.add(roadButton251);
        tmp.add(roadButton252);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton260);
        tmp.add(roadButton261);
        tmp.add(roadButton262);
        tmp.add(roadButton263);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton270);
        tmp.add(roadButton271);
        tmp.add(roadButton272);
        tmp.add(roadButton273);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton280);
        tmp.add(roadButton281);
        tmp.add(roadButton282);
        tmp.add(roadButton283);
        tmp.add(roadButton284);
        tmp.add(roadButton285);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton290);
        tmp.add(roadButton291);
        tmp.add(roadButton292);
        tmp.add(roadButton293);
        tmp.add(roadButton294);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton300);
        tmp.add(roadButton301);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton310);
        tmp.add(roadButton311);
        tmp.add(roadButton312);
        tmp.add(roadButton313);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton320);
        tmp.add(roadButton321);
        tmp.add(roadButton322);
        tmp.add(roadButton323);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton330);
        tmp.add(roadButton331);
        tmp.add(roadButton332);
        tmp.add(roadButton333);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton340);
        tmp.add(roadButton341);
        tmp.add(roadButton342);
        tmp.add(roadButton343);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton350);
        tmp.add(roadButton351);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton360);
        tmp.add(roadButton361);
        tmp.add(roadButton362);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton370);
        tmp.add(roadButton371);
        tmp.add(roadButton372);
        tmp.add(roadButton373);
        tmp.add(roadButton374);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton380);
        tmp.add(roadButton381);
        tmp.add(roadButton382);
        tmp.add(roadButton383);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton390);
        tmp.add(roadButton391);
        tmp.add(roadButton392);
        tmp.add(roadButton393);
        tmp.add(roadButton394);
        tmp.add(roadButton395);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton400);
        tmp.add(roadButton401);
        tmp.add(roadButton402);
        tmp.add(roadButton403);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton410);
        tmp.add(roadButton411);
        tmp.add(roadButton412);
        tmp.add(roadButton413);
        tmp.add(roadButton414);
        tmp.add(roadButton415);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton420);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton430);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton440);
        tmp.add(roadButton441);
        tmp.add(roadButton442);
        tmp.add(roadButton443);
        tmp.add(roadButton444);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton450);
        tmp.add(roadButton451);
        tmp.add(roadButton452);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton460);
        tmp.add(roadButton461);
        tmp.add(roadButton462);
        tmp.add(roadButton463);
        tmp.add(roadButton464);
        tmp.add(roadButton465);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton470);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton480);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton490);
        tmp.add(roadButton491);
        tmp.add(roadButton492);
        tmp.add(roadButton493);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton500);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton510);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton520);
        tmp.add(roadButton521);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton530);
        tmp.add(roadButton531);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton540);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton550);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton560);
        tmp.add(roadButton561);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton570);
        tmp.add(roadButton571);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton580);
        tmp.add(roadButton581);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton590);
        tmp.add(roadButton591);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton600);
        tmp.add(roadButton601);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton610);
        tmp.add(roadButton611);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton620);
        tmp.add(roadButton621);
        tmp.add(roadButton622);
        tmp.add(roadButton623);
        tmp.add(roadButton624);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton630);
        tmp.add(roadButton631);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton640);
        tmp.add(roadButton641);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton650);
        tmp.add(roadButton651);
        tmp.add(roadButton652);
        tmp.add(roadButton653);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        buttons.add(new ArrayList<>(tmp));
        buttons.add(new ArrayList<>(tmp));
        tmp.add(roadButton680);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton690);
        tmp.add(roadButton691);
        tmp.add(roadButton692);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton700);
        tmp.add(roadButton701);
        tmp.add(roadButton702);
        tmp.add(roadButton703);
        tmp.add(roadButton704);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton710);
        tmp.add(roadButton711);
        tmp.add(roadButton712);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton720);
        tmp.add(roadButton721);
        tmp.add(roadButton722);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton730);
        tmp.add(roadButton731);
        tmp.add(roadButton732);
        tmp.add(roadButton733);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton740);
        tmp.add(roadButton741);
        tmp.add(roadButton742);
        tmp.add(roadButton743);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton750);
        tmp.add(roadButton751);
        tmp.add(roadButton752);
        tmp.add(roadButton753);
        tmp.add(roadButton754);
        tmp.add(roadButton755);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton760);
        tmp.add(roadButton761);
        tmp.add(roadButton762);
        tmp.add(roadButton763);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton770);
        tmp.add(roadButton771);
        tmp.add(roadButton772);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton780);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton790);
        tmp.add(roadButton791);
        tmp.add(roadButton792);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton800);
        tmp.add(roadButton801);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton810);
        tmp.add(roadButton811);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton820);
        tmp.add(roadButton821);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton830);
        tmp.add(roadButton831);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton840);
        tmp.add(roadButton841);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton850);
        tmp.add(roadButton851);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton860);
        tmp.add(roadButton861);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton870);
        tmp.add(roadButton871);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton880);
        tmp.add(roadButton881);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton890);
        tmp.add(roadButton891);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton900);
        tmp.add(roadButton901);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton910);
        tmp.add(roadButton911);
        tmp.add(roadButton912);
        tmp.add(roadButton913);
        tmp.add(roadButton914);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton920);
        tmp.add(roadButton921);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton930);
        tmp.add(roadButton931);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton940);
        tmp.add(roadButton941);
        tmp.add(roadButton942);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton950);
        tmp.add(roadButton951);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton960);
        tmp.add(roadButton961);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton970);
        tmp.add(roadButton971);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton980);
        tmp.add(roadButton981);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(roadButton990);
        tmp.add(roadButton991);
        tmp.add(roadButton992);
        tmp.add(roadButton993);
        buttons.add(new ArrayList<>(tmp));
        tmp.clear();
        doRefresh(gameData);
    }

    public void red() {
        client.colorPressed(Ticket.RED);
    }

    public void orange() {
        client.colorPressed(Ticket.ORANGE);
    }

    public void yellow() {
        client.colorPressed(Ticket.YELLOW);
    }

    public void green() {
        client.colorPressed(Ticket.GREEN);
    }

    public void blue() {
        client.colorPressed(Ticket.BLUE);
    }

    public void darkblue() {
        client.colorPressed(Ticket.DARKBLUE);
    }

    public void pink() {
        client.colorPressed(Ticket.PINK);
    }

    public void white() {
        client.colorPressed(Ticket.WHITE);
    }

    public void rainbow() {
        client.colorPressed(Ticket.RANBOW);
    }

    public void MapController(int roadID) {
        System.out.println("in MapController");
        if(client.roadPressed(roadID) == 1) {
            System.out.println("in");
            int color = client.getColor();
            String CSS = "CSS/bicycleBLUE.css";
            switch (color) {
                case 0:
                    CSS = "CSS/bicycleBLUE.css";
                    break;
                case 1:
                    CSS = "CSS/bicycleGreen.css";
                    break;
                case 2:
                    CSS = "CSS/bicycleOrange.css";
                    break;
                case 3:
                    CSS = "CSS/bicyclePink.css";
                    break;
                case 4:
                    CSS = "CSS/bicycleRed.css";
                    break;
            }
            for (Button button : buttons.get(roadID))
                button.getStylesheets().add(CSS);
        }
        refresh();
    }

    public void road0() {
        MapController(0);
    }

    public void road1() {
        MapController(1);
    }

    public void road2() {
        MapController(2);
    }

    public void road3() {
        MapController(3);
    }

    public void road4() {
        MapController(4);
    }

    public void road5() {
        MapController(5);
    }

    public void road6() {
        MapController(6);
    }

    public void road7() {
        MapController(7);
    }

    public void road8() {
        MapController(8);
    }

    public void road9() {
        MapController(9);
    }

    public void road10() {
        MapController(10);
    }

    public void road11() {
        MapController(11);
    }

    public void road12() {
        MapController(12);
    }

    public void road13() {
        MapController(13);
    }

    public void road14() {
        MapController(14);
    }

    public void road15() {
        MapController(15);
    }

    public void road16() {
        MapController(16);
    }

    public void road17() {
        MapController(17);
    }

    public void road18() {
        MapController(18);
    }

    public void road19() {
        MapController(19);
    }

    public void road20() {
        MapController(20);
    }

    public void road21() {
        MapController(21);
    }

    public void road22() {
        MapController(22);
    }

    public void road23() {
        MapController(23);
    }

    public void road24() {
        MapController(24);
    }

    public void road25() {
        MapController(25);
    }

    public void road26() {
        MapController(26);
    }

    public void road27() {
        MapController(27);
    }

    public void road28() {
        MapController(28);
    }

    public void road29() {
        MapController(29);
    }

    public void road30() {
        MapController(30);
    }

    public void road31() {
        MapController(31);
    }

    public void road32() {
        MapController(32);
    }

    public void road33() {
        MapController(33);
    }

    public void road34() {
        MapController(34);
    }

    public void road35() {
        MapController(35);
    }

    public void road36() {
        MapController(36);
    }

    public void road37() {
        MapController(37);
    }

    public void road38() {
        MapController(38);
    }

    public void road39() {
        MapController(39);
    }

    public void road40() {
        MapController(40);
    }

    public void road41() {
        MapController(41);
    }

    public void road42() {
        MapController(42);
    }

    public void road43() {
        MapController(43);
    }

    public void road44() {
        MapController(44);
    }

    public void road45() {
        MapController(45);
    }

    public void road46() {
        MapController(46);
    }

    public void road47() {
        MapController(47);
    }

    public void road48() {
        MapController(48);
    }

    public void road49() {
        MapController(49);
    }

    public void road50() {
        MapController(50);
    }

    public void road51() {
        MapController(51);
    }

    public void road52() {
        MapController(52);
    }

    public void road53() {
        MapController(53);
    }

    public void road54() {
        MapController(54);
    }

    public void road55() {
        MapController(55);
    }

    public void road56() {
        MapController(56);
    }

    public void road57() {
        MapController(57);
    }

    public void road58() {
        MapController(58);
    }

    public void road59() {
        MapController(59);
    }

    public void road60() {
        MapController(60);
    }

    public void road61() {
        MapController(61);
    }

    public void road62() {
        MapController(62);
    }

    public void road63() {
        MapController(63);
    }

    public void road64() {
        MapController(64);
    }

    public void road65() {
        MapController(65);
    }

    public void road66() {
        MapController(66);
    }

    public void road67() {
        MapController(67);
    }

    public void road68() {
        MapController(68);
    }

    public void road69() {
        MapController(69);
    }

    public void road70() {
        MapController(70);
    }

    public void road71() {
        MapController(71);
    }

    public void road72() {
        MapController(72);
    }

    public void road73() {
        MapController(73);
    }

    public void road74() {
        MapController(74);
    }

    public void road75() {
        MapController(75);
    }

    public void road76() {
        MapController(76);
    }

    public void road77() {
        MapController(77);
    }

    public void road78() {
        MapController(78);
    }

    public void road79() {
        MapController(79);
    }

    public void road80() {
        MapController(80);
    }

    public void road81() {
        MapController(81);
    }

    public void road82() {
        MapController(82);
    }

    public void road83() {
        MapController(83);
    }

    public void road84() {
        MapController(84);
    }

    public void road85() {
        MapController(85);
    }

    public void road86() {
        MapController(86);
    }

    public void road87() {
        MapController(87);
    }

    public void road88() {
        MapController(88);
    }

    public void road89() {
        MapController(89);
    }

    public void road90() {
        MapController(90);
    }

    public void road91() {
        MapController(91);
    }

    public void road92() {
        MapController(92);
    }

    public void road93() {
        MapController(93);
    }

    public void road94() {
        MapController(94);
    }

    public void road95() {
        MapController(95);
    }

    public void road96() {
        MapController(96);
    }

    public void road97() {
        MapController(97);
    }

    public void road98() {
        MapController(98);
    }

    public void road99() {
        MapController(99);
    }

}
