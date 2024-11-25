package com.example.moodify.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MoodDAO {
    @Autowired DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirMood(Mood mod){
        String sql = "INSERT INTO mood(song, moodType, description)" +
        " VALUEs (?,?,?)";
        Object[] obj = new Object[3];
        obj[0] = mod.getSong();
        obj[1] = mod.getMoodType();
        obj[2] = mod.getDescription();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarMoods(){
        String sql = "SELECT * FROM mood";
        return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterMood(int id){
        String sql = "SELECT * mood where id = ?";
        Object[] obj = new Object[1];
        obj[0]= id;
        return jdbc.queryForList(sql,obj);
    }

    public void atualizarMood(int id, Mood mod){
        String sql = "UPDATE mood SET song = ?," + "moodType = ?," + "description = ? WHERE id = ?";
        Object[] obj = new Object[4];
        obj[0] = mod.getSong();
        obj[1] = mod.getMoodType();
        obj[2] = mod.getDescription();
        obj[3] = id;
        jdbc.update(sql, obj);
    }

    public void apagarMood(int id){
        String sql = "DELETE FROM mood WHERE id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql, obj);
    }
                       
}
