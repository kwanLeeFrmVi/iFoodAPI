package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Course_Dish", schema = "dbo", catalog = "I_Food")
public class CourseDishEntity {
    private int id;
    private UUID courseId;
    private UUID dishId;
    private String description;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CourseId")
    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "DishId")
    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDishEntity that = (CourseDishEntity) o;
        return id == that.id &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, dishId, description);
    }
}
