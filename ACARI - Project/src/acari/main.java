package acari;

//import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import javax.swing.UIManager;
import view.*;

/**
 *
 * @author Bento
 */
public class main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*
                   try{
          UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());}   
                catch (Exception e){
          e.printStackTrace();}
                    new principalView().setVisible(true);
            }});
                 */
                new principalView().setVisible(true);
            }
        });
    
    }
}
