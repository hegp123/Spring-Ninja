package com.g2.service;

import java.util.List;

import com.g2.entity.Course;

public interface CourseService {

    public abstract List<Course> listAllCourses();

    public abstract Course addCourse(Course course);

    public abstract int removeCourse(int id);

    public abstract Course updateCourse(Course course);

}
