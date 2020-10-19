package com.example.alumno.controller;

import com.example.alumno.entities.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")

public class AlumnoController extends BaseControllerImpl<Alumno, AlumnoServiceImpl>{
}
