package com.learnifybackend.learnify.Service;

import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Methods for course-related operations

    public Course createCourse(Course course) {
        // Perform any necessary validation on the course object

        // Save the course to the database using the courseRepository
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        // Find the course by ID using the courseRepository
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Update the course fields with the values from the updatedCourse object

        // Save the updated course to the database using the courseRepository
        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        // Find the course by ID using the courseRepository
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Delete the course from the database using the courseRepository
        courseRepository.delete(course);
    }

    // Additional methods for course-related operations
}
