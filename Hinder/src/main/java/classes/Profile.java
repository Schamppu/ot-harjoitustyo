// This class is for creating new character profiles.
package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;
import javax.swing.JOptionPane;


public class Profile {
    
    private File profFile;
    private String profName;
    private int profAge;
    private String profBio;
    private String profPic;
    private String profJob;
    private String profStudy;
    private String profCity;
    private String profWin;
    private boolean profContinue = false;
    private HashMap<Integer, Dialog> profDialog = new HashMap<>();
    
    public Profile(File file) {
        profFile = file;
        readFile();
    }
    
    
    /**
     * This method reads the file that has been assigned for the Profile
     * object inside the constructor.
     * 
     */
    public void readFile() {
        // Here we read the profile file and generate the profile data based on the file.
        try {
            Scanner scanner = new Scanner(profFile);
            Dialog dialogNow = null;
            int lineNumber = 00;
            while (scanner.hasNextLine()) {
                // Lets start by copying the current file
                String line = scanner.nextLine();
                lineNumber++;

                // Lets remove comments
                if (line.contains("//")) {
                    line = line.substring(0, line.indexOf("//"));
                }

                // Then lets do some cases based on stuff
                String check = ""; // What are we checking?
                String tag = "#"; // How do we mark the beginning of a tag?
                // Base information
                
                for (int i = 0; i < 10; i++) {
                    
                    switch (i) {
                        case 0: 
                            check = "name";
                            break;
                        case 1: 
                            check = "age";
                            break;
                        case 2: 
                            check = "bio";
                            break;
                        case 3: 
                            check = "pic";
                            break;
                        case 4: 
                            check = "job";
                            break;
                        case 5: 
                            check = "study";
                            break;
                        case 6: 
                            check = "city";
                            break;
                        case 7: 
                            check = "victory";
                            break;
                        case 8: 
                            check = "continue";
                            break;
                    }
                    check = check.toUpperCase();
                    
                    if (line.contains(tag + check)) {
                        line = line.replace(tag + check, ""); 
                        line = line.trim();
                        switch (i) {
                            
                            case 0: 
                                profName = line;
                                break;
                            case 1: 
                                profAge = Integer.valueOf(line);
                                break;
                            case 2: 
                                profBio = line;
                                break;
                            case 3: 
                                profPic = line;
                                break;
                            case 4: 
                                profJob = line;
                                break;
                            case 5: 
                                profStudy = line;
                                break;
                            case 6: 
                                profCity = line;
                                break;
                            case 7: 
                                profWin = line;
                                break;
                            case 8: 
                                profContinue = true;
                                break;
                        }
                    }
                }
                

                // Create the dialog
                if (line.length() > 2) {
                    if (line.substring(0, 1).contains("#") && NumberUtils.isNumber(line.substring(1, 2)) == true) {
                        int refNumber = 0;
                        for (int i = 0; i < line.length(); i++) {
                            if (line.substring(i, i + 1).contains(" ")) {
                                refNumber = Integer.valueOf(line.substring(0, i).replaceAll(tag, ""));
                                line = line.substring(i + 1, line.length());
                                break;
                            }
                        }
                        Dialog dialog = new Dialog(line.trim());
                        profDialog.put(refNumber, dialog);
                        dialogNow = dialog;

                    }
                }

                // Modify the dialog

                // Option to choose from
                check = "opt"; 
                check = check.toUpperCase();
                if (line.contains(tag + check)) {

                    if (!line.contains("#MSG")) {
                        new Popup("Error: missing MSG tag", "There is a #OPT tag without a #MSG tag. \nFile: " + profFile.toString() + "\nRow number: " + lineNumber);
                    }
                    if (!line.contains("#REF")) {
                        new Popup("Error: missing REF tag", "There is a #OPT tag without a #REF tag. \nFile: " + profFile.toString() + "\nRow number: " + lineNumber);
                    }

                    line = line.replace(tag + check, ""); 
                    line = line.trim();

                    String option = line.substring(0, line.indexOf(tag + "MSG") - 1);
                    int refer = 0;
                    String refTag = "REF";
                    // Check for win/block condition
                    if (line.contains("#WIN") || line.contains("#RMV")) {
                        if (line.contains("#WIN")) { 
                            refer = -1; 
                            refTag = "WIN"; 
                        }
                        if (line.contains("#RMV")) { 
                            refer = -2; 
                            refTag = "RMV"; 
                        }
                    } else {
                        if (NumberUtils.isNumber(line.substring(line.indexOf(tag + refTag) + 4, line.length()).trim()) == true) {
                            refer = Integer.valueOf(line.substring(line.indexOf(tag + refTag) + 4, line.length()).trim());
                        } else {
                            new Popup("Error: invalid REF number", "There is an invalid REF number. \nFile: " + profFile.toString() + "\nRow number: " + lineNumber + "\nInvalid referate number is: " + line.substring(line.indexOf(tag + refTag) + 4, line.length()).trim());
                        }
                    }

                    String message = line.substring(line.indexOf(tag + "MSG") + 4, line.indexOf(tag + refTag) - 1);

                    dialogNow.addOption(option, message, refer);

                } else {

                    // Straight reference to another message
                    if (line.contains("#WIN") || line.contains("#RMV")) {
                        if (line.contains("#WIN")) { 
                            dialogNow.setRef(-1); 
                        }
                        if (line.contains("#RMV")) { 
                            dialogNow.setRef(-2); 
                        }
                    } else {
                        check = "ref"; 
                        check = check.toUpperCase();
                        if (line.contains(tag + check)) {
                            line = line.replace(tag + check, ""); 
                            line = line.trim();
                            dialogNow.setRef(Integer.valueOf(line));
                        }
                    }

                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // Then, lets run a checking algorithm that finds if there is something wrong with our referate ID:s
        checkRefers();
        
    }
    
    public void checkRefers() {
        
        // First, lets add all the refer ID's to a list
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<String> texts = new ArrayList<>();
        for (Dialog dialog: profDialog.values()) {
            
            values.add(dialog.getRef());
            texts.add("Dialog text: [" + dialog.getText() + "]");
            for (int i = 0; i < 10; i++) {
                values.add(dialog.getOptionRef(i));
                texts.add("#OPT text: [" + dialog.getOption(i) + "] #MSG text: [" + dialog.getOptionMessage(i) + "]");
                
            }
            
        }
        
        // Then, lets go through it
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != 0 && values.get(i) != -1 && values.get(i) != -2 && !profDialog.containsKey(values.get(i))) {
                new Popup("Invalid referate number", "There is an referate number in a file that refers to an non-existing dialog.\nFile: " + profFile.toString() + "\nNon-existing dialog ID: " + values.get(i) + "\n" + texts.get(i));
            }
        }
        
    }
    
    public String getName() {
        return profName;
    }
    
    public int getAge() {
        return profAge;
    }
    
    public String getPicture() {
        return profPic;
    }
    
    public String getCity() {
        return profCity;
    }
    
    public String getJob() {
        return profJob;
    }
    
    public String getStudy() {
        return profStudy;
    }
    
    public String getBio() {
        return profBio;
    }
    
    public String getWin() {
        return profWin;
    }
    
    public boolean getContinue() {
        return profContinue;
    }
    
    public String getDialogText(int id) {
        return profDialog.get(id).getText();
    }
    
    public Dialog getDialogObj(int id) {
        return profDialog.get(id);
    }
    
    public String getOptionMessage(int id, int msgId) {
        return profDialog.get(id).getOptionMessage(msgId);
    }
    
    public int getOptionRef(int id, int msgId) {
        return profDialog.get(id).getOptionRef(msgId);
    }
    
    public void addDialog(Dialog dialog, int key) {
        profDialog.put(key, dialog);
    }
    
}
