package br.com.pires.atividade.jdbc.controller;

import br.com.pires.atividade.jdbc.model.Instrutor;
import br.com.pires.atividade.jdbc.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jdbc/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @PostMapping
    public ResponseEntity<String> createInstrutor(@RequestBody Instrutor instrutor) {
        instrutorService.save(instrutor);
        return ResponseEntity.ok("Instrutor criado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getInstrutorById(@PathVariable Long id) {
        Instrutor instrutor = instrutorService.findById(id);
        return ResponseEntity.ok(instrutor);
    }

    @GetMapping
    public ResponseEntity<List<Instrutor>> getAllInstrutores() {
        List<Instrutor> instrutores = instrutorService.findAll();
        return ResponseEntity.ok(instrutores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInstrutor(@PathVariable Long id, @RequestBody Instrutor instrutor) {
        instrutor.setId(id);
        instrutorService.update(instrutor);
        return ResponseEntity.ok("Instrutor atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstrutor(@PathVariable Long id) {
        instrutorService.delete(id);
        return ResponseEntity.ok("Instrutor deletado com sucesso!");
    }
}
