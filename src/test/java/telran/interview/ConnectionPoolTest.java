package telran.interview;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
    // should contain the tests reflecting your understanding what should be done
    ConnectionPool connectionPool;
    String[] array = {"con_1", "con_2", "con_3", "con_4"};

    private void setUp() {
        connectionPool = new ConnectionPool(5);
        connectionPool.addConnection(new Connection("con_1"));
        connectionPool.addConnection(new Connection("con_2"));
        connectionPool.addConnection(new Connection("con_3"));
        connectionPool.addConnection(new Connection("con_4"));
    }

    @Test
    void getConnectionTest() {
        setUp();
        assertEquals(new Connection("con_1").ConnectionId(), connectionPool.getConnection("con_1").ConnectionId());
        assertThrowsExactly(NoSuchElementException.class, () -> connectionPool.getConnection("con_5"));    
    }

    @Test
    void ConnectPoolTest() {
        setUp();
        assertArrayEquals(array, connectionPool.map.keySet().toArray());       
    }

    @Test
    void addConnectionTest() {
        setUp(); //{"con_1", "con_2", "con_3", "con_4"}

        assertThrowsExactly(IllegalStateException.class, () -> connectionPool.addConnection(new Connection("con_4")));

        String[] array1 = {"con_1", "con_2", "con_3", "con_4", "con_5"};
        connectionPool.addConnection(new Connection("con_5"));
        assertArrayEquals(array1, connectionPool.map.keySet().toArray());

        String[] array2 = {"con_2", "con_3", "con_4", "con_5", "con_6"};
        connectionPool.addConnection(new Connection("con_6"));
        assertArrayEquals(array2, connectionPool.map.keySet().toArray());

        String[] array3 = {"con_4", "con_5", "con_6", "con_2", "con_7"};
        connectionPool.getConnection("con_2");
        connectionPool.addConnection(new Connection("con_7"));
        assertArrayEquals(array3, connectionPool.map.keySet().toArray());
    }

}
