/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.ucs.parcial.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ucs.parcial.model.Libros;
import pe.ucs.parcial.service.LibrosService;
import pe.ucs.parcial.dao.LibrosDao;

/**
 *
 * @author admin
 */
@Service
public class LibrosServiceImpl implements LibrosService{
    @Autowired
    private LibrosDao postDao;
    @Override
    public int create(Libros post) {
        return postDao.create(post);
    }

    @Override
    public int update(Libros post) {
        return postDao.update(post);
    }

    @Override
    public int delete(int id) {
        return postDao.delete(id);
    }

    @Override
    public Libros read(int id) {
        return postDao.read(id);
    }

    @Override
    public List<Libros> readAll() {
        return postDao.readAll();
    }
    
}
