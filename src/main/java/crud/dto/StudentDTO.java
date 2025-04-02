package crud.dto;

// Importación de la librería Lombok para generar automáticamente métodos como getters, setters, toString, etc.
import lombok.Data;

/**
 * Clase DTO (Data Transfer Object) para representar un estudiante.
 * Utiliza Lombok para reducir el código boilerplate.
 */
@Data
public class StudentDTO {
    // Nombre del estudiante
    private String nombre;

    // Email del estudiante
    private String email;

    // Edad del estudiante
    private int edad;
}