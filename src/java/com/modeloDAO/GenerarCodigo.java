/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modeloDAO;

/**
 *
 * @author antonieta
 */
public class GenerarCodigo {
    int dato;
    String numero;
    
    public String CodigoSerie(int dato){
        this.dato = dato+1;
        if((this.dato>1000)&&(this.dato<=10000)){
            numero=""+this.dato;
        }
        if((this.dato>100)&&(this.dato<=1000)){
            numero="0"+this.dato;
        }
        if((this.dato>10)&&(this.dato<=100)){
            numero="00"+this.dato;
        }
         if(this.dato<10){
            numero="000"+this.dato;
        }
        
        return numero;
    }
}
