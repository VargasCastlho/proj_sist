/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.controller;

import com.ifes.entidade.Fabricante;
import com.ifes.repository.FabricanteRepository;
import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;
import java.util.ArrayList;
import service.FabricanteService;

/**
 *
 * @author 2022222760011
 */
public class FabricanteController {
    
   
    private FabricanteService fabricanteService = new FabricanteService();
    
    public ArrayList<Fabricante> getAllFabricantes() {
        ArrayList<Fabricante> result = this.fabricanteService.findAllFabricantes();
        return result;
    }
    
    public Fabricante insertFabricante(Fabricante fabricante){
        Fabricante result = this.fabricanteService.insertFabricante(fabricante);
        return result;
    }
    
    
}
