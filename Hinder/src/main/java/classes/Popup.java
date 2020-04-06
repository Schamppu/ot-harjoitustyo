package classes;    
import javax.swing.JOptionPane;

/**
 * This class is for creating a popup message
 * 
 */
public class Popup {
    
    String titleText;
    String messageText;
    boolean allowErrors = false;
    
    public Popup(String title, String message) {
        titleText = title;
        messageText = message;
        infoBox(messageText, titleText);
    }

    public void infoBox(String infoMessage, String titleBar) {
        if (allowErrors == true) {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println(infoMessage + "\n");
    }
    
}
