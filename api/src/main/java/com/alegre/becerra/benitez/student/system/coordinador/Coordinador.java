package com.alegre.becerra.benitez.student.system.coordinador;

import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import jakarta.persistence.*;//Importa las anotaciones de JPA (Jakarta Persistence API), que permiten que la clase se mapee a una tabla de base de datos.

import java.util.UUID; //para identificar de manera única elementos en sistemas distribuidos o en bases de datos.
//Sirve para manejar un identificador único para cada instancia de Coordinador.
@Entity //Indica que la clase Coordinador es una entidad JPA, lo que significa que se mapea a una tabla en la base de datos.
@Table(name= "coordinador") //nombre de la tabla q se va a mapear
public class Coordinador {
    @Id //indica q uuid es la clave primaria de la tabla
    @GeneratedValue //La clave primaria será generada automáticamente.
    private UUID uuid = UUID.randomUUID(); //identificador para cada coordi se inicia con un valor al azar

    private String nombre;
    private String apellido;

//relacionaa un coordi con una sola carrera
    @OneToOne(mappedBy = "coordinador", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //relacion bidireccional, Las operaciones (como guardado, actualización o eliminación)
    private Carrera carrera;

    public Coordinador() {
    }

    public Coordinador(String nombre, String apellido, Carrera carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public UUID getUuid() { //get accede
        return uuid;
    }

    public void setUuid(UUID uuid) { //modifica
        this.uuid = uuid;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
