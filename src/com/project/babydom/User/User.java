package com.project.babydom.User;

public class User {
    private UserState currentState;

    public User() {
        //User is initialized with logged off state
        this.setCurrentState(new LogOut());
    }

    //Getter
    public UserState getCurrentState() {
        return this.currentState;
    }

    //Setter
    public void setCurrentState(UserState currentState) {
        this.currentState = currentState;
    }

    /**
     * User action to click log off from the website
     */
    public void clickLogOff() {
        currentState.logOut(this);
    }

    /**
     * User action to click log in to the website
     */
    public void clickLogIn() {
        currentState.logIn(this);
    }

    /**
     * Using the user's current state to set their profile
     */
    public void setUserProfile() {
        currentState.setUserProfile(this);
    }

}
