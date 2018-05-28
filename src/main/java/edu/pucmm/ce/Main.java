package edu.pucmm.ce;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;

import static spark.Spark.get;

public class Main {

    public static void main(String[] args) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante(20132013, "Nelson", "Duran", "809-631-2328"));

        get("/hello", (req, res) ->
            new ModelAndView(null,"index.hbs"),
                new HandlebarsTemplateEngine()
        );
    }

}
