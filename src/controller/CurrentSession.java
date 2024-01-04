package controller;

import model.User;
// lấy được người đang đăng nhập hiện tại
public class CurrentSession {
    private static User currentUser = null;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentSession.currentUser = currentUser;
    }
}

