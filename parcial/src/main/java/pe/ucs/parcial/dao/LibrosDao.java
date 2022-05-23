package pe.ucs.parcial.dao;


import java.util.List;
import pe.ucs.parcial.model.Libros;



/**
 *
 * @author admin
 */
public interface LibrosDao {
    int create(Libros post);
    int update(Libros post);
    int delete(int id);
    Libros read(int id);
    List<Libros> readAll();
}
