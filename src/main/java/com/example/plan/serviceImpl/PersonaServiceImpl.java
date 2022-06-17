
package com.example.plan.serviceImpl;
import com.example.plan.model.Persona;
import com.example.plan.repository.PersonaRepository;
import com.example.plan.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository batisRepository;

    @Override
    public List<Persona> findAll() {
        return batisRepository.findAll();
    }

    @Override
    public Persona findById(long id) {
        return batisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
         return batisRepository.deleteById(id);
    }

    @Override
    public int insert(Persona persona) {
        return batisRepository.insert(persona);
    }

    @Override
    public int update(Persona persona) {
         return batisRepository.update(persona);
    }
}
