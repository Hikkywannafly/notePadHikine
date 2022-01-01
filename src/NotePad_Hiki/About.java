package NotePad_Hiki;

import javax.swing.*;
import java.awt.*;


public class About extends JFrame {
    JLabel l1,l2,l3;
    JButton b1;
    NotePadListen npl = new NotePadListen(this);
    public About() {
        this.setTitle("About of NotePade");
        this.setSize(230,150);
        this.setLayout(new FlowLayout());
        Font font  = new Font("Ink Free Regular", Font.PLAIN,14);
        l1 = new JLabel("Hello I'm Hiki");
        l1.setFont(font);
        l1.setForeground(Color.magenta);
        l2 = new JLabel("Yeah this NotePad made by me ");
        l3 = new JLabel( "It so fk hard haha , so just enjoy this");
        b1 = new JButton("Close");
        b1.addActionListener(npl);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(b1);
        this.setLocationRelativeTo(null);

       // this.setVisible(true);
    }


}
