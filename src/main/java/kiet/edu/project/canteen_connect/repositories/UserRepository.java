package kiet.edu.project.canteen_connect.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import kiet.edu.project.canteen_connect.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
    
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
}
