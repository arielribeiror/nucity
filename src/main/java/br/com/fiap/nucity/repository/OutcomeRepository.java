package br.com.fiap.nucity.repository;

import br.com.fiap.nucity.model.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
    List<Outcome> findByName(String name);
    List<Outcome> findByStartAt(Calendar startAt);
    List<Outcome> findByEndAt(Calendar endAt);
}