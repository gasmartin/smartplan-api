/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Nota;
import br.com.gsm.smartplan.smartplanapi.repository.NotaRepository;
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
@RequestMapping("/api")
public class NotaController {
    
    @Autowired
    private NotaRepository notaRepository;

    //Retorna dados de uma determinada nota.
    @RequestMapping(method = RequestMethod.GET, path = "/nota/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(notaRepository.findById(id), HttpStatus.OK);
    }

    //Retorna todas as notas.
    @RequestMapping(method = RequestMethod.GET, path = "/nota")
    public ResponseEntity<?> listOfNotas() {
        return new ResponseEntity<>(notaRepository.findAll(), HttpStatus.OK);
    }

    //Cria uma nota.
    @RequestMapping(method = RequestMethod.POST, path = "/nota/insert")
    public ResponseEntity<?> insertNota(@Valid @RequestBody Nota nota) {
        return new ResponseEntity<>(notaRepository.save(nota), HttpStatus.OK);
    }

    //Atualiza uma determinada nota.
    @RequestMapping(method = RequestMethod.PUT, path = "/nota/{id}")
    public ResponseEntity<?> updateNota(@PathVariable("id") Long nota_id,
            @Valid @RequestBody Nota nota_details) {
        
        Nota nota = notaRepository.findById(nota_id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota", "nota", nota_id));
        
        nota.setNota(nota_details.getNota());
        
        return new ResponseEntity<>(notaRepository.save(nota), HttpStatus.OK);
    }

    //Deleta uma nota.
    @RequestMapping(method = RequestMethod.DELETE, path = "/nota/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable("id") Long nota_id) {
        Nota nota = notaRepository.findById(nota_id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota", "id", nota_id));
        
        notaRepository.delete(nota);
        
        return ResponseEntity.ok().build();
    }
}
