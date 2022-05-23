package pe.ucs.parcial.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.ucs.parcial.model.Libros;
import pe.ucs.parcial.dao.LibrosDao;


/**
 *
 * @author admin
 */
@Repository
public class LibrosDaoImpl implements LibrosDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Libros post) {
        String SQL ="INSERT INTO libros(titulo, idioma, paginas, descripcion, idautor, ideditorial) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{post.getTitulo(),post.getIdioma(),post.getPaginas(),post.getDescripcion(),post.getIdautor(),post.getIdeditorial()});
    }

    @Override
    public int update(Libros post) {
        String SQL ="UPDATE libros SET titulo=?, idioma=?, paginas=?, descripcion=?, idautor=?, ideditorial=? WHERE idlibro=?";                 
        return jdbcTemplate.update(SQL,new Object[]{post.getTitulo(),post.getIdioma(),post.getPaginas(),post.getDescripcion(),post.getIdautor(),post.getIdeditorial(),post.getIdlibro()});
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM libros WHERE idlibro=?"; 
        return jdbcTemplate.update(SQL,id);
        
    }

    @Override
    public Libros read(int id) {
        String SQL ="SELECT *FROM libros WHERE idlibro=?";
        try {
            Libros post = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Libros.class),id);
            return post;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Libros> readAll() {
        String SQL ="SELECT idlibro, titulo, idioma, paginas, descripcion, idautor, ideditorial FROM libros ORDER BY idlibro ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Libros.class));
    }
    
}
