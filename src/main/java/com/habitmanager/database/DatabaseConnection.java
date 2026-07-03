package com.habitmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:habit_manager.db";

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void initializeDatabase() {
        String createHabitsTable = "CREATE TABLE IF NOT EXISTS habits ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "category TEXT,"
                + "type TEXT NOT NULL,"
                + "created_at TEXT DEFAULT CURRENT_TIMESTAMP"
                + ");";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createHabitsTable);
            System.out.println("Database ready: habits table checked.");
        } catch (SQLException exception) {
            throw new IllegalStateException("Could not initialize database.", exception);
        }
    }
}
