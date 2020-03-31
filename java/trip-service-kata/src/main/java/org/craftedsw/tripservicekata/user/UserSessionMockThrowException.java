package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;

public class UserSessionMockThrowException implements UserSession {

    public User getLoggedUser() {
        throw new UserNotLoggedInException();
    }

}
