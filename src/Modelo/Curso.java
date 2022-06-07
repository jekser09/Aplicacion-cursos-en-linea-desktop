/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
/**
 *
 * @author juans
 */
public class Curso implements Serializable{
    private String nombreCurso;
    private int codigoCurso;
    private float valorCurso;
    private String fotoCurso;   
    private String descripcion;
    public Curso(String nombreCurso, int codigoCurso, float valorCurso, String fotoCurso,String descripcion) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.valorCurso = valorCurso;
        this.fotoCurso = fotoCurso;
        this.descripcion=descripcion;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public float getValorCurso() {
        return valorCurso;
    }

    public void setValorCurso(float valorCurso) {
        this.valorCurso = valorCurso;
    }

    public String getFotoCurso() {
        return fotoCurso;
    }

    public void setFotoCurso(String fotoCurso) {
        this.fotoCurso = fotoCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }   
}
