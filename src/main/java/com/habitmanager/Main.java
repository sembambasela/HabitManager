package com.habitmanager;

import com.habitmanager.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        System.out.println("Habit Manager is ready.");
    }
}
