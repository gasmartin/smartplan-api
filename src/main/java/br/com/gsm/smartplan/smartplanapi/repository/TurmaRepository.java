/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.repository;

import br.com.gsm.smartplan.smartplanapi.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gabriel San Martin
 */

@Component
public interface TurmaRepository extends JpaRepository<Turma, Long>{
}
