package com.habitmanager.dao;

import com.habitmanager.database.DatabaseConnection;
import com.habitmanager.model.Habit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HabitDao {
    public Habit insert(Habit habit) {
        String sql = "INSERT INTO habits (name, category, type) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, habit.getName());
            statement.setString(2, habit.getCategory());
            statement.setString(3, habit.getType().name());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    habit.setId(generatedKeys.getInt(1));
                }
            }

            return habit;
        } catch (SQLException exception) {
            throw new IllegalStateException("Could not insert habit.", exception);
        }
    }
}
