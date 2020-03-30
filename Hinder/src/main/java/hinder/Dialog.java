// This class is for creating new dialog responses.
package hinder;
        
import java.util.ArrayList;

public class Dialog {
    
    private ArrayList<String> optionText = new ArrayList<>();
    private ArrayList<Integer> optionRefId = new ArrayList<>();
    private ArrayList<String> optionDialogText = new ArrayList<>();
    private String message;
    private int refNext = -1;
    
    public Dialog(String msg) {
        message = msg;
    }
    
    public void addOption(String text, String dialog, int refId) {
        optionText.add(text);
        optionDialogText.add(dialog);
        optionRefId.add(refId);
    }
    
    public String getText() {
        return message;
    }
    
    public String getOption(int id) {
        if (optionText.size() > id) {
            return optionText.get(id);
        }
        
        return "";
    }
    
    
    public String getOptionMessage(int id) {
        if (optionDialogText.size() > id) {
            return optionDialogText.get(id);
        }
        
        return "";
    }
    
    public int getOptionRef(int id) {
        if (optionRefId.size() > id) {
            return optionRefId.get(id);
        }
        
        return 0;
    }
    
    public void setRef(int id) {
        refNext = id;
    }
    
    public int getRef() {
        return refNext;
    }
            
}
