package br.com.pires.atividade.jpa.repository;

import br.com.pires.atividade.jpa.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByTituloContainingIgnoreCase(String titulo);

    List<Curso> findByDuracaoHorasBetween(Double duracaoMin, Double duracaoMax);

    List<Curso> findByInstrutorId(Long instrutorId);

    @Query("SELECT c FROM Curso c WHERE c.instrutor.id = :instrutorId AND c.duracaoHoras >= :duracaoMin")
    List<Curso> buscarPorInstrutorIdEDuracaoMinima(@Param("instrutorId") Long instrutorId, @Param("duracaoMin") Double duracaoMin);

    @Query("SELECT c FROM Curso c JOIN FETCH c.instrutor")
    List<Curso> buscarCursosComInstrutores();
}
