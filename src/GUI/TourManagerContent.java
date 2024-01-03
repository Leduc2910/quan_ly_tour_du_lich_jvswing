package GUI;

import controller.ManagerController;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.scripts.JO;
import model.Tour;
import model.Tour_category;
import model.User;
import service.TourCategoryService;
import service.TourService;
import validate.ImageValidate;
import validate.InputRegex;
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

    private Manager manager;
    private PanelRound containMain;
    private JButton testbtn;
    private JPanel containTile;
    private JLabel lbIcoTour;
    private JLabel lbTourTitle;
    private JButton btnAddTour;
    private JButton btnIconReload;
    private PanelRound containInfo;
    private JLabel lbInfoTitle;
    private PanelRound containInInfo;
    private JLabel lbTourName;
    private JLabel lbTourSche;
    private JLabel lbTourCate;
    private JLabel lbTourTime;
    private JLabel lbTourPrice;
    private JLabel lbTourDes;
    private JLabel lbTourStart;
    private JButton btnDetailTour;
    private JTextField tfTourName;
    private JTextField tfTourSche;
    private JTextField tfTourStart;
    private JTextField tfTourDes;
    private JTextField tfTourPrice;
    private JComboBox cbTourCate;
    private TourCategoryService tourCategory = new TourCategoryService();
    private TourService tourService = new TourService();
    private JTextField tfTourDayTime;
    private JTextField tfTourNightTime;
    private JLabel lbTourDayTime;
    private JLabel lbTourNightTime;
    private PanelRound containOption;
    private JLabel lbFilterTourCate;
    private JComboBox cbFilterTourCate;
    private PanelRound containSearchInput;
    private JTextField tfSearchInput;
    private JButton btnSearchReload;
    private JScrollPane tableScroll;
    private JTable tbListTour;

    public TourManagerContent(Manager manager) {
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

        containTile = new JPanel();
        containTile.setLayout(null);
        containTile.setBackground(Color.WHITE);
        containTile.setBounds(0, 22, 1146, 60);
        containMain.add(containTile);

        Icon icon = ImageValidate.scaleAndCreateIcon("/image/tour.png", 30, 30);
        lbIcoTour = new JLabel(icon);
        lbIcoTour.setBounds(35, 18, 30, 30);
        containTile.add(lbIcoTour);

        lbTourTitle = new JLabel("Tour");
        lbTourTitle.setBounds(90, 18, 100, 30);
        lbTourTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        containTile.add(lbTourTitle);

        icon = ImageValidate.scaleAndCreateIcon("/image/reload.png", 30, 30);
        btnIconReload = new JButton(icon);
        btnIconReload.setBounds(1065, 18, 30, 30);
        btnIconReload.setBorderPainted(false);
        btnIconReload.setContentAreaFilled(false);
        btnIconReload.setFocusPainted(false);
        btnIconReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadPanel();
            }
        });
        containTile.add(btnIconReload);

        containInfo = new PanelRound();
        containInfo.setBounds(0, 88, 1146, 301);
        containInfo.setBackground(Color.WHITE);
        containInfo.setLayout(null);
        containMain.add(containInfo);

        lbInfoTitle = new JLabel("Thông tin tour");
        lbInfoTitle.setFont(new Font("Roboto", Font.BOLD, 20));
        lbInfoTitle.setBounds(35, 2, 345, 33);
        containInfo.add(lbInfoTitle);

        containInInfo = new PanelRound();
        containInInfo.setRoundBottomLeft(20);
        containInInfo.setRoundTopLeft(20);
        containInInfo.setRoundBottomRight(20);
        containInInfo.setRoundTopRight(20);
        containInInfo.setBounds(35, 35, 1060, 266);
        containInInfo.setBackground(new Color(241, 241, 249));
        containInInfo.setLayout(null);
        containInfo.add(containInInfo);

        Font lbInput = new Font("Roboto", Font.PLAIN, 20);
        Font tfInput = new Font("Roboto", Font.PLAIN, 16);

        lbTourName = new JLabel("Tên tour");
        lbTourName.setBounds(30, 25, 86, 30);
        lbTourName.setFont(lbInput);
        containInInfo.add(lbTourName);

        tfTourName = new JTextField();
        tfTourName.setBounds(155, 20, 340, 40);
        tfTourName.setBackground(Color.WHITE);
        tfTourName.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourName.setFont(tfInput);
        containInInfo.add(tfTourName);

        lbTourSche = new JLabel("Lịch trình");
        lbTourSche.setBounds(30, 90, 110, 30);
        lbTourSche.setFont(lbInput);
        containInInfo.add(lbTourSche);

        tfTourSche = new JTextField();
        tfTourSche.setBounds(155, 85, 880, 40);
        tfTourSche.setBackground(Color.WHITE);
        tfTourSche.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourSche.setFont(tfInput);
        containInInfo.add(tfTourSche);

        lbTourCate = new JLabel("Loại tour");
        lbTourCate.setBounds(30, 155, 110, 30);
        lbTourCate.setFont(lbInput);
        containInInfo.add(lbTourCate);

        cbTourCate = new JComboBox();
        cbTourCate.addItem("");
        for (Tour_category tourCategory : tourCategory.findAll()) {
            cbTourCate.addItem(tourCategory.getCategory_name());
        }
        cbTourCate.setBounds(155, 150, 340, 40);
        cbTourCate.setBackground(Color.WHITE);
        cbTourCate.setFocusable(false);
        cbTourCate.setFont(tfInput);
        containInInfo.add(cbTourCate);

        lbTourTime = new JLabel("Thời gian");
        lbTourTime.setBounds(30, 220, 110, 30);
        lbTourTime.setFont(lbInput);
        containInInfo.add(lbTourTime);

        tfTourDayTime = new JTextField();
        tfTourDayTime.setBackground(Color.WHITE);
        tfTourDayTime.setBounds(155, 215, 84, 40);
        tfTourDayTime.setFont(tfInput);
        tfTourDayTime.setHorizontalAlignment(SwingConstants.CENTER);
        tfTourDayTime.setBorder(null);
        containInInfo.add(tfTourDayTime);

        lbTourDayTime = new JLabel("Ngày");
        lbTourDayTime.setBounds(265, 220, 44, 30);
        lbTourDayTime.setFont(tfInput);
        lbTourDayTime.setHorizontalAlignment(SwingConstants.CENTER);
        containInInfo.add(lbTourDayTime);

        tfTourNightTime = new JTextField();
        tfTourNightTime.setBackground(Color.WHITE);
        tfTourNightTime.setBounds(335, 215, 84, 40);
        tfTourNightTime.setFont(tfInput);
        tfTourNightTime.setHorizontalAlignment(SwingConstants.CENTER);
        tfTourNightTime.setBorder(null);
        containInInfo.add(tfTourNightTime);

        lbTourNightTime = new JLabel("Đêm");
        lbTourNightTime.setBounds(445, 220, 44, 30);
        lbTourNightTime.setFont(tfInput);
        lbTourNightTime.setHorizontalAlignment(SwingConstants.CENTER);
        containInInfo.add(lbTourNightTime);

        lbTourStart = new JLabel("Điểm khởi hành");
        lbTourStart.setBounds(546, 25, 150, 30);
        lbTourStart.setFont(lbInput);
        containInInfo.add(lbTourStart);

        tfTourStart = new JTextField();
        tfTourStart.setBounds(695, 20, 340, 40);
        tfTourStart.setBackground(Color.WHITE);
        tfTourStart.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfTourStart.setFont(tfInput);
        containInInfo.add(tfTourStart);


        lbTourPrice = new JLabel("Giá tiền");
        lbTourPrice.setBounds(546, 160, 130, 30);
        lbTourPrice.setFont(lbInput);
        containInInfo.add(lbTourPrice);

        tfTourPrice = new JTextField();
        tfTourPrice.setBounds(695, 150, 340, 40);
        tfTourPrice.setBackground(Color.WHITE);
        tfTourPrice.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containInInfo.add(tfTourPrice);

        btnAddTour = new JButton("Thêm mới");
        btnAddTour.setBounds(772, 212, 120, 40);
        btnAddTour.setBackground(new Color(97, 95, 220));
        btnAddTour.setForeground(Color.WHITE);
        btnAddTour.setFocusPainted(false);
        containInInfo.add(btnAddTour);

        btnDetailTour = new JButton("Xem chi tiết");
        btnDetailTour.setBounds(921, 212, 120, 40);
        btnDetailTour.setBackground(new Color(97, 95, 220));
        btnDetailTour.setForeground(Color.WHITE);
        btnDetailTour.setFocusPainted(false);
        containInInfo.add(btnDetailTour);

        containOption = new PanelRound();
        containOption.setRoundBottomLeft(20);
        containOption.setRoundTopLeft(20);
        containOption.setRoundBottomRight(20);
        containOption.setRoundTopRight(20);
        containOption.setBounds(35, 415, 1060, 92);
        containOption.setBackground(new Color(241, 241, 249));
        containOption.setLayout(null);
        containMain.add(containOption);

        lbFilterTourCate = new JLabel("Loại tour");
        lbFilterTourCate.setFont(tfInput);
        lbFilterTourCate.setBounds(35, 31, 68, 30);
        containOption.add(lbFilterTourCate);

        cbFilterTourCate = new JComboBox();
        cbFilterTourCate.setBounds(123, 26, 209, 40);
        cbFilterTourCate.addItem("");
        for (Tour_category tourCategory1 :
                tourCategory.findAll()) {
            cbFilterTourCate.addItem(tourCategory1.getCategory_name());
        }
        cbFilterTourCate.setFocusable(false);
        cbFilterTourCate.setBackground(Color.WHITE);
        cbFilterTourCate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbFilterTourCateActionPerformed(e);
            }
        });
        containOption.add(cbFilterTourCate);

        containSearchInput = new PanelRound();
        containSearchInput.setRoundBottomLeft(20);
        containSearchInput.setRoundTopLeft(20);
        containSearchInput.setRoundBottomRight(20);
        containSearchInput.setRoundTopRight(20);
        containSearchInput.setBounds(656, 26, 372, 40);
        containSearchInput.setBackground(Color.WHITE);
        containSearchInput.setLayout(null);
        containOption.add(containSearchInput);

        tfSearchInput = new JTextField("Nhập từ khóa tìm kiếm...");
        tfSearchInput.setFont(tfInput);
        tfSearchInput.setBounds(15, 0, 309, 40);
        tfSearchInput.setBackground(Color.WHITE);
        tfSearchInput.setForeground(Color.GRAY);
        tfSearchInput.setBorder(null);
        tfSearchInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfSearchInput.getText().equals("Nhập từ khóa tìm kiếm...")) {
                    tfSearchInput.setText("");
                    tfSearchInput.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfSearchInput.getText().isEmpty()) {
                    tfSearchInput.setForeground(Color.GRAY);
                    tfSearchInput.setText("Nhập từ khóa tìm kiếm...");
                }
            }
        });
        containSearchInput.add(tfSearchInput);

        icon = ImageValidate.scaleAndCreateIcon("/image/search.png", 22, 22);
        btnSearchReload = new JButton(icon);
        btnSearchReload.setBounds(337, 9, 22, 22);
        btnSearchReload.setBorderPainted(false);
        btnSearchReload.setContentAreaFilled(false);
        btnSearchReload.setFocusPainted(false);
/*        btnSearchReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchActionPerformed(e);
            }
        });*/
        containSearchInput.add(btnSearchReload);

        tableScroll = new JScrollPane();
        tableScroll.setBounds(35, 519, 1060, 372);
        tableScroll.setBorder(BorderFactory.createEmptyBorder());
        tableScroll.setBackground(Color.WHITE);
        containMain.add(tableScroll);

        tbListTour = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableScroll.setViewportView(tbListTour);
        tbListTour.setFillsViewportHeight(true);
        tbListTour.setFont(new Font("Roboto", Font.PLAIN, 14));
        tbListTour.setSelectionBackground(new Color(237, 237, 237));
        tbListTour.setDefaultRenderer(Object.class, new MyRenderer());
        tbListTour.setShowVerticalLines(false);
        tbListTour.setRowHeight(105);
        tbListTour.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"STT", "Tên tour", "Thời gian", "Điểm khởi hành", "Loại tour", "Giá"}));
        showAllTourList();

        JTableHeader jTableHeader = tbListTour.getTableHeader();
        jTableHeader.setResizingAllowed(false);
        jTableHeader.setReorderingAllowed(false);
        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTableHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        jTableHeader.setBackground(Color.WHITE);
        jTableHeader.setFont(new Font("Roboto", Font.BOLD, 15));
        jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 57));

        TableColumnModel columnModel = tbListTour.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
    }

    private void cbFilterTourCateActionPerformed(ActionEvent e) {
        deleteOldData();
        String selected = (String) cbFilterTourCate.getSelectedItem();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListTour.getModel();
        if (selected.isEmpty()) {
            showAllTourList();
        } else {
            for (Tour tour : tourService.findAll()) {
                if (tour.getTourCategory().getCategory_name().equals(selected)) {
                    defaultTableModel.addRow(new Object[]{
                            tour.getId(),
                            tour.getTour_name() + ": " + tour.getSchedule(),
                            tour.getTour_time(),
                            tour.getStart_point(),
                            tour.getTourCategory().getCategory_name(),
                            InputRegex.formatCurrency(tour.getPrice())});
                }
            }
        }
    }

    private void showAllTourList() {
        deleteOldData();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListTour.getModel();
        for (Tour tour : tourService.findAll()) {
            defaultTableModel.addRow(new Object[]{
                    tour.getId(),
                    tour.getTour_name() + ": " + tour.getSchedule(),
                    tour.getTour_time(),
                    tour.getStart_point(),
                    tour.getTourCategory().getCategory_name(),
                    InputRegex.formatCurrency(tour.getPrice())});
        }
    }

    public void reloadPanel() {
        deleteDataForm();
        showAllTourList();
    }

    public void deleteOldData() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) tbListTour.getModel();
            int countRow = model_table.getRowCount();
            if (countRow == 0)
                break;
            else
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void deleteDataForm() {
        tfTourName.setText("");
        tfTourStart.setText("");
        tfTourSche.setText("");
        tfTourPrice.setText("");
        tfTourDayTime.setText("");
        tfTourNightTime.setText("");
        cbTourCate.setSelectedItem("");
        cbFilterTourCate.setSelectedItem("");
        tfSearchInput.setText("Nhập từ khóa tìm kiếm...");
        tfSearchInput.setForeground(Color.GRAY);
    }

    public class MyRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(CENTER);
            if (column == 1) {
                setHorizontalAlignment(LEFT);
                setToolTipText(value.toString());
            }
            setBorder(noFocusBorder);
            return this;
        }
    }
}
