package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] array = {1, 9};
        assertTrue(InterviewTasks.hasSumTwo(array, 10));
        assertFalse(InterviewTasks.hasSumTwo(array, 11));

        int[] array2 = {1, 15, 10, 22, 9};
        assertFalse(InterviewTasks.hasSumTwo(array2, 20));
        assertTrue(InterviewTasks.hasSumTwo(array2, 10));
    }
}
