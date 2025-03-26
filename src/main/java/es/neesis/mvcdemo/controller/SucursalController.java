package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.services.SucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.neesis.mvcdemo.model.Sucursal;

import java.util.List;


@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private SucursalService sucursalService;

    @GetMapping("/formularioSucursal")
    public String mostrarFormularioSucursal() {
        return "formularioSucursal"; 
    }

    @PostMapping("/addSucursal")
    public String addSucursal(@RequestParam("nombre") String nombre, @RequestParam("director") String director, @RequestParam("direccion") String direccion, Model model){
        mostrarFormularioSucursal();
        sucursalService.addSucursal(nombre,director,direccion);
        model.addAttribute("nombre" , nombre);
        return "addSucursal";

    }

    @GetMapping("/listadoSucursales")
    public String listadoSucursales(Model model){
        List<Sucursal> sucursales = sucursalService.listadoSucursales();
        model.addAttribute("sucursales" , sucursales);
        return "listadoSucursales";
    }

    @DeleteMapping("/deleteSucursal")
    public String eliminarSucursal(@RequestParam("nombre") String nombre, Model model){

        sucursalService.deleteSucursal(nombre);
        model.addAttribute("nombre" , nombre);
        return "deleteSucursal";

    }




}