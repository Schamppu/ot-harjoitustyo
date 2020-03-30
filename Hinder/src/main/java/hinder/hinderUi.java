package hinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class hinderUi extends Application {
    
    // How large should the application be?
    static int appHeight = 720;
    static int appWidth = 480;
    
    // The timer for chatting
    static double secondSpeed = 60;
    static double messageTimer = 2*secondSpeed;
    static boolean waitForResponse = false;
    static double readingTimer = 2*secondSpeed;
    static Text nameText = new Text("");
    
    
    // Global variables
    static ArrayList<Profile> chrProfiles = new ArrayList<>();
    static Profile profObjId;
    static String profName;
    static int profAge;
    static boolean himPreviously;
    static int nextMessageId = -1;
    static VBox chatBox = new VBox();
    static int scrollDown = 3;
    static boolean showMe = false; // Show His profile or yourself?
    static boolean loseGame = false; // Game is lost
    static boolean loseOnce = true; // Game can be lost just once
    static boolean winGame = false; // Game is lost
    static boolean winOnce = true; // Game can be lost just once
    static boolean blockUser = false; // The chat partner has blocked you
    static boolean blockMessage = false; // Don't sent the block message many times
    static int profPicSize = 300;
    static int dialogBoxHeight = 200;
    
   
    
    // Your character's bio text
    static String bioText = "|plane |globe |wine |dancer |sushi |wlifting |wrunning/n /n Moikka! Harrastuksina käyn kuntosalilla ja juoksen. Olen siis sporttinen mimmi Vantaalta. Laittakaa viestiä |smile0";
    
    // Profile variables
    Text scnProfileName = new Text();
    Text scnProfileJob = new Text();
    ImageView scnProfilePicture = new ImageView("placeholder.png");
    TextFlow scnProfileBio = new TextFlow();
    ImageView characterPic = new ImageView("character.png");
    

    // Create appropriate Scenes
    Scene sceneChat;
    Scene sceneProfile;
    Scene sceneBegin;
    Scene sceneWin;
    Scene sceneLose;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        // Use this to calculate the number of rows of this project, just because data is nice
        //try { calculateRows(); } catch(FileNotFoundException e) { System.out.println("Too bad.") ;};
        
        
        // Here we create the ScrollPane for the TextFlow
        ScrollPane scrollBox = new ScrollPane();
        scrollBox.setPrefSize(120, appHeight-dialogBoxHeight);
        scrollBox.setContent(chatBox);
        scrollBox.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollBox.setId("chatPane");
        
        // Here we create the container for buttons and the chat
        VBox containerChat = new VBox();
        VBox dialogBox = new VBox();
        VBox dialogOptions = new VBox();
        dialogBox.setAlignment(Pos.CENTER);
        dialogOptions.setAlignment(Pos.CENTER);
        dialogOptions.setSpacing(5);
        dialogOptions.setTranslateY(15);
        
        // Lets create the XXX is online/writing UI element
        Text statusText = new Text("online");
        HBox profileBox = new HBox();
        profileBox.getChildren().addAll(nameText,statusText);
        profileBox.setAlignment(Pos.CENTER);
        nameText.setId("profileText");
        
        // Lets create a top bar for the chat manipulation view
        GridPane profileBar = new GridPane();
        profileBar.setAlignment(Pos.CENTER);
        
        profileBox.setMinWidth(200);
        
        //profileBar.getColumnConstraints().add(new ColumnConstraints(70));
        //profileBar.getColumnConstraints().add(new ColumnConstraints(200));
        //profileBar.getColumnConstraints().add(new ColumnConstraints(60));
        
        profileBar.add(profileBox, 1, 0);
        profileBar.setTranslateY(10);
        
        // Let add buttons for profile and 
        Button btnProfile = new Button("Profiili");
        Button btnBlock = new Button("Estä");
        profileBar.add(btnProfile, 0, 0);
        profileBar.add(btnBlock, 2, 0);
        
        btnProfile.setMinWidth(100);
        btnBlock.setMinWidth(100);
        
        btnProfile.setId("buttonProfile");
        btnBlock.setId("buttonBlock");
        
        // Rectangle to split the two
        Rectangle box = new Rectangle();
        box.setWidth(appWidth);
        box.setHeight(2);
        box.setTranslateY(-28);
        box.setId("separator");
        
        // Add everything to the dialogbox (main dialog navigation view)
        dialogBox.getChildren().addAll(profileBar,box,dialogOptions);
        
        
        // Add everything to the container which holds chat stuff
        containerChat.getChildren().addAll(scrollBox, dialogBox);
        
        // Lets call the method to create all character profiles
        createProfiles();
        
        // Lets start the conversation with the first profile
        startConversation();
        
        // Create a scene for character profiles
        VBox containerProfile = new VBox();
        containerProfile.setSpacing(10);
        
        // Lets create the row for name, age, location
        HBox nameRow = new HBox();
        nameRow.setAlignment(Pos.CENTER);
        scnProfileName.setId("textName");
        nameRow.getChildren().addAll(scnProfileName);
        
        // Lets create the row for job and school
        HBox jobRow = new HBox();
        jobRow.setAlignment(Pos.CENTER);
        scnProfileJob.setId("textJob");
        scnProfileJob.setTextAlignment(TextAlignment.CENTER);
        jobRow.getChildren().addAll(scnProfileJob);
        
        // Lets create a row for the profile picture
        HBox picRow = new HBox();
        picRow.setAlignment(Pos.CENTER);
        picRow.setMinHeight(profPicSize);
        picRow.getChildren().addAll(scnProfilePicture);
        
        // Lets create a row for the bio
        HBox bioRow = new HBox();
        ScrollPane bioPane = new ScrollPane();
        bioRow.setAlignment(Pos.CENTER);
        scnProfileBio.setTextAlignment(TextAlignment.CENTER);
        
        bioPane.setContent(scnProfileBio);
        scnProfileBio.setMaxWidth(appWidth-60);
        scnProfileBio.setPadding(new Insets(10));
        scnProfileBio.setTranslateX(30);
        
        bioPane.setMinSize(appWidth, 250);
        bioPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        
        bioRow.getChildren().addAll(bioPane);
        
        // Lets create a row for the button to go back to the chat
        HBox bottomRow = new HBox();
        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.setSpacing(10);
        Button backButton = new Button("Keskustelu");
        Button swapButton = new Button("Keskustelukumppanisi profiili");
        bottomRow.getChildren().addAll(backButton,swapButton);
        
        containerProfile.getChildren().addAll(picRow,nameRow,jobRow,bioRow,bottomRow);
        
        
        // Create the container for the beginning of the game
        VBox containerBegin = new VBox();
        containerBegin.setSpacing(10);
        containerBegin.setAlignment(Pos.CENTER);
        
        TextFlow tutorialTitle = new TextFlow();
        tutorialTitle.setTextAlignment(TextAlignment.CENTER);
        
        String textTitle = "/n Tervetuloa Hinderiin! /n /n";
        createEmojiText(tutorialTitle,textTitle,"tutorialTitle");
        
        TextFlow tutorialText = new TextFlow();
        tutorialText.setTextAlignment(TextAlignment.CENTER);
        
        TextFlow disclaimerText = new TextFlow();
        disclaimerText.setTextAlignment(TextAlignment.CENTER);
        
        String textDisclaimer = "HUOMIO!/n /n Kaikki pelin hahmon ovat kuvitteellisia. Hahmoja esittävät kuvat ovat löydetty Googlesta tai erilaisilta sivuilta, jotka tarjoavat ilmaisia stock -kuvia. Näiden lisäksi kuvat, joissa esiintyy ihmisiä, on sumennettu Polygonize-algoritmilla satunnaisesti, jotta niissä olevia henkilöitä ei voida tunnistaa./n" +
        "/n " +
        "Muistakaa, että pelissä karikatyylisesti tuodaan esille erilaisia deittipalveluissa esiintyviä stereotypioita ja että sen tarkoituksena ei ole loukata ketään./n" +
        "/n " +
        "Sisältää voimakasta kielenkäyttöä ja seksuaalissävytteisiä teemoja./n /n";
        
        String textMain = "Pelin kulku/n /nPelin tarkoituksena on keskustella erilaisten keskustelukumppaneiden kanssa./n /nVoit siirtyä seuraavaan keskustelukumppaniin estämällä keskustelukumppanin./n /nPelin tarkoituksena on, että päädyt treffeille henkilön kanssa, kenen uskot olevan elämänkumppanisi./n /nPelin häviää jos et löydä itsellesi elämänkumppania./n /nJatka nähdäksesi hahmosi oman profiilin ja siirtyäksesi ensimmäiseen keskusteluun./n";
        
        createEmojiText(disclaimerText,textDisclaimer,"disclaimerText");
        createEmojiText(tutorialText,textMain,"tutorialText");
        
        disclaimerText.setMaxWidth(appWidth-60);
        disclaimerText.setTranslateX(28);
        ScrollPane disclaimerPane = new ScrollPane();
        disclaimerPane.setContent(disclaimerText);
        disclaimerPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        disclaimerPane.setMaxHeight(200);
        disclaimerPane.setId("disclaimerPane");
        
        
        tutorialText.setMaxWidth(appWidth-60);
        tutorialText.setTranslateX(28);
        ScrollPane tutorialPane = new ScrollPane();
        tutorialPane.setContent(tutorialText);
        tutorialPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tutorialPane.setMaxHeight(200);
        tutorialPane.setId("tutorialPane");
        
        
        ImageView logo = new ImageView("logo.png");
        logo.setId("iconFrame");
        
        // Button to go forward
        Button btnStart = new Button("Aloita peli");
        
        containerBegin.getChildren().addAll(logo,tutorialTitle,tutorialPane,disclaimerPane,btnStart);
        
        // Create the container for losing the game
        VBox containerLose = new VBox();
        containerLose.setAlignment(Pos.CENTER);
        
        TextFlow loseTitle = new TextFlow();
        loseTitle.setTextAlignment(TextAlignment.CENTER);
        
        String textLoseTitle = "/n Hävisit pelin. /n /n";
        createEmojiText(loseTitle,textLoseTitle,"tutorialTitle");
        
        TextFlow loseText = new TextFlow();
        loseText.setTextAlignment(TextAlignment.CENTER);
        
        String textLoseMain = "Kävit läpi kaikki mahdolliset keskustelukumppanit./n/n Ja kukaan niistä ei miellyttänyt sinua tarpeeksi./n /nEt löytänyt elämäsi rakkautta, mutta kenties parempi onni ensi kerralla?/n";
        createEmojiText(loseText,textLoseMain,"tutorialText");
        
        loseText.setMaxWidth(appWidth-40);
        loseText.setLineSpacing(10);
        
        ImageView lose = new ImageView("lose.png");
        lose.setId("iconFrame");
        
        // Button to go forward
        Button btnQuit = new Button("Lopeta peli");
        
        containerLose.getChildren().addAll(lose,loseTitle,loseText,btnQuit);
        
        
        // Create the container for winning the game
        VBox containerWin = new VBox();
        containerWin.setAlignment(Pos.CENTER);
        
        TextFlow winTitle = new TextFlow();
        winTitle.setTextAlignment(TextAlignment.CENTER);
        
        
        TextFlow winText = new TextFlow();
        winText.setTextAlignment(TextAlignment.CENTER);
        winText.setTranslateX(10);
        winText.setTranslateY(10);
        
        ScrollPane winScroll = new ScrollPane();
        winScroll.setContent(winText);
        winScroll.setMinSize(appWidth, appHeight-300);
        winScroll.setId("winPane");
        winScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        winScroll.setPadding(new Insets(20));
                
        ImageView win = new ImageView("victory.png");
        win.setId("iconFrame");
        
        // Button to go keep looking for a match
        Button btnContinue = new Button("Jatka etsintää...");
        
        containerWin.getChildren().addAll(win,winTitle,winScroll,btnContinue);
        
        // Create appropriate Scenes
        Scene sceneChat = new Scene(containerChat, appWidth, appHeight);
        Scene sceneProfile = new Scene(containerProfile, appWidth, appHeight);
        Scene sceneBegin = new Scene(containerBegin, appWidth, appHeight);
        Scene sceneWin = new Scene(containerWin, appWidth, appHeight);
        Scene sceneLose = new Scene(containerLose, appWidth, appHeight);
        
        // Take styling from CSS file
        sceneChat.getStylesheets().add("Hinder.css");
        sceneBegin.getStylesheets().add("Hinder.css");
        sceneLose.getStylesheets().add("Hinder.css");
        sceneWin.getStylesheets().add("Hinder.css");
        sceneProfile.getStylesheets().add("HinderProfile.css");
        
        
        // Functionality for the "Profile" button
        btnProfile.setOnMouseReleased(e -> {
            primaryStage.setScene(sceneProfile);
        });
        
        // Functionality for the "Block" button
        btnBlock.setOnMouseReleased(e -> {
            startConversation();
            if (blockUser == true) {
                blockUser = false;
                blockMessage = false;
                btnBlock.setId("buttonBlock");
                btnBlock.setText("Estä");
            }
        });
        
        // Functionality for the "Quit Game" button
        btnQuit.setOnMouseReleased(e -> {
            primaryStage.close();
        });
        
        // Functionality for the "Continue Search" button
        btnContinue.setOnMouseReleased(e -> {
            if (profObjId.getContinue() == false) {
                primaryStage.close();
            } else {
                winOnce = false;
                winGame = false;
                startConversation();
                primaryStage.setScene(sceneChat);
            }
        });
        
        // Functionality for the "Start Game" button
        btnStart.setOnMouseReleased(e -> {
            primaryStage.setScene(sceneProfile);
            showMe = true;
            bottomRow.getChildren().remove(backButton);
            updateProfile();
        });
        // Functionality for the "Swap Profile" button
        swapButton.setOnMouseReleased(e -> {
            if (showMe == false) {
                showMe = true;
                swapButton.setText("Keskustelukumppanisi profiili");
                bottomRow.getChildren().remove(backButton);
            } else {
                showMe = false;
                swapButton.setText("Oma profiilisi");
                bottomRow.getChildren().remove(swapButton);
                bottomRow.getChildren().addAll(backButton,swapButton);
                backButton.setVisible(true);
            }
            updateProfile();
        });
        
        
        // Functionality for the "Profile" button
        backButton.setOnMouseReleased(e -> {
            primaryStage.setScene(sceneChat);
        });

        // Set the Scene and make it not resizable
        primaryStage.setScene(sceneBegin);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hinder");
        primaryStage.show();
        

        // Lets create the Animation Timer for the game
        new AnimationTimer() {
            @Override
            public void handle(long currentTime) {
                
                if (chatBox.getChildren().isEmpty()) {
                    scrollBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                } else {
                    scrollBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                }
                
                if (loseGame == true || winGame == true) {
                    if (loseOnce == true && loseGame == true) {
                        primaryStage.setScene(sceneLose);
                        loseOnce = false;
                    }
                    if (winOnce == true && winGame == true) {
                        primaryStage.setScene(sceneWin);
                        winOnce = false;
                        
                        String textWinTitle = "/n "+profName+" vei sinut treffeille. /n /n";
                        createEmojiText(winTitle,textWinTitle,"tutorialTitle");
                        
                        
                        String textWinMain = profObjId.getWin()+"/n";
                        createEmojiText(winText,textWinMain,"tutorialText");
                        winText.setLineSpacing(10);
                        winText.setMaxWidth(appWidth-60);
                        
                        if (profObjId.getContinue() == true) {
                            btnContinue.setText("Jatka etsintää...");
                        } else {
                            btnContinue.setText("Lopeta peli");
                        }
                        
                        
                    }
                } else {
                    // SCroll the scrollbox down
                    if (scrollDown > 0) {
                        scrollBox.setVvalue(1);
                        scrollDown --;
                    }

                    // Do the timers
                    if (readingTimer > 0) {
                        statusText.setText("online");
                        statusText.setId("profileOnline");
                        dialogOptions.getChildren().removeAll(dialogOptions.getChildren());
                        readingTimer --;
                    } else {
                        if (messageTimer > 0) {
                            // Waiting for a message
                            statusText.setText("writing...");
                            statusText.setId("profileWriting");
                            dialogOptions.getChildren().removeAll(dialogOptions.getChildren());
                            messageTimer --;
                        } else {
                            if (waitForResponse == false) { // Here the character responds
                                
                                if (blockUser == true) { // If the chat partner has blocked you
                                    if (blockMessage == false) {
                                        blockMessage = true;
                                        statusText.setText("offline");
                                        statusText.setId("profileOffline");
                                        addText(profObjId.getName()+" on estänyt sinut. |stop",true);
                                        btnBlock.setText("Seuraava");
                                        btnBlock.setId("buttonNext");
                                    }
                                } else { // If not, then lets do the stuff
                                    // Waiting for a response
                                    statusText.setText("online");
                                    statusText.setId("profileOnline");
                                    // Check if this message automatically refers to another message
                                    boolean autoRefer = false;
                                    if (profObjId.getDialogObj(nextMessageId).getRef() != -1) {
                                        autoRefer = true;
                                    }

                                    // Adds the current response message from the AI
                                    addText(profObjId.getDialogText(nextMessageId),true);

                                    if (autoRefer == false) { // If there is no automatical referance to another message

                                        // Adds buttons for responses
                                        for (int i = 0; i < 10; i++) {
                                            if (profObjId.getDialogObj(nextMessageId).getOption(i) != "") {
                                                Button button = new Button((i+1)+". "+profObjId.getDialogObj(nextMessageId).getOption(i));
                                                button.setId("buttonOption");
                                                dialogOptions.getChildren().add(button);
                                            }
                                        }

                                        waitForResponse = true;

                                        // Character Controls (1,2,3,4 etc.)
                                        int id = 0;
                                        for (Node button: dialogOptions.getChildren()) {
                                            final int tmpID = id;
                                            button.setOnKeyPressed(e -> {
                                                if(e.getCode() == KeyCode.DIGIT1) {
                                                    chooseOption(tmpID);
                                                }
                                            });

                                            button.setOnMouseReleased(e -> {
                                                    chooseOption(tmpID);
                                            });

                                            id ++;
                                        }
                                    } else { // If there is a referance to another message
                                        newMessage(profObjId.getDialogObj(nextMessageId).getRef(),1);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }.start();
        
    }
    
    // This method loads new variables to profile
    public void updateProfile() {
        if (showMe == false) {
            // Name/Age/Place
            scnProfileName.setText(profName+", "+profAge+", "+profObjId.getCity());

            // Job/Study
            scnProfileJob.setText("Työ: "+profObjId.getJob()+"\nKoulutus: "+profObjId.getStudy());

            // Bio
            scnProfileBio.getChildren().removeAll(scnProfileBio.getChildren());
            createEmojiText(scnProfileBio,profObjId.getBio(),"textBio");

            // Picture
            Image kuva = new ImageView(profObjId.getPicture()).getImage();
            scnProfilePicture.setImage(kuva);
            scnProfilePicture.setFitHeight(profPicSize);
            scnProfilePicture.setFitWidth(profPicSize);
            scnProfilePicture.setPreserveRatio(true);
            scnProfilePicture.setId("pictureFrame");
        } else {
            scnProfileName.setText("Janica (sinä), 22, Vantaa");
            scnProfileJob.setText("Työ: Espresso House\nKoulutus: Tikkurilan lukio");
            
            scnProfileBio.getChildren().removeAll(scnProfileBio.getChildren());
            createEmojiText(scnProfileBio,bioText,"textBio");
            
            Image kuva = characterPic.getImage();
            scnProfilePicture.setImage(kuva);
            scnProfilePicture.setFitHeight(profPicSize);
            scnProfilePicture.setFitWidth(profPicSize);
            scnProfilePicture.setPreserveRatio(true);
            scnProfilePicture.setId("pictureFrame");
        }
                
    }
    
    // This method is used to add a new line of text to the chat
    public void addText(String text, boolean itsHim) {
        
        // Set the scrollbox to scroll itself down again
        scrollDown = 3;
        
        // Lets set the color scheme correctly
        String nicknameStyle = "nicknameHim";
        String textStyle = "textHim";
        String nickname = "  "+profName+", "+profAge+"v";
        
        // Lets cheate a new TextFlow box to add all the text
        TextFlow textFlow = new TextFlow();
        textFlow.setPadding(new Insets(10));
        textFlow.setLineSpacing(10);
        textFlow.setTextAlignment(TextAlignment.LEFT);
        
        textFlow.setMaxWidth(appWidth-50);
        
        textFlow.setId("boxHim");
        
        ImageView profilePic = new ImageView(profObjId.getPicture());
        textFlow.setTranslateX(5);
            
        if (itsHim == false) {
            nicknameStyle = "nicknameHer";
            textStyle = "textHer";
            nickname = "sinä  ";
            textFlow.setId("boxHer");
            textFlow.setTextAlignment(TextAlignment.RIGHT);
            profilePic = characterPic;
            textFlow.setTranslateX(25);
        }
        
        profilePic.setFitHeight(30);
        profilePic.setFitWidth(30);
        profilePic.setId("pictureFrame");
        
        // Styling for the block message is a bit different
        if (blockUser == true) {
            textStyle = "textBlock";
            textFlow.setId("boxBlock");
        }
        
        // Create the text object depending on whether it is the first time we create a text object or not
        boolean itWas = false;
        if (blockUser == false) { // If the user has been blocked, don't add a picture to message
            if (himPreviously != itsHim) {
                if(textFlow.getChildren().size()!=0){
                    Text nameText = new Text("\n"+nickname);
                    nameText.setId(nicknameStyle);
                    nameText.setTranslateY(-8);
                    itWas = true;
                    if (itsHim == true) { textFlow.getChildren().addAll(profilePic,nameText,new Text("\n")); } else { textFlow.getChildren().addAll(nameText,profilePic,new Text("\n")); }
                } else {
                    Text nameText = new Text(""+nickname);
                    nameText.setId(nicknameStyle);
                    nameText.setTranslateY(-8);
                    itWas = true;
                    if (itsHim == true) { textFlow.getChildren().addAll(profilePic,nameText,new Text("\n")); } else { textFlow.getChildren().addAll(nameText,profilePic,new Text("\n")); }
                }
            }
        }
        
        // Lets tell messages after this if this was from him or not, so we know if we need to show the nickname or not
        himPreviously = itsHim;
        
        // Create the emoji text
        createEmojiText(textFlow, text, textStyle);
        
        // Rectangle to split the two
        Rectangle box = new Rectangle();
        box.setWidth(appWidth-50);
        box.setHeight(2);
        box.setTranslateX(5);
        if (itsHim == false) { box.setTranslateX(25); }
        box.setId("separatorMessage");
        
        
        // Lastly, add the new textflow box to chat
        chatBox.getChildren().addAll(textFlow,box);
        
        // Play message sound
        
    }
    
    
    public void createEmojiText(TextFlow textFlow, String text, String textStyle) {
        
        // Lets create all the emojis we need
        HashMap<String,String> emojiDB = createEmojiData();
        
        // Example
        //emojiDB.put("name", "link");
        
        // Create an emojilist and textlist to add text and emoji sequences
        ArrayList<String> textList = new ArrayList<>();
        ArrayList<ImageView> emojiList = new ArrayList<>();
        
        // Chopping the text on all the emojis we can find from it
        int textStep = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i+1).contains("|")) {
                for (String emoji: emojiDB.keySet()) {
                    
                    if (i+emoji.length() < text.length()) {
                        if (text.substring(i, i+emoji.length()+1).contains(emoji)) {
                            ImageView imageView = new ImageView(emojiDB.get(emoji)+".png");
                            imageView.setId("emojiStyle");
                            imageView.setFitHeight(25);
                            imageView.setFitWidth(25);
                            imageView.setTranslateY(5);
                            if (blockUser == true) {
                                imageView.setTranslateY(0);
                            }
                            textList.add(text.substring(textStep, i));
                            emojiList.add(imageView);
                            textStep = i;
                        }
                    }
                }
            }
            
        }
        
        // Lets add rest of the text to the textList
        textList.add(text.substring(textStep,text.length()));
        
        // And finally lets add all the texts and emojis to the textFlow object
        for (int i = 0; i < textList.size(); i++) {
            String tmpText = textList.get(i);
            
            // Lets remove all the emoji tags from the text
            for (String emoji: emojiDB.keySet()) {
                if(tmpText.contains("|"+emoji)) {
                    tmpText = tmpText.replace("|"+emoji,"");

                }
            }
            
            // Lets add linebreaks to the text
            while (tmpText.contains("/n")) {
                //tmpText = tmpText.substring(0,chopText.indexOf("\n"));
                Text addedText = new Text(tmpText.substring(0,tmpText.indexOf("/n")));
                if (blockUser == true) {
                    addedText.setTranslateY(-4);
                }
                addedText.setId(textStyle);
                tmpText = tmpText.substring(tmpText.indexOf("/n")+2,tmpText.length());
                addedText.setId(textStyle);
                //addedText.setTranslateY(-4);
                textFlow.getChildren().add(addedText);
                textFlow.getChildren().add(new Text(System.lineSeparator()));
            }
            
            Text restText = new Text(tmpText);
            if (blockUser == true) {
                restText.setTranslateY(-4);
            }
            restText.setId(textStyle);
            //restText.setTranslateY(-4);
            textFlow.getChildren().add(restText);
            
            
            if (emojiList.size() > 0) {
                textFlow.getChildren().add(emojiList.get(0));
                emojiList.remove(0);
            }
            
        }
        
        
    }

    public void chooseOption(int id) {
        addText(profObjId.getOptionMessage(nextMessageId, id),false);
        
        newMessage(profObjId.getOptionRef(nextMessageId, id),0);
        
    }
    
    public void newMessage(int messageId, int type) {
        
        // Lets calculate how long it takes to write the message by its length
        double speed = profObjId.getDialogText(messageId).length();
        
        // Lets use the length to calculate how long it takes to write a single character
        speed = speed*0.05;
        
        // Use this to calculate messageTimer (secondSpeed is how long is a second)
        messageTimer = secondSpeed*speed;
        
        if (type == 0) {
            readingTimer = 2*secondSpeed;
        }
        if (type == 1) {
            readingTimer = secondSpeed/2;
        }
        

        waitForResponse = false;
        nextMessageId = messageId;
        
        if (nextMessageId == -1) {
            winGame = true;
        }
        if (nextMessageId == -2) {
            blockUser = true;
        }
        
        
    }
    
    public void createProfiles() {
        
        // First, lets scan all files in /resources folder that end in .profile
        List<File> files = findFilesFormat(".profile");
        for (File file: files) {
            
            chrProfiles.add(new Profile(file));
            
        }
        
    }
    
    
    
    public List<File> findFilesFormat(String format) {
        File dir = new File("./src/main/resources/");

        List<File> textFiles = new ArrayList<File>();
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((format))) {
                textFiles.add(file);
            }
        }
        return textFiles;

    }
    
    public void startConversation() {
        // This method starts the conversation with a random character
        if (chrProfiles.size() > 0) {
            Random rand = new Random(System.currentTimeMillis());

            // Get the profile object id
            profObjId = chrProfiles.get(rand.nextInt(chrProfiles.size()));

            // Load the profile to profile variables
            profName = profObjId.getName();
            profAge = profObjId.getAge();
            himPreviously = false;
            nameText.setText(profName+" is ");
            
            // Delete the profile from chrProfiles
            chrProfiles.remove(profObjId);
            
            // Clear the chat
            chatBox.getChildren().removeAll(chatBox.getChildren());
            
            // Reset the waiters
            newMessage(0, 0);

            // Finally, add pointer to the first message
            nextMessageId = 0;
            
            // And update the profile
            updateProfile();
        } else {
            // There is nobody to chat to, game over
            loseGame = true;
        }
    }
    
    public HashMap<String, String> createEmojiData() {
        
        HashMap<String, String> emojis = new HashMap<>();
        // Here we read the profile file and generate the profile data based on the file.
        try {
                Scanner scanner = new Scanner(new File("./src/main/resources/emoji.data"));
                Dialog dialogNow = null;
                while (scanner.hasNextLine()) {
                    // Lets start by copying the current file
                    String line = scanner.nextLine();
                    
                    // First, lets remove comment from the line
                    if (line.contains("//")) {
                        line = line.substring(0,line.indexOf("//"));
                        line = line.replaceAll(" ","");
                    }
                    
                    // If it is not comment or empty
                    if (line.length() > 0) {
                        
                        emojis.put(line.substring(0,line.indexOf("#")), line.substring(line.indexOf("#")+1,line.length()));
                        
                    }
                    
                }
                scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return emojis;
    }
    
    // This method is just to see how many rows of code/text/etc. the project currently has
    public static void calculateRows() throws FileNotFoundException {

        final String folderPath = ".";

        long totalLineCount = 0;
        final List<File> folderList = new LinkedList<>();
        folderList.add(new File(folderPath));
        while (!folderList.isEmpty()) {
            final File folder = folderList.remove(0);
            if (folder.isDirectory() && folder.exists()) {
                System.out.println("Scanning " + folder.getName());
                final File[] fileList = folder.listFiles();
                for (final File file : fileList) {
                    if (file.isDirectory()) {
                        folderList.add(file);
                    } else if (file.getName().endsWith(".java")
                            || file.getName().endsWith(".profile")
                            || file.getName().endsWith(".sql")) {
                        long lineCount = 0;
                        final Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                        totalLineCount += lineCount;
                        final String lineCountString;
                        if (lineCount > 99999) {
                            lineCountString = "" + lineCount;
                        } else {
                            final String temp = ("     " + lineCount);
                            lineCountString = temp.substring(temp.length() - 5);
                        }
                        System.out.println(lineCountString + " lines in " + file.getName());
                    }
                }
            }
        }
        System.out.println("Scan Complete: " + totalLineCount + " lines total");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
