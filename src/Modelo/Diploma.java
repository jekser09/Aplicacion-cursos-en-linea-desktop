/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author juans
 */
public class Diploma implements Serializable {
    private String titulo;
    private final String NOMBRE_INSTITUCION = "Universidad Central";
    private Date fecha;
    private String nombreEstudiante;
    private int cedula;
    private int codCurso;
    private String descripcion;

    public Diploma(String titulo, Date fecha, String nombreEstudiante, int cedula, int codCurso, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.nombreEstudiante = nombreEstudiante;
        this.cedula = cedula;
        this.codCurso = codCurso;
        this.descripcion = descripcion;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNOMBRE_INSTITUCION() {
        return NOMBRE_INSTITUCION;
    }  
}
