package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    private final ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/formularioAddCliente")
    public String formularioAddCliente() {
        return "FormularioAddCliente";
    }

    @PostMapping("/addCliente")
    public String addCliente(@RequestParam(value = "dni") String dni,
                             @RequestParam("nombre") String nombre,
                             @RequestParam("direccion") String direccion,
                             @RequestParam("email") String email,
                             @RequestParam("telefono") int telefono,
                             @RequestParam("sucursalPrincipal") int sucursalPrincipal,
                             Model model) {
        clientesService.addCliente(dni, nombre, direccion, email, telefono, sucursalPrincipal);

        model.addAttribute("dni", dni);
        model.addAttribute("nombre", nombre);
        model.addAttribute("direccion", direccion);
        model.addAttribute("email", email);
        model.addAttribute("telefono", telefono);
        model.addAttribute("sucursalPrincipal", sucursalPrincipal);

        return "";
    }


    @PutMapping("/modificarCliente")
    public String modificarCliente(@RequestParam(value = "id", required = false) Integer id,
                                   @RequestParam(value = "dni", required = false) String dni,
                                   @RequestParam(value = "email", required = false) String email,
                                   Model model) {
        model.addAttribute("id", id.toString());
        model.addAttribute("dni", dni);
        model.addAttribute("email", email);

        return "modificarCliente";
    }

    @GetMapping("/listadoClientes")
    public String listadoClientes(Model model) {
        clientesService.listadoClientes();
        return "listadoClientes";
    }

    @DeleteMapping("/borrarCliente")
    public String borrarCliente(@RequestParam(value = "id", required = false) Integer id,
                                @RequestParam(value = "dni", required = false) String dni,
                                @RequestParam(value = "email", required = false) String email,
                                Model model) {
        model.addAttribute("id", id);
        clientesService.borrarCliente(id.toString());
        model.addAttribute("dni", dni);
        clientesService.borrarCliente(dni);
        model.addAttribute("email", email);
        clientesService.borrarCliente(email);

        return "borrarCliente";
    }

    @GetMapping("/mostrarCliente")
    public String mostrarCliente(@RequestParam(value = "id", required = false) Integer id,
                                 @RequestParam(value = "dni", required = false) String dni,
                                 @RequestParam(value = "email", required = false) String email,
                                 Model model) {
        model.addAttribute("id", id);
        clientesService.mostrarCliente(id.toString());
        model.addAttribute("dni", dni);
        clientesService.mostrarCliente(dni);
        model.addAttribute("email", email);
        clientesService.mostrarCliente(email);

        return "mostrarCliente";
    }
}
