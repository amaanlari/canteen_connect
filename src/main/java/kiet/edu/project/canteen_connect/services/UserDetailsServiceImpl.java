 package kiet.edu.project.canteen_connect.services;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;

 import kiet.edu.project.canteen_connect.models.User;
 import kiet.edu.project.canteen_connect.repositories.UserRepository;
 import org.springframework.stereotype.Service;

 @Service
 public class UserDetailsServiceImpl implements UserDetailsService{

     @Autowired
     private UserRepository userRepository;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
         return org.springframework.security.core.userdetails.User
             .builder()
             .username(user.getEmail())
             .password(user.getPassword())
             .roles(user.getRole().name())
             .build();
     }

 }
