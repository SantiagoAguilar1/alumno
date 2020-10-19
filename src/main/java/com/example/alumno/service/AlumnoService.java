package com.example.alumno.service;

import com.example.alumno.entities.Alumno;
import com.example.alumno.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService implements BaseService <Alumno>{

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    @Transactional
    public List<Alumno> findAll() throws Exception {
        try {
            List<Alumno> entities = alumnoRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno findById(Long id) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno save(Alumno entity) throws Exception {
        try {
            entity = alumnoRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno update(Long id, Alumno entity) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            Alumno alumno = entityOptional.get();
            alumno = alumnoRepository.save(alumno);
            return alumno;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (alumnoRepository.existsById(id)){
                alumnoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
