package com.project.babydom.User;

public class LogOut implements UserState {

    /**
     * LogOut class's specific implementation of logIn method
     * @param context as User
     */
    @Override
    public void logIn(User context) {
        System.out.println("Sign in the user to BabyDom website...");
        context.setCurrentState(new LogIn());
        System.out.println(context.getCurrentState().toString());
    }

    /**
     * LogOut class's specific implementation of logOut method
     * @param context as User
     */
    @Override
    public void logOut(User context) {
        //User is logged out already, Logout button would be disabled
        System.out.println("User is already logged out, no further action here.");
    }

    @Override
    public void setUserProfile(User context) {
        System.out.println(">> User should login to set profile details, redirect to login >>");
        this.logIn(context);
    }

    public String toString()
    {
        return "\t** User is logged out. **";
    }

}
