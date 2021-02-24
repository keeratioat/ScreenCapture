import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
 
public class AFKScreenCapture extends Thread {
 
    public void ScreenCapture(int min , String filename) throws InterruptedException {
        try {
            int ms = min * 60 *1000;
            
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = filename +"."+ format;
            
            Thread.sleep(ms);
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
             
            JOptionPane optionPane = new JOptionPane ();
            optionPane.setMessageType ( JOptionPane.INFORMATION_MESSAGE );
            optionPane.setMessage ( "A full screenshot saved!" );
           
            JDialog dialog = optionPane.createDialog ( null, "AFK Screen Capture" );
            dialog.setVisible ( true );
            System.out.println("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}