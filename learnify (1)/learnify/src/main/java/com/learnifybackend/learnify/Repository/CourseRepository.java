package com.learnifybackend.learnify.Repository;



import com.learnifybackend.learnify.Entities.Course;

import com.learnifybackend.learnify.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import java.util.List;



@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {



    List<Course> findByInstructor(User instructor);


    int countByInstructor(User instructor);

    int countByInstructorAndStatus(Long instructorId, String status);

    int countDistinctEnrolledStudentsByInstructor(User instructor);



    double sumOfEarningsByInstructor(User instructor);

    double sumOfEarningsByInstructorId(Long id);

    int countByInstructorId(Long id);

    int countDistinctEnrolledStudentsByInstructorId(Long id);

    int countByInstructorIdAndStatus(Long id, String completed);

    int countby(Long id);


    // Add any other methods related to courses and instructors

}