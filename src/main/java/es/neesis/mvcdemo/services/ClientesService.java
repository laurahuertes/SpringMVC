package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.model.Cliente;
import es.neesis.mvcdemo.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesService {
    private static Integer contador = 0;
    private static List<Cliente> clientes = new ArrayList<>();


    //Listar clientes
    public List<Cliente> listadoClientes() {
        return clientes;
    }

    //Añadir cliente
    public void addCliente(String dni, String nombre, String direccion, String email, int telefono, Sucursal sucursalPrincipal) {
        Cliente nuevoCliente = new Cliente(contador ++, dni, nombre, direccion, email, telefono, sucursalPrincipal);
        clientes.add(nuevoCliente);
    }

    //modificar cliente
    public void modificarCliente(String identificador, Cliente clienteModificado) {
        for (Cliente cliente: clientes) {
            if (cliente.getId().toString().equals(identificador) ||
                    (cliente.getDni().equals(identificador)) ||
                    (cliente.getEmail().equals(identificador))) {
                    cliente.setNombre(clienteModificado.getNombre());
                    cliente.setDireccion(clienteModificado.getDireccion());
                    cliente.setEmail(clienteModificado.getEmail());
                    cliente.setTelefono(clienteModificado.getTelefono());
                    cliente.setSucursalPrincipal(clienteModificado.getSucursalPrincipal());

                }
        }
        return;
    }

    //Borrar cliente
    public void borrarCliente(String identificador) {
        for (Cliente cliente: clientes) {
            if (cliente.getId().toString().equals(identificador) ||
                (cliente.getDni().equals(identificador)) ||
                (cliente.getEmail().equals(identificador))) {
                    try {
                        clientes.remove(cliente);
                    } catch(Exception e) {
                        throw new IllegalArgumentException("El cliente que quiere borrar no existe");
                    }
                }
        }
    }

    //Mostrar cliente
    public Cliente mostrarCliente(String identificador) {
        for (Cliente cliente: clientes) {
            if (cliente.getId().toString().equals(identificador) ||
                    (cliente.getDni().equals(identificador)) ||
                    (cliente.getEmail().equals(identificador))) {
                    return cliente;
                }
        }
        return null;
    }
}