/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.ucs.parcial.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ucs.parcial.model.Libros;
import pe.ucs.parcial.service.LibrosService;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/post")
public class LibrosRestController {

    @Autowired
    private LibrosService postService;

    @GetMapping("/all")
    public List<Libros> getPosts() {
        return postService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> getPost(@PathVariable int id) {
        Libros post = postService.read(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {        
        return postService.delete(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Libros post) {  
        System.out.println(post.getTitulo());
        return postService.create(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Libros post) {  
        Libros pos = new Libros(post.getIdlibro(),post.getTitulo(),post.getIdioma(),post.getPaginas(),post.getDescripcion(),post.getIdautor(),post.getIdeditorial());
        
        System.out.println(post.getIdlibro()+","+post.getTitulo()+","+post.getIdioma()+","+post.getPaginas()+","+post.getDescripcion()+","+post.getIdautor()+","+post.getIdeditorial());
        return postService.update(post);
    }
}
