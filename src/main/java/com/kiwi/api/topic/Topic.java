package com.kiwi.api.topic;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 1000)
    private String message;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String author;
    private String course;
    private boolean deleted = false;

    public Topic() {}

    public Topic(String title, String message, LocalDateTime date, Status status, String author, String course) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.status = status;
        this.author = author;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
