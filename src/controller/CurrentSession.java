package controller;

import model.User;
import service.UserService;

public class CurrentSession {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentSession.currentUser = currentUser;
    }
}
