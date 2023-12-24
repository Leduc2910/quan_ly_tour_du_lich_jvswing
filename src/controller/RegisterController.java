package controller;

import GUI.Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private Register register;

    public RegisterController() {
    }

    public RegisterController(Register register) {
        this.register = register;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register.getJbHidPass()) {
            register.showPass();
        } else if (e.getSource() == register.getJbShowPass()) {
            register.hidPass();
        } else if (e.getSource() == register.getLgButton()) {
            register.showFormLogin();
        }
    }
}
