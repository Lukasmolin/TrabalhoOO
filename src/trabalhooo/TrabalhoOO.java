/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author izabe
 */
public class TrabalhoOO {
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        String[] arr = new String[10];
        
        for(int i = 0; i < 20; i++){
            l.add("Teste: " + i);
        }
        
        System.out.println("Imprimindo lista:");
        for(String s : l){
            System.out.println(s);
        }
        
        arr = l.subList(0, 10).toArray(arr);
        l.removeAll(l.subList(0, 10));
        
        System.out.println("Imprimindo o array:");
        for(String s : arr){
            System.out.println(s);
        }
        
        System.out.println("Imprimindo a Lista de novo");
        for(String s : l){
            System.out.println(s);
        }
        
        
    }
    
}
