/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Evento;
import br.com.gsm.smartplan.smartplanapi.model.Planejamento;
import br.com.gsm.smartplan.smartplanapi.repository.EventoRepository;
import br.com.gsm.smartplan.smartplanapi.repository.PlanejamentoRepository;
import java.util.List;
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
public class EventoController {
    
    @Autowired
    private EventoRepository eventoRepository;
    
     @Autowired
    private PlanejamentoRepository planejamentoRepository;

    //Retorna dados de um determinado evento.
    @RequestMapping(method = RequestMethod.GET, path = "/evento/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoRepository.findById(id), HttpStatus.OK);
    }

    //Retorna todos os eventos.
    @RequestMapping(method = RequestMethod.GET, path = "/evento")
    public ResponseEntity<?> listOfEventos() {
        return new ResponseEntity<>(eventoRepository.findAll(), HttpStatus.OK);
    }
    
    //Cria um evento.
    @RequestMapping(method = RequestMethod.POST, path = "/planejamento/{id}/eventos/insert")
    public ResponseEntity<?> insertEvento(@PathVariable("id") Long id, @Valid @RequestBody Evento evento) {
        Planejamento planejamento = planejamentoRepository.findById(id).get();
        List<Evento> evs = planejamento.getEventos();
        evs.add(evento);
        planejamento.setEventos(evs);
        return new ResponseEntity<>(planejamentoRepository.save(planejamento), HttpStatus.OK);
    }

    //Atualiza um determinado evento.
    @RequestMapping(method = RequestMethod.PUT, path = "/evento/{id}")
    public ResponseEntity<?> updateEvento(@PathVariable("id") Long evento_id,
            @Valid @RequestBody Evento evento_details) {

        Evento evento = eventoRepository.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento", "evento", evento_id));
        
        return new ResponseEntity<>(eventoRepository.save(evento), HttpStatus.OK);
    }

    //Deleta um evento.
    @RequestMapping(method = RequestMethod.DELETE, path = "/evento/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable("id") Long evento_id) {
        Evento evento = eventoRepository.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento", "id", evento_id));

        eventoRepository.delete(evento);

        return ResponseEntity.ok().build();
    }
    
    //Retorna eventos de um determinado planejamento.
    @RequestMapping(method = RequestMethod.GET, path = "/planejamento/{id}/eventos")
    public ResponseEntity<?> getAllEventosByPlanejamentoId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(planejamentoRepository.findById(id).get().getEventos(), HttpStatus.OK);
    }
    
}
