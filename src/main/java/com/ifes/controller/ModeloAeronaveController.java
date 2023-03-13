/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.controller;



import com.ifes.entidade.ModeloAeronave;
import com.ifes.service.ModeloAeronaveService;
import java.util.ArrayList;



/**
 *
 * @author 2022222760011
 */
public class ModeloAeronaveController {
    private ModeloAeronaveService modeloAeronaveService = new ModeloAeronaveService();
    
    public ArrayList<ModeloAeronave> getAllModelosAeronaves() {
        ArrayList<ModeloAeronave> result = this.modeloAeronaveService.findAllModelosAeronaves();
        return result;
    }
    
    public ModeloAeronave insertModeloAeronave(ModeloAeronave modelo){
        ModeloAeronave result = this.modeloAeronaveService.insertModeloAeronave(modelo);
        return result;
    }
}
