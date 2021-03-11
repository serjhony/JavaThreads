/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectfinal;

import static com.oracle.jrockit.jfr.DataType.INTEGER;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author serca
 */
public class MultiplyWorker implements Runnable
{ 
  
   private int[][] matrix1;
   private int[][] matrix2;
   int start, N; // başlangıç satırı ve satır sayısı
   private final Buffer sharedLocation; // referans

   // Multiply worker için constructor
   public MultiplyWorker(Buffer sharedLocation,int[][] matrix1, int[][] matrix2, int s,int n) {
        this.sharedLocation = sharedLocation;
       // this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.start = s;
        this.N= n;
   }
 
   // Threadde bulunması gereken ve matris çarpım işleminin mantıksal olarak gerçekleştiği run fonksiyonu
   public void run()                                           
   {
      int Cols = matrix1[0].length;
	for(int i = start;i<N+start && i<Cols;i++)
	    for(int j=0;j<Cols;j++)
		{   int x =0;
		    //sharedLocation.put(0,i,j);
		    for(int k=0;k<Cols;k++)
			x += matrix1[i][k] * matrix2[k][j];
                        sharedLocation.put(x,i,j);
		}  
      
   } 
   // Matrixleri dosyadan okuyup önce geçici bir arrayliste ardından da iki boyutlu bir arraye atan matris oluşturma fonksiyonu
   public static int[][] matrixMaker(String dosya) throws FileNotFoundException{
       int rowCount = 0; 
       ArrayList <String[]> temp = new ArrayList<>();
       FileReader fr= new FileReader(dosya);
       BufferedReader br = new BufferedReader(fr);
       Scanner scanner = new Scanner(br);
       while(scanner.hasNextLine()){
           String row = scanner.nextLine();;
           temp.add(row.split(" "));
           ++rowCount;
       }
       int[][] matrix=new int[temp.size()][];
       for (int i = 0; i < temp.size(); i++) {
           
           int[] satir=new int[temp.get(i).length];
           for (int j = 0; j < satir.length; j++) {
               satir[j]=Integer.parseInt(temp.get(i)[j]);
           }
           matrix[i]=satir;
       }
       return matrix;
   }
} 

    
 
    
    
   

