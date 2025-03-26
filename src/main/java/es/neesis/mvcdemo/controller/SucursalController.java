package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.services.SucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.neesis.mvcdemo.model.Sucursal;

import java.util.List;


@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/formularioAddSucursal")
    public String formularioAddSucursal() {
        return "formularioAddSucursal";
    }

    @PostMapping("/addSucursal")
    public String addSucursal(@RequestParam("nombre") String nombre, @RequestParam("director") String director, @RequestParam("direccion") String direccion, Model model){

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

    @GetMapping("/formularioDeleteSucursal")
    public String formularioDeleteSucursal() {
        return "formularioDeleteSucursal";
    }

    @PostMapping("/deleteSucursal")
    public String eliminarSucursal(@RequestParam("nombre") String nombre, Model model){

        sucursalService.deleteSucursal(nombre);
        model.addAttribute("nombre" , nombre);
        return "deleteSucursal";

    }

    @GetMapping("/formularioModifySucursal")
    public String formularioModifySucursal() {
        return "formularioModifySucursal";
    }

    @PostMapping("/modifySucursal")
    public String modificarSucursal(@RequestParam("nombre") String nombre,@RequestParam("director") String director, @RequestParam("direccion") String direccion, Model model){

        sucursalService.modifySucursal(nombre,director,direccion);
        model.addAttribute("nombre" , nombre);
        model.addAttribute("director" , director);
        model.addAttribute("direccion" , direccion);
        return "modifySucursal";

    }




}