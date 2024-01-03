package GUI;

import validate.PanelRound;

import javax.swing.*;
import java.awt.*;

public class AddTourContent extends JPanel {
    private Manager manager;
    private PanelRound containMain;
    private JTextField txf1;
    public int id;

    public AddTourContent(Manager manager) {
        this.manager = manager;
        init();
    }

    public void init() {
        setBackground(new Color(219, 219, 219));
        setLayout(new BorderLayout());

        containMain = new PanelRound();
        containMain.setRoundBottomLeft(20);
        containMain.setRoundTopLeft(20);
        containMain.setRoundBottomRight(20);
        containMain.setRoundTopRight(20);
        containMain.setPreferredSize(new Dimension(1146, 929));
        containMain.setBackground(Color.WHITE);
        containMain.setLayout(null);
        add(containMain, BorderLayout.CENTER);
        
        txf1 = new JTextField();
        txf1.setBounds(100,100,1000,100);
        containMain.add(txf1);
    }
}
