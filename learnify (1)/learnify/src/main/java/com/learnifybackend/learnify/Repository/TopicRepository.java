package com.learnifybackend.learnify.Repository;

import com.learnifybackend.learnify.Entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    // Additional custom methods can be defined here
}
