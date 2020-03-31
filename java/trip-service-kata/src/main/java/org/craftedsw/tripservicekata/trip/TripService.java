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

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getLoggedUser();
        checkLoggedUser(loggedUser);
        return getTrips(user, loggedUser);
    }

    private List<Trip> getTrips(User user, User loggedUser) {
        if (user.isFriend(loggedUser)) {
            return getFriendsTrips(user);
        } else {
            return new ArrayList<Trip>();
        }
    }

    private User getLoggedUser() {
        return userSession.getLoggedUser();
    }

    private void checkLoggedUser(User loggedUser) throws UserNotLoggedInException {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    private List<Trip> getFriendsTrips(User user) {
        return tripDAO.findTripsByUser(user);
    }

}