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

    public static void main(String[] args) {
        port(getPort());
        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        //get("/hello", (req, res) -> "Hello World");
        get("/hello/put/:name", (request, response) -> {
            String g = request.params(":name");
            try {
                Double num = Double.parseDouble(g);
                proc.addDato(num);
                return 1.0;

            } catch (Exception e) {
                System.out.println("" + e);

            }
            return 1.0;
        });

        get("hello/get/media", (request, response) -> {
            //String g=request.params(":name");
            //Double num= Double.parseDouble(g);
            Double tmp = proc.media();
            System.out.println("miremos" + tmp);
            return proc.media();
        });

        get("hello/ad/dv/:media", (request, response) -> {
            String g = request.params(":media");
            Double num= Double.parseDouble(g);
            return proc.db(num);
        });
        get("hello/ad/reset", (request, response) -> {
            proc.reset();
            return "Ok";
        });        
        
        
        /**
         * path("/hello", () -> {
         *
         * path("/put", () -> { get("/dt/:name", (request, response) -> { String
         * g = request.params(":name"); System.out.println("que va ver"+g);
         * //Double num= Double.parseDouble(g); //datos.add(num);
         * //System.out.println("haber "+datos.isEmpty());
         * //System.out.println("numero "+num);          *
         *
         * return "Hello";
         *
         *
         * });
         *
         * }); path("/media", () -> { get("/md", (req, res) -> "good");
         *
         * }); });
         */
    }
    
    
    static int getPort(){
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    
    }
    
    
    

}
