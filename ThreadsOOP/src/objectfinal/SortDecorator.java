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
public class SortDecorator implements Sort {
    protected Sort decoratedSort;
    
    public SortDecorator(Sort decoratedSort){
        this.decoratedSort=decoratedSort;
    }
    @Override
    public void sort() {
        decoratedSort.sort();
    }
    
}
