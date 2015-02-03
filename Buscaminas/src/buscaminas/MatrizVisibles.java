/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buscaminas;

/**
 *
 * @author oscar
 */
public class MatrizVisibles {
    boolean Visibles[][]; 
    
    
   public MatrizVisibles() {
       Visibles= new boolean[5][5]; 
   } 
   
    
   public void visibilizar(Boolean valor){
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                Visibles[y][x] = valor;
            }
        }
    }
   
   
    public boolean isValor(int x, int y) {
        return Visibles[x][y];
    }
    
    
     public void setVisible(int x,int y, boolean b) {
        Visibles[x][y]=b;
    }
     
}
