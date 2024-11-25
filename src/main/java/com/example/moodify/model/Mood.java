package com.example.moodify.model;

import org.springframework.data.annotation.Id;


public class Mood {
    @Id
    private Long id;
    private String song;
    private String moodType;
    private String description;

    public Mood(){

    }

    public Mood(String song, String moodType, String description) {
        this.song = song;
        this.moodType = moodType;
        this.description = description;
    }

    
    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getMoodType() {
        return moodType;
    }

    public void setMoodType(String moodType) {
        this.moodType = moodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}