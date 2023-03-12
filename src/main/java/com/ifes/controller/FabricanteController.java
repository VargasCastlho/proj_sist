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
import javax.xml.ws.Response;

/**
 *
 * @author 2022222760011
 */
public class FabricanteController {
    
    private FabricanteRepository fabricanteRepository = new FabricanteRepository();
    
    /*public Response getAllFabricantes() {
        ArrayList<Fabricante> result = this.fabricanteRepository.findAll();
        
        return Response.status(result.size() > 0 ? Response.Status.OK : Response.Status.NO_CONTENT).entity(result).build();
    }*/
}
