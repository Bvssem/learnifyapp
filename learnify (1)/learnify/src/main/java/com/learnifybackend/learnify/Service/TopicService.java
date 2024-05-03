package com.learnifybackend.learnify.Service;

import com.learnifybackend.learnify.Entities.Topic;
import com.learnifybackend.learnify.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Methods for topic-related operations

    public Topic createTopic(Topic topic) {
        // Perform any necessary validation on the topic object

        // Save the topic to the database using the topicRepository
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long topicId, Topic updatedTopic) {
        // Find the topic by ID using the topicRepository
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        // Update the topic fields with the values from the updatedTopic object

        // Save the updated topic to the database using the topicRepository
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long topicId) {
        // Find the topic by ID using the topicRepository
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        // Delete the topic from the database using the topicRepository
        topicRepository.delete(topic);
    }

    // Additional methods for topic-related operations
}
