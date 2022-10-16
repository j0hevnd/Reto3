package com.gym.reto3.repository;

import com.gym.reto3.entities.Score;
import com.gym.reto3.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository{
        @Autowired
        private ScoreCrudRepository scoreCrudRepository;

        public List<Score> getAll(){
            return (List<Score>) scoreCrudRepository.findAll();
        }

        public Optional<Score> getScore(int id){
            return scoreCrudRepository.findById(id);
        }
        public Score save(Score c){
            return scoreCrudRepository.save(c);
        }
        public void delete(Score c){
            scoreCrudRepository.delete(c);
        }
}
