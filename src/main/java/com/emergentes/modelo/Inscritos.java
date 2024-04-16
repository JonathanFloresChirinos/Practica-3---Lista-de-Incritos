package com.emergentes.modelo;

public class Inscritos {
    private int id;
    private String fecha;
    private String nombre;
    private String apellidos;
    private String turno;
    private String sem1,sem2,sem3,sem4;

    public Inscritos() {
        this.id = 0;
        this.fecha = " ";
        this.nombre = " ";
        this.apellidos = " ";
        this.turno = " ";
        this.sem1 = " ";
        this.sem2 = " ";
        this.sem3 = " ";
        this.sem4 = " ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSem1() {
        return sem1;
    }

    public void setSem1(String sem1) {
        this.sem1 = sem1;
    }

    public String getSem2() {
        return sem2;
    }

    public void setSem2(String sem2) {
        this.sem2 = sem2;
    }

    public String getSem3() {
        return sem3;
    }

    public void setSem3(String sem3) {
        this.sem3 = sem3;
    }

    public String getSem4() {
        return sem4;
    }

    public void setSem4(String sem4) {
        this.sem4 = sem4;
    }

    
}
