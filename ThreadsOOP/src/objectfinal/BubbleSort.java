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
//Sort Arayüzünden implemente edilen BubbleSort sınıfı
public class BubbleSort implements Sort {
    public void sort(){
        System.out.println("BubbleSort seçildi.");
    }
    //BubbleSort sıralmasının mantıksal olarak gerçekleştirilmesi
    void bubbleSort(int[] arr) {
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    }
    // Dizinin ekrana basılması için yazılmış fonskiyon
    void printArray(int[] arr) {
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println("\n"); 
    } 
}
