package crud.model;

// Importaciones de Lombok para generar automáticamente código repetitivo como getters, setters, constructores, etc.
import lombok.AllArgsConstructor; // Genera un constructor con todos los argumentos.
import lombok.Data; // Genera getters, setters, toString, equals, hashCode, etc.
import lombok.NoArgsConstructor; // Genera un constructor sin argumentos.

@Data // Anotación de Lombok para generar automáticamente métodos como getters, setters, toString, etc.
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos.
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos.
public class Student {
    private Long id; // Identificador único del estudiante.
    private String nombre; // Nombre del estudiante.
    private String email; // Correo electrónico del estudiante.
    private int edad; // Edad del estudiante.
}
