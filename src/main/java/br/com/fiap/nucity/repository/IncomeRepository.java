package br.com.fiap.nucity.repository;

import br.com.fiap.nucity.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    List<Income> findByName(String name);
    List<Income> findByStartAt(Calendar startAt);
    List<Income> findByEndAt(Calendar endAt);
}