package NotePad_Hiki;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new NotePad();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
