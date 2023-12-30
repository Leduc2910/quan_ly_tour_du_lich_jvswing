package GUI;

import controller.CurrentSession;
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
    private AccountDetailContent accountDetailContent;
    private CardLayout cardLayout;
    private JPanel accountDetailFunction;
    private JLabel lbIconAccDetail;
    private JLabel lbAccDetail;
    private JPanel containLogout;
    private JLabel lbLogout;
    private JLabel lbIconLog;
    private JPanel pnlFullName;


    public Manager() {
        this.init();
        this.changeForm();
    }

    public Manager(JPanel containLogout, JPanel managerTourFunction, JPanel managerStafffunction, JPanel accountDetailFunction, CardLayout cardLayout, PanelRound containManager, AccountDetailContent accountDetailContent, JLabel lbAccDetail, JLabel lbTour, JLabel lbUserGear, JLabel lbLogout) {
        this.managerTourFunction = managerTourFunction;
        this.managerStafffunction = managerStafffunction;
        this.accountDetailFunction = accountDetailFunction;
        this.containLogout = containLogout;
        this.cardLayout = cardLayout;
        this.containManager = containManager;
        this.lbAccDetail = lbAccDetail;
        this.lbTour = lbTour;
        this.lbUserGear = lbUserGear;
        this.lbLogout = lbLogout;
    }

    public JPanel getContainLogout() {
        return containLogout;
    }

    public TourManagerContent getTourManagerContent() {
        return tourManagerContent;
    }

    public void setTourManagerContent(TourManagerContent tourManagerContent) {
        this.tourManagerContent = tourManagerContent;
    }

    public StaffManagerContent getStaffManagerContent() {
        return staffManagerContent;
    }

    public void setStaffManagerContent(StaffManagerContent staffManagerContent) {
        this.staffManagerContent = staffManagerContent;
    }

    public void setContainLogout(JPanel containLogout) {
        this.containLogout = containLogout;
    }

    public JLabel getLbTour() {
        return lbTour;
    }

    public void setLbTour(JLabel lbTour) {
        this.lbTour = lbTour;
    }

    public JLabel getLbUserGear() {
        return lbUserGear;
    }

    public void setLbUserGear(JLabel lbUserGear) {
        this.lbUserGear = lbUserGear;
    }

    public JLabel getLbAccDetail() {
        return lbAccDetail;
    }

    public void setLbAccDetail(JLabel lbAccDetail) {
        this.lbAccDetail = lbAccDetail;
    }

    public JLabel getLbLogout() {
        return lbLogout;
    }

    public void setLbLogout(JLabel lbLogout) {
        this.lbLogout = lbLogout;
    }

    public JPanel getAccountDetailFunction() {
        return accountDetailFunction;
    }

    public void setAccountDetailFunction(JPanel accountDetailFunction) {
        this.accountDetailFunction = accountDetailFunction;
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

    public AccountDetailContent getAccountDetailContent() {
        return accountDetailContent;
    }

    public void setAccountDetailContent(AccountDetailContent accountDetailContent) {
        this.accountDetailContent = accountDetailContent;
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
        containAvatar.setBounds(0, 74, 342, 270);
        containAvatar.setBackground(Color.WHITE);
        containAvatar.setLayout(null);
        containMenuBar.add(containAvatar);

        String path = "/image/" + CurrentSession.getCurrentUser().getImage();
        Icon icon = ImageValidate.makeRoundedImageIcon(path, 200, 200, 200);
//        Icon icon = ImageValidate.makeRoundedImageIcon("/image/huychien.png", 200, 200, 200);
        lbAvatar = new JLabel(icon);
        lbAvatar.setBounds(70, 0, 200, 200);
        containAvatar.add(lbAvatar);

        pnlFullName = new JPanel();
        pnlFullName.setBounds(0, 220, 342, 52);
        pnlFullName.setBackground(Color.WHITE);
        containAvatar.add(pnlFullName);

/*        lbFullName = new JLabel(CurrentSession.getCurrentUser().getFullName());
        *//*        lbFullName = new JLabel("Trần Huy Chiến");*//*
        lbFullName.setFont(new Font("Roboto", Font.BOLD, 32));
        pnlFullName.add(lbFullName);*/
        String fullName = "Trần Huy Chiến - Một người có tên rất dài để kiểm tra việc xuống dòng"; // Thay thế bằng CurrentSession.getCurrentUser().getFullName()

        JLabel lbFullName = new JLabel("<html>" + fullName + "</html>");
        lbFullName.setFont(new Font("Roboto", Font.BOLD, 16));
        lbFullName.setPreferredSize(new Dimension(342, 52));
        lbFullName.setVerticalAlignment(SwingConstants.TOP); // Căn lề đầu dòng
        lbFullName.setVerticalTextPosition(SwingConstants.TOP); // Căn lề đầu dòng
        lbFullName.setLineWrap(true);
        lbFullName.setWrapStyleWord(true);
        pnlFullName.add(lbFullName);


        containFunction = new JPanel();
        containFunction.setBounds(0, 400, 342, 383);
        containFunction.setLayout(null);
        containFunction.setBackground(Color.WHITE);
        containMenuBar.add(containFunction);

        accountDetailFunction = new JPanel();
        accountDetailFunction.setBounds(0, 15, 342, 80);
        accountDetailFunction.setBackground(Color.WHITE);
        accountDetailFunction.setLayout(null);
        accountDetailFunction.addMouseListener(mouseListener);
        containFunction.add(accountDetailFunction);

        icon = ImageValidate.scaleAndCreateIcon("/image/user-gear.png", 30, 30);
        lbIconAccDetail = new JLabel(icon);
        lbIconAccDetail.setBounds(47, 25, 30, 30);
        accountDetailFunction.add(lbIconAccDetail);

        lbAccDetail = new JLabel("Thông tin tài khoản");
        lbAccDetail.setBounds(95, 25, 230, 30);
        lbAccDetail.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbAccDetail.setForeground(Color.GRAY);
        accountDetailFunction.add(lbAccDetail);

        managerTourFunction = new JPanel();
        managerTourFunction.setBounds(0, 106, 342, 80);
        managerTourFunction.setBackground(Color.WHITE);
        managerTourFunction.setLayout(null);
        managerTourFunction.addMouseListener(mouseListener);
        containFunction.add(managerTourFunction);

        icon = ImageValidate.scaleAndCreateIcon("/image/tourism.png", 30, 30);
        lbIconTour = new JLabel(icon);
        lbIconTour.setBounds(47, 25, 30, 30);
        managerTourFunction.add(lbIconTour);

        lbTour = new JLabel("Quản lý tour");
        lbTour.setBounds(95, 25, 201, 30);
        lbTour.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbTour.setForeground(Color.GRAY);
        managerTourFunction.add(lbTour);

        managerStafffunction = new JPanel();
        managerStafffunction.setBounds(0, 197, 342, 80);
        managerStafffunction.setLayout(null);
        managerStafffunction.setBackground(Color.WHITE);
        managerStafffunction.addMouseListener(mouseListener);
        containFunction.add(managerStafffunction);

        icon = ImageValidate.scaleAndCreateIcon("/image/teamwork.png", 30, 30);
        lbIconUser = new JLabel(icon);
        lbIconUser.setBounds(47, 25, 30, 30);
        managerStafffunction.add(lbIconUser);

        lbUserGear = new JLabel("Quản lý nhân viên");
        lbUserGear.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbUserGear.setBounds(95, 25, 201, 30);
        lbUserGear.setForeground(Color.GRAY);
        managerStafffunction.add(lbUserGear);

        containLogout = new JPanel();
        containLogout.setBounds(0, 288, 342, 80);
        containLogout.setLayout(null);
        containLogout.setBackground(Color.WHITE);
        containLogout.addMouseListener(mouseListener);
        containFunction.add(containLogout);

        icon = ImageValidate.scaleAndCreateIcon("/image/logout.png", 30, 30);
        lbIconLog = new JLabel(icon);
        lbIconLog.setBounds(47, 25, 30, 30);
        containLogout.add(lbIconLog);

        lbLogout = new JLabel("Đăng xuất");
        lbLogout.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbLogout.setBounds(95, 25, 201, 30);
        lbLogout.setForeground(Color.GRAY);
        containLogout.add(lbLogout);

        if (CurrentSession.getCurrentUser().getRole().getId() == 3) {
            containLogout.setBounds(0, 106, 342, 80);
            managerTourFunction.setVisible(false);
            managerStafffunction.setVisible(false);
        }
        if (CurrentSession.getCurrentUser().getRole().getId() == 1) {
            containLogout.setBounds(0, 197, 342, 80);
            managerStafffunction.setVisible(false);
        }


        containManager = new PanelRound();
        containManager.setBackground(new Color(219, 219, 219));
        containManager.setLayout(new CardLayout(12, 12));
        containContent.add(containManager, BorderLayout.CENTER);

        tourManagerContent = new TourManagerContent();
        containManager.add(tourManagerContent, "tourManagerContent");

        staffManagerContent = new StaffManagerContent();
        containManager.add(staffManagerContent, "staffManagerContent");

        accountDetailContent = new AccountDetailContent();
        containManager.add(accountDetailContent, "accountDetailContent");

    }

    public void setActiveFunctionPanle(JPanel panel) {
        Color color = new Color(97, 96, 220);
        lbAccDetail.setForeground((panel == accountDetailContent) ? color : Color.GRAY);
        lbTour.setForeground((panel == tourManagerContent) ? color : Color.GRAY);
        lbUserGear.setForeground((panel == staffManagerContent) ? color : Color.GRAY);
    }
    public void logout() {
        CurrentSession.setCurrentUser(null);
        Login login = new Login();
        login.setVisible(true);
        setVisible(false);
    }

    public void changeForm() {
        cardLayout = (CardLayout) (containManager.getLayout());
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setVisible(true);
    }

}
