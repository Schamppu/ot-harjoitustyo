// This class is for creating new character profiles.
package hinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

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
    private HashMap<Integer,Dialog> profDialog = new HashMap<>();
    
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
                while (scanner.hasNextLine()) {
                    // Lets start by copying the current file
                    String line = scanner.nextLine();
                    
                    // Then lets do some cases based on stuff
                    if (!line.contains("//")) {
                        String check = ""; // What are we checking?
                        String tag = "#"; // How do we mark the beginning of a tag?
                        // Base information
                        check = "name"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profName = line;
                        }
                        check = "age"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profAge = Integer.valueOf(line);
                        }
                        check = "bio"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profBio = line;
                        }
                        check = "pic"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profPic = line;
                        }
                        check = "job"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profJob = line;
                        }
                        check = "study"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profStudy = line;
                        }
                        check = "city"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profCity = line;
                        }
                        check = "victory"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            line = line.replace(tag+check,""); line = line.trim();
                            profWin = line;
                        }
                        check = "continue"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            profContinue = true;
                        }
                        
                        // Create the dialog
                        if (line.length() > 2) {
                            if (line.substring(0, 1).contains("#") && NumberUtils.isNumber(line.substring(1,2)) == true) {
                                int refNumber = 0;
                                for (int i = 0; i < line.length(); i++) {
                                    if (line.substring(i,i+1).contains(" ")) {
                                        refNumber = Integer.valueOf(line.substring(0,i).replaceAll(tag, ""));
                                        line = line.substring(i+1,line.length());
                                        break;
                                    }
                                }
                                Dialog dialog = new Dialog(line);
                                profDialog.put(refNumber, dialog);
                                dialogNow = dialog;
                                
                            }
                        }
                        
                        // Modify the dialog
                        
                        // Option to choose from
                        check = "opt"; check = check.toUpperCase();
                        if (line.contains(tag+check)) {
                            
                            line = line.replace(tag+check,""); line = line.trim();
                            
                            String option = line.substring(0,line.indexOf(tag+"MSG")-1);
                            int refer = 0;
                            String refTag = "REF";
                            // Check for win/block condition
                            if (line.contains("#WIN") || line.contains("#RMV")) {
                                if (line.contains("#WIN")) { refer = -1; refTag = "WIN"; }
                                if (line.contains("#RMV")) { refer = -2; refTag = "RMV"; }
                            } else {
                                refer = Integer.valueOf(line.substring(line.indexOf(tag+refTag)+4,line.length()).trim());
                            }
                            
                            String message = line.substring(line.indexOf(tag+"MSG")+4,line.indexOf(tag+refTag)-1);
                            
                            dialogNow.addOption(option, message, refer);
                            
                        } else {
                            
                            // Straight reference to another message
                            if (line.contains("#WIN") || line.contains("#RMV")) {
                                if (line.contains("#WIN")) { dialogNow.setRef(-1); }
                                if (line.contains("#RMV")) { dialogNow.setRef(-2); }
                            } else {
                                check = "ref"; check = check.toUpperCase();
                                if (line.contains(tag+check)) {
                                    line = line.replace(tag+check,""); line = line.trim();
                                    dialogNow.setRef(Integer.valueOf(line));
                                }
                            }
                            
                        }
                        
                        
                        
                        
                        //System.out.println(line);
                    }
                    
                }
                scanner.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
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
