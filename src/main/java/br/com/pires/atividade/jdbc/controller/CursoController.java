package br.com.pires.atividade.jdbc.controller;

import br.com.pires.atividade.jdbc.service.CursoService;
import br.com.pires.atividade.jdbc.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jdbc/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<String> createCurso(@RequestBody Curso curso) {
        cursoService.save(curso);
        return ResponseEntity.ok("Curso criado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id);
        cursoService.update(curso);
        return ResponseEntity.ok("Curso atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.ok("Curso deletado com sucesso!");
    }

    @GetMapping("/filtros")
    public ResponseEntity<List<Curso>> getCursosByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Double duracaoMin,
            @RequestParam(required = false) Double duracaoMax,
            @RequestParam(required = false) Long instrutorId) {
        List<Curso> cursos = cursoService.findWithFilters(titulo, duracaoMin, duracaoMax, instrutorId);
        return ResponseEntity.ok(cursos);
    }
}
