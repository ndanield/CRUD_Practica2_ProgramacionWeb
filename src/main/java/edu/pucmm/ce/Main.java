package edu.pucmm.ce;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Main {

    public static void main(String[] args) {
        staticFileLocation("/public");

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante(20132013, "Nelson", "Duran", "809-631-2328"));
        estudiantes.add(new Estudiante(20122013, "Pedro", "Caceres", "809-641-2428"));

        get("/", (req, res) -> {
            Map<String, ArrayList> model = new HashMap<>();
            model.put("estudiantes", estudiantes);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
