package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RobotOperationsTest {

    @InjectMocks
    private RobotOperations robotOperations;

    private RobotPlan robotPlan;


    @Test
    public void getStonesForCertainDays() {
        // Given
        int days = 4;
        // When
        robotPlan = robotOperations.excavateStonesForDays(days);
        // Then
        assertEquals(8, robotPlan.numberOfStones());
    }

    @Test
    public void getStonesForCertainDaysThrowsError() {
        // Given
        int days = 0;
        // When
        var exception = assertThrows(
                IllegalArgumentException.class, () -> robotOperations.excavateStonesForDays(days));
        //Then
        assertEquals("No actions", exception.getMessage());
    }

    @Test
    public void daysRequiredToCollectStonesThrowsError() {
        // Given
        int stones = -1;
        // When
        var exception = assertThrows(
                IllegalArgumentException.class, () -> robotOperations.daysRequiredToCollectStones(stones));
        //Then
        assertEquals("Days can't be negative number", exception.getMessage());
    }

    @Test
    public void daysRequiredToCollectStonesForCertainDays() {
        // Given
        int stones = 9;
        // When
        robotPlan = robotOperations.daysRequiredToCollectStones(stones);
        //Then
        assertEquals(5, robotPlan.numberOfDays());
    }
}
