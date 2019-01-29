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
//

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

        get("/", (request, response) -> {

            return "<form action=\"/action_page\">\n"
                    + "  Numeros<br>\n"
                    + "  <input type=\"text\" name=\"numeros\" value=\"1,2,3,4,5,6,7\">\n"
                    + "  <br>\n"
                    + "\n"
                    + "  <br><br>\n"
                    + "  <input type=\"submit\" value=\"Submit\"  >\n"
                    + "</form> ";

        });

        get("/action_page", (req, res) -> {
            String datos = req.queryParams("numeros");
            String[] dat = datos.split(",");
            for (int i = 0; i < dat.length; i++) {
                Double num = Double.parseDouble(dat[i]);
                proc.addDato(num);
            }
            Double media = proc.media();
            Double dv = proc.db(media);
            proc.reset();
            return "<html>\n"
                    + "<body>\n"
                    + "\n"
                    + "<h2>Resultados de su busqueda</h2>\n"
                    + "\n"
                    + "\n"+"<p>La media y desviacion estandar es: "+media+"<br>"
                    + "\n"+
                    "<p>La desviacion estandar es :"+dv+"<br>"
                    +"<a href=\"/\">Si desea realizar otra consulta</a>"+ "</body>\n"
                    + "</html>";

        });
        //
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
            Double num = Double.parseDouble(g);
            return proc.db(num);
        });
        get("hello/ad/reset", (request, response) -> {
            proc.reset();
            return "Ok";
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;

    }

}
