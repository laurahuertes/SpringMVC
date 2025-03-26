package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Cliente;
import es.neesis.mvcdemo.services.ClientesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/formularioAddCliente")
    public String formularioAddCliente() {
        return "FormularioAddCliente";
    }

    @GetMapping("/formularioDeleteCliente")
    public String formularioDeleteCliente() {
        return "FormularioDeleteCliente";
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

        return "addCliente";
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
        List<Cliente> clientes = clientesService.listadoClientes();
        model.addAttribute("clientes", clientes);
        return "listadoClientes";
    }

    @PostMapping("/borrarCliente")
    public String borrarCliente(@RequestParam(value = "id", required = false) Integer id,
                                Model model) {
        model.addAttribute("id", id);
        clientesService.borrarCliente(id);

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
