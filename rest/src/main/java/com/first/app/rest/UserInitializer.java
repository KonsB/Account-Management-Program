package com.first.app.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserRepo userRepo;

    public UserInitializer(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if database is empty
        if (userRepo.count() == 0) {
            createUser("John", "Doe", 30, "Software Engineer");
            createUser("Jane", "Smith", 28, "UX Designer");
            createUser("Bob", "Johnson", 35, "Product Manager");
            createUser("Alice", "Williams", 32, "Data Scientist");
            createUser("Mike", "Brown", 40, "DevOps Specialist");
            
            System.out.println("Initial user data loaded successfully!");
        }
    }

    private void createUser(String firstName, String lastName, int age, String occupation) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setOccupation(occupation);
        userRepo.save(user);
    }
}