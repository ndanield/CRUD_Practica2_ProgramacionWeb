package edu.pucmm.ce;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String[] args) {
        staticFileLocation("/public");

        estudiantes.add(new Estudiante(20132013, "Daniel", "Pichardo", "809-621-2328"));
        estudiantes.add(new Estudiante(20122013, "Pedro", "Caceres", "809-641-2428"));
        estudiantes.add(new Estudiante(20170523, "Marchielys", "Korrea", "829-621-2425"));


        get("/", (req, res) -> {
            Map<String, ArrayList> model = new HashMap<>();
            model.put("estudiantes", estudiantes);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/create", (req, res) -> new ModelAndView(null, "create.hbs"),
                new HandlebarsTemplateEngine());

        post("/create", (req, res) -> {
            estudiantes.add(new Estudiante(Integer.parseInt(req.queryParams("matricula")),
                    req.queryParams("nombre"),
                    req.queryParams("apellido"),
                    req.queryParams("telefono")));
            res.redirect("/");
            return null;
        });

        get("/show/:matricula", (req, res) -> {
            Map<String, Estudiante> model = new HashMap<>();
            model.put("estudiante", getPorMatricula(req.params("matricula")));

            return new ModelAndView(model, "show.hbs");
        }, new HandlebarsTemplateEngine());

        get("/edit/:matricula", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("estudiante", req.params("matricula"));
            return new ModelAndView(model, "edit.hbs");
        }, new HandlebarsTemplateEngine());

        post("/delete/:matricula", (req, res) -> {
            estudiantes.remove(getPorMatricula(req.params("matricula")));
            res.redirect("/");
            return null;
        });
    }


    public static Estudiante getPorMatricula(String matricula) {
        return estudiantes.stream().
                filter(estudiante -> estudiante.getMatricula() == Integer.parseInt(matricula))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
