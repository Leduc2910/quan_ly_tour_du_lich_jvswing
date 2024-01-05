package GUI;

import com.toedter.calendar.JDateChooser;
import controller.CurrentSession;
import model.Role;
import model.User;
import service.UserService;
import validate.ImageValidate;
import validate.InputRegex;
import validate.PanelRound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountDetailContent extends JPanel {
    private Manager manager;
    private User user;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private PanelRound containMain;
    private JPanel containTitle;
    private JLabel lbIconTitle;
    private JLabel lbTitle;
    private JButton btnIconReload;
    private PanelRound containDetailForm;
    private JLabel lbInfoStaff;
    private JLabel lbFullName;
    private JTextField tfInFullName;
    private JTextField tfInUsername;
    private JLabel lbUsername;
    private JLabel lbBirthday;
    private JLabel lbGender;
    private JLabel lbRole;
    private JLabel lbPhone;
    private JLabel lbEmail;
    private JLabel lbImage;
    private JTextField tfInPhone;
    private JTextField tfInEmail;
    private JDateChooser jDCBirthday; // tải thử viện ngoài jCalender.jar
    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private ButtonGroup btngrGender;
    private JTextField tfInRole;
    private JFileChooser fcAvatar;
    private JButton btnFCAvatar;
    private JLabel lbFileName;
    private JLabel lbAvatar;
    private JButton btnEdit;
    private JLabel lbChangePass;
    private PanelRound containChangePass;
    private JLabel lbOldPass;
    private JLabel lbNewdPass;
    private JLabel lbSubmitNewPass;
    private JPasswordField tfInOldPass;
    private JPasswordField tfInSubNewPass;
    private JPasswordField tfInNewPass;
    private JButton btnEditPass;
    private JButton btnSubmit;
    private JButton btnIconClose;
    private UserService userService = new UserService();
    private File selectedImgAvt;

    public AccountDetailContent(Manager manager) {
        this.manager = manager;
        this.init();
        this.getCurrentAccountInfo();
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

        Icon icon = ImageValidate.scaleAndCreateIcon("/image/user-gear.png", 30, 30);
        lbIconTitle = new JLabel(icon);
        lbIconTitle.setBounds(43, 10, 30, 30);
        containTitle.add(lbIconTitle);

        lbTitle = new JLabel("Quản lý nhân viên");
        lbTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lbTitle.setBounds(93, 11, 1000, 30);
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
                btnReloadActionPerformed(e);
            }
        });
        containTitle.add(btnIconReload);

        lbInfoStaff = new JLabel("Thông tin cá nhân");
        lbInfoStaff.setFont(new Font("Roboto", Font.BOLD, 20));
        lbInfoStaff.setBounds(43, 104, 345, 30);
        containMain.add(lbInfoStaff);

        containDetailForm = new PanelRound();
        containDetailForm.setRoundBottomLeft(20);
        containDetailForm.setRoundTopLeft(20);
        containDetailForm.setRoundBottomRight(20);
        containDetailForm.setRoundTopRight(20);
        containDetailForm.setBounds(43, 131, 1060, 637);
        containDetailForm.setBackground(new Color(241, 241, 249));
        containDetailForm.setLayout(null);
        containMain.add(containDetailForm);

        Font lbFont = new Font("Roboto", Font.PLAIN, 20);
        Font tfFont = new Font("Roboto", Font.PLAIN, 16);

        lbFullName = new JLabel("Họ tên");
        lbFullName.setFont(lbFont);
        lbFullName.setBounds(35, 40, 100, 30);
        containDetailForm.add(lbFullName);

        tfInFullName = new JTextField();
        tfInFullName.setFont(tfFont);
        tfInFullName.setBounds(135, 35, 492, 40);
        tfInFullName.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containDetailForm.add(tfInFullName);

        lbUsername = new JLabel("Tài khoản");
        lbUsername.setFont(lbFont);
        lbUsername.setBounds(35, 105, 100, 30);
        containDetailForm.add(lbUsername);

        tfInUsername = new JTextField("mihduc");
        tfInUsername.setFont(tfFont);
        tfInUsername.setBounds(135, 100, 492, 40);
        tfInUsername.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfInUsername.setEditable(false);
        containDetailForm.add(tfInUsername);

        lbBirthday = new JLabel("Ngày sinh");
        lbBirthday.setFont(lbFont);
        lbBirthday.setBounds(35, 170, 100, 30);
        containDetailForm.add(lbBirthday);

        jDCBirthday = new JDateChooser();
        jDCBirthday.setBounds(135, 165, 248, 40);
        jDCBirthday.setDateFormatString("dd/MM/yyyy");
        containDetailForm.add(jDCBirthday);

        lbGender = new JLabel("Giới tính");
        lbGender.setFont(lbFont);
        lbGender.setBounds(35, 235, 100, 30);
        containDetailForm.add(lbGender);

        rbtnMale = new JRadioButton("Nam");
        rbtnMale.setFont(lbFont);
        rbtnMale.setBackground(new Color(241, 241, 249));
        rbtnMale.setBounds(135, 241, 96, 20);
        containDetailForm.add(rbtnMale);

        rbtnFemale = new JRadioButton("Nữ");
        rbtnFemale.setFont(lbFont);
        rbtnFemale.setBackground(new Color(241, 241, 249));
        rbtnFemale.setBounds(260, 241, 96, 20);
        containDetailForm.add(rbtnFemale);

        btngrGender = new ButtonGroup();
        btngrGender.add(rbtnMale);
        btngrGender.add(rbtnFemale);

        lbRole = new JLabel("Vai trò");
        lbRole.setFont(lbFont);
        lbRole.setBounds(35, 302, 100, 30);
        containDetailForm.add(lbRole);

        tfInRole = new JTextField();
        tfInRole.setFont(tfFont);
        tfInRole.setBounds(135, 297, 244, 40);
        tfInRole.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfInRole.setEditable(false);
        containDetailForm.add(tfInRole);

        lbPhone = new JLabel("Điện thoại");
        lbPhone.setFont(lbFont);
        lbPhone.setBounds(35, 367, 100, 30);
        containDetailForm.add(lbPhone);

        tfInPhone = new JTextField();
        tfInPhone.setFont(tfFont);
        tfInPhone.setBounds(135, 362, 492, 40);
        tfInPhone.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containDetailForm.add(tfInPhone);

        lbEmail = new JLabel("Email");
        lbEmail.setFont(lbFont);
        lbEmail.setBounds(35, 432, 100, 30);
        containDetailForm.add(lbEmail);

        tfInEmail = new JTextField();
        tfInEmail.setFont(tfFont);
        tfInEmail.setBounds(135, 427, 492, 40);
        tfInEmail.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        tfInEmail.setEditable(false);
        containDetailForm.add(tfInEmail);

        lbImage = new JLabel("Ảnh");
        lbImage.setFont(lbFont);
        lbImage.setBounds(35, 497, 100, 30);
        containDetailForm.add(lbImage);

        fcAvatar = new JFileChooser();

        btnFCAvatar = new JButton("Choose file");
        btnFCAvatar.setBounds(135, 497, 100, 30);
        btnFCAvatar.setFont(new Font("Roboto", Font.PLAIN, 13));
        btnFCAvatar.setFocusPainted(false);
        btnFCAvatar.setBackground(new Color(239, 239, 239));
        btnFCAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFCAvatarActionPerformed(e);
            }
        });
        containDetailForm.add(btnFCAvatar);

        lbFileName = new JLabel("No file chosen");
        lbFileName.setBounds(255, 503, 130, 20);
        lbFileName.setFont(new Font("Roboto", Font.PLAIN, 13));
        containDetailForm.add(lbFileName);

        lbAvatar = new JLabel();
        lbAvatar.setBounds(690, 35, 307, 307);
        containDetailForm.add(lbAvatar);

        btnEdit = new JButton("Lưu");
        btnEdit.setBounds(397, 562, 120, 40);
        btnEdit.setBackground(new Color(97, 95, 220));
        btnEdit.setFocusPainted(false);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditActionPerormed(e);
            }
        });
        containDetailForm.add(btnEdit);

        btnEditPass = new JButton("Đổi mật khẩu");
        btnEditPass.setBounds(542, 562, 120, 40);
        btnEditPass.setBackground(new Color(241, 241, 249));
        btnEditPass.setFocusPainted(false);
        btnEditPass.setForeground(new Color(128, 128, 227));
        btnEditPass.setBorder(new LineBorder(new Color(128, 128, 227), 2));
        btnEditPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditPassActionPerformed(e);
            }
        });
        containDetailForm.add(btnEditPass);

        lbChangePass = new JLabel("Đổi mật khẩu");
        lbChangePass.setFont(new Font("Roboto", Font.BOLD, 20));
        lbChangePass.setBounds(737, 104, 345, 30);
        containMain.add(lbChangePass);

        containChangePass = new PanelRound();
        containChangePass.setRoundBottomLeft(20);
        containChangePass.setRoundTopLeft(20);
        containChangePass.setRoundBottomRight(20);
        containChangePass.setRoundTopRight(20);
        containChangePass.setBounds(735, 131, 370, 384);
        containChangePass.setBackground(new Color(241, 241, 249));
        containChangePass.setLayout(null);
        containMain.add(containChangePass);

        icon = ImageValidate.scaleAndCreateIcon("/image/close.png", 15, 15);
        btnIconClose = new JButton(icon);
        btnIconClose.setBounds(339, 16, 15, 15);
        btnIconClose.setBorderPainted(false);
        btnIconClose.setContentAreaFilled(false);
        btnIconClose.setFocusPainted(false);
        btnIconClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIconCloseActionPerformed(e);
            }
        });
        containChangePass.add(btnIconClose);

        lbOldPass = new JLabel("Mật khẩu cũ");
        lbOldPass.setFont(lbFont);
        lbOldPass.setBounds(41, 33, 291, 30);
        containChangePass.add(lbOldPass);

        tfInOldPass = new JPasswordField();
        tfInOldPass.setFont(tfFont);
        tfInOldPass.setBounds(41, 63, 300, 40);
        tfInOldPass.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containChangePass.add(tfInOldPass);

        lbNewdPass = new JLabel("Mật khẩu mới");
        lbNewdPass.setFont(lbFont);
        lbNewdPass.setBounds(41, 128, 291, 30);
        containChangePass.add(lbNewdPass);

        tfInNewPass = new JPasswordField();
        tfInNewPass.setFont(tfFont);
        tfInNewPass.setBounds(41, 158, 300, 40);
        tfInNewPass.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containChangePass.add(tfInNewPass);

        lbSubmitNewPass = new JLabel("Nhập lại mật khẩu mới");
        lbSubmitNewPass.setFont(lbFont);
        lbSubmitNewPass.setBounds(41, 223, 291, 30);
        containChangePass.add(lbSubmitNewPass);

        tfInSubNewPass = new JPasswordField();
        tfInSubNewPass.setFont(tfFont);
        tfInSubNewPass.setBounds(41, 253, 300, 40);
        tfInSubNewPass.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        containChangePass.add(tfInSubNewPass);

        btnSubmit = new JButton("Lưu");
        btnSubmit.setBounds(127, 314, 120, 40);
        btnSubmit.setBackground(new Color(97, 95, 220));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSubmitActionPerformed(e);
            }
        });
        containChangePass.add(btnSubmit);

        containChangePass.setVisible(false);
        lbChangePass.setVisible(false);

    }

    private void btnReloadActionPerformed(ActionEvent e) {
        reloadPanel();
    }

    private void btnSubmitActionPerformed(ActionEvent e) {
        String oldPass = tfInOldPass.getText();
        String newPass = tfInNewPass.getText();
        String subNewPass = tfInSubNewPass.getText();

        if (oldPass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu cũ.");
        } else if (newPass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới.");
        } else if (subNewPass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập lại mật khẩu mới.");
        } else if (!user.getPassword().equals(oldPass)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng.");
        } else if (!subNewPass.equals(newPass)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không trùng khớp.");
        } else {
            int click = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn chỉnh sửa không?");
            if (click == JOptionPane.YES_OPTION) {
                user.setPassword(newPass);
                userService.edit(user.getId(), user);
                JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.");
                containChangePass.setVisible(false);
                lbChangePass.setVisible(false);
                containDetailForm.setBounds(43, 131, 1060, 637);
                lbAvatar.setVisible(true);
                btnEdit.setBounds(397, 562, 120, 40);
                btnEditPass.setVisible(true);
            }
        }
    }

    private void btnFCAvatarActionPerformed(ActionEvent e) {
        fcAvatar.setDialogTitle("Chọn ảnh đại diện");
        fcAvatar.setCurrentDirectory(new File("C:\\Users\\mihdu\\Pictures"));
        fcAvatar.setFileFilter(new FileNameExtensionFilter("Pictures", "png", "jpeg", "jpg"));
        int res = fcAvatar.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedImgAvt = fcAvatar.getSelectedFile();
            lbFileName.setText(selectedImgAvt.getName());
            Icon icon = ImageValidate.makeRoundedImageIconAbPath(selectedImgAvt.getAbsolutePath(), 307, 307, 10);
            lbAvatar.setIcon(icon);
        }
    }

    private void btnEditActionPerormed(ActionEvent e) {
        String fullname = tfInFullName.getText(); //1
        String date = (jDCBirthday.getDate() != null) ? dateFormat.format(jDCBirthday.getDate()) : "";
        String phone = tfInPhone.getText();
        String image = selectedImgAvt.getAbsolutePath();

        if (fullname.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên.");
        } else if (phone.trim().isEmpty() || !InputRegex.isPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại (0 hoặc +84).");
        } else if (date.isEmpty() || !InputRegex.isBirthday(date)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng ngày sinh.");
        } else {
            int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn chỉnh sửa không?");
            if (click == JOptionPane.YES_OPTION) {
                user.setFullName(fullname);
                user.setGender((rbtnMale.isSelected()) ? 0 : 1);
                user.setPhone(phone);
                user.setBirthday(date);
                user.setImage(image);
                userService.edit(user.getId(), user);
                CurrentSession.setCurrentUser(user);
                getCurrentAccountInfo();
                manager.reloadCurrentUser();
            }
        }
    }

    public void reloadPanel() {
        getCurrentAccountInfo();
        tfInOldPass.setText("");
        tfInNewPass.setText("");
        tfInSubNewPass.setText("");
        containChangePass.setVisible(false);
        lbChangePass.setVisible(false);
        containDetailForm.setBounds(43, 131, 1060, 637);
        lbAvatar.setVisible(true);
        btnEdit.setBounds(397, 562, 120, 40);
        btnEditPass.setVisible(true);
    }

    public void getCurrentAccountInfo() {
        user = CurrentSession.getCurrentUser();
        tfInFullName.setText(user.getFullName());
        tfInUsername.setText(user.getUsername());
        if (user.getBirthday() == null) {
            jDCBirthday.setDate(null);
        } else {
            Date date = null;
            try {
                date = dateFormat.parse(user.getBirthday());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            jDCBirthday.setDate(date);
        }
        btngrGender.setSelected((user.getGender() == 1) ? rbtnFemale.getModel() : rbtnMale.getModel(), true);
        tfInRole.setText(user.getRole().getRole_name());
        tfInPhone.setText(user.getPhone());
        tfInEmail.setText(user.getEmail());
        Icon icon = ImageValidate.makeRoundedImageIconAbPath(user.getImage(), 307, 307, 10);
        lbAvatar.setIcon(icon);
        selectedImgAvt = new File(user.getImage());
        lbFileName.setText(selectedImgAvt.getName());
    }

    private void btnIconCloseActionPerformed(ActionEvent e) {
        containChangePass.setVisible(false);
        lbChangePass.setVisible(false);
        lbAvatar.setVisible(true);
        containDetailForm.setBounds(43, 131, 1060, 637);
        btnEditPass.setVisible(true);
        btnEdit.setBounds(397, 562, 120, 40);
    }

    private void btnEditPassActionPerformed(ActionEvent e) {
        lbAvatar.setVisible(false);
        containDetailForm.setBounds(43, 131, 662, 637);
        containChangePass.setVisible(true);
        btnEditPass.setVisible(false);
        btnEdit.setBounds(271, 563, 120, 40);
        lbChangePass.setVisible(true);
    }
}
