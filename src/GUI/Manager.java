package GUI;

import javax.swing.*;
import java.awt.*;

public class Manager extends JFrame {
    public Manager() {
        this.init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quản lý tour du lịch");
        setSize(500, 448);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

    }
}
