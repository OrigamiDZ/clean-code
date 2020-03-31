package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public interface TripDAO {
    List<Trip> findTripsByUser(User user);
}
