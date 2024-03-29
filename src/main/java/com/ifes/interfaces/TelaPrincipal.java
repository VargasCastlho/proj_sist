/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.interfaces;
import com.ifes.entidade.Fabricante;
import com.ifes.entidade.ModeloAeronave;
import com.ifes.controller.FabricanteController;
import com.ifes.controller.ModeloAeronaveController;
import com.ifes.repository.FabricanteRepository;
import com.ifes.repository.ModeloAeronaveRepository;
import com.ifes.repository.MyConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2021122760232
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    private FabricanteController fabricanteController = new FabricanteController();
    private ModeloAeronaveController modeloAeronaveController = new ModeloAeronaveController();
    
    
    public TelaPrincipal() {
        initComponents();
        panelModeloAeronave.setVisible(false);
        panelFabricante.setVisible(false);
        
        this.initLayoutFabricante();
        this.initLayoutModeloAeronave();
       
    }
    
    private void initLayoutFabricante(){
        this.loadComboboxPaisOrigem();
        this.loadTableFabricante();
    }
    
    private void initLayoutModeloAeronave(){
        this.loadTableModeloAeronave();
        this.loadComboboxFabricante();
    }
    
    private void loadComboboxPaisOrigem(){
        String[] paises = { "Estados Unidos", "Canadá", "Brasil"};
        paisOrigemCombobox.setModel(new javax.swing.DefaultComboBoxModel(paises));
    }
    
    private void loadComboboxFabricante(){
        ArrayList<Fabricante> fabricantes = this.fabricanteController.getAllFabricantes();;
        
        String[] versoesWindows = { "Selecione um fabricante"};
        fabricanteCombobox.setModel(new javax.swing.DefaultComboBoxModel(versoesWindows));
        
        if(fabricantes != null && !fabricantes.isEmpty()){
            fabricantes.stream().forEach( fab -> {
                fabricanteCombobox.addItem(fab.getNome());
            });
        }
        
    }
    
    private void loadTableModeloAeronave( ){
        Object[] colunas = {"Nome", "Capacidade de Carga", "Fabricante", "Capacidade de passageiros", "Autonomia"};
        DefaultTableModel model = model = new DefaultTableModel(colunas, 0);

        ArrayList<ModeloAeronave> modelos = this.modeloAeronaveController.getAllModelosAeronaves();
        if(modelos != null && !modelos.isEmpty()){
            for(int i = 0; i < modelos.size(); i++){
                ModeloAeronave modelo = modelos.get(i);
                Object row = new Object[]{modelo.getNome(), modelo.getCapPassageiros(), modelo.getFabricante().getNome(), modelo.getCapCargas(), modelo.getAutonomia()};
                model.addRow((Object[]) row);
            }  
        }
        
        tableModeloAeronave.setModel(model);
    }
    
    private void loadTableFabricante()   {
        Object[] colunas = {"Nome", "País de Origem"};
        DefaultTableModel model = model = new DefaultTableModel(colunas, 0);
           
         ArrayList<Fabricante>  fabricantes = this.fabricanteController.getAllFabricantes();
        
        if(fabricantes != null && !fabricantes.isEmpty()){
            for(int i = 0; i < fabricantes.size(); i++){
                Fabricante fabricante = fabricantes.get(i);
                Object row = new Object[]{fabricante.getNome(), fabricante.getPais()};
                model.addRow((Object[]) row);
            }
        }
        
        tableFabricante.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        popUpFabricante = new javax.swing.JPopupMenu();
        editarFabricante = new javax.swing.JMenuItem();
        excluirFabricante = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        panelModeloAeronave = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeModeloAeronave = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        capacidade_de_carga = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        fabricanteCombobox = new javax.swing.JComboBox<>();
        labelCpP = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cadastrarModeloAeronave = new javax.swing.JButton();
        autonomia = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableModeloAeronave = new javax.swing.JTable();
        cap_de_passageiros = new javax.swing.JSpinner();
        panelFabricante = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nomeFabricante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        paisOrigemCombobox = new javax.swing.JComboBox<>();
        CadastrarFabricante = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFabricante = new javax.swing.JTable();
        navBar = new javax.swing.JMenuBar();
        eventCadastrarModeloAeronave = new javax.swing.JMenu();
        eventCadastrarFabricante = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        editarFabricante.setText("Editar");
        popUpFabricante.add(editarFabricante);

        excluirFabricante.setText("Excluir");
        excluirFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirFabricanteMouseClicked(evt);
            }
        });
        popUpFabricante.add(excluirFabricante);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        panelModeloAeronave.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar Modelo de Aeronave"));
        panelModeloAeronave.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nome: ");

        jLabel3.setText("Capacidade de Carga: ");

        capacidade_de_carga.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        capacidade_de_carga.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setText("Fabricante:");

        fabricanteCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricanteComboboxActionPerformed(evt);
            }
        });

        labelCpP.setText("Capacidade de passageiros: ");

        jLabel6.setText("Autonomia: ");

        cadastrarModeloAeronave.setBackground(new java.awt.Color(102, 255, 102));
        cadastrarModeloAeronave.setText("Cadastrar");
        cadastrarModeloAeronave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarModeloAeronaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarModeloAeronaveMouseEntered(evt);
            }
        });
        cadastrarModeloAeronave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarModeloAeronaveActionPerformed(evt);
            }
        });

        tableModeloAeronave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableModeloAeronave);

        javax.swing.GroupLayout panelModeloAeronaveLayout = new javax.swing.GroupLayout(panelModeloAeronave);
        panelModeloAeronave.setLayout(panelModeloAeronaveLayout);
        panelModeloAeronaveLayout.setHorizontalGroup(
            panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastrarModeloAeronave)
                    .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeModeloAeronave))
                        .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fabricanteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(autonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                        .addComponent(labelCpP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cap_de_passageiros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capacidade_de_carga)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGap(14, 14, 14)))
        );
        panelModeloAeronaveLayout.setVerticalGroup(
            panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModeloAeronaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeModeloAeronave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(capacidade_de_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fabricanteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(autonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCpP)
                    .addComponent(cap_de_passageiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(cadastrarModeloAeronave)
                .addContainerGap(217, Short.MAX_VALUE))
            .addGroup(panelModeloAeronaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModeloAeronaveLayout.createSequentialGroup()
                    .addContainerGap(141, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)))
        );

        panelFabricante.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Fabricante"));

        jLabel7.setText("Nome: ");

        jLabel8.setText("País de Origem: ");

        CadastrarFabricante.setBackground(new java.awt.Color(51, 255, 51));
        CadastrarFabricante.setText("Cadastrar");
        CadastrarFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CadastrarFabricanteMouseClicked(evt);
            }
        });
        CadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarFabricanteActionPerformed(evt);
            }
        });

        tableFabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFabricante.setComponentPopupMenu(popUpFabricante);
        tableFabricante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFabricanteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableFabricante);

        javax.swing.GroupLayout panelFabricanteLayout = new javax.swing.GroupLayout(panelFabricante);
        panelFabricante.setLayout(panelFabricanteLayout);
        panelFabricanteLayout.setHorizontalGroup(
            panelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFabricanteLayout.createSequentialGroup()
                .addGroup(panelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFabricanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paisOrigemCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFabricanteLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(CadastrarFabricante))
                    .addGroup(panelFabricanteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelFabricanteLayout.setVerticalGroup(
            panelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFabricanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(paisOrigemCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(CadastrarFabricante)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navBar.setBackground(new java.awt.Color(204, 255, 204));
        navBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navBarMouseClicked(evt);
            }
        });

        eventCadastrarModeloAeronave.setText("Cadastrar Modelos de Aeronave");
        eventCadastrarModeloAeronave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventCadastrarModeloAeronaveMouseClicked(evt);
            }
        });
        navBar.add(eventCadastrarModeloAeronave);

        eventCadastrarFabricante.setText("Cadastrar Fabricante");
        eventCadastrarFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventCadastrarFabricanteMouseClicked(evt);
            }
        });
        navBar.add(eventCadastrarFabricante);

        setJMenuBar(navBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelModeloAeronave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelModeloAeronave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fabricanteComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabricanteComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteComboboxActionPerformed

    private void cadastrarModeloAeronaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarModeloAeronaveActionPerformed
        ModeloAeronave modelo = new ModeloAeronave();
        modelo.setNome(nomeModeloAeronave.getText());
        modelo.setCapCargas(Double.parseDouble(capacidade_de_carga.getValue().toString()));
        modelo.setCapPassageiros(Integer.parseInt(cap_de_passageiros.getValue().toString()));
        modelo.setAutonomia(Double.parseDouble(autonomia.getValue().toString()));
        Fabricante fabricante = null;
        
        ArrayList<Fabricante>  fabricantes = this.fabricanteController.getAllFabricantes();
        if(fabricantes != null && !fabricantes.isEmpty()){
            for(int i = 0; i < fabricantes.size(); i++){
                Fabricante fab = fabricantes.get(i);
                if(fabricanteCombobox.getModel().getSelectedItem().equals(fab.getNome())){
                    fabricante = new Fabricante();
                    fabricante.setIdFabricante(fab.getIdFabricante());
                }
            }
        }
        
        modelo.setFabricante(fabricante);
        
        boolean inserirDado = this.validateCamposModeloAeronave(modelo);
        if(inserirDado){
            ModeloAeronave result = this.modeloAeronaveController.insertModeloAeronave(modelo);
            this.loadTableModeloAeronave();
            if(result != null){
                this.createPopUp("Registro inserido com sucesso!!");
                this.limparCamposModelosAeronave();
            }else{
                this.createPopUp("Não foi possivel inserir esse registro. ");
            }
        }          
    }//GEN-LAST:event_cadastrarModeloAeronaveActionPerformed
    
    private Fabricante getRowAtFabricante(int row) {
         String[] result = new String[2];
         Fabricante fabricante = new Fabricante();
         fabricante.getNome(tableFabricante.getModel().getValueAt(row, 1).toString());
         fabricante.getPais(tableFabricante.getModel().getValueAt(row, 2).toString());
         return fabricante;
    }
    
    private void navBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBarMouseClicked
        
    }//GEN-LAST:event_navBarMouseClicked

    private void eventCadastrarFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventCadastrarFabricanteMouseClicked
         if(eventCadastrarFabricante.getModel().isSelected()){
            panelFabricante.setVisible(true);
            panelModeloAeronave.setVisible(false);
        }
    }//GEN-LAST:event_eventCadastrarFabricanteMouseClicked

    private void eventCadastrarModeloAeronaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventCadastrarModeloAeronaveMouseClicked
        if(eventCadastrarModeloAeronave.getModel().isSelected()){
            panelModeloAeronave.setVisible(true);
            panelFabricante.setVisible(false);
            this.initLayoutModeloAeronave();
        }
    }//GEN-LAST:event_eventCadastrarModeloAeronaveMouseClicked
    private boolean validateCamposModeloAeronave(ModeloAeronave modelo){
        //nome
        boolean openModal = false;
        if(modelo.getNome().isEmpty()) {
            openModal = true;
        }else if(modelo.getCapCargas() == 0){
            openModal = true;
        }else if(modelo.getCapPassageiros() == 0){
            openModal = true;
        }else if(modelo.getAutonomia() == 0){
            openModal = true;
        }else if(modelo.getFabricante() == null){
             openModal = true;
        }
        
        if(openModal){
           this.createPopUp("Preencha todos os campos, por favor!!"); 
        }
        
        return !openModal;
    }
    
    private void createPopUp(String label){
        PopUp dialog = new PopUp(this, true);
        dialog.setLabel(label);
        dialog.setVisible(true); 
    }
    private void CadastrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarFabricanteActionPerformed

       
    }//GEN-LAST:event_CadastrarFabricanteActionPerformed
   
    
    //retorna true se caso inseriu todos os campos, false se não
    private boolean validateCamposObrigatoriosFabricante(){
        boolean openModal = false;
        boolean result = false;
        //inseriu o nome
        if(!"".equals(nomeModeloAeronave.getText())){
             
        }else{
           openModal = true;
        }
        
        return result;
    }
    
    private void cadastrarModeloAeronaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarModeloAeronaveMouseClicked

    }//GEN-LAST:event_cadastrarModeloAeronaveMouseClicked

    private void CadastrarFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarFabricanteMouseClicked
      
       Fabricante result = this.fabricanteController.insertFabricante(nomeFabricante.getText(), paisOrigemCombobox.getSelectedItem().toString());
        if(result != null){
            this.createPopUp("Registro inserido com sucesso");
        }else{
            this.createPopUp("Não foi possivel inserir esse registro");
        
        }
        this.loadTableFabricante();
    }//GEN-LAST:event_CadastrarFabricanteMouseClicked

    private void cadastrarModeloAeronaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarModeloAeronaveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarModeloAeronaveMouseEntered

    private void tableFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFabricanteMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableFabricanteMouseClicked

    private void excluirFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirFabricanteMouseClicked
        
    }//GEN-LAST:event_excluirFabricanteMouseClicked
    
    private void limparCamposModelosAeronave(){
         nomeModeloAeronave.setText("");
        capacidade_de_carga.setValue(0);
        cap_de_passageiros.setValue(0);
        autonomia.setValue(0);
        fabricanteCombobox.getModel().setSelectedItem(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarFabricante;
    private javax.swing.JSpinner autonomia;
    private javax.swing.JButton cadastrarModeloAeronave;
    private javax.swing.JSpinner cap_de_passageiros;
    private javax.swing.JSpinner capacidade_de_carga;
    private javax.swing.JMenuItem editarFabricante;
    private javax.swing.JMenu eventCadastrarFabricante;
    private javax.swing.JMenu eventCadastrarModeloAeronave;
    private javax.swing.JMenuItem excluirFabricante;
    private javax.swing.JComboBox<String> fabricanteCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCpP;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JTextField nomeFabricante;
    private javax.swing.JTextField nomeModeloAeronave;
    private javax.swing.JComboBox<String> paisOrigemCombobox;
    private javax.swing.JPanel panelFabricante;
    private javax.swing.JPanel panelModeloAeronave;
    private javax.swing.JPopupMenu popUpFabricante;
    private javax.swing.JTable tableFabricante;
    private javax.swing.JTable tableModeloAeronave;
    // End of variables declaration//GEN-END:variables
}
