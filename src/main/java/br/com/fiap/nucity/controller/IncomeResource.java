package br.com.fiap.nucity.controller;

import br.com.fiap.nucity.model.Income;
import br.com.fiap.nucity.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("income")
public class IncomeResource {
    @Autowired
    private IncomeRepository incomeRepository;

    @GetMapping
    public List<Income> listAll() {
        return incomeRepository.findAll();
    }

    @GetMapping("{id}")
    public Income findById(@PathVariable Integer id) {
        return (Income) incomeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Income create(@RequestBody Income income) {
        return (Income) incomeRepository.save(income);
    }

    @PutMapping("{id}")
    public Income update(@RequestBody Income income, @PathVariable Integer id) {
        income.setId(id);
        return (Income) incomeRepository.save(income);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        incomeRepository.deleteById(id);
    }

    @GetMapping("search")
    public List<Income> search(@RequestParam(required = false) String name) {
        return incomeRepository.findByName(name);
    }
}
