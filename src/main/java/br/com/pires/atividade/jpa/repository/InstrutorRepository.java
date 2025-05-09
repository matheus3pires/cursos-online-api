package br.com.pires.atividade.jpa.repository;

import br.com.pires.atividade.jpa.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
}
