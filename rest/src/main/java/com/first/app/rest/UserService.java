package com.first.app.rest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserDTO> getUsers() throws Exception {
        return userRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public String saveUser(UserDTO userDto) throws Exception {
        userRepo.save(convertToEntity(userDto));
        return "Saved user " + userDto.getFirstName() + " " + userDto.getLastName();
    }

    public String updateUser(long id, UserDTO userDto) throws Exception {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        updateEntityFromDTO(userDto, existingUser);
        userRepo.save(existingUser);
        return "Updated user with id: " + id;
    }
    
    public String deleteUser(long id) throws Exception {
        userRepo.deleteById(id);
        return "Deleted user with id: " + id;
    }

    // Conversion methods
    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName()); 
        dto.setAge(user.getAge());
        dto.setOccupation(user.getOccupation());
        return dto;
    }

    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAge(dto.getAge());
        user.setOccupation(dto.getOccupation());
        return user;
    }

    private void updateEntityFromDTO(UserDTO dto, User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setOccupation(dto.getOccupation());
        
 } 
}