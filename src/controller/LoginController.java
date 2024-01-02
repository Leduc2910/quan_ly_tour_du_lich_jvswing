package controller;

import GUI.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private Login login;

    public LoginController() {
    }

    public LoginController(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getJbHidPass()) {
            login.showPass();
        } else if (e.getSource() == login.getJbShowPass()) {
            login.hidPass();
        } else if (e.getSource() == login.getRgButton()) {
            login.showFormRegis();
        } else if (e.getSource() == login.getLgButton()) {
            login.btnLoginPerformed();
        }
    }
}
