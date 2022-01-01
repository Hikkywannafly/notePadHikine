package NotePad_Hiki;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;

public class NotePad extends JFrame {
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu file, view , Format , help, color;
    JMenuItem reset, save , saveas , open , exit;
    JMenuItem hiki, about,zoom;
    NotePadListen npl = new NotePadListen(this);
    popupMenuListener pml = new popupMenuListener();
    JPopupMenu popupMenu;
    JMenuItem cutI , copyI, pasteI, aboutI;
    String filename ;
    String fileaddress ;
    JMenuItem wordwrap, font, fontsize;
    public NotePad(){
        this.init();
        this.menuBar();
        this.menuItem();
        this.textArea();
        this.popup();
        this.setVisible(true);

    }
    public void  init(){
        this.setTitle("NotePad of Hiki");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    public void menuBar(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar); // DDm chol oz fdms
        file = new JMenu("File");
        file.addActionListener(npl);
        menuBar.add(file);
        view = new JMenu("View");
        view.addActionListener(npl);
        menuBar.add(view);
        Format = new JMenu("Format");
        Format.addActionListener(npl);
        menuBar.add(Format);
        help = new JMenu("Help");
        help.addActionListener(npl);
        menuBar.add(help);
        color = new JMenu("Color");
        color.addActionListener(npl);
        menuBar.add(color);

        this.setVisible(true);
    }
    public void menuItem(){
        //reset, save , saveas , open , exit;
        reset = new JMenuItem("Reset");
        file.add(reset);
        reset.addActionListener(npl);
        save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(npl);
        saveas = new JMenuItem("Save as");
        file.add(saveas);
        saveas.addActionListener(npl);
        open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(npl);
        exit = new JMenuItem("Exit");
        file.addSeparator();
        file.add(exit);
        exit.addActionListener(npl);
        // hiki, about,zoom;

        hiki = new JMenu("Hiki nè");
        zoom  = new JMenuItem("Zoom");
        view.add(zoom);
        about = new JMenuItem("About of NotePad");
        about.addActionListener(npl);
        view.add(about);

    }

    public void textArea(){
        Font font = new Font("Lucida Console",Font.PLAIN, 12); //Arial
        textArea = new JTextArea();
        textArea.setFont(font);
        scrollPane = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.addMouseListener(pml);
        this.add(scrollPane);

        //this.addMouseListener(npm);

    }
    public void popup(){
        popupMenu = new JPopupMenu("Hiki ne");
        copyI = new JMenuItem("Copy");
        copyI.addActionListener(npl);
        popupMenu.add(copyI);
        pasteI = new JMenuItem("Paste");
        pasteI.addActionListener(npl);
        popupMenu.add(pasteI);
        cutI = new JMenuItem("Cut");
        cutI.addActionListener(npl);
        popupMenu.add(cutI);
        aboutI = new JMenuItem("About of NotePad Hiki");
        aboutI.addActionListener(npl);
        popupMenu.addSeparator();
        popupMenu.add(aboutI);

       // this.add(popupMenu);
    }


    public void newFile() {
           this.textArea.setText("");
           this.setTitle("Hiki đã reset");
            fileaddress = null;
            filename = null;
    }
    public void saveFile() {

    }
    public void saveAsFile() {
        FileDialog fd = new FileDialog(this, "Save as ", FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile() != null) {
            filename = fd.getFile();
            fileaddress = fd.getDirectory();
            this.setTitle(filename);
        }
        try{
            FileWriter writer = new FileWriter(fileaddress +filename);
            writer.write(this.textArea.getText());
            writer.close();
        }
        catch(Exception ea){

            System.out.println("Something were wrong!");

        }


    }
    class popupMenuListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.isPopupTrigger()) {
            popupMenu.show(e.getComponent(),e.getX(),e.getY());

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popupMenu.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

}
