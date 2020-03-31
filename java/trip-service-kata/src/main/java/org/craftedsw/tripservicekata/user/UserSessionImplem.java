package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSessionImplem implements UserSession {

	private static final UserSessionImplem userSession = new UserSessionImplem();

	private UserSessionImplem() {
	}

	public User getLoggedUser() {
		throw new CollaboratorCallException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
