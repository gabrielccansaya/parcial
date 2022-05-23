package pe.ucs.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libros {
    private int idlibro;
    private String titulo;
    private String idioma;
    private int paginas;
    private String descripcion;
    private int idautor;
    private int ideditorial;  
    
}
