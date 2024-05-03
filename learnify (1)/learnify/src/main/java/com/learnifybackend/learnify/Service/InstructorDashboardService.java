package com.learnifybackend.learnify.Service;

import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Entities.User;
import com.learnifybackend.learnify.Repository.CourseRepository;
import com.learnifybackend.learnify.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorDashboardService {

    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public InstructorDashboardService(CourseRepository courseRepository, TopicRepository topicRepository) {
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
    }

    public DashboardData getDashboardData(User user) {
        int enrolledCourses = courseRepository.countby(user.getId());
        int activeCourses = courseRepository.countByInstructorIdAndStatus(user.getId(), "ACTIVE");
        int completedCourses = courseRepository.countByInstructorIdAndStatus(user.getId(), "COMPLETED");
        int totalStudents = courseRepository.countDistinctEnrolledStudentsByInstructorId(user.getId());
        int totalCourses = courseRepository.countByInstructorId(user.getId());
        double totalEarnings = courseRepository.sumOfEarningsByInstructorId(user.getId());

        return new DashboardData(enrolledCourses, activeCourses, completedCourses, totalStudents, totalCourses, totalEarnings);
    }

    public Optional<Course> getMyCourses(User user) {
        Optional<Course> courses = courseRepository.findById(user.getId());
        return courses;
    }
}

class DashboardData {
    private int enrolledCourses;
    private int activeCourses;
    private int completedCourses;
    private int totalStudents;
    private int totalCourses;
    private double totalEarnings;

    public DashboardData(int enrolledCourses, int activeCourses, int completedCourses, int totalStudents, int totalCourses, double totalEarnings) {
        this.enrolledCourses = enrolledCourses;
        this.activeCourses = activeCourses;
        this.completedCourses = completedCourses;
        this.totalStudents = totalStudents;
        this.totalCourses = totalCourses;
        this.totalEarnings = totalEarnings;
    }

    // Getters and setters
}