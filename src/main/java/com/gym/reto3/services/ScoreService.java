package com.gym.reto3.services;

import com.gym.reto3.entities.Score;
import com.gym.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScoreById(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score c) {
        Optional<Score> cat = scoreRepository.getScore(c.getIdScore());
        if (c.getIdScore() == null || cat.isEmpty()) {
            return scoreRepository.save(c);
        }
        return c;
    }

    public Score update(Score c) {
        Optional<Score> ScoreServer = scoreRepository.getScore(c.getIdScore());
        if (ScoreServer.isPresent() && c.getIdScore() != null) {
            ScoreServer.get().setMessageText(c.getMessageText());
            ScoreServer.get().setStars(c.getStars());
            return scoreRepository.save(ScoreServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Score> ScoreId = scoreRepository.getScore(id);
        if (ScoreId.isPresent()) {
            scoreRepository.delete(ScoreId.get());
            return true;
        }
        return false;
    }
}
