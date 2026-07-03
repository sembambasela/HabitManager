package com.habitmanager.model;

public class Habit {
    private int id;
    private String name;
    private String category;
    private HabitType type;
    private String createdAt;

    public Habit(String name, String category, HabitType type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public Habit(int id, String name, String category, HabitType type, String createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public HabitType getType() {
        return type;
    }

    public void setType(HabitType type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Habit{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", category='" + category + '\''
                + ", type=" + type
                + ", createdAt='" + createdAt + '\''
                + '}';
    }
}
