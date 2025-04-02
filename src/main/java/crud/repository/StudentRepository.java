package crud.repository;

import crud.model.Student; // Importa la clase modelo Student
import org.springframework.stereotype.Repository; // Anotación para indicar que esta clase es un componente de repositorio
import java.util.*; // Importa clases de utilidad para colecciones
import java.util.concurrent.ConcurrentHashMap; // Importa una implementación de mapa segura para hilos

/**
 * Clase repositorio para gestionar entidades de tipo Student en un almacenamiento en memoria.
 */
@Repository
public class StudentRepository {

    // Almacenamiento en memoria seguro para hilos para las entidades Student
    private final Map<Long, Student> studentStorage = new ConcurrentHashMap<>();
    private long currentId = 1; // Contador para generar IDs únicos

    /**
     * Recupera todos los estudiantes del almacenamiento.
     *
     * @return una lista de todos los estudiantes
     */
    public List<Student> findAll() {
        return new ArrayList<>(studentStorage.values());
    }

    /**
     * Busca un estudiante por su ID.
     *
     * @param id el ID del estudiante
     * @return un Optional que contiene el estudiante si se encuentra, o vacío si no
     */
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(studentStorage.get(id));
    }

    /**
     * Guarda un nuevo estudiante o actualiza uno existente.
     * Si el estudiante no tiene un ID, se genera un nuevo ID.
     *
     * @param student el estudiante a guardar
     * @return el estudiante guardado
     */
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(currentId++);
        }
        studentStorage.put(student.getId(), student);
        return student;
    }

    /**
     * Actualiza un estudiante existente por su ID.
     *
     * @param id el ID del estudiante a actualizar
     * @param student los datos actualizados del estudiante
     * @return un Optional que contiene el estudiante actualizado si el ID existe, o vacío si no
     */
    public Optional<Student> update(Long id, Student student) {
        if (studentStorage.containsKey(id)) {
            student.setId(id);
            studentStorage.put(id, student);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    /**
     * Elimina un estudiante por su ID.
     *
     * @param id el ID del estudiante a eliminar
     */
    public void delete(Long id) {
        studentStorage.remove(id);
    }
}