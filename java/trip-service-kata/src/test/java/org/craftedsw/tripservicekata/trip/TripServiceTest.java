package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSessionMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripServiceTest {

    private TripService tripService = new TripService(new UserSessionMock());
    private User user = new User();

    @Test
    void getTripsByUsers_sucess() {
        // When
        List<Trip> result = tripService.getTripsByUser(user);

        // Then
        assertTrue(result.isEmpty());
    }

}
