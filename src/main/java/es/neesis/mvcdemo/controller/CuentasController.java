package es.neesis.mvcdemo.controller;

import org.springframework.web.bind.annotation.*;
import es.neesis.mvcdemo.services.CuentasService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/cuentas")
public class CuentasController 
{
    private CuentasService cuentasService;

    @PostMapping("/addCuenta")
    public String addCuenta(@RequestParam("numeroCuenta") int numeroCuenta,
                            @RequestParam("sucursal") int sucursal,
                            @RequestParam("idUsuario") int idUsuario,
                            @RequestParam("balance") double balance,
                            Model model)
    {
        cuentasService.addCuenta(numeroCuenta, sucursal, idUsuario, balance);

        model.addAttribute("numeroCuenta", numeroCuenta);
        model.addAttribute("sucursal", sucursal);
        model.addAttribute("idUsuario", idUsuario);
        model.addAttribute("balance", balance);

        return "addCuenta";
    }

    @PutMapping("/editCuenta")
    public String editCuenta(@RequestParam("numeroCuenta") int numeroCuenta,
                            Model model)
    {
        model.addAttribute("numeroCuenta", numeroCuenta);
        cuentasService.editCuenta(numeroCuenta);

        return "editCuenta";
    }

    @GetMapping("/listCuentas")
    public String listCuentas(Model model)
    {
        cuentasService.listCuentas();
        return "listCuentas";
    }

    @DeleteMapping("/deleteCuenta")
    public String deleteCuenta(@RequestParam("numeroCuenta") int numeroCuenta,
                                Model model)
    {
        model.addAttribute("numeroCuenta", numeroCuenta);
        cuentasService.deleteCuenta(numeroCuenta);

        return "deleteCuenta";
    }

    @GetMapping("/detailCuenta")
    public String detailCuenta(@RequestParam("numeroCuenta") int numeroCuenta,
                                @RequestParam("balance") double balance,
                                Model model)
    {
        model.addAttribute("numeroCuenta", numeroCuenta);
        cuentasService.detailCuenta(numeroCuenta, balance);

        return "detailCuenta";
    }
}