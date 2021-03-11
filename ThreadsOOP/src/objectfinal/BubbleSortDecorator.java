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


/**
 *
 * @author serca
 */
public class BubbleSortDecorator extends SortDecorator {
    public BubbleSortDecorator(Sort decoratedSort) {
        super(decoratedSort);
    }
    
    @Override
    public void sort(){
        decoratedSort.sort();
        try {
            setBubble(decoratedSort);
        } catch (InterruptedException ex) {
            Logger.getLogger(BubbleSortDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Bubble sort için dizinin oluşturulması ve sıralanmasını yapan fonksiyon, bu süre içinde geçen zaman da currentTimeMilis ile ölçülür.
    private void setBubble(Sort decoratedSort) throws InterruptedException{
        BubbleSort ob = new BubbleSort(); 
        int arr[] = {64, 34, 25, 12, 22, 11, 90, 5, 72, 24, 45, 19, 12, 2, 66, 74, 29, 99, 42, 3, 84, 37, 1, 91, 26, 71, 8, 55}; 
        System.out.println("İlk Hali:");
        System.out.println(Arrays.toString(arr));
        ob.bubbleSort(arr); 
        System.out.println("Düzenlenmiş Hali:"); 
        ob.printArray(arr);   
        
        long startTime = System.currentTimeMillis();
        //1 saniyelik uyku
        TimeUnit.SECONDS.sleep(1);
        long endTime = System.currentTimeMillis();
 
        long timeElapsed = endTime - startTime;
 
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        
    }
    
}
