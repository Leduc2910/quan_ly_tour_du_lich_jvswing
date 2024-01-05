package GUI;


import model.Tour;
import model.Tour_Vehicle;
import model.Tour_category;
import service.TourCategoryService;
import service.TourService;
import service.TourVehicleService;
import validate.ImageValidate;
import validate.InputRegex;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TourDetailContent extends JPanel {
    private TourCategoryService tourCategoryService = new TourCategoryService();
    private TourVehicleService tourVehicleService = new TourVehicleService();
    private TourService tourService = new TourService();
    private Manager manager;
    private Tour selectedTour;
    private PanelRound containMain;
    private JPanel containTitle;
    private JLabel lbIconTitle;
    private JLabel lbTitle;
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
    private JButton btnClose;
    private JButton btnFCAvatar;
    private JLabel lbFileName;
    private JFileChooser fcTourProgram;
    private JButton btnFCTourProgram;
    private JButton lbFileProgram;
    private JCheckBox cbVehiclePlane;
    private JCheckBox cbVehicleCar;
    private JFileChooser fcBanner;
    private File selectedBannerFile;
    private File selectedProgramFile;
    private JButton btnEdit;
    private JButton btnDelete;


    public TourDetailContent(Manager manager) {
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

        lbTitle = new JLabel("Xem chi tiết tour");
        lbTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lbTitle.setBounds(93, 17, 225, 30);
        containTitle.add(lbTitle);

        btnEdit = new JButton("Sửa");
        btnEdit.setBounds(851, 12, 120, 40);
        btnEdit.setBackground(new Color(97, 95, 220));
        btnEdit.setFocusPainted(false);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditActionPerformed(e);
            }
        });
        containTitle.add(btnEdit);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(991, 12, 120, 40);
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.setForeground(new Color(212, 95, 91));
        btnDelete.setBorder(new LineBorder(new Color(212, 95, 91), 2));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteActionPerformed(e);
            }
        });
        containTitle.add(btnDelete);

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
        cbVehicleCar.setFocusPainted(false);
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

        icon = ImageValidate.scaleAndCreateIcon("/image/eye.png", 25, 25);
        lbFileProgram = new JButton("Xem");
        lbFileProgram.setIcon(icon);
        lbFileProgram.setBounds(820, 634, 100, 30);
        lbFileProgram.setFont(new Font("Roboto", Font.BOLD, 14));
        lbFileProgram.setBorderPainted(false);
        lbFileProgram.setContentAreaFilled(false);
        lbFileProgram.setFocusPainted(false);
        lbFileProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFilePDFActionPerformed(e);
            }
        });
        containFormTour.add(lbFileProgram);

        btnClose = new JButton("Đóng");
        btnClose.setBounds(478, 721, 120, 40);
        btnClose.setForeground(Color.WHITE);
        btnClose.setBackground(new Color(97, 95, 220));
        btnClose.setFocusPainted(false);
        btnClose.setBorder(null);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.changeForm("tourManagerContent");
                manager.getTourManagerContent().reloadPanel();
            }
        });
        containFormTour.add(btnClose);
    }

    private void btnDeleteActionPerformed(ActionEvent e) {
        int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tour này không?");
        if (click == JOptionPane.YES_OPTION) {
            int id = selectedTour.getId();
            tourService.delete(id);
            JOptionPane.showMessageDialog(null, "Xóa tour thành công.");
            manager.changeForm("tourManagerContent");
            manager.getTourManagerContent().reloadPanel();
        }
    }

    public void getSelectedTour(Tour tour) {
        reloadPanel();
        selectedTour = tour;
        Icon icon = ImageValidate.scaleAndCreateIconAbPath(tour.getImage(), 966, 318);
        lbBanner.setIcon(icon);
        tfTourName.setText(tour.getTour_name());
        tfTourSche.setText(tour.getSchedule());
        cbTourCate.setSelectedItem(tour.getTourCategory().getCategory_name());
        selectedBannerFile = new File(tour.getImage());
        lbFileName.setText(selectedBannerFile.getName());
        tfTourStart.setText(tour.getStart_point());
        tfTourPrice.setText(String.valueOf(tour.getPrice()));
        selectedProgramFile = new File(tour.getTour_program());
        List<Tour_Vehicle> tour_vehicleList = tourVehicleService.findAll();
        for (Tour_Vehicle tourVehicle :
                tour_vehicleList) {
            if (tourVehicle.getTour_id() == tour.getId()) {
                if (tourVehicle.getVehicle_id() == 1) {
                    cbVehiclePlane.setSelected(true);
                }
                if (tourVehicle.getVehicle_id() == 2) {
                    cbVehicleCar.setSelected(true);
                }
            }
        }
        String[] tour_time = tour.getTour_time().split("");
        tfTourDayTime.setText(tour_time[0]);
        tfTourNightTime.setText(tour_time[2]);
    }

    private void btnEditActionPerformed(ActionEvent e) {
        String tour_name = tfTourName.getText();
        String tour_sche = tfTourSche.getText();
        String tour_start = tfTourStart.getText();
        String tour_price = tfTourPrice.getText();
        String daytime = tfTourDayTime.getText();
        String nighttime = tfTourNightTime.getText();
        String tour_cate = (String) cbTourCate.getSelectedItem();
        String tour_image = selectedBannerFile.getAbsolutePath();
        if (tour_name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tour.");
        } else if (tour_sche.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập lộ trình cho tour.");
        } else if (tour_cate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại tour.");
        } else if (!cbVehiclePlane.isSelected() && !cbVehicleCar.isSelected()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phương tiện di chuyển.");
        } else if (tour_image.equals("No file chosen")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ảnh.");
        } else if (daytime.trim().isEmpty() || nighttime.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thời gian tour.");
        } else if (!InputRegex.inputNumber(daytime) || !InputRegex.inputNumber(nighttime)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập định dạng số cho thời gian.");
        } else if (tour_start.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm khởi hành.");
        } else if (tour_price.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá tiền.");
        } else if (!InputRegex.inputNumber(tour_price)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập định dạng số cho giá tiền.");
        } else if (!selectedProgramFile.exists()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn chương tình tour.");
        } else {
            int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật thông tin tour không?");
            if (click == JOptionPane.YES_OPTION) {
                selectedTour.setTour_name(tour_name);
                selectedTour.setSchedule(tour_sche);
                selectedTour.setStart_point(tour_start);
                selectedTour.setPrice(Integer.parseInt(tour_price));
                selectedTour.setImage(tour_image);
                selectedTour.setTour_program(selectedProgramFile.getAbsolutePath());
                String tour_time = daytime + "N" + nighttime + "Đ";
                selectedTour.setTour_time(tour_time);
                for (Tour_category tourCategory :
                        tourCategoryService.findAll()) {
                    if (tourCategory.getCategory_name().equals(tour_cate)) {
                        selectedTour.setTourCategory(tourCategory);
                    }
                }
                tourService.edit(selectedTour.getId(), selectedTour);

                boolean planeSelected = cbVehiclePlane.isSelected();
                boolean carSelected = cbVehicleCar.isSelected();
                List<Tour_Vehicle> tourVehicles = tourVehicleService.findByTour_ID(selectedTour.getId());
                if (tourVehicles.size() == 0) {
                    if (planeSelected) {
                        Tour_Vehicle newTourVehicle = new Tour_Vehicle(selectedTour.getId(), 1);
                        tourVehicleService.add(newTourVehicle);
                    }
                    if (carSelected) {
                        Tour_Vehicle newTourVehicle = new Tour_Vehicle(selectedTour.getId(), 2);
                        tourVehicleService.add(newTourVehicle);
                    }
                } else {
                    for (Tour_Vehicle t : tourVehicles) {
                        if ((t.getVehicle_id() == 1 && !planeSelected) || (t.getVehicle_id() == 2 && !carSelected)) {
                            tourVehicleService.delete(t.getId());
                        }
                        if (planeSelected && !tourVehicleService.findByTour_IDAndVehicle_ID(selectedTour.getId(), 1)) {
                            Tour_Vehicle newTourVehicle = new Tour_Vehicle(selectedTour.getId(), 1);
                            tourVehicleService.add(newTourVehicle);
                        }
                        if (carSelected && !tourVehicleService.findByTour_IDAndVehicle_ID(selectedTour.getId(), 2)) {
                            Tour_Vehicle newTourVehicle = new Tour_Vehicle(selectedTour.getId(), 2);
                            tourVehicleService.add(newTourVehicle);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thành công.");
                manager.changeForm("tourManagerContent");
                manager.getTourManagerContent().reloadPanel();
            }
        }
    }

    private void openFilePDFActionPerformed(ActionEvent e) {
        try {
            if (selectedProgramFile.exists()) {
                ProcessBuilder processBuilder;
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    processBuilder = new ProcessBuilder("cmd", "/c", "start", "\"\"", selectedProgramFile.getAbsolutePath());
                } else {
                    processBuilder = new ProcessBuilder("xdg-open", selectedProgramFile.getAbsolutePath());
                }
                processBuilder.start();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy file!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void btnFCTourProgramActionPerformed(ActionEvent e) {
        fcTourProgram.setDialogTitle("Chọn tệp chương trình tour");
        fcTourProgram.setCurrentDirectory(new File("C:\\Users\\mihdu\\Downloads\\Documents"));
        fcTourProgram.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
        int res = fcTourProgram.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedProgramFile = fcTourProgram.getSelectedFile();
        }
    }

    private void btnFCAvatarActionPerformed(ActionEvent e) {
        fcBanner.setDialogTitle("Chọn ảnh đại diện");
        fcBanner.setCurrentDirectory(new File("C:\\Users\\mihdu\\Pictures\\tour"));
        fcBanner.setFileFilter(new FileNameExtensionFilter("Pictures", "png", "jpeg", "jpg"));
        int res = fcBanner.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedBannerFile = fcBanner.getSelectedFile();
            lbFileName.setText(selectedBannerFile.getName());
            Icon icon = ImageValidate.scaleAndCreateIconAbPath(selectedBannerFile.getAbsolutePath(), 966, 318);
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
        cbVehiclePlane.setSelected(false);
        cbVehicleCar.setSelected(false);
        selectedBannerFile = null;
        selectedProgramFile = null;
    }
}
