/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JOptionPane;
import modelo.Materiasprimas;
import persistencia.MateriasprimasJpaController;


/**
 *
 * @author Kings
 */
public class logica_fabrica_stock_fabrica {
    MateriasprimasJpaController cMateriasprimas = new MateriasprimasJpaController();
    Materiasprimas cEdit;
    
    int[][] graniplas = { {16, 10}, {5,100}, {6,50}, {7,2}, {8,10}, {4,5}, {11,5}, {12,1}, {14,1}, {15,1} };
    int[][] pintura = { {16, 10}, {3,20}, {10,1}, {9,3}, {11,2}, {12,1}, {13,1}, {4,2}, {14,2}, {15,1} };
    
    public void reducirMP(int a) {
        //Si a es 0 se ejecutara para graniplas
        //Si a es 1 se ejecutara para pintura
        switch (a) {
            case 0:
                for(int i=0; i<graniplas.length; i++){
                    try {
                    cEdit = cMateriasprimas.findMateriasprimas(graniplas[i][0]);
                    cEdit.setMatCatidad(cEdit.getMatCatidad() - graniplas[i][1]);

                    cMateriasprimas.edit(cEdit);
                    System.out.println("Se actualizo");
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString() + "error");
                    }
                }
                break;
            case 1:
                for(int i=0; i<pintura.length; i++){
                    try {
                    cEdit = cMateriasprimas.findMateriasprimas(pintura[i][0]);
                    cEdit.setMatCatidad(cEdit.getMatCatidad() - pintura[i][1]);

                    cMateriasprimas.edit(cEdit);
                    System.out.println("Se actualizo");
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString() + "error");
                    }
                }
                break;
        }

    }
    
    
    
}
