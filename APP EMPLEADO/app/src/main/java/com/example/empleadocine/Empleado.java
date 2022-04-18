package com.example.empleadocine;

public class Empleado {
    public static int idEmp, idCargo, idSede;
    public static String Nombre, Apellido, Dni, Edad, Sede, Cargo;

    public static int getIdEmp() {
        return idEmp;
    }

    public static void setIdEmp(int idEmp) {
        Empleado.idEmp = idEmp;
    }

    public static int getIdCargo() {
        return idCargo;
    }

    public static void setIdCargo(int idCargo) {
        Empleado.idCargo = idCargo;
    }

    public static int getIdSede() {
        return idSede;
    }

    public static void setIdSede(int idSede) {
        Empleado.idSede = idSede;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String nombre) {
        Nombre = nombre;
    }

    public static String getApellido() {
        return Apellido;
    }

    public static void setApellido(String apellido) {
        Apellido = apellido;
    }

    public static String getDni() {
        return Dni;
    }

    public static void setDni(String dni) {
        Dni = dni;
    }

    public static String getEdad() {
        return Edad;
    }

    public static void setEdad(String edad) {
        Edad = edad;
    }

    public static String getSede() {
        return Sede;
    }

    public static void setSede(String sede) {
        Sede = sede;
    }

    public static String getCargo() {
        return Cargo;
    }

    public static void setCargo(String cargo) {
        Cargo = cargo;
    }
}
