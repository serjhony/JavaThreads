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
//Sort Arayüzünden implemente edilen InsertionSort sınıfı
public class InsertionSort implements Sort {
    public void sort(){
        System.out.println("InsertionSort seçildi.");
        
    }
     //InsertionSort sıralmasının mantıksal olarak gerçekleştirilmesi
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
}  
     // Dizinin ekrana basılması için yazılmış fonskiyon
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println("\n"); 
    } 
    
}
    

