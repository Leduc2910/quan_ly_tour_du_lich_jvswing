package GUI;

import controller.ManagerController;
import model.Tour;
import model.Tour_category;
import service.TourCategoryService;
import service.TourService;
import validate.ImageValidate;
import validate.InputValidate;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Manager extends JFrame {
    private JPanel containContent;
    private JPanel containMenuBar;
    private PanelRound containManager;
    private JPanel containAvatar;
    private JLabel lbFullName;
    private JLabel lbAvatar;
    private JPanel containFunction;
    private JLabel lbIconTour;
    private JPanel managerTourFunction;
    private JLabel lbTour;
    private JLabel lbIconUser;
    private JLabel lbUserGear;
    private JPanel managerStafffunction;
    private TourManagerContent tourManagerContent;
    private StaffManagerContent staffManagerContent;
    private CardLayout cardLayout;

    public Manager() {
        this.init();
        this.changeForm();
    }

    public Manager(JPanel managerTourFunction, JPanel managerStafffunction, CardLayout cardLayout, PanelRound containManager) {
        this.managerTourFunction = managerTourFunction;
        this.managerStafffunction = managerStafffunction;
        this.cardLayout = cardLayout;
        this.containManager = containManager;
    }

    public JPanel getContainManager() {
        return containManager;
    }

    public void setContainManager(PanelRound containManager) {
        this.containManager = containManager;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getManagerTourFunction() {
        return managerTourFunction;
    }

    public void setManagerTourFunction(JPanel managerTourFunction) {
        this.managerTourFunction = managerTourFunction;
    }

    public JPanel getManagerStafffunction() {
        return managerStafffunction;
    }

    public void setManagerStafffunction(JPanel managerStafffunction) {
        this.managerStafffunction = managerStafffunction;
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quản lý tour du lịch");
        setSize(1512, 982);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(219, 219, 219));

        MouseListener mouseListener = new ManagerController(this);

        containContent = new PanelRound();
        containContent.setBackground(new Color(219, 219, 219));
        containContent.setLayout(new BorderLayout());
        add(containContent);

        containMenuBar = new JPanel();
        containMenuBar.setPreferredSize(new Dimension(342, 982));
        containMenuBar.setBackground(Color.WHITE);
        containMenuBar.setLayout(null);
        containContent.add(containMenuBar, BorderLayout.WEST);

        containAvatar = new JPanel();
        containAvatar.setBounds(48, 115, 240, 295);
        containAvatar.setBackground(Color.WHITE);
        containAvatar.setLayout(null);
        containMenuBar.add(containAvatar);

        ImageIcon userIcon = new ImageIcon(getClass().getResource("/image/huychien.png"));
        Image image = new ImageIcon(ImageValidate.scaleSize(userIcon.getImage(), 240, 240)).getImage();
        Image roundImage = ImageValidate.makeRoundedImage(image, 200);
        Icon avt = new ImageIcon(roundImage);
        lbAvatar = new JLabel(avt);
        lbAvatar.setBounds(0, 0, 240, 240);
        containAvatar.add(lbAvatar);

        lbFullName = new JLabel("Trần Huy Chiến");
        lbFullName.setBounds(10, 260, 240, 35);
        lbFullName.setFont(new Font("Roboto", Font.PLAIN, 32));
        containAvatar.add(lbFullName);

        containFunction = new JPanel();
        containFunction.setBounds(0, 490, 342, 160);
        containFunction.setLayout(null);
        containFunction.setBackground(Color.WHITE);
        containMenuBar.add(containFunction);

        managerTourFunction = new JPanel();
        managerTourFunction.setBounds(0, 0, 342, 50);
        managerTourFunction.setBackground(Color.WHITE);
        managerTourFunction.setLayout(null);
        managerTourFunction.addMouseListener(mouseListener);
        containFunction.add(managerTourFunction);

        ImageIcon tourIcon = new ImageIcon(getClass().getResource("/image/flag-alt.png"));
        Icon icon = new ImageIcon(ImageValidate.scaleSize(tourIcon.getImage(), 30, 30));
        lbIconTour = new JLabel(icon);
        lbIconTour.setBounds(41, 10, 30, 30);
        managerTourFunction.add(lbIconTour);

        lbTour = new JLabel("Tour");
        lbTour.setBounds(99, 10, 68, 20);
        lbTour.setFont(new Font("Roboto", Font.PLAIN, 24));
        managerTourFunction.add(lbTour);

        managerStafffunction = new JPanel();
        managerStafffunction.setBounds(0, 90, 342, 50);
        managerStafffunction.setLayout(null);
        managerStafffunction.setBackground(Color.WHITE);
        managerStafffunction.addMouseListener(mouseListener);
        containFunction.add(managerStafffunction);

        ImageIcon staffIcon = new ImageIcon(getClass().getResource("/image/user-gear.png"));
        icon = new ImageIcon(ImageValidate.scaleSize(staffIcon.getImage(), 30, 30));
        lbIconUser = new JLabel(icon);
        lbIconUser.setBounds(41, 10, 30, 30);
        managerStafffunction.add(lbIconUser);

        lbUserGear = new JLabel("Nhân viên");
        lbUserGear.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbUserGear.setBounds(99, 10, 118, 20);
        managerStafffunction.add(lbUserGear);

        containManager = new PanelRound();
        containManager.setBackground(new Color(219, 219, 219));
        containManager.setLayout(new CardLayout(12, 12));
        containContent.add(containManager, BorderLayout.CENTER);

        tourManagerContent = new TourManagerContent();
        containManager.add(tourManagerContent, "tourManagerContent");

        staffManagerContent = new StaffManagerContent();
        containManager.add(staffManagerContent, "staffManagerContent");
    }
    public void reloadPanel(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
    public void changeForm() {
        cardLayout = (CardLayout) (containManager.getLayout());
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setVisible(true);
    }

}
