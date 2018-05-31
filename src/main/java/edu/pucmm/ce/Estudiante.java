package edu.pucmm.ce;

import java.util.Objects;

public class Estudiante {

    private int matricula;
    private String nombre;
    private String apellido;
    private String telefono;

    public Estudiante(int mat, String nom, String ape, String tel) {
        this.matricula = mat;
        this.nombre = nom;
        this.apellido = ape;
        this.telefono = tel;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = ( Estudiante ) o;
        return matricula == that.matricula;
    }

    @Override
    public int hashCode() {

        return Objects.hash(matricula);
    }
}
