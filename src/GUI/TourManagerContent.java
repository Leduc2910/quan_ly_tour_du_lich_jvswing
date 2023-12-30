package GUI;

import controller.ManagerController;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.scripts.JO;
import model.Tour;
import model.Tour_category;
import service.TourCategoryService;
import service.TourService;
import validate.ImageValidate;
import validate.InputValidate;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TourManagerContent extends JPanel {


    public TourManagerContent() {
        init();
    }





    public void init() {
        setPreferredSize(new Dimension(1130, 935));
        setBackground(new Color(219, 219, 219));
        setLayout(new BorderLayout());


    }
}
