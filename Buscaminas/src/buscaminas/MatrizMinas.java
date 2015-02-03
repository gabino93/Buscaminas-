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
public class MatrizMinas {
    
    private int Valores[][];
    
    public MatrizMinas() {
        Valores  = new int [5][5];
        limpiarMinas(); 
    }
    
    public void limpiarMinas() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                Valores[y][x] = 0;
            }
        }
    }
    
    public void colocarMinas() {
        limpiarMinas();
        int x, y;
        for (int i = 0; i < 5; i++) {
            do {
                y = (int) (Math.random() * 5);
                x = (int) (Math.random() * 5);
            } while (Valores[y][x] != 0);
            Valores[x][y] = 4;
        }
    }
    
    public int getMina(int y, int x) {
        return Valores[y][x];
    }
    
    public void calcularMinas() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (Valores[y][x] == 4) {
                    for (int y2 = y - 1; y2 <= y + 1; y2++) {
                        for (int x2 = x - 1; x2 <= x + 1; x2++) {
                            if (y2 >= 0 && y2 < 5 && x2 >= 0 && x2 < 5 && Valores[y2][x2] != 4) {
                                Valores[y2][x2]++;
                            }
                        }
                    }
                }
            }
        }
    }

}
