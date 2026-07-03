package com.habitmanager.service;

import com.habitmanager.dao.HabitDao;
import com.habitmanager.model.Habit;
import com.habitmanager.model.HabitType;

public class HabitService {
    private final HabitDao habitDao;

    public HabitService(HabitDao habitDao) {
        this.habitDao = habitDao;
    }

    public Habit createHabit(String name, String category, HabitType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Habit name is required.");
        }

        HabitType safeType = type == null ? HabitType.NEUTRAL : type;
        Habit habit = new Habit(name.trim(), cleanCategory(category), safeType);
        return habitDao.insert(habit);
    }

    private String cleanCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            return null;
        }
        return category.trim();
    }
}
