package br.com.fiap.nucity.controller;

import br.com.fiap.nucity.model.User;
import br.com.fiap.nucity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return (User) userRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        return (User) userRepository.save(user);
    }

    @PutMapping("{id}")
    public User update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        return (User) userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("search")
    public List<User> search(@RequestParam(required = false) String username) {
        return userRepository.findByUsername(username);
    }
}
