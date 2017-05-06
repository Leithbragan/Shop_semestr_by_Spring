package ru.kpfu.itis.form;

import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;

public class UserModifyForm {

    private User user;
    private UserRole role;
    private boolean is_confirm;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(boolean is_confirm) {
        this.is_confirm = is_confirm;
    }
}
