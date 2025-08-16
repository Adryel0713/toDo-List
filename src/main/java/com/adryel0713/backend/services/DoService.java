package com.adryel0713.backend.services;

import com.adryel0713.backend.model.Do;
import com.adryel0713.backend.repositories.DoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DoService {

    private final DoRepository repository;

    public DoService(DoRepository repository) {
        this.repository = repository;
    }

    public Optional<Do> findById(Long id) { // buscar 1
        return repository.findById(id);
    }
    public List<Do> findAll() { // buscar todos
        return repository.findAll();
    }
    public Do save(Do doDo){ // salvar
        return repository.save(doDo);
    }
    public Do edit(Do doDo){ // Editar (vou por o id no controller)
        return repository.save(doDo);
    }
    public void delete(Long id){ // Deletar por Id
        repository.deleteById(id);
    }

}
