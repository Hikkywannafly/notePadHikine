package NotePad_Hiki;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class NotePadListen implements ActionListener {

    NotePad notePad;
    About about;
    String filename;
    String fileaddress;
    public NotePadListen(NotePad notePad) {
        this.notePad = notePad;
    }

    public NotePadListen(About about) {
        this.about = about;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getEvent = e.getActionCommand();
        if (getEvent.equals("Reset")) {
            notePad.newFile();
        } else if (getEvent.equals("Exit")) {
            System.exit(0);
        } else if (getEvent.equals("Open")) {
            FileDialog fd = new FileDialog(this.notePad, "Open", FileDialog.LOAD);
            fd.setVisible(true);
            if (fd.getFile() != null) {
                filename = fd.getFile();
                fileaddress = fd.getDirectory();
                notePad.setTitle(filename);
            }
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileaddress + filename));
                notePad.textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    notePad.textArea.append(line + "\n");
                }
                reader.close();
            } catch (Exception ea) {
                System.out.println("Nothing in this file");
            }


        } else if (getEvent.equals("Save")) {
            if (filename == null) {
                notePad.saveAsFile();
            } else {
                try {
                    FileWriter writer = new FileWriter(fileaddress + filename);
                    writer.write(notePad.textArea.getText());
                    notePad.setTitle(filename);
                    writer.close();
                } catch (Exception ex) {
                    System.out.println("Something were wrong!");
                }

            }
        } else if (getEvent.equals("Save as")) {

            notePad.saveAsFile();

        }else if (e.getActionCommand().equals("About of NotePad") || e.getActionCommand().equals("About of NotePad Hiki") ){
            new About().setVisible(true);
        }else if (getEvent.equals("Close")){
            about.setVisible(false);
        }else if (getEvent.equals("Copy")){
            notePad.textArea.copy();
        }else if (getEvent.equals("Paste")){
            notePad.textArea.paste();
        }
    }
}