package com.kiwi.api.controller;

import com.kiwi.api.exception.ResourceNotFoundException;
import com.kiwi.api.topic.Topic;
import com.kiwi.api.topic.TopicData;
import com.kiwi.api.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public void registerTopic(@Valid @RequestBody TopicData topicData) {
        Topic topic = new Topic(
                topicData.title(),
                topicData.message(),
                topicData.date(),
                topicData.status(),
                topicData.author(),
                topicData.course());
        topicRepository.save(topic);
        System.out.println("The topic has been registered");
    }

    @GetMapping("/list")
    public List<TopicData> getAllTopics(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) Integer year,
            @RequestParam(defaultValue = "false") boolean sorted) {
        return topicRepository.findAll().stream()
                .filter(topic -> course == null || topic.getCourse().equals(course))
                .filter(topic -> year == null || topic.getDate().getYear() == year)
                .sorted((t1, t2) -> sorted ? t1.getDate().compareTo(t2.getDate()) : 0)
                .map(topic -> new TopicData(
                        topic.getTitle(),
                        topic.getMessage(),
                        topic.getDate(),
                        topic.getStatus(),
                        topic.getAuthor(),
                        topic.getCourse()))
                .limit(10)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TopicData getTopic(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found with id " + id));
        return new TopicData(
                topic.getTitle(),
                topic.getMessage(),
                topic.getDate(),
                topic.getStatus(),
                topic.getAuthor(),
                topic.getCourse());
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable Long id, @Valid @RequestBody TopicData topicData) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setTitle(topicData.title());
            topic.setMessage(topicData.message());
            topic.setDate(topicData.date());
            topic.setStatus(topicData.status());
            topic.setAuthor(topicData.author());
            topic.setCourse(topicData.course());

            topicRepository.save(topic);
            System.out.println("The topic with ID " + id + " has been updated");
        } else {
            throw new ResourceNotFoundException("Topic not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")//NOT DELETING FROM DATABASE
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setDeleted(true);
            topicRepository.save(topic);
            System.out.println("The topic with ID " + id + " has been deleted");

            return ResponseEntity.ok("Topic with ID " + id + " has been deleted");
        } else {
            throw new ResourceNotFoundException("Topic not found with id " + id);
        }
    }

    @DeleteMapping("/hard-delete/{id}")//DELETING FROM DATABASE
    public ResponseEntity<String> hardDeleteTopic(@PathVariable Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            System.out.println("The topic with ID " + id + " has been permanently deleted from the database");

            return ResponseEntity.ok("Topic with ID " + id + " has been permanently deleted from the database");
        } else {
            throw new ResourceNotFoundException("Topic not found with id " + id);
        }
    }

}
