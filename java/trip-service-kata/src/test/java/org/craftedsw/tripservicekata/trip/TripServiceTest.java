package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSessionMock;
import org.craftedsw.tripservicekata.user.UserSessionMockThrowException;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripServiceTest {

    private TripService tripService = new TripService(new UserSessionMock());
    private User user = new User();

    @Test
    void getTripsByUsers_success() {
        // When
        List<Trip> result = tripService.getTripsByUser(user);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void getTripsByUsers_shouldThrowException_WhenUserIsNotLoggedIn() {
        // Given
        TripService tripService = new TripService(new UserSessionMockThrowException());

        // When
        Exception exception = assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(user);
        });

    }

}
