package homework16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionRun {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "misha555";
    private static final Connection CONNECTION = buildConnect();

    private static Connection buildConnect() {
        Connection localConnection = null;
        try {
            localConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.err.println("Подключение успешно");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться");
        }
        return localConnection;
    }

    public static Connection getConnect() {
        return CONNECTION;
    }

    public static void shutdown() {
        try {
            CONNECTION.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
