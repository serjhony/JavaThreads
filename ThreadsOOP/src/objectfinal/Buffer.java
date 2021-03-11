/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectfinal;

/**
 *
 * @author serca
 */
public class Buffer  {
   
     private final int[][] array;

    //Buffer constructor sonuç matrisine ilişkin satır ve sütun sayılarını alır ve sonucun yerleşeceği iki boyutu diziyi (sonuç matrisini) bu satır ve sütun sayılarına göre oluşturur
    public Buffer(int row_size, int col_size){
       array = new int[row_size][col_size]; 
    }
    // Buffer için put metodu 
    public synchronized void put(int value,int x,int y){
        
        int position_x = x;
        int posion_y = y;
        array[position_x][posion_y] = value;
    }
    //sonuç matrisinin tümünü yazdırmak için print metodu
    public void print(){
        System.out.println("Sonuç "+resultRow()+"x"+resultCol()+" matrisi: ");
        for (int i = 0; i < resultRow(); i++) {
            for (int j = 0; j < resultCol(); j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public int resultCol(){
        return array[0].length;
    }
    public int resultRow(){
        return array.length;

    }
}

   
   
    

