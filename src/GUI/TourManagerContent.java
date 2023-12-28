package GUI;

import controller.ManagerController;
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
    private TourService tourService = new TourService();
    private TourCategoryService tourCategoryService = new TourCategoryService();
    private JPanel containTitle;
    private JLabel lbIconTitle;
    private JLabel lbTitle;
    private PanelRound containOption;
    private JLabel lbFilter;
    private JTextField tfSearch;
    private JButton btnSearch;
    private JButton btnAdd;
    private JPanel containTable;
    private JTable tbTourLst;
    private JLabel lbDetailTour;
    private JLabel icDetailTour;
    private JPanel containDetailTour;
    private JComboBox cbCategory;
    private PanelRound containMain;

    public TourManagerContent() {
        init();
    }

    public TourManagerContent(JComboBox cbCategory, JButton btnSearch) {
        this.btnSearch = btnSearch;
        this.cbCategory = cbCategory;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JComboBox getCbCategory() {
        return cbCategory;
    }

    public void setCbCategory(JComboBox cbCategory) {
        this.cbCategory = cbCategory;
    }

    private void init() {
        setPreferredSize(new Dimension(1130, 935));
        setBackground(new Color(219, 219, 219));
        setLayout(new BorderLayout());

        ActionListener actionListener = new ManagerController(this);
        MouseListener mouseListener = new ManagerController(this);

        containMain = new PanelRound();
        containMain.setRoundBottomLeft(20);
        containMain.setRoundTopLeft(20);
        containMain.setRoundBottomRight(20);
        containMain.setRoundTopRight(20);
        containMain.setPreferredSize(new Dimension(1130, 935));
        containMain.setBackground(Color.WHITE);
        containMain.setLayout(null);
        add(containMain, BorderLayout.CENTER);

        containTitle = new JPanel();
        containTitle.setBounds(0, 35, 1130, 30);
        containTitle.setLayout(null);
        containTitle.setBackground(Color.WHITE);
        containMain.add(containTitle);

        ImageIcon flagIcon = new ImageIcon(getClass().getResource("/image/flag-alt.png"));
        Icon icon = new ImageIcon(ImageValidate.scaleSize(flagIcon.getImage(), 30, 30));
        lbIconTitle = new JLabel(icon);
        lbIconTitle.setBounds(35, 0, 30, 30);
        containTitle.add(lbIconTitle);

        lbTitle = new JLabel("Danh sách tour");
        lbTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lbTitle.setBounds(90, 0, 500, 20);
        containTitle.add(lbTitle);

        containOption = new PanelRound();
        containOption.setRoundBottomLeft(30);
        containOption.setRoundTopLeft(30);
        containOption.setRoundBottomRight(30);
        containOption.setRoundTopRight(30);
        containOption.setBounds(35, 100, 1060, 122);
        containOption.setBackground(new Color(237, 237, 237));
        containOption.setLayout(null);
        containMain.add(containOption);

        lbFilter = new JLabel("Loại tour : ");
        lbFilter.setFont(new Font("Dialog", Font.BOLD, 15));
        lbFilter.setBounds(35, 51, 90, 20);
        containOption.add(lbFilter);

        cbCategory = new JComboBox();
        cbCategory.addItem("Tất cả");
        for (Tour_category tourCategory :
                tourCategoryService.findAll()) {
            cbCategory.addItem(tourCategory.getCategory_name());
        }
        cbCategory.setBounds(123, 41, 209, 40);
        cbCategory.addActionListener(actionListener);
        containOption.add(cbCategory);

        tfSearch = new JTextField("Nhập từ khóa tìm kiếm....");
        tfSearch.setForeground(Color.GRAY);
        tfSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfSearch.getText().equals("Nhập từ khóa tìm kiếm....")) {
                    tfSearch.setText("");
                    tfSearch.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfSearch.getText().isEmpty()) {
                    tfSearch.setForeground(Color.GRAY);
                    tfSearch.setText("Nhập từ khóa tìm kiếm....");
                }
            }
        });
        tfSearch.setBounds(558, 41, 271, 40);
        tfSearch.setBorder(null);
        containOption.add(tfSearch);

        btnSearch = new JButton("Tìm kiếm");
        btnSearch.addActionListener(actionListener);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(new Color(56, 109, 158));
        btnSearch.setFocusPainted(false);
        btnSearch.setBounds(841, 41, 90, 40);
        containOption.add(btnSearch);

        btnAdd = new JButton("Thêm mới");
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(66, 128, 71));
        btnAdd.setBounds(935, 41, 100, 40);
        btnAdd.setFocusPainted(false);
        btnAdd.setBorderPainted(false);
        containOption.add(btnAdd);

        containTable = new JPanel();
        containTable.setBounds(35, 275, 1060, 522);
        containTable.setBackground(Color.WHITE);
        containTable.setLayout(new BorderLayout());
        containMain.add(containTable);

        tbTourLst = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbTourLst.setFillsViewportHeight(true);
        tbTourLst.setFont(new Font("Roboto", Font.PLAIN, 14));
        tbTourLst.setRowHeight(110);
        tbTourLst.setSelectionBackground(new Color(237, 237, 237));
        tbTourLst.setDefaultRenderer(Object.class, new MyRenderer());
        tbTourLst.setShowVerticalLines(false);
        tbTourLst.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"STT", "Tour", "Thời gian", "Điểm khởi hành",
                        "Điểm đến", "Loại tour", "Giá", "Hành động"}));
        showAllTourList();

        JTableHeader jTableHeader = tbTourLst.getTableHeader();
        jTableHeader.setResizingAllowed(false);
        jTableHeader.setReorderingAllowed(false);
        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTableHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        jTableHeader.setBackground(Color.WHITE);
        jTableHeader.setFont(new Font("Roboto", Font.BOLD, 15));
        jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 80));

        TableColumnModel columnModel = tbTourLst.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(140);
        columnModel.getColumn(4).setPreferredWidth(140);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(tbTourLst);
/*        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        containTable.add(scrollPane, BorderLayout.CENTER);

/*        Icon detailIcon = new ImageIcon(getClass().getResource("/image/icons-detail.png"));
        icDetailTour = new JLabel(detailIcon);
        lbDetailTour = new JLabel("Xem");
        containDetailTour = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        containDetailTour.setBackground(Color.WHITE);
        containDetailTour.add(icDetailTour);
        containDetailTour.add(lbDetailTour);*/


        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.BLACK));
        UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 14));

    }

    public void searchByKeyWord() {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tbTourLst.getModel();
        String name = tfSearch.getText();
        if (name.equals("Nhập từ khóa tìm kiếm....") || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập từ khóa cần tìm!");
            showAllTourList();
        } else {
            List<Tour> tourList = tourService.searchByKeyword(name);
            if (tourList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu!");
                showAllTourList();
            } else {
                deleteOldData();
                for (Tour tour : tourList) {
                    defaultTableModel.addRow(new Object[]{tour.getId() + "", tour.getTour_name() + ": " + tour.getSchedule(), tour.getTour_time() + "", tour.getStart_point() + "", tour.getDestination() + "", tour.getTourCategory().getCategory_name() + "", InputValidate.formatCurrency(tour.getPrice()) + "", "Xem"});
                }
            }
        }
    }

    public void deleteOldData() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) tbTourLst.getModel();
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

    public void sortByTourCategory() {
        deleteOldData();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbTourLst.getModel();
        String name = cbCategory.getSelectedItem().toString();
        if (name.equals("Tất cả")) {
            showAllTourList();
        } else {
            List<Tour> tourList = tourService.sortByTourCategory(name);
            for (Tour tour : tourList) {
                defaultTableModel.addRow(new Object[]{tour.getId() + "", tour.getTour_name() + ": " + tour.getSchedule(), tour.getTour_time() + "", tour.getStart_point() + "", tour.getDestination() + "", tour.getTourCategory().getCategory_name() + "", InputValidate.formatCurrency(tour.getPrice()) + "", "Xem"});
            }
        }
    }

    public void showAllTourList() {
        deleteOldData();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbTourLst.getModel();
        List<Tour> tourList = tourService.findAll();

        for (Tour tour : tourList) {
            defaultTableModel.addRow(new Object[]{tour.getId() + "", tour.getTour_name() + ": " + tour.getSchedule(), tour.getTour_time() + "", tour.getStart_point() + "", tour.getDestination() + "", tour.getTourCategory().getCategory_name() + "", InputValidate.formatCurrency(tour.getPrice()) + "", "Xem"});
        }
    }

    public class MyRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column != 1 && column != 7) {
                setHorizontalAlignment(CENTER);
            } else if (column == 1) {
                setHorizontalAlignment(LEFT);
                setToolTipText(value.toString());
            } else if (column == 7) {
            }
            setBorder(noFocusBorder);
            return this;
        }
    }
}
