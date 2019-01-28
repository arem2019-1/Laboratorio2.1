/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2arem;

import java.util.LinkedList;
import static spark.Spark.*;

public class HelloWorld {

    private static calcul proc = new calcul();

    private static LinkedList<Double> datos = new LinkedList<Double>();
    private static Double media;

    public static void main(String[] args) {
        //get("/hello", (req, res) -> "Hello World");
        
        get("/hello/:name", (request, response) -> {
            String g=request.params(":name");
            //proc.addDato(g);
            //Double num= Double.parseDouble(g);
            //System.out.println("miremos"+proc.prueba());
            //System.out.println("miremos "+g+"el año"+request.params(":age"));
            return 1.0;
        });


        get("/get/media", (request, response) -> {
            String g=request.params(":name");
            //Double num= Double.parseDouble(g);
            System.out.println("miremos"+proc.prueba());
            System.out.println("miremos "+g+"el año"+request.params(":age"));
            return proc.media();
        });        
        
        get("/get/dv/:media", (request, response) -> {
            String g=request.params(":media");
            //Double num= Double.parseDouble(g);
            System.out.println("miremos"+proc.prueba());
            System.out.println("miremos "+g+"el año"+request.params(":age"));
            return proc.dat();
        });                
        /**
        path("/hello", () -> {

            path("/put", () -> {
                get("/dt/:name", (request, response) -> {
                    String g = request.params(":name");
                    System.out.println("que va ver"+g);
                    //Double num= Double.parseDouble(g);
                    //datos.add(num);
                    //System.out.println("haber "+datos.isEmpty());
                    //System.out.println("numero "+num);                    
                    
                    
                    return "Hello";
                
                
                });
                
            });
            path("/media", () -> {
                get("/md", (req, res) -> "good");
                
            });
        });
*/
    }
}
