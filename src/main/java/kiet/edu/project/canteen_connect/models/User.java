package kiet.edu.project.canteen_connect.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
public class User {

    @Id
    ObjectId _id;

    @NonNull
    String username;
    
    @NonNull
    String password;
    
    @Indexed(unique = true)
    @NonNull
    String email;
    
    @NonNull
    String phone;
    
    @NonNull
    String address;

    Role role = Role.CONSUMER;

    boolean isOpen = false;

    String image = null;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

}
