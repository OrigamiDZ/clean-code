package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	TripService(UserSession userSession, TripDAO tripDAO) {
		this.userSession = userSession;
		this.tripDAO = tripDAO;
	}

	private UserSession userSession;
	private TripDAO tripDAO;

	protected User getLoggedUser() {
		return userSession.getLoggedUser();
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
