package model;

import java.util.Objects;

public class Bug {
    private int id;
    private String description;
    private int userId;

    public Bug(int id, String description, int userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return id == bug.id &&
                userId == bug.userId &&
                Objects.equals(description, bug.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, userId);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
