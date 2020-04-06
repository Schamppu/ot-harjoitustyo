package hinder;

import classes.Profile;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class hinderMainTest {
    
    Profile profileTest;
    
    @Before
    public void setUp() {
        profileTest = new Profile(new File("./src/main/resources/Antero.profile"));
    }
    
    @Test
    public void profileBioLengthTest() {
        assertTrue(profileTest.getBio().length() > 0);      
    }
    
    @Test
    public void profileNameLengthTest() {
        assertTrue(profileTest.getName().length() > 0);      
    }
    
}
