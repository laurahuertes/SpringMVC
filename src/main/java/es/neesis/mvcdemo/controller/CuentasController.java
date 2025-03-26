package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import es.neesis.mvcdemo.services.CuentasService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cuentas")
public class CuentasController 
{
    private CuentasService cuentasService;

    @Autowired
    public CuentasController(CuentasService cuentasService)
    {
        this.cuentasService = cuentasService;
    }

    @GetMapping("/addCuenta")
    public String mostrarFormulario(Model model)
    {
        model.addAttribute("numeroCuenta", "");
        model.addAttribute("sucursal", "");
        model.addAttribute("idUsuario", "");
        model.addAttribute("balance", "");
        return "addCuenta";
    }

    @PostMapping("/addCuenta")
    public String addCuenta(@RequestParam int numeroCuenta,
                            @RequestParam int sucursal,
                            @RequestParam int idUsuario,
                            @RequestParam double balance,
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
    public String editCuenta(@RequestParam(name="numeroCuenta", defaultValue="1") int numeroCuenta,
                            Model model)
    {
        model.addAttribute("numeroCuenta", numeroCuenta);
        cuentasService.editCuenta(numeroCuenta);

        return "editCuenta";
    }

    @GetMapping("/listCuentas")
    public String listCuentas(Model model)
    {
        List<Cuenta> cuentas = cuentasService.listCuentas();

        if (cuentas == null)
        {
            cuentas = new ArrayList<Cuenta>();
        }

        model.addAttribute("cuentas", cuentas);
        return "listCuentas";
    }

    @GetMapping("/deleteCuenta")
    public String mostrarFormularioDelete(Model model)
    {
        model.addAttribute("numeroCuenta", "");
        return "deleteCuenta";
    }

    @PostMapping("/deleteCuenta")
    public String deleteCuenta(@RequestParam int numeroCuenta, Model model)
    {
        try
        {
            cuentasService.deleteCuenta(numeroCuenta);
            model.addAttribute("message", "Cuenta eliminada con éxito.");
        }
        catch (IllegalArgumentException e)
        {
            model.addAttribute("message", e.getMessage());
        }
        return "deleteCuenta";
    }

    @GetMapping("/detailCuenta")
    public String detailCuenta(@RequestParam(name="numeroCuenta", defaultValue="1") int numeroCuenta,
                                Model model)
    {
        Cuenta cuenta = cuentasService.detailCuenta(numeroCuenta);

        if (cuenta != null)
        {
            model.addAttribute("numeroCuenta", cuenta.getNumeroCuenta());
            model.addAttribute("balance", cuenta.getBalance());
        }
        else
        {
            model.addAttribute("message", "Cuenta no encontrada.");
        }

        return "detailCuenta";
    }
}