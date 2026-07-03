package com.habitmanager;

import com.habitmanager.dao.HabitDao;
import com.habitmanager.database.DatabaseConnection;
import com.habitmanager.model.Habit;
import com.habitmanager.model.HabitType;
import com.habitmanager.service.HabitService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();

        HabitService habitService = new HabitService(new HabitDao());
        Habit habit = habitService.createHabit("Drink water", "Health", HabitType.POSITIVE);

        System.out.println("Habit Manager is ready.");
        System.out.println("Created habit: " + habit);
    }
}
