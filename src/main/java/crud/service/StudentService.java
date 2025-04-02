package crud.service;

// Importaciones necesarias para el funcionamiento del servicio
import crud.dto.StudentDTO; // DTO para transferir datos del estudiante
import crud.model.Student; // Modelo de datos del estudiante
import crud.repository.StudentRepository; // Repositorio para interactuar con la base de datos
import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias
import org.springframework.stereotype.Service; // Anotación para marcar esta clase como un servicio
import java.util.List; // Para manejar listas
import java.util.Optional; // Para manejar valores opcionales

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Obtiene todos los estudiantes registrados.
     * @return Lista de estudiantes.
     */
    public List<Student> obtenerTodos() {
        return studentRepository.findAll();
    }

    /**
     * Obtiene un estudiante por su ID.
     * @param id Identificador del estudiante.
     * @return Un Optional que contiene el estudiante si existe.
     */
    public Optional<Student> obtenerPorId(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Registra un nuevo estudiante en el sistema.
     * @param studentDTO Objeto DTO con los datos del estudiante.
     * @return El estudiante registrado.
     */
    public Student registrar(StudentDTO studentDTO) {
        Student student = new Student();
        student.setNombre(studentDTO.getNombre());
        student.setEmail(studentDTO.getEmail());
        student.setEdad(studentDTO.getEdad());
        return studentRepository.save(student);
    }

    /**
     * Actualiza los datos de un estudiante existente.
     * @param id Identificador del estudiante a actualizar.
     * @param studentDTO Objeto DTO con los nuevos datos del estudiante.
     * @return Un Optional que contiene el estudiante actualizado si existe.
     */
    public Optional<Student> actualizar(Long id, StudentDTO studentDTO) {
        return studentRepository.update(id, new Student(id, studentDTO.getNombre(), studentDTO.getEmail(), studentDTO.getEdad()));
    }

    /**
     * Elimina un estudiante por su ID.
     * @param id Identificador del estudiante a eliminar.
     */
    public void eliminar(Long id) {
        studentRepository.delete(id);
    }
}