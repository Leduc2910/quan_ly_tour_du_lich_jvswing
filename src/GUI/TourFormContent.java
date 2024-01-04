package GUI;

import model.Tour_category;
import service.TourCategoryService;
import validate.ImageValidate;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TourFormContent extends JPanel {
    private TourCategoryService tourCategoryService = new TourCategoryService();
    private Manager manager;
    private PanelRound containMain;
    private JPanel containTitle;
    private JLabel lbIconTitle;
    private JLabel lbTitle;
    private JButton btnIconReload;
    private PanelRound containFormTour;
    private PanelRound containImage;
    private JLabel lbBanner;
    private JLabel lbTourName;
    private JTextField tfTourName;
    private JLabel lbTourSche;
    private JTextField tfTourSche;
    private JLabel lbTourProgram;
    private JLabel lbTourPrice;
    private JLabel lbTourStart;
    private JLabel lbTourTime;
    private JLabel lbTourImage;
    private JLabel lbTourVehicle;
    private JLabel lbTourCate;
    private JComboBox cbTourCate;
    private JTextField tfTourDayTime;
    private JLabel lbTourDayTime;
    private JTextField tfTourNightTime;
    private JLabel lbTourNightTime;
    private JTextField tfTourStart;
    private JTextField tfTourPrice;
    private JButton btnEdit;
    private JButton btnClose;
    private JButton btnFCAvatar;
    private JLabel lbFileName;
    private JFileChooser fcTourProgram;
    private JButton btnFCTourProgram;
    private JLabel lbFileProgram;
    private JCheckBox cbVehiclePlane;
    private JCheckBox cbVehicleCar;
    private JFileChooser fcBanner;
    private File selectedBannerFile;
    private File selectedProgramFile;


    public TourFormContent(Manager manager) {
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

        containTitle = new JPanel();
        containTitle.setBounds(0, 26, 1146, 64);
        containTitle.setBackground(Color.WHITE);
        containTitle.setLayout(null);
        containMain.add(containTitle);

        Icon icon = ImageValidate.scaleAndCreateIcon("/image/tour.png", 30, 30);
        lbIconTitle = new JLabel(icon);
        lbIconTitle.setBounds(43, 17, 30, 30);
        containTitle.add(lbIconTitle);

        lbTitle = new JLabel("Thêm tour");
        lbTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lbTitle.setBounds(93, 17, 225, 30);
        containTitle.add(lbTitle);

        icon = ImageValidate.scaleAndCreateIcon("/image/reload.png", 30, 30);
        btnIconReload = new JButton(icon);
        btnIconReload.setBounds(1069, 17, 30, 30);
        btnIconReload.setBorderPainted(false);
        btnIconReload.setContentAreaFilled(false);
        btnIconReload.setFocusPainted(false);
        btnIconReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadPanel();
            }
        });
        containTitle.add(btnIconReload);

        containFormTour = new PanelRound();
        containFormTour.setRoundBottomLeft(20);
        containFormTour.setRoundTopLeft(20);
        containFormTour.setRoundBottomRight(20);
        containFormTour.setRoundTopRight(20);
        containFormTour.setBounds(35, 108, 1076, 786);
        containFormTour.setBackground(new Color(241, 241, 249));
        containFormTour.setLayout(null);
        containMain.add(containFormTour);

        containImage = new PanelRound();
        containImage.setBounds(55, 25, 966, 318);
        containImage.setBackground(Color.WHITE);
        containImage.setLayout(null);
        containFormTour.add(containImage);

        lbBanner = new JLabel();
        lbBanner.setBounds(0, 0, 966, 318);
        containImage.add(lbBanner);

        Font lbInput = new Font("Roboto", Font.PLAIN, 20);
        Font tfInput = new Font("Roboto", Font.PLAIN, 16);

        lbTourName = new JLabel("Tên tour");
        lbTourName.setBounds(55, 373, 100, 30);
        lbTourName.setFont(lbInput);
        containFormTour.add(lbTourName);

        tfTourName = new JTextField();
        tfTourName.setBounds(172, 368, 372, 40);
        tfTourName.setBackground(Color.WHITE);
        tfTourName.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourName.setFont(tfInput);
        containFormTour.add(tfTourName);

        lbTourSche = new JLabel("Lịch trình");
        lbTourSche.setBounds(55, 438, 100, 30);
        lbTourSche.setFont(lbInput);
        containFormTour.add(lbTourSche);

        tfTourSche = new JTextField();
        tfTourSche.setBounds(172, 433, 372, 40);
        tfTourSche.setBackground(Color.WHITE);
        tfTourSche.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourSche.setFont(tfInput);
        containFormTour.add(tfTourSche);

        lbTourCate = new JLabel("Loại tour");
        lbTourCate.setBounds(55, 503, 120, 30);
        lbTourCate.setFont(lbInput);
        containFormTour.add(lbTourCate);

        cbTourCate = new JComboBox();
        cbTourCate.setBounds(172, 498, 372, 40);
        cbTourCate.addItem("");
        for (Tour_category tourCategory1 :
                tourCategoryService.findAll()) {
            cbTourCate.addItem(tourCategory1.getCategory_name());
        }
        cbTourCate.setFocusable(false);
        cbTourCate.setBackground(Color.WHITE);
        cbTourCate.setFont(tfInput);
        containFormTour.add(cbTourCate);

        lbTourVehicle = new JLabel("Phương tiện");
        lbTourVehicle.setBounds(55, 568, 110, 30);
        lbTourVehicle.setFont(lbInput);
        containFormTour.add(lbTourVehicle);

        cbVehiclePlane = new JCheckBox("Máy bay");
        cbVehiclePlane.setFont(tfInput);
        cbVehiclePlane.setBackground(new Color(241, 241, 249));
        cbVehiclePlane.setBounds(172, 568, 96, 30);
        cbVehiclePlane.setFocusPainted(false);
        containFormTour.add(cbVehiclePlane);

        cbVehicleCar = new JCheckBox("Ô tô");
        cbVehicleCar.setFont(tfInput);
        cbVehicleCar.setBounds(358, 568, 96, 30);
        cbVehicleCar.setBackground(new Color(241, 241, 249));
        containFormTour.add(cbVehicleCar);

        lbTourImage = new JLabel("Ảnh");
        lbTourImage.setBounds(55, 633, 100, 30);
        lbTourImage.setFont(lbInput);
        containFormTour.add(lbTourImage);

        fcBanner = new JFileChooser();

        btnFCAvatar = new JButton("Choose file");
        btnFCAvatar.setBounds(172, 633, 100, 30);
        btnFCAvatar.setFont(new Font("Roboto", Font.PLAIN, 13));
        btnFCAvatar.setFocusPainted(false);
        btnFCAvatar.setBackground(new Color(239, 239, 239));
        btnFCAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFCAvatarActionPerformed(e);
            }
        });
        containFormTour.add(btnFCAvatar);

        lbFileName = new JLabel("No file chosen");
        lbFileName.setBounds(287, 634, 250, 30);
        lbFileName.setFont(new Font("Roboto", Font.PLAIN, 13));
        containFormTour.add(lbFileName);

        lbTourTime = new JLabel("Thời gian");
        lbTourTime.setBounds(565, 373, 110, 30);
        lbTourTime.setFont(lbInput);
        containFormTour.add(lbTourTime);

        tfTourDayTime = new JTextField();
        tfTourDayTime.setBackground(Color.WHITE);
        tfTourDayTime.setBounds(713, 368, 84, 40);
        tfTourDayTime.setFont(tfInput);
        tfTourDayTime.setHorizontalAlignment(SwingConstants.CENTER);
        tfTourDayTime.setBorder(null);
        containFormTour.add(tfTourDayTime);

        lbTourDayTime = new JLabel("Ngày");
        lbTourDayTime.setBounds(810, 373, 44, 30);
        lbTourDayTime.setFont(tfInput);
        lbTourDayTime.setHorizontalAlignment(SwingConstants.CENTER);
        containFormTour.add(lbTourDayTime);

        tfTourNightTime = new JTextField();
        tfTourNightTime.setBackground(Color.WHITE);
        tfTourNightTime.setBounds(867, 368, 84, 40);
        tfTourNightTime.setFont(tfInput);
        tfTourNightTime.setHorizontalAlignment(SwingConstants.CENTER);
        tfTourNightTime.setBorder(null);
        containFormTour.add(tfTourNightTime);

        lbTourNightTime = new JLabel("Đêm");
        lbTourNightTime.setBounds(964, 373, 44, 30);
        lbTourNightTime.setFont(tfInput);
        lbTourNightTime.setHorizontalAlignment(SwingConstants.CENTER);
        containFormTour.add(lbTourNightTime);

        lbTourStart = new JLabel("Điểm khởi hành");
        lbTourStart.setBounds(565, 438, 140, 30);
        lbTourStart.setFont(lbInput);
        containFormTour.add(lbTourStart);

        tfTourStart = new JTextField();
        tfTourStart.setBounds(713, 433, 308, 40);
        tfTourStart.setBackground(Color.WHITE);
        tfTourStart.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourStart.setFont(tfInput);
        containFormTour.add(tfTourStart);

        lbTourPrice = new JLabel("Giá");
        lbTourPrice.setBounds(565, 503, 110, 30);
        lbTourPrice.setFont(lbInput);
        containFormTour.add(lbTourPrice);

        tfTourPrice = new JTextField();
        tfTourPrice.setBounds(713, 498, 308, 40);
        tfTourPrice.setBackground(Color.WHITE);
        tfTourPrice.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourPrice.setFont(tfInput);
        containFormTour.add(tfTourPrice);

        lbTourProgram = new JLabel("Chương trình");
        lbTourProgram.setBounds(565, 633, 120, 30);
        lbTourProgram.setFont(lbInput);
        containFormTour.add(lbTourProgram);

        fcTourProgram = new JFileChooser();

        btnFCTourProgram = new JButton("Choose file");
        btnFCTourProgram.setBounds(713, 633, 100, 30);
        btnFCTourProgram.setFont(new Font("Roboto", Font.PLAIN, 13));
        btnFCTourProgram.setFocusPainted(false);
        btnFCTourProgram.setBackground(new Color(239, 239, 239));
        btnFCTourProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFCTourProgramActionPerformed(e);
            }
        });
        containFormTour.add(btnFCTourProgram);

        lbFileProgram = new JLabel("No file chosen");
        lbFileProgram.setBounds(828, 634, 250, 30);
        lbFileProgram.setFont(new Font("Roboto", Font.PLAIN, 13));
        containFormTour.add(lbFileProgram);

        btnEdit = new JButton("Xác nhận");
        btnEdit.setBounds(405, 721, 120, 40);
        btnEdit.setBackground(new Color(97, 95, 220));
        btnEdit.setFocusPainted(false);
        btnEdit.setForeground(Color.WHITE);
        containFormTour.add(btnEdit);

        btnClose = new JButton("Đóng");
        btnClose.setBounds(550, 721, 120, 40);
        btnClose.setBackground(new Color(241, 241, 249));
        btnClose.setFocusPainted(false);
        btnClose.setForeground(new Color(128, 128, 227));
        btnClose.setBorder(new LineBorder(new Color(128, 128, 227), 2));
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.changeForm("tourManagerContent");
                manager.getTourManagerContent().reloadPanel();
            }
        });
        containFormTour.add(btnClose);
    }

    private void btnFCTourProgramActionPerformed(ActionEvent e) {
        fcTourProgram.setDialogTitle("Chọn tệp chương trình tour");
        fcTourProgram.setCurrentDirectory(new File("."));
        fcTourProgram.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
        int res = fcTourProgram.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedProgramFile = fcTourProgram.getSelectedFile();
            lbFileProgram.setText(selectedProgramFile.getName());
        }
    }

    private void btnFCAvatarActionPerformed(ActionEvent e) {
        fcBanner.setDialogTitle("Chọn ảnh đại diện");
        fcBanner.setCurrentDirectory(new File(".\\src\\image"));
        fcBanner.setFileFilter(new FileNameExtensionFilter("Pictures", "png", "jpeg", "jpg"));
        int res = fcBanner.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedBannerFile = fcBanner.getSelectedFile();
            lbFileName.setText(selectedBannerFile.getName());
            Icon icon = ImageValidate.scaleAndCreateIcon("/image/" + selectedBannerFile.getName(), 966, 318);
            lbBanner.setIcon(icon);
        }
    }

    public void reloadPanel() {
        lbBanner.setIcon(null);
        tfTourName.setText("");
        tfTourSche.setText("");
        tfTourDayTime.setText("");
        tfTourNightTime.setText("");
        tfTourStart.setText("");
        cbTourCate.setSelectedItem("");
        tfTourPrice.setText("");
        fcBanner.setSelectedFile(null);
        lbFileName.setText("No file chosen");
        fcTourProgram.setSelectedFile(null);
        lbFileProgram.setText("No file chosen");
        cbVehiclePlane.setSelected(false);
        cbVehicleCar.setSelected(false);
        selectedBannerFile = null;
    }
}
