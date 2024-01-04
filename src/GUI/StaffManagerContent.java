package GUI;

import com.toedter.calendar.JDateChooser;
import controller.CurrentSession;
import model.Role;
import model.User;
import service.RoleService;
import service.UserService;
import validate.ImageValidate;
import validate.InputRegex;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StaffManagerContent extends JPanel {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
    private Manager manager;
    private PanelRound containMain;
    private JPanel containTitle;
    private JLabel lbIconTitle;
    private JLabel lbTitle;
    private JButton btnIconReload;
    private PanelRound containInputInfo;
    private JLabel lbInfoStaff;
    private JPanel containInfoStaff;
    private JLabel lbInFullName;
    private JTextField tfInFullName;
    private JLabel lbInUsername;
    private JTextField tfInUsername;
    private JLabel lbInRole;
    private JComboBox cbInRole;
    private JLabel lbInGender;
    private JLabel lbInPhone;
    private JTextField tfInPhone;
    private JLabel lbBirthday;
    private JLabel lbInEmail;
    private JTextField tfInEmail;
    private JLabel lbInAnh;
    private JLabel lbAvatar;
    private JButton btnEdit;
    private JButton btnDelete;
    private PanelRound containFilter;
    private JLabel lbFilterTitle;
    private JLabel lbSearchTitle;
    private JPanel containOption;
    private PanelRound containSearch;
    private JLabel lbGenderFilter;
    private JLabel lbRoleFilter;
    private PanelRound containSearchInput;
    private JTextField tfSearchInput;
    private JButton btnSearchReload;
    private JPanel containTable;
    private JScrollPane tableScroll;
    private JTable tbListStaff;
    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private ButtonGroup btngrGender;
    private JButton btnFCAvatar;
    private JLabel lbFileName;
    private JDateChooser jDCBirthday;
    private JComboBox cbFilterGender;
    private JComboBox cbFilterRole;
    private File selectedImgAvt;
    private JFileChooser fcAvatar;


    public StaffManagerContent(Manager manager) {
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
        containTitle.setBackground(Color.WHITE);
        containTitle.setBounds(0, 33, 1146, 52);
        containTitle.setLayout(null);
        containMain.add(containTitle);

        Icon icon = ImageValidate.scaleAndCreateIcon("/image/group.png", 30, 30);
        lbIconTitle = new JLabel(icon);
        lbIconTitle.setBounds(43, 10, 30, 30);
        containTitle.add(lbIconTitle);

        lbTitle = new JLabel("Quản lý nhân viên");
        lbTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lbTitle.setBounds(93, 11, 500, 30);
        containTitle.add(lbTitle);

        icon = ImageValidate.scaleAndCreateIcon("/image/reload.png", 30, 30);
        btnIconReload = new JButton(icon);
        btnIconReload.setBounds(1069, 11, 30, 30);
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

        containInfoStaff = new JPanel();
        containInfoStaff.setBounds(0, 99, 1146, 376);
        containInfoStaff.setLayout(null);
        containInfoStaff.setBackground(Color.WHITE);
        containMain.add(containInfoStaff);

        lbInfoStaff = new JLabel("Thiết lập thông tin nhân viên");
        lbInfoStaff.setFont(new Font("Roboto", Font.PLAIN, 20));
        lbInfoStaff.setBounds(43, 4, 345, 28);
        containInfoStaff.add(lbInfoStaff);

        containInputInfo = new PanelRound();
        containInputInfo.setRoundBottomLeft(20);
        containInputInfo.setRoundTopLeft(20);
        containInputInfo.setRoundBottomRight(20);
        containInputInfo.setRoundTopRight(20);
        containInputInfo.setBounds(43, 36, 1060, 340);
        containInputInfo.setBackground(new Color(241, 241, 249));
        containInputInfo.setLayout(null);
        containInfoStaff.add(containInputInfo);

        Font lbFont = new Font("Roboto", Font.PLAIN, 20);
        Font tfFont = new Font("Roboto", Font.PLAIN, 16);
        LineBorder inLineBorder = new LineBorder(new Color(228, 228, 228));

        lbInFullName = new JLabel("Tên NV");
        lbInFullName.setFont(lbFont);
        lbInFullName.setBounds(30, 25, 66, 30);
        containInputInfo.add(lbInFullName);

        tfInFullName = new JTextField();
        tfInFullName.setFont(tfFont);
        tfInFullName.setBounds(130, 20, 248, 40);
        tfInFullName.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        containInputInfo.add(tfInFullName);

        lbInUsername = new JLabel("Tài khoản");
        lbInUsername.setFont(lbFont);
        lbInUsername.setBounds(30, 90, 85, 30);
        containInputInfo.add(lbInUsername);

        tfInUsername = new JTextField();
        tfInUsername.setFont(tfFont);
        tfInUsername.setBounds(130, 85, 248, 40);
        tfInUsername.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        tfInUsername.setEditable(false);
        containInputInfo.add(tfInUsername);

        lbInRole = new JLabel("Chức vụ");
        lbInRole.setFont(lbFont);
        lbInRole.setBounds(30, 155, 80, 30);
        containInputInfo.add(lbInRole);

        cbInRole = new JComboBox();
        cbInRole.addItem("");
        for (Role role : roleService.findAll()) {
            cbInRole.addItem(role.getRole_name());
        }
        cbInRole.setBackground(Color.WHITE);
        cbInRole.setFont(tfFont);
        cbInRole.setBounds(130, 150, 248, 40);
        cbInRole.setFocusable(false);
        containInputInfo.add(cbInRole);

        lbInGender = new JLabel("Giới tính");
        lbInGender.setFont(lbFont);
        lbInGender.setBounds(30, 221, 96, 30);
        containInputInfo.add(lbInGender);

        rbtnMale = new JRadioButton("Nam");
        rbtnMale.setFont(lbFont);
        rbtnMale.setBackground(new Color(241, 241, 249));
        rbtnMale.setBounds(130, 225, 96, 25);
        containInputInfo.add(rbtnMale);

        rbtnFemale = new JRadioButton("Nữ");
        rbtnFemale.setFont(lbFont);
        rbtnFemale.setBackground(new Color(241, 241, 249));
        rbtnFemale.setBounds(255, 225, 96, 25);
        containInputInfo.add(rbtnFemale);

        btngrGender = new ButtonGroup();
        btngrGender.add(rbtnMale);
        btngrGender.add(rbtnFemale);

        lbInPhone = new JLabel("Điện thoại");
        lbInPhone.setFont(lbFont);
        lbInPhone.setBounds(413, 25, 89, 30);
        containInputInfo.add(lbInPhone);

        tfInPhone = new JTextField();
        tfInPhone.setFont(tfFont);
        tfInPhone.setBounds(517, 20, 248, 40);
        tfInPhone.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        containInputInfo.add(tfInPhone);

        lbBirthday = new JLabel("Ngày sinh");
        lbBirthday.setFont(lbFont);
        lbBirthday.setBounds(413, 90, 88, 30);
        containInputInfo.add(lbBirthday);

        jDCBirthday = new JDateChooser();
        jDCBirthday.setBounds(517, 85, 248, 40);
        jDCBirthday.setDateFormatString("dd/MM/yyyy");
        containInputInfo.add(jDCBirthday);

        lbInEmail = new JLabel("Email");
        lbInEmail.setFont(lbFont);
        lbInEmail.setBounds(413, 155, 89, 30);
        containInputInfo.add(lbInEmail);

        tfInEmail = new JTextField();
        tfInEmail.setFont(tfFont);
        tfInEmail.setEditable(false);
        tfInEmail.setBounds(517, 150, 248, 40);
        tfInEmail.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        containInputInfo.add(tfInEmail);

        lbInAnh = new JLabel("Ảnh");
        lbInAnh.setFont(lbFont);
        lbInAnh.setBounds(413, 221, 89, 30);
        containInputInfo.add(lbInAnh);

        fcAvatar = new JFileChooser();

        btnFCAvatar = new JButton("Choose file");
        btnFCAvatar.setBounds(517, 220, 100, 30);
        btnFCAvatar.setFont(new Font("Roboto", Font.PLAIN, 13));
        btnFCAvatar.setFocusPainted(false);
        btnFCAvatar.setBackground(new Color(239, 239, 239));
        btnFCAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFCAvatarActionPerformed(e);
            }
        });
        containInputInfo.add(btnFCAvatar);

        lbFileName = new JLabel("No file chosen");
        lbFileName.setBounds(632, 220, 130, 30);
        lbFileName.setFont(new Font("Roboto", Font.PLAIN, 13));
        containInputInfo.add(lbFileName);

        lbAvatar = new JLabel();
        lbAvatar.setBounds(795, 20, 235, 235);
        containInputInfo.add(lbAvatar);

        btnEdit = new JButton("Lưu");
        btnEdit.setBounds(397, 280, 120, 40);
        btnEdit.setBackground(new Color(97, 95, 220));
        btnEdit.setFocusPainted(false);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditActionPerformed(e);
            }
        });
        containInputInfo.add(btnEdit);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(542, 280, 120, 40);
        btnDelete.setBackground(new Color(241,241,249));
        btnDelete.setFocusPainted(false);
        btnDelete.setForeground(new Color(212, 95, 91));
        btnDelete.setBorder(new LineBorder(new Color(212, 95, 91),2));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteActionPerformed(e);
            }
        });
        containInputInfo.add(btnDelete);

        containOption = new JPanel();
        containOption.setLayout(null);
        containOption.setBounds(0, 489, 1146, 121);
        containOption.setBackground(Color.WHITE);
        containMain.add(containOption);

        lbFilterTitle = new JLabel("Lọc");
        lbFilterTitle.setBounds(43, 11, 345, 32);
        lbFilterTitle.setFont(lbFont);
        containOption.add(lbFilterTitle);

        lbSearchTitle = new JLabel("Tìm kiếm");
        lbSearchTitle.setBounds(859, 16, 345, 32);
        lbSearchTitle.setFont(lbFont);
        containOption.add(lbSearchTitle);

        containFilter = new PanelRound();
        containFilter.setRoundBottomLeft(20);
        containFilter.setRoundTopLeft(20);
        containFilter.setRoundBottomRight(20);
        containFilter.setRoundTopRight(20);
        containFilter.setBounds(43, 43, 757, 78);
        containFilter.setBackground(new Color(241, 241, 249));
        containFilter.setLayout(null);
        containOption.add(containFilter);

        lbGenderFilter = new JLabel("Lọc theo giới tính");
        lbGenderFilter.setBounds(30, 24, 152, 30);
        lbGenderFilter.setFont(lbFont);
        containFilter.add(lbGenderFilter);

        cbFilterGender = new JComboBox();
        cbFilterGender.addItem("");
        cbFilterGender.addItem("Nam");
        cbFilterGender.addItem("Nữ");
        cbFilterGender.setBackground(Color.WHITE);
        cbFilterGender.setFont(tfFont);
        cbFilterGender.setBounds(192, 19, 180, 40);
        cbFilterGender.setFocusable(false);
        cbFilterGender.addActionListener(new ActionListener() { //
            @Override
            public void actionPerformed(ActionEvent e) {
                cbFilterGenderActionPerformed(e);
            }
        });
        containFilter.add(cbFilterGender);

        lbRoleFilter = new JLabel("Lọc theo chức vụ");
        lbRoleFilter.setBounds(402, 24, 152, 30);
        lbRoleFilter.setFont(lbFont);
        containFilter.add(lbRoleFilter);

        cbFilterRole = new JComboBox();
        cbFilterRole.addItem("");
        for (Role r : roleService.findAll()) {
            cbFilterRole.addItem(r.getRole_name());
        }
        cbFilterRole.setBackground(Color.WHITE);
        cbFilterRole.setFont(tfFont);
        cbFilterRole.setBounds(560, 19, 180, 40);
        cbFilterRole.setFocusable(false);
        cbFilterRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbFilterRoleActionPerformed(e);
            }
        });
        containFilter.add(cbFilterRole);

        containSearch = new PanelRound();
        containSearch.setRoundBottomLeft(20);
        containSearch.setRoundTopLeft(20);
        containSearch.setRoundBottomRight(20);
        containSearch.setRoundTopRight(20);
        containSearch.setBounds(859, 43, 240, 78);
        containSearch.setBackground(new Color(241, 241, 249));
        containSearch.setLayout(null);
        containOption.add(containSearch);

        containSearchInput = new PanelRound();
        containSearchInput.setRoundBottomLeft(20);
        containSearchInput.setRoundTopLeft(20);
        containSearchInput.setRoundBottomRight(20);
        containSearchInput.setRoundTopRight(20);
        containSearchInput.setBounds(15, 19, 210, 40);
        containSearchInput.setBackground(Color.WHITE);
        containSearchInput.setLayout(null);
        containSearch.add(containSearchInput);

        tfSearchInput = new JTextField("Nhập ...");
        tfSearchInput.setFont(tfFont);
        tfSearchInput.setBounds(15, 0, 154, 40);
        tfSearchInput.setBackground(Color.WHITE);
        tfSearchInput.setForeground(Color.GRAY);
        tfSearchInput.setBorder(null);
        tfSearchInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfSearchInput.getText().equals("Nhập ...")) {
                    tfSearchInput.setText("");
                    tfSearchInput.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfSearchInput.getText().isEmpty()) {
                    tfSearchInput.setText("Nhập ...");
                    tfSearchInput.setForeground(Color.GRAY);
                }
            }
        });
        containSearchInput.add(tfSearchInput);

        icon = ImageValidate.scaleAndCreateIcon("/image/search.png", 22, 22);
        btnSearchReload = new JButton(icon);
        btnSearchReload.setBounds(177, 9, 22, 22);
        btnSearchReload.setBorderPainted(false);
        btnSearchReload.setContentAreaFilled(false);
        btnSearchReload.setFocusPainted(false);
        btnSearchReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchActionPerformed(e);
            }
        });
        containSearchInput.add(btnSearchReload);

        containTable = new JPanel();
        containTable.setBackground(Color.WHITE);
        containTable.setBounds(43, 624, 1056, 270);
        containTable.setLayout(new BorderLayout());
        containMain.add(containTable);

        tableScroll = new JScrollPane();
        tableScroll.setBorder(BorderFactory.createEmptyBorder());
        containTable.add(tableScroll);

        tbListStaff = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableScroll.setViewportView(tbListStaff);
        tbListStaff.setFillsViewportHeight(true);
        tbListStaff.setFont(new Font("Roboto", Font.PLAIN, 14));
        tbListStaff.setSelectionBackground(new Color(237, 237, 237));
        tbListStaff.setDefaultRenderer(Object.class, new MyRenderer());
        tbListStaff.setShowVerticalLines(false);
        tbListStaff.setRowHeight(45);
        tbListStaff.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"STT", "Tài khoản", "Tên", "Chức vụ", "Điên thoại", "Ngày sinh",
                        "Giới tính", "Email"}));
        showAllStaffList();

        JTableHeader jTableHeader = tbListStaff.getTableHeader();
        jTableHeader.setResizingAllowed(false);
        jTableHeader.setReorderingAllowed(false);
        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTableHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        jTableHeader.setBackground(Color.WHITE);
        jTableHeader.setFont(new Font("Roboto", Font.BOLD, 15));
        jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 45));

        TableColumnModel columnModel = tbListStaff.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(180);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(250);

        tbListStaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tbListStaffMouseClicked(e);
            }
        });

    }

    private void btnDeleteActionPerformed(ActionEvent e) {
        if (tbListStaff.getSelectedRow() != -1) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
            int id = (int) defaultTableModel.getValueAt(tbListStaff.getSelectedRow(), 0);
            User user = userService.findByID(id);
            if (user.getUsername().equals(CurrentSession.getCurrentUser().getUsername())) {
                JOptionPane.showMessageDialog(null, "Bạn không thể xóa tài khoản của bản thân.");
            } else {
                int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn xóa nhân viên không?");
                if (click == JOptionPane.YES_OPTION) {
                    userService.delete(id);
                    reloadPanel();
                }
            }
        }
    }


    private void btnEditActionPerformed(ActionEvent e) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
        if (tbListStaff.getSelectedRow() != -1) {
            int id = (int) defaultTableModel.getValueAt(tbListStaff.getSelectedRow(), 0);
            User user = userService.findByID(id);

            String fullname = tfInFullName.getText();
            String role_name = (String) cbInRole.getSelectedItem();
            String phone = tfInPhone.getText();
            String date = (jDCBirthday.getDate() != null) ? dateFormat.format(jDCBirthday.getDate()) : "";
            String image = lbFileName.getText();

            if (fullname.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên.");
            } else if (role_name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn chức vụ.");
            } else if (btngrGender.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.");
            } else if (phone.trim().isEmpty() || !InputRegex.isPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại (0 hoặc +84).");
            } else if (date.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh.");
            } else {
                int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn chỉnh sửa không?");
                if (click == JOptionPane.YES_OPTION) {
                    user.setFullName(fullname);
                    Role role = roleService.findByName(role_name);
                    user.setRole(role);
                    user.setGender((rbtnMale.isSelected()) ? 0 : 1);
                    user.setPhone(phone);
                    user.setBirthday(date);
                    user.setImage(image);
                    userService.edit(id, user);
                    if (CurrentSession.getCurrentUser().getUsername().equals(user.getUsername())) {
                        CurrentSession.setCurrentUser(user);
                        manager.reloadCurrentUser();
                        manager.getAccountDetailContent().reloadPanel();
                    }
                    reloadPanel();
                }
            }
        }
    }

    private void btnFCAvatarActionPerformed(ActionEvent e) {
        fcAvatar.setDialogTitle("Chọn ảnh đại diện");
        fcAvatar.setCurrentDirectory(new File(".\\src\\image"));
        fcAvatar.setFileFilter(new FileNameExtensionFilter("All pics", "png", "jpeg", "jpg"));
        int res = fcAvatar.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedImgAvt = fcAvatar.getSelectedFile();
            lbFileName.setText(selectedImgAvt.getName());
            Icon icon = ImageValidate.makeRoundedImageIcon("/image/" + selectedImgAvt.getName(), 235, 235, 10);
            lbAvatar.setIcon(icon);
        }

    }

    private void tbListStaffMouseClicked(MouseEvent e) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();

        int id = (int) defaultTableModel.getValueAt(tbListStaff.getSelectedRow(), 0);
        User selectedUser = userService.findByID(id);

        tfInFullName.setText(selectedUser.getFullName());
        tfInUsername.setText(selectedUser.getUsername());
        cbInRole.setSelectedItem(selectedUser.getRole().getRole_name());
        btngrGender.setSelected((selectedUser.getGender() == 1) ? rbtnFemale.getModel() : rbtnMale.getModel(), true);
        tfInPhone.setText(selectedUser.getPhone());
        if (selectedUser.getBirthday() == null) {
            jDCBirthday.setDate(null);
        } else {
            try {
                Date date = dateFormat.parse(selectedUser.getBirthday());
                jDCBirthday.setDate(date);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
        tfInEmail.setText(selectedUser.getEmail());
        lbFileName.setText(selectedUser.getImage());
        String path = "/image/" + selectedUser.getImage();
        Icon icon = ImageValidate.makeRoundedImageIcon(path, 235, 235, 10);
        lbAvatar.setIcon(icon);

    }

    private void btnSearchActionPerformed(ActionEvent e) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
        String value = tfSearchInput.getText(); // lưu trữ cái tên muốn tìm
        if (value.equals("Nhập ...") || value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập để tìm kiếm theo tên.");
        } else {
            List<User> userList = userService.findByName(value);
            if (userList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu.");
            } else {
                deleteOldData();
                for (User user : userList) {
                    defaultTableModel.addRow(new Object[]{
                            user.getId(),
                            user.getUsername(),
                            user.getFullName(),
                            user.getRole().getRole_name(),
                            user.getPhone(),
                            user.getBirthday(),
                            ((user.getGender() == 1) ? "Nữ" : "Nam"),
                            (user.getEmail())});
                }
            }
        }
    }

    private void cbFilterGenderActionPerformed(ActionEvent e) { // lọc theo giới tính
        deleteOldData();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
        String selected = (String) cbFilterGender.getSelectedItem(); // Nam
        if (selected.isEmpty()) {
            showAllStaffList();
        } else {
            List<User> userList = userService.findAll(); // 8 tài khoản
            for (User user : userList) {
                if (user.getGender() == 1 && selected.equals("Nữ")) {
                    defaultTableModel.addRow(new Object[]{
                            user.getId(),
                            user.getUsername(),
                            user.getFullName(),
                            user.getRole().getRole_name(),
                            user.getPhone(),
                            user.getBirthday(),
                            ((user.getGender() == 1) ? "Nữ" : "Nam"),
                            (user.getEmail())});
                } else if (user.getGender() == 0 && selected.equals("Nam")) {
                    defaultTableModel.addRow(new Object[]{
                            user.getId(),
                            user.getUsername(),
                            user.getFullName(),
                            user.getRole().getRole_name(),
                            user.getPhone(),
                            user.getBirthday(),
                            ((user.getGender() == 1) ? "Nữ" : "Nam"),
                            (user.getEmail())});
                }
            }
        }
    }

    private void cbFilterRoleActionPerformed(ActionEvent e) {
        deleteOldData();
        String selected = (String) cbFilterRole.getSelectedItem();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
        if (selected.isEmpty()) {
            showAllStaffList();
        } else {
            for (User user : userService.findAll()) {
                if (user.getRole().getRole_name().equals(selected)) {
                    defaultTableModel.addRow(new Object[]{
                            user.getId(),
                            user.getUsername(),
                            user.getFullName(),
                            user.getRole().getRole_name(),
                            user.getPhone(),
                            user.getBirthday(),
                            ((user.getGender() == 1) ? "Nữ" : "Nam"),
                            (user.getEmail())});
                }
            }
        }
    }

    public void reloadPanel() {
        showAllStaffList();
        reloadForm();
    }

    public void deleteOldData() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) tbListStaff.getModel();
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

    public void showAllStaffList() { // hiển thị dữ liệu từ CSDL ra tbStaffList
        deleteOldData();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbListStaff.getModel();
        List<User> userList = userService.findAll();
        for (User user : userList) {
            defaultTableModel.addRow(new Object[]{
                    user.getId(),
                    user.getUsername(),
                    user.getFullName(),
                    user.getRole().getRole_name(),
                    user.getPhone(),
                    user.getBirthday(),
                    ((user.getGender() == 1) ? "Nữ" : "Nam"),
                    (user.getEmail())});
        }
    }

    public void reloadForm() { // Reload lại thành form trắng
        tfSearchInput.setText("Nhập ...");
        tfSearchInput.setForeground(Color.GRAY);
        tfInEmail.setText("");
        tfInPhone.setText("");
        tfInFullName.setText("");
        tfInUsername.setText("");
        cbInRole.setSelectedItem("");
        btngrGender.clearSelection();
        jDCBirthday.setDate(null);
        jDCBirthday.setCalendar(null);
        lbFileName.setText("No file chosen");
        fcAvatar.setSelectedFile(null);
        lbAvatar.setIcon(null);
        cbFilterGender.setSelectedItem("");
        cbFilterRole.setSelectedItem("");
        selectedImgAvt = null;
    }

    public class MyRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(CENTER);
            if (column == 7 || column == 2 || column == 1) {
                setHorizontalAlignment(LEFT);
            }
            setBorder(noFocusBorder);
            return this;
        }
    }
}

