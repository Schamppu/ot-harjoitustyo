package hinder;

import static hinder.HinderUi.bioText;
import static hinder.HinderUi.blockUser;
import static hinder.HinderUi.characterPic;
import static hinder.HinderUi.idProfileBio;
import static hinder.HinderUi.idProfileJob;
import static hinder.HinderUi.idProfileName;
import static hinder.HinderUi.idProfilePicture;
import static hinder.HinderUi.idProfileStudy;
import static hinder.HinderUi.listProfileBio;
import static hinder.HinderUi.listProfileJob;
import static hinder.HinderUi.listProfileName;
import static hinder.HinderUi.listProfilePicture;
import static hinder.HinderUi.listProfileStudy;
import static hinder.HinderUi.profAge;
import static hinder.HinderUi.profName;
import static hinder.HinderUi.profObjId;
import static hinder.HinderUi.profPicSize;
import static hinder.HinderUi.scnProfileBio;
import static hinder.HinderUi.scnProfileJob;
import static hinder.HinderUi.scnProfileName;
import static hinder.HinderUi.scnProfilePicture;
import static hinder.HinderUi.scnProfileStudy;
import static hinder.HinderUi.showMe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import classes.Profile;

public class HinderMethods {
    // This class includes methods that are used by UI, but kept away from the 
    // code for better testing and checkstyling
    
    public static void createEmojiText(TextFlow textFlow, String text, String textStyle) {
        // Lets create all the emojis we need
        HashMap<String, String> emojiDB = createEmojiData();

        // Create an emojilist and textlist to add text and emoji sequences
        ArrayList<String> textList = new ArrayList<>();
        ArrayList<ImageView> emojiList = new ArrayList<>();

        // Chopping the text on all the emojis we can find from it
        int textStep = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).contains(":")) {
                for (String emoji: emojiDB.keySet()) {
                    if (i + emoji.length() < text.length() && text.substring(i, i + emoji.length() + 1).contains(emoji) && text.substring(i + emoji.length() + 1, i + emoji.length() + 2).contains(":")) {
                        ImageView imageView = new ImageView(emojiDB.get(emoji) + ".png");
                        imageView.setId("emojiStyle");
                        imageView.setFitHeight(25);
                        imageView.setFitWidth(25);
                        imageView.setTranslateY(5);
                        if (blockUser == true) {
                            imageView.setTranslateY(0);
                        }

                        if (textList.size() == 0 && text.substring(textStep, i).length() == 0) {
                            textList.add(text.substring(textStep, i) + "");
                        } else {
                            textList.add(text.substring(textStep, i) + "");
                        }

                        emojiList.add(imageView);
                        textStep = i;
                    }
                }
            }

        }

        // Lets add rest of the text to the textList
        textList.add(text.substring(textStep, text.length()));

        // And finally lets add all the texts and emojis to the textFlow object
        for (int i = 0; i < textList.size(); i++) {
            String tmpText = textList.get(i);

            // Lets remove all the emoji tags from the text
            for (String emoji: emojiDB.keySet()) {
                if (tmpText.contains(":" + emoji + ":")) {
                    tmpText = tmpText.replace(":" + emoji + ":", "");

                }
            }

            // Lets add linebreaks to the text
            while (tmpText.contains("/n")) {
                //tmpText = tmpText.substring(0,chopText.indexOf("\n"));
                Text addedText = new Text(tmpText.substring(0, tmpText.indexOf("/n")));
                if (blockUser == true) {
                    addedText.setTranslateY(-4);
                }
                addedText.setId(textStyle);
                tmpText = tmpText.substring(tmpText.indexOf("/n") + 2, tmpText.length());
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
            if (restText.getText().length() > 0) {
                textFlow.getChildren().add(restText);
            }

            if (emojiList.size() > 0) {
                textFlow.getChildren().addAll(emojiList.get(0));
                emojiList.remove(0);
            }
        }
    }
    
    public static HashMap<String, String> createEmojiData() {
        HashMap<String, String> emojis = new HashMap<>();
        // Here we read the profile file and generate the profile data based on the file.
        try {
            Scanner scanner = new Scanner(new File("./src/main/resources/emoji.data"));
            while (scanner.hasNextLine()) {
                // Lets start by copying the current file
                String line = scanner.nextLine();        
                // First, lets remove comment from the line
                if (line.contains("//")) {
                    line = line.substring(0, line.indexOf("//"));
                    line = line.replaceAll(" ", "");
                }
                // If it is not comment or empty
                if (line.length() > 0) {        
                    emojis.put(line.substring(0, line.indexOf("#")), line.substring(line.indexOf("#") + 1, line.length()));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return emojis;
    }
    
    public static void updateProfile() {
        if (showMe == false) {
            // Name/Age/Place
            scnProfileName.setText(profName + ", " + profAge + ", " + profObjId.getCity());
            // Job/Study
            scnProfileJob.setText("Työ: " + profObjId.getJob());
            scnProfileStudy.setText("Koulutus: " + profObjId.getStudy());
            // Bio
            scnProfileBio.getChildren().removeAll(scnProfileBio.getChildren());
            createEmojiText(scnProfileBio, profObjId.getBio(), "textBio");
            // Picture
            Image kuva = new ImageView(profObjId.getPicture()).getImage();
            scnProfilePicture.setImage(kuva);
        } else {
            scnProfileName.setText(listProfileName.get(idProfileName) + " (sinä), 22, Vantaa");
            scnProfileJob.setText("Työ: " + listProfileJob.get(idProfileJob));
            scnProfileStudy.setText("Koulutus: " + listProfileStudy.get(idProfileStudy));
            scnProfileBio.getChildren().removeAll(scnProfileBio.getChildren());
            createEmojiText(scnProfileBio, listProfileBio.get(idProfileBio), "textBio");
            Image kuva = characterPic.getImage();
            scnProfilePicture.setImage(listProfilePicture.get(idProfilePicture).getImage());
        }           
    }
    
    public static void createCharacterData() {
        try {
            Scanner scanner = new Scanner(new File("./src/main/resources/character.data"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String check = ""; // What are we checking?
                String tag = "#"; // How do we mark the beginning of a tag?
                List<String> checkList = Arrays.asList("name","job","study","bio");
                for (int i = 0; i < 4; i++) {
                    if (line.contains(tag + checkList.get(i).toUpperCase())) {
                        line = line.replaceAll(tag + checkList.get(i).toUpperCase(), "");
                        switch (checkList.get(i)) {
                            case "name":
                                listProfileName.add(line);
                                break;
                            case "job":
                                listProfileJob.add(line);
                                break;
                            case "study":
                                listProfileStudy.add(line);
                                break;
                            case "bio":
                                listProfileBio.add(line);
                                break;
                        }
                    }
                
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
