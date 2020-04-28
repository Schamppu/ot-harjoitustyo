package hinder;

import classes.Profile;
import static hinder.HinderMethods.createEmojiText;
import static hinder.HinderMethods.updateProfile;
import static hinder.HinderUi.listProfileName;
import static hinder.HinderUi.scnProfileName;
import java.io.File;
import javafx.scene.text.TextFlow;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class hinderMainTest {
    
    Profile profileTest;
    
    @Before
    public void setUp() {
        profileTest = new Profile(new File("./resources/profiles/Antero.profile"));
    }
    
    @Test
    public void profileBioLengthTest() {
        assertTrue(profileTest.getBio().length() > 0);      
    }
    
    @Test
    public void profileNameLengthTest() {
        assertTrue(profileTest.getName().length() > 0);      
    }
    
    @Test
    public void emojiTextBasicTest() {
        TextFlow testFlow = new TextFlow();
        createEmojiText(testFlow,"test","");
        assertTrue(testFlow.toString().length() > 0);      
    }
    
}
