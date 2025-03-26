
package es.neesis.mvcdemo.model;
import es.neesis.mvcdemo.model.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String dni;
    private String nombre;
    private String direccion;
    private String email;
    private int telefono;
    private Sucursal sucursalPrincipal;
    private List<Cuenta> cuentas;

    public Cliente(Integer id, String dni, String nombre, String direccion, String email, int telefono, Sucursal sucursalPrincipal) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.sucursalPrincipal = sucursalPrincipal;
        this.cuentas = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public Sucursal getSucursalPrincipal() {
        return this.sucursalPrincipal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setSucursalPrincipal(Sucursal sucursalPrincipal) {
        this.sucursalPrincipal = sucursalPrincipal;
    }

    public void SetCliente(Cliente cliente) {
        this.id = cliente.getId();
        this.dni = cliente.getDni();
        this.nombre = cliente.getNombre();
        this.direccion = cliente.getDireccion();
        this.email = cliente.getEmail();
        this.telefono = cliente.getTelefono();
        this.sucursalPrincipal = cliente.getSucursalPrincipal();
    }

}