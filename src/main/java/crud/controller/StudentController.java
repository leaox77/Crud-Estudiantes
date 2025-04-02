package crud.controller;

// Importación de la clase StudentDTO que representa un objeto de transferencia de datos para estudiantes.
import crud.dto.StudentDTO;

// Importación de la clase Student que representa el modelo de datos de un estudiante.
import crud.model.Student;

// Importación del servicio StudentService que contiene la lógica de negocio para manejar estudiantes.
import crud.service.StudentService;

// Importación de ResponseEntity para construir respuestas HTTP con códigos de estado y datos.
import org.springframework.http.ResponseEntity;

// Importación de las anotaciones de Spring para definir controladores y manejar solicitudes HTTP.
import org.springframework.web.bind.annotation.*;

// Importación de la clase List para manejar colecciones de estudiantes.
import java.util.List;

// Importación de la clase Optional para manejar valores que pueden estar presentes o ausentes.
import java.util.Optional;

/**
 * Controlador REST para gestionar operaciones relacionadas con estudiantes.
 * Proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    /**
     * Servicio que contiene la lógica de negocio para manejar estudiantes.
     */
    private final StudentService studentService;

    /**
     * Constructor que inyecta el servicio de estudiantes.
     *
     * @param studentService Servicio de estudiantes.
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Endpoint para obtener todos los estudiantes.
     * Este método maneja solicitudes HTTP GET en la ruta base del controlador.
     * 
     * @return Una respuesta HTTP con una lista de todos los estudiantes en la base de datos
     *         y un código de estado 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Student>> obtenerTodos() {
        return ResponseEntity.ok(studentService.obtenerTodos());
    }

    /**
     * Endpoint para obtener un estudiante por su ID.
     * Este método maneja solicitudes HTTP GET en la ruta "/{id}" del controlador.
     * 
     * @param id El ID del estudiante que se desea buscar.
     * @return Una respuesta HTTP que contiene el estudiante encontrado con un código de estado 200 (OK),
     *         o un código de estado 404 (Not Found) si no se encuentra el estudiante.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> obtenerPorId(@PathVariable Long id) {
        Optional<Student> estudiante = studentService.obtenerPorId(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para registrar un nuevo estudiante.
     * Este método maneja solicitudes HTTP POST en la ruta base del controlador.
     *
     * @param studentDTO Objeto DTO que contiene los datos del estudiante a registrar.
     *                   Este objeto debe incluir la información necesaria para crear un nuevo estudiante.
     * @return Una respuesta HTTP que contiene el estudiante creado con un código de estado 201 (Created).
     *         Si ocurre algún error durante el registro, se devolverá una respuesta adecuada.
     */
    @PostMapping
    public ResponseEntity<Student> registrar(@RequestBody StudentDTO studentDTO) {
        Student nuevoEstudiante = studentService.registrar(studentDTO);
        return ResponseEntity.status(201).body(nuevoEstudiante);
    }

    /**
     * Endpoint para actualizar un estudiante existente.
     * Este método maneja solicitudes HTTP PUT en la ruta "/{id}" del controlador.
     * 
     * @param id         El ID del estudiante que se desea actualizar.
     *                   Este ID debe corresponder a un estudiante existente en la base de datos.
     * @param studentDTO Objeto DTO que contiene los nuevos datos del estudiante.
     *                   Este objeto debe incluir la información actualizada del estudiante.
     * @return Una respuesta HTTP que contiene el estudiante actualizado con un código de estado 200 (OK),
     *         o un código de estado 404 (Not Found) si no se encuentra el estudiante con el ID proporcionado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> actualizar(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Optional<Student> estudianteActualizado = studentService.actualizar(id, studentDTO);
        return estudianteActualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para eliminar un estudiante por su ID.
     * Este método maneja solicitudes HTTP DELETE en la ruta "/{id}" del controlador.
     *
     * @param id El ID del estudiante a eliminar.
     *           Este ID debe corresponder a un estudiante existente en la base de datos.
     * @return Una respuesta HTTP con un código de estado 204 (No Content) si la eliminación fue exitosa.
     *         Si el estudiante no existe, se devolverá una respuesta adecuada.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        studentService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}