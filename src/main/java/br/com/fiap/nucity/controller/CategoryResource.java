package br.com.fiap.nucity.controller;

import br.com.fiap.nucity.model.Category;
import br.com.fiap.nucity.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryResource {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Category findById(@PathVariable Integer id) {
        return (Category) categoryRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Category create(@RequestBody Category category) {
        return (Category) categoryRepository.save(category);
    }

    @PutMapping("{id}")
    public Category update(@RequestBody Category category, @PathVariable Integer id) {
        category.setId(id);
        return (Category) categoryRepository.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
    }

    @GetMapping("search")
    public List<Category> search(@RequestParam(required = false) String name) {
        return categoryRepository.findByName(name);
    }

}
