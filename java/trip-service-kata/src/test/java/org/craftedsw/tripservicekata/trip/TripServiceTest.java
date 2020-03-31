package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.craftedsw.tripservicekata.user.UserSessionMock;
import org.craftedsw.tripservicekata.user.UserSessionMockThrowException;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TripServiceTest {

    private TripDAO tripDAO = new TripDAOMock();

    @Test
    void getTripsByUsers_success() {
        User user = new User();
        TripService tripService = new TripService(new UserSessionMock(user), tripDAO);

        // When
        List<Trip> result = tripService.getTripsByUser(user);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void getTripsByUsers_shouldThrowException_WhenUserIsNotLoggedIn() {
        // Given
        User user = new User();
        TripService tripService = new TripService(new UserSessionMockThrowException(), tripDAO);

        // When
        Exception exception = assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(user);
        });

    }

    @Test
    void getTripsByUsers_sucess_when_friend_has_trip_list() {
        // Given
        User loggedUser = new User();
        User friendUser = new User();
        UserSessionMock userSessionMock = new UserSessionMock(loggedUser);

        friendUser.addFriend(loggedUser);
        TripService tripService = new TripService(userSessionMock, tripDAO);

        // When
        List<Trip> result = tripService.getTripsByUser(friendUser);

        // Then
        assertNull(result);
    }

}
