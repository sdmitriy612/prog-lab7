package ru.sdmitriy612.client;

import ru.sdmitriy612.interactors.UserAuthorization;

public class Session {
    private static Session INSTANCE;
    private UserAuthorization userAuthorization;

    private Session(){}

    public static Session getInstance(){
        return INSTANCE == null ? INSTANCE = new Session() : INSTANCE;
    }

    public UserAuthorization getUserAuthorization() {
        return userAuthorization;
    }

    public void setUserAuthorization(UserAuthorization userAuthorization) {
        this.userAuthorization = userAuthorization;
    }
}
