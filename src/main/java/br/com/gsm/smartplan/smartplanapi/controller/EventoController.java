/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Evento;
import br.com.gsm.smartplan.smartplanapi.model.Turma;
import br.com.gsm.smartplan.smartplanapi.repository.EventoRepository;
import br.com.gsm.smartplan.smartplanapi.repository.TurmaRepository;
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
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    //Retorna dados de um determinado evento.
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoRepository.findById(id), HttpStatus.OK);
    }

    //Retorna todos os eventos.
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listOfEventos() {
        return new ResponseEntity<>(eventoRepository.findAll(), HttpStatus.OK);
    }

    //Cria um evento.
    @RequestMapping(method = RequestMethod.POST, path = "/cadastrar")
    public ResponseEntity<?> insertEvento(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<>(eventoRepository.save(evento), HttpStatus.OK);
    }

    //Atualiza um determinado evento.
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<?> updateEvento(@PathVariable("id") Long evento_id,
            @Valid @RequestBody Evento evento_details) {

        Evento evento = eventoRepository.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento", "evento", evento_id));
        
        

        return new ResponseEntity<>(eventoRepository.save(evento), HttpStatus.OK);
    }

    //Deleta um evento.
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable("id") Long evento_id) {
        Evento evento = eventoRepository.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento", "id", evento_id));

        eventoRepository.delete(evento);

        return ResponseEntity.ok().build();
    }
}
