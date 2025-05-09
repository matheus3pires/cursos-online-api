package br.com.pires.atividade.jdbc.service;

import br.com.pires.atividade.jdbc.model.Curso;
import br.com.pires.atividade.jdbc.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void save(Curso curso) {
        if (curso.getDuracaoHoras() <= 0) {
            throw new IllegalArgumentException("A duração do curso deve ser positiva.");
        }
        cursoRepository.save(curso);
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public void update(Curso curso) {
        if (curso.getDuracaoHoras() <= 0) {
            throw new IllegalArgumentException("A duração do curso deve ser positiva.");
        }
        cursoRepository.update(curso);
    }

    public void delete(Long id) {
        cursoRepository.delete(id);
    }

    public List<Curso> findByInstrutorId(Long instrutorId) {
        return cursoRepository.findByInstrutorId(instrutorId);
    }

    public List<Curso> findWithFilters(String titulo, Double duracaoMin, Double duracaoMax, Long instrutorId) {
        return cursoRepository.findWithFilters(titulo, duracaoMin, duracaoMax, instrutorId);
    }

    @Transactional(rollbackOn = Exception.class)
    public void createCursoWithLog(Curso curso) {
        if (curso.getDuracaoHoras() <= 0) {
            throw new IllegalArgumentException("A duração do curso deve ser positiva.");
        }

        cursoRepository.save(curso);
    }

    public void batchInsert(List<Curso> cursos) {
        cursoRepository.batchInsert(cursos);
    }
}
