package controller;

import GUI.Manager;
import GUI.TourManagerContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerController implements MouseListener, ActionListener {
    private Manager manager;
    private TourManagerContent tourManagerContent;

    public ManagerController(Manager manager) {
        this.manager = manager;
    }
    public ManagerController(TourManagerContent tourManagerContent) {
        this.tourManagerContent = tourManagerContent;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == manager.getManagerTourFunction()) {
            manager.reloadPanel(manager.getContainManager());
            manager.getCardLayout().show(manager.getContainManager(), "tourManagerContent");
        } else if (e.getSource() == manager.getManagerStafffunction()) {
            manager.reloadPanel(manager.getContainManager());
            manager.getCardLayout().show(manager.getContainManager(), "staffManagerContent");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tourManagerContent.getCbCategory()) {
            tourManagerContent.sortByTourCategory();
        }else if (e.getSource() == tourManagerContent.getBtnSearch()) {
            tourManagerContent.searchByKeyWord();
        }
    }
}
