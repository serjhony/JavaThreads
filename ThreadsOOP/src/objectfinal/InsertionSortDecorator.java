/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectfinal;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static objectfinal.InsertionSort.printArray;

/**
 *
 * @author serca
 */
public class InsertionSortDecorator extends SortDecorator{
     public InsertionSortDecorator(Sort decoratedSort) {
        super(decoratedSort);
    }
    
    @Override
    public void sort(){
        decoratedSort.sort();
         try {
             setInsertion(decoratedSort);
         } catch (InterruptedException ex) {
             Logger.getLogger(InsertionSortDecorator.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     //Insertion sort için dizinin oluşturulması ve sıralanmasını yapan fonksiyon, bu süre içinde geçen zaman da currentTimeMilis ile ölçülür.
    private void setInsertion(Sort decoratedSort) throws InterruptedException{
        int arr[] = { 64, 34, 25, 12, 22, 11, 90, 5, 72, 24, 45, 19, 12, 2, 66, 74, 29, 99, 42, 3, 84, 37, 1, 91, 26, 71, 8, 55}; 
        System.out.println("İlk Hali");
        System.out.println(Arrays.toString(arr));
        InsertionSort ob = new InsertionSort(); 
        ob.sort(arr); 
        System.out.println("Düzenlenmiş Hali"); 
        printArray(arr); 
        long startTime = System.currentTimeMillis();
        //1 saniyelik uyku
        TimeUnit.SECONDS.sleep(1);
        long endTime = System.currentTimeMillis();
 
        long timeElapsed = endTime - startTime;
 
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        
    }
}

