package com.example.moodify.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodService {
    
    @Autowired MoodDAO mDao;

    public void inserirMood(Mood mod){
        mDao.inserirMood(mod);
    }

    public List<Map<String, Object>> listarMoods(){
        return mDao.listarMoods();
    }

    public void atualizarMood(int id, Mood mod){
        mDao.atualizarMood(id, mod);
    }

    public List<Map<String, Object>> obterMood(int id){
        return mDao.obterMood(id);
    }

    public void apagarMood(int id){
        mDao.apagarMood(id);
    }

}
