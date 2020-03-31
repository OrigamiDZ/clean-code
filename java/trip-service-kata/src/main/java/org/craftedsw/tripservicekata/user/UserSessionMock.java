package org.craftedsw.tripservicekata.user;

public class UserSessionMock implements UserSession {

	public UserSessionMock(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	private User loggedUser;

	public User getLoggedUser() {
		return loggedUser;
	}

}
