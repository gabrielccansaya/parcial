/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.ucs.parcial.service;

import java.util.List;
import pe.ucs.parcial.model.Libros;

/**
 *
 * @author admin
 */
public interface LibrosService {
    int create(Libros post);
    int update(Libros post);
    int delete(int id);
    Libros read(int id);
    List<Libros> readAll();
}
