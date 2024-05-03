package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "instructor_id") // Assuming instructorId is stored in a column named instructor_id
    private Long instructorId;


    // Course Info
    private String title;

    private String slug;

    private String aboutCourse;

    // Course Setting
    private int maximumStudents;

    private String difficultyLevel;

    private boolean isPublicCourse;

    private boolean enableQA;

    // Choose Categories
    private String categories;

    // Course Thumbnail
    @Lob
    @Column(name = "course_thumbnail")
    private byte[] courseThumbnail;

    // Course Intro Video
    private String introVideoPath; // Store local video path or video URL

    // Course Builder - Topic
    @ElementCollection
    @CollectionTable(name = "course_topics", joinColumns = @JoinColumn(name = "course_id"))
    private List<Topic> topics;

    // Additional Information
    private Date startDate;

    private String language;

    private String requirements;

    private String description;

    private int totalCourseDurationHours;

    private int totalCourseDurationMinutes;

    private String courseTags;

    private String targetedAudience;

    // Certificate Template
    @Lob
    @Column(name = "certificate_template")
    private byte[] certificateTemplate;

    // Getters and setters
}