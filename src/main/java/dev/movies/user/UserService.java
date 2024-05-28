package dev.movies.user;

import dev.movies.exceptions.EntityNotFoundException;
import dev.movies.exceptions.ExistingCredentialsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signUpUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            throw new ExistingCredentialsException("Existing username!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Long logInUser(User user) {

        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found!");
        }
        User userToBeAuthenticated = userOptional.get();
        if (!passwordEncoder.matches(user.getPassword(), userToBeAuthenticated.getPassword())) {
            throw new EntityNotFoundException("Wrong password!");
        }
        return userToBeAuthenticated.getId();
    }

}
