package GUI;

import com.mysql.cj.log.Log;
import controller.CurrentSession;
import controller.LoginController;
import model.User;
import service.UserService;
import validate.ImageValidate;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JPanel containTitle, containUsername, containPassword, containLogin, containButton;
    private JLabel lbTitle, lbTitle2, lbUsername, lbPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton lgButton, jbHidPass, jbShowPass, rgButton;
    private UserService userService = new UserService();

    public Login() {
        this.init();
    } // Khoi tao

    public JButton getLgButton() {
        return lgButton;
    }

    public void setLgButton(JButton lgButton) {
        this.lgButton = lgButton;
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

    public JButton getRgButton() {
        return rgButton;
    }

    public void setRgButton(JButton rgButton) {
        this.rgButton = rgButton;
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //  nhấn nút x--> chương trinhf dừng
        setTitle("Đăng nhập");
        setSize(500, 448);
        setLocationRelativeTo(null); // can can su ra giua
        setResizable(false);// cố định kích thước

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());// set bố cục

        ActionListener actionListener = new LoginController(this);

        containTitle = new JPanel();
        containTitle.setBorder(BorderFactory.createEmptyBorder(37, 0, 0, 0));
        containTitle.setBackground(Color.WHITE);
        containTitle.setLayout(new BorderLayout());
        add(containTitle, BorderLayout.NORTH);

        lbTitle = new JLabel("HỆ THỐNG");
        lbTitle.setFont(new Font("Inter", Font.BOLD, 28)); // chỉnh font
        lbTitle.setForeground(new Color(62, 94, 165)); // chỉnh màu chữ
        lbTitle.setHorizontalAlignment(JLabel.CENTER); // căn theo chiều ngang
        containTitle.add(lbTitle, BorderLayout.NORTH);

        lbTitle2 = new JLabel("QUẢN LÝ TOUR DU LỊCH");
        lbTitle2.setFont(new Font("Inter", Font.BOLD, 31));
        lbTitle2.setForeground(new Color(245, 218, 64));
        lbTitle2.setHorizontalAlignment(JLabel.CENTER);
        containTitle.add(lbTitle2, BorderLayout.CENTER);

        containLogin = new JPanel();
        containLogin.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 37));
        containLogin.setBackground(Color.WHITE);
        add(containLogin, BorderLayout.CENTER);

        containUsername = new JPanel();
        containUsername.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        containUsername.setBackground(new Color(231, 239, 253));
        containUsername.setPreferredSize(new Dimension(368, 39));
        containLogin.add(containUsername);

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
        containLogin.add(containPassword);

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
        jbHidPass.setContentAreaFilled(false); // tắt background
        containPassword.add(jbHidPass);

        containButton = new JPanel();
        containButton.setLayout(new FlowLayout());
        containButton.setBackground(Color.WHITE);
        containButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(containButton, BorderLayout.SOUTH);

        lgButton = new JButton("Đăng nhập");
        lgButton.addActionListener(actionListener);
        lgButton.setBackground(new Color(97, 96, 220));
        lgButton.setPreferredSize(new Dimension(368, 39));
        lgButton.setForeground(Color.WHITE);
        lgButton.setBorderPainted(false); // tắt hover border
        lgButton.setFocusPainted(false); // tắt focus border
        UIManager.put("Button.select", new Color(79, 78, 236));
        containButton.add(lgButton);

        rgButton = new JButton("Đăng kí");
        rgButton.addActionListener(actionListener);
        rgButton.setFont(new Font("Dialog", Font.BOLD, 13));
        rgButton.setPreferredSize(new Dimension(368, 39));
        rgButton.setBorderPainted(false);  // tắt border
        rgButton.setContentAreaFilled(false); // tắt background
        rgButton.setFocusPainted(false); // tắt focus border
        containButton.add(rgButton);
    }

    public void showPass() {
        ActionListener actionListener = new LoginController(this);
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

    public void showFormRegis() {
        Register register = new Register();
        register.setVisible(true);
        setVisible(false);
    }

    public void btnLoginPerformed() {
            String username = tfUsername.getText(); // 1234
            String password = String.valueOf(pfPassword.getPassword()); // 123
            if (username.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
            } else if (password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
            } else {
                User user = userService.getUserByAccount(username, password);//  kiểm tra du lieu nhap vao xem co trong database khong
                if (user != null) {
                    CurrentSession.setCurrentUser(user); // lay user dang nhap vao he thong
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!\nXin chào, " + user.getFullName() + ".");
                    Manager manager = new Manager();
                    manager.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai thông tin tài khoản hoặc mật khẩu!");
                }
            }
    }
}
