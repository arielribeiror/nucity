package br.com.fiap.nucity.controller;

import br.com.fiap.nucity.model.Type;
import br.com.fiap.nucity.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("type")
public class TypeResource {
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> listAll() {
        return typeRepository.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Type create(@RequestBody Type type) {
        return (Type) typeRepository.save(type);
    }

    @PutMapping("{id}")
    public Type update(@RequestBody Type type, @PathVariable Integer id) {
        type.setId(id);
        return (Type) typeRepository.save(type);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        typeRepository.deleteById(id);
    }

    @GetMapping("search")
    public List<Type> search(@RequestParam(required = false) String name) {
        return typeRepository.findByName(name);
    }
}
