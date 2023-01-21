package com.example.gestionproductos.controller;
import com.example.gestionproductos.models.Producto;
import com.example.gestionproductos.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @RequestMapping("/")
    public String verPagInicio(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Producto> listaProductos = productoServicio.listarProductos(palabraClave);
        modelo.addAttribute("palabraClave", palabraClave);
        modelo.addAttribute("listaProductos", listaProductos);

        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.save(producto);
        return "redirect:/";
    }

    @RequestMapping(value = "/editar/{id}")
    public ModelAndView mostrarFormularioEditarProducto(@PathVariable(name = "id") Long id) {
        ModelAndView modelo = new ModelAndView("editar_producto");
        Producto producto = productoServicio.get(id);
        modelo.addObject("producto", producto);
        return modelo;

    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id) {
        productoServicio.delete(id);
        return "redirect:/";
    }

}