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
    }

    public Login(JButton jbHidPass, JButton jbShowPass, JButton lgButton, JButton rgButton) {
        this.jbHidPass = jbHidPass;
        this.jbShowPass = jbShowPass;
        this.lgButton = lgButton;
        this.rgButton = rgButton;
    }

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setSize(500, 448);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        ActionListener actionListener = new LoginController(this);

        containTitle = new JPanel();
        containTitle.setBorder(BorderFactory.createEmptyBorder(37, 0, 0, 0));
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
        jbHidPass.setContentAreaFilled(false);
        jbHidPass.setFocusPainted(false);
        containPassword.add(jbHidPass);

        containButton = new JPanel();
        containButton.setLayout(new FlowLayout());
        containButton.setBackground(Color.WHITE);
        containButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        add(containButton, BorderLayout.SOUTH);

        lgButton = new JButton("Đăng nhập");
        lgButton.addActionListener(actionListener);
        lgButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnLoginPerformed(e);
            }
        });

        lgButton.setBackground(new Color(97, 96, 220));
        lgButton.setPreferredSize(new Dimension(368, 39));
        lgButton.setForeground(Color.WHITE);
        lgButton.setBorderPainted(false);
        lgButton.setFocusPainted(false);
        UIManager.put("Button.select", new Color(79, 78, 236));
        containButton.add(lgButton);

        rgButton = new JButton("Đăng kí");
        rgButton.addActionListener(actionListener);
        rgButton.setFont(new Font("Dialog", Font.BOLD, 13));
        rgButton.setPreferredSize(new Dimension(368, 39));
        rgButton.setBorderPainted(false);
        rgButton.setContentAreaFilled(false);
        rgButton.setFocusPainted(false);
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

    public void btnLoginPerformed(MouseEvent e) {
        String username = tfUsername.getText();
        String password = String.valueOf(pfPassword.getPassword());
        if (username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
        } else if (password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
        } else {
            User user = userService.getUserByAccount(username, password);
            String message = "";
            if (user != null) {
                CurrentSession.setCurrentUser(user);
                message = "Đăng nhập thành công!\nXin chào, " + user.getFullName() + ".";
                JOptionPane.showMessageDialog(null, message);
                Manager manager = new Manager();
                manager.setVisible(true);
                this.setVisible(false);
            } else {
                message = "Sai thông tin tài khoản hoặc mật khẩu!";
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }
}
