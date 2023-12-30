package controller;

import GUI.Manager;
import GUI.TourManagerContent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerController implements MouseListener {
    private Manager manager;


    public ManagerController(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == manager.getManagerTourFunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "tourManagerContent");
            manager.setActiveFunctionPanle(manager.getTourManagerContent());
        } else if (e.getSource() == manager.getManagerStafffunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "staffManagerContent");
            manager.setActiveFunctionPanle(manager.getStaffManagerContent());
        } else if (e.getSource() == manager.getAccountDetailFunction()) {
            manager.getCardLayout().show(manager.getContainManager(), "accountDetailContent");
            manager.setActiveFunctionPanle(manager.getAccountDetailContent());
        } else if (e.getSource() == manager.getContainLogout()) {
            manager.logout();
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
        if(e.getSource() == manager.getContainLogout()) {
            manager.getLbLogout().setForeground(new Color(97, 96, 220));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == manager.getContainLogout()) {
            manager.getLbLogout().setForeground(Color.GRAY);
        }
    }
}
