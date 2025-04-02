package crud;

// Importa la clase SpringApplication que se utiliza para iniciar la aplicación Spring Boot
import org.springframework.boot.SpringApplication;
// Importa la anotación SpringBootApplication que marca esta clase como la principal de la aplicación Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que indica que esta es una aplicación Spring Boot
@SpringBootApplication
public class CrudApplication {

	// Método principal que inicia la ejecución de la aplicación
	public static void main(String[] args) {
		// Ejecuta la aplicación Spring Boot utilizando la clase CrudApplication como punto de entrada
		SpringApplication.run(CrudApplication.class, args);
	}

}
