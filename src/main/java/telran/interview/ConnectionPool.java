package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    // work out data structure
    // Connection pool comprises of some number of connections
    // It cannot contains more than the predefined number of connetion
    // You should define some Connection Pool policy so that
    // if number of connections is going to exceed the limit
    // a connection should be removed from the connection
    // Policy should take in consideration the order of adding connections in pool
    // and using connection
    private int maxSize;
    LinkedHashMap<String, Connection> map;

    public ConnectionPool(int size) {
        this.maxSize = size;
        map = new LinkedHashMap<>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry){
                return size() > maxSize;
            }
        };
    }

    public void addConnection(Connection connection) {
        // if the connection already exists in the pool
        // the IllegalStateException shuld be thrown
        if (map.putIfAbsent(connection.ConnectionId(), connection) != null) {
            throw new IllegalStateException();
        }
    }

    public Connection getConnection(String connectionId) {
        // If connection with a given ID doesn't exist the NoSuchElementExceptiojn
        // should be thrown
        Connection key = map.get(connectionId);
        if (key == null) {
            throw new NoSuchElementException();    
        }
        return key;
    }
}
