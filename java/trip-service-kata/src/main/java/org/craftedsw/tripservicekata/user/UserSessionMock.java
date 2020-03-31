package org.craftedsw.tripservicekata.user;

public class UserSessionMock implements UserSession {

	public User getLoggedUser() {
		return new User();
	}

}
