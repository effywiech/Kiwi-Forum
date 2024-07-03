package com.kiwi.api.repository;
import com.kiwi.api.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    boolean existsByTitleAndMessage(String title, String message);

}
