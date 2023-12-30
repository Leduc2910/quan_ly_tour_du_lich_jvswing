package controller;

import GUI.Manager;
import GUI.TourManagerContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerController implements MouseListener{
    private Manager manager;


    public ManagerController(Manager manager) {
        this.manager = manager;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == manager.getManagerTourFunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "tourManagerContent");
        } else if (e.getSource() == manager.getManagerStafffunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "staffManagerContent");
        } else if (e.getSource() == manager.getAccountDetailFunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "accountDetailManager");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
