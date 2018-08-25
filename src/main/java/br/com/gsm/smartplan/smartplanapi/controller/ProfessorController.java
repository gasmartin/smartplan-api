/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import br.com.gsm.smartplan.smartplanapi.services.ProfessorService;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel San Martin
 */
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    //Retorna dados de um determinado professor através do e-mail.
    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public ResponseEntity<?> getByEmail() { //@PathVariable("email") String email
        Professor professor = professorService.findByEmail();
        if (professor == null) {
            return new ResponseEntity<>("Ficou nulo", HttpStatus.OK);
        }
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    //Retorna dados de um determinado professor.
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(professorService.findById(id), HttpStatus.OK);
    }

    //Retorna todos os professores.
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listOfProfessores() {
        return new ResponseEntity<>(professorService.findAll(), HttpStatus.OK);
    }

//    //Cria um professor
//    @RequestMapping(method = RequestMethod.POST, path = "/cadastrar")
//    public ResponseEntity<?> insert(@Valid @RequestBody Professor professor) {
//        return new ResponseEntity<>(professorService.save(professor), HttpStatus.OK);
//    }
//
//    //Atualiza um determinado professor
//    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
//    public ResponseEntity<?> updateConceito(@PathVariable("id") Long professor_id,
//            @Valid @RequestBody Professor professor_details) {
//
//        Professor professor = professorService.findById(professor_id)
//                .orElseThrow(() -> new ResourceNotFoundException("Professor", "professor", professor_id));
//
//        professor.setNome(professor_details.getNome());
//        professor.setEmail(professor_details.getEmail());
//        professor.setSenha(professor_details.getSenha());
//
//        return new ResponseEntity<>(professorService.save(professor), HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public ResponseEntity<?> deleteProfessor(@PathVariable("id") Long professor_id) {
//        Professor professor = professorService.findById(professor_id)
//                .orElseThrow(() -> new ResourceNotFoundException("Professor", "id", professor_id));
//
//        professorService.delete(professor);
//
//        return ResponseEntity.ok().build();
//    }
}
