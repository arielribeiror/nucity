package br.com.fiap.nucity.controller;

import br.com.fiap.nucity.model.Outcome;
import br.com.fiap.nucity.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("outcome")
public class OutcomeResource {
    @Autowired
    private OutcomeRepository outcomeRepository;

    @GetMapping
    public List<Outcome> listAll() {
        return outcomeRepository.findAll();
    }

    @GetMapping("{id}")
    public Outcome findById(@PathVariable Integer id) {
        return (Outcome) outcomeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Outcome create(@RequestBody Outcome outcome) {
        return (Outcome) outcomeRepository.save(outcome);
    }

    @PutMapping("{id}")
    public Outcome update(@RequestBody Outcome outcome, @PathVariable Integer id) {
        outcome.setId(id);
        return (Outcome) outcomeRepository.save(outcome);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        outcomeRepository.deleteById(id);
    }

    @GetMapping("search")
    public List<Outcome> search(@RequestParam(required = false) String name) {
        return outcomeRepository.findByName(name);
    }
}
