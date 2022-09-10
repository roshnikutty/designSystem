package com.project.babydom.User;


public class LogIn implements UserState {
    /**
     * LogIn class's specific implementation of logIn method
     * @param context as User
     */
    @Override
    public void logIn(User context) {
        //User is logged in already, Login button would be disabled
        System.out.println("User is already logged in, no further action here.");
    }

    /**
     * LogIn class's specific implementation of logOut method
     * @param context as User
     */
    @Override
    public void logOut(User context) {
        System.out.println("Sign out the user from BabyDom website...");
        context.setCurrentState(new LogOut());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void setUserProfile(User context) {
        System.out.println(">> Set profile details, if not already done >>");
    }

    public String toString()
    {
        return "\t** User is logged in. **";
    }
}