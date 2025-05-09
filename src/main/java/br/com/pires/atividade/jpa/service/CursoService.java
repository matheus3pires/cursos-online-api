package br.com.pires.atividade.jpa.service;

import br.com.pires.atividade.jpa.model.Curso;
import br.com.pires.atividade.jpa.repository.CursoRepository;
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
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + id));
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public void update(Curso curso) {
        if (curso.getDuracaoHoras() <= 0) {
            throw new IllegalArgumentException("A duração do curso deve ser positiva.");
        }
        cursoRepository.save(curso);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    public List<Curso> findByInstrutorId(Long instrutorId) {
        return cursoRepository.findByInstrutorId(instrutorId);
    }

    public List<Curso> findWithFilters(String titulo, Double duracaoMin, Double duracaoMax, Long instrutorId) {
        if (instrutorId != null && duracaoMin != null) {
            return cursoRepository.buscarPorInstrutorIdEDuracaoMinima(instrutorId, duracaoMin);
        } else if (titulo != null) {
            return cursoRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (duracaoMin != null && duracaoMax != null) {
            return cursoRepository.findByDuracaoHorasBetween(duracaoMin, duracaoMax);
        }
        return cursoRepository.findAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public void createCursoWithLog(Curso curso) {
        if (curso.getDuracaoHoras() <= 0) {
            throw new IllegalArgumentException("A duração do curso deve ser positiva.");
        }

        cursoRepository.save(curso);
    }
}
