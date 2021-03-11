/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectfinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static objectfinal.MultiplyWorker.matrixMaker;
//import static objectfinal.MultiplyWorker.readData;

/**
 *
 * @author serca
 */
public class Soru1Deneme {
    //1. Sorunun çalıştırıldığı main sınıfı
    /*NOT** 3x3 matrisinde kod sorunsuz çalışırken 2x3 veya 3x2 durumlarında matrisler 
  ve sonuçlar doğru bir şekilde çalışmasına rağmen ekrana sonuçlardan sonra hata mesajı verilmektedir. Maalesef sebebini çözemedim.   */
     public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException { //İşlemlerin gerçekleştiği main sınıfı
      int[][] matrix1 = matrixMaker("Matrix1.txt"); // matrix1 dosyasından matris oluşumu
      int[][] matrix2 = matrixMaker("Matrix2.txt"); // matrix2 dosyasından matris oluşumu
      System.out.println(Arrays.deepToString(matrix1));
      System.out.println(Arrays.deepToString(matrix2));
      
            // thread havuzu kullanımı
      ExecutorService executorService = Executors.newCachedThreadPool();

      // buffer objesinin oluşturulması ve ilk matrisin satır sayısı kadar thread oluşturulması  
      Buffer sharedLocation = new Buffer(matrix1.length,matrix2[0].length);
         for (int i = 0; i < matrix1.length; i++) {
             System.out.println("Thread " + (i+1) + " çalıştı.");
             executorService.execute(new MultiplyWorker(sharedLocation,matrix1,matrix2,i,matrix1.length));
             
         }  
           
      executorService.shutdown(); 
      System.out.println("Tüm görevler teslim edildi. \n");
      executorService.awaitTermination(1, TimeUnit.MINUTES); 
      System.out.println("Tüm görevler bitti. \n ");
      sharedLocation.print();

      
      
      
   }
         
         
     }

