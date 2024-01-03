package GUI;

import controller.RegisterController;
import model.Role;
import model.User;
import service.UserService;
import validate.ImageValidate;
import validate.InputRegex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Register extends JFrame {
    private JPanel containTitle, containUsername, containPassword, containRegis, containButton, containName, containEmail;
    private JLabel lbTitle, lbTitle2, lbUsername, lbPassword, lbFullName, lbEmail;
    private JTextField tfUsername, tfFullName, tfEmail;
    private JPasswordField pfPassword;
    private JButton rgButton, jbHidPass, jbShowPass, lgButton;

    private UserService userService = new UserService();

    public Register() {
        this.init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Đăng kí");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        ActionListener actionListener = new RegisterController(this);

        containTitle = new JPanel();
        containTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        containTitle.setBackground(Color.WHITE);
        containTitle.setLayout(new BorderLayout());
        add(containTitle, BorderLayout.NORTH);


        lbTitle = new JLabel("HỆ THỐNG");
        lbTitle.setFont(new Font("Inter", Font.BOLD, 28));
        lbTitle.setForeground(new Color(62, 94, 165));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        containTitle.add(lbTitle, BorderLayout.NORTH);

        lbTitle2 = new JLabel("QUẢN LÝ TOUR DU LỊCH");
        lbTitle2.setFont(new Font("Inter", Font.BOLD, 31));
        lbTitle2.setForeground(new Color(245, 218, 64));
        lbTitle2.setHorizontalAlignment(JLabel.CENTER);
        containTitle.add(lbTitle2, BorderLayout.CENTER);

        containRegis = new JPanel();
        containRegis.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        containRegis.setBackground(Color.WHITE);
        add(containRegis, BorderLayout.CENTER);

        containUsername = new JPanel();
        containUsername.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        containUsername.setBackground(new Color(231, 239, 253));
        containUsername.setPreferredSize(new Dimension(368, 39));
        containRegis.add(containUsername);

        Icon icon = ImageValidate.scaleAndCreateIcon("/image/user.png", 19, 19);
        lbUsername = new JLabel(icon);
        containUsername.add(lbUsername);

        tfUsername = new JTextField();
        tfUsername.setFont(new Font("Inter", Font.PLAIN, 14));
        tfUsername.setBackground(new Color(231, 239, 253));
        tfUsername.setColumns(27);
        tfUsername.setBorder(null);
        tfUsername.setToolTipText("Nhập tài khoản");
        containUsername.add(tfUsername);


        containPassword = new JPanel();
        containPassword.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        containPassword.setBackground(new Color(231, 239, 253));
        containPassword.setPreferredSize(new Dimension(368, 39));
        containRegis.add(containPassword);

        icon = ImageValidate.scaleAndCreateIcon("/image/lock.png", 19, 19);
        lbPassword = new JLabel(icon);
        containPassword.add(lbPassword);

        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Inter", Font.PLAIN, 14));
        pfPassword.setBackground(new Color(231, 239, 253));
        pfPassword.setColumns(26);
        pfPassword.setBorder(null);
        pfPassword.setToolTipText("Nhập mật khẩu");
        containPassword.add(pfPassword);

        icon = ImageValidate.scaleAndCreateIcon("/image/crossed-eye.png", 19, 19);
        jbHidPass = new JButton(icon);
        jbHidPass.addActionListener(actionListener);
        jbHidPass.setBorder(null);
        jbHidPass.setContentAreaFilled(false);
        jbHidPass.setFocusPainted(false);
        containPassword.add(jbHidPass);

        containName = new JPanel();
        containName.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        containName.setBackground(new Color(231, 239, 253));
        containName.setPreferredSize(new Dimension(368, 39));
        containRegis.add(containName);

        icon = ImageValidate.scaleAndCreateIcon("/image/fullname.png", 19, 19);
        lbFullName = new JLabel(icon);
        containName.add(lbFullName);

        tfFullName = new JTextField();
        tfFullName.setFont(new Font("Inter", Font.PLAIN, 14));
        tfFullName.setBackground(new Color(231, 239, 253));
        tfFullName.setColumns(27);
        tfFullName.setBorder(null);
        tfFullName.setToolTipText("Nhập họ và tên");
        containName.add(tfFullName);

        containEmail = new JPanel();
        containEmail.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        containEmail.setBackground(new Color(231, 239, 253));
        containEmail.setPreferredSize(new Dimension(368, 39));
        containRegis.add(containEmail);

        icon = ImageValidate.scaleAndCreateIcon("/image/email.png", 19, 19);
        lbEmail = new JLabel(icon);
        containEmail.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Inter", Font.PLAIN, 14));
        tfEmail.setBackground(new Color(231, 239, 253));
        tfEmail.setColumns(27);
        tfEmail.setBorder(null);
        tfEmail.setToolTipText("Nhập email");
        containEmail.add(tfEmail);

        containButton = new JPanel();
        containButton.setLayout(new FlowLayout());
        containButton.setBackground(Color.WHITE);
        containButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(containButton, BorderLayout.SOUTH);

        rgButton = new JButton("Đăng ký");
        rgButton.addActionListener(actionListener);
        rgButton.setBackground(new Color(97, 96, 220));
        rgButton.setFont(new Font("Dialog", Font.BOLD, 13));
        rgButton.setPreferredSize(new Dimension(368, 39));
        rgButton.setForeground(Color.WHITE);
        rgButton.setBorderPainted(false);
        rgButton.setFocusPainted(false);
        UIManager.put("Button.select", new Color(79, 78, 236));
        containButton.add(rgButton);

        lgButton = new JButton("Đăng nhập");
        lgButton.addActionListener(actionListener);
        lgButton.setFont(new Font("Dialog", Font.BOLD, 13));
        lgButton.setPreferredSize(new Dimension(368, 39));
        lgButton.setBorderPainted(false);
        lgButton.setContentAreaFilled(false);
        lgButton.setFocusPainted(false);
        containButton.add(lgButton);
    }


    public void showPass() {
        ActionListener actionListener = new RegisterController(this);
        Icon icon = ImageValidate.scaleAndCreateIcon("/image/open-eye.png", 19, 19);
        jbShowPass = new JButton(icon);
        jbShowPass.addActionListener(actionListener);
        jbShowPass.setBorder(null);
        jbShowPass.setContentAreaFilled(false);
        jbShowPass.setFocusPainted(false);
        containPassword.add(jbShowPass);
        jbHidPass.setVisible(false);
        jbShowPass.setVisible(true);
        pfPassword.setEchoChar((char) 0);
    }

    public void hidPass() {
        jbHidPass.setVisible(true);
        jbShowPass.setVisible(false);
        pfPassword.setEchoChar('•');
    }

    public void showFormLogin() {
        Login login = new Login();
        login.setVisible(true);
        setVisible(false);
    }

    public void btnRegisterActionPerformed() {
        String username = tfUsername.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String fullName = tfFullName.getText();
        String email = tfEmail.getText();
        String message = "";

        if (username.trim().isEmpty()) {
            message = "Vui lòng nhập tài khoản!";
            JOptionPane.showMessageDialog(null, message);
            return;
        } else if (userService.checkAccAlreadyByUsername(username)) {
            message = "Tài khoản đã tồn tại!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        if (password.trim().isEmpty()) {
            message = "Vui lòng nhập mật khẩu!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        if (fullName.trim().isEmpty()) {
            message = "Vui lòng nhập tên!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        if (email.trim().isEmpty() || !InputRegex.isEmail(email)) {
            message = "Vui lòng nhập đúng định dạng email!";
            JOptionPane.showMessageDialog(null, message);
            return;
        } else if (userService.checkAccAlreadyByEmail(email)) {
            message = "Email đã tồn tại!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        Role role = new Role();
        User user = new User(username, password, fullName, email, role);
        userService.add(user);
        message = "Đăng ký thành công!";
        JOptionPane.showMessageDialog(null, message);
        showFormLogin();
    }

    public JButton getRgButton() {
        return rgButton;
    }

    public void setRgButton(JButton rgButton) {
        this.rgButton = rgButton;
    }

    public JButton getJbHidPass() {
        return jbHidPass;
    }

    public void setJbHidPass(JButton jbHidPass) {
        this.jbHidPass = jbHidPass;
    }

    public JButton getJbShowPass() {
        return jbShowPass;
    }

    public void setJbShowPass(JButton jbShowPass) {
        this.jbShowPass = jbShowPass;
    }

    public JButton getLgButton() {
        return lgButton;
    }

    public void setLgButton(JButton lgButton) {
        this.lgButton = lgButton;
    }
}
