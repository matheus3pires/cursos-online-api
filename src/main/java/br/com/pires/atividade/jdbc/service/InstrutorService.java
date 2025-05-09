package br.com.pires.atividade.jdbc.service;

import br.com.pires.atividade.jdbc.model.Instrutor;
import br.com.pires.atividade.jdbc.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public void save(Instrutor instrutor) {
        if (instrutor.getNome() == null || instrutor.getEmail() == null) {
            throw new IllegalArgumentException("Nome e email do instrutor são obrigatórios.");
        }
        instrutorRepository.save(instrutor);
    }

    public Instrutor findById(Long id) {
        return instrutorRepository.findById(id);
    }

    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }

    public void update(Instrutor instrutor) {
        if (instrutor.getNome() == null || instrutor.getEmail() == null) {
            throw new IllegalArgumentException("Nome e email do instrutor são obrigatórios.");
        }
        instrutorRepository.update(instrutor);
    }

    public void delete(Long id) {
        instrutorRepository.delete(id);
    }
}
