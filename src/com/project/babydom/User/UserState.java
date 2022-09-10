package com.project.babydom.User;

public interface UserState {
    void logIn(User context);
    void logOut(User context);

    void setUserProfile(User context);

}
