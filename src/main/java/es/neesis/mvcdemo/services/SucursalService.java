package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService {
    private static Integer contador = 0;
    private static List<Sucursal> sucursales = new ArrayList<>();

    public List<Sucursal> listadoSucursales() {
        return sucursales;
    }

    public void addSucursal(String nombre, String director, String direccion) {

        Sucursal sucursal = new Sucursal(++contador, nombre, director, direccion);

        sucursales.add(sucursal);

    }

    public void deleteSucursal(String nombre) {

        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equals(nombre)) {
                try {
                    sucursales.remove(sucursal);
                    break;
                } catch (Exception e) {
                    throw new IllegalArgumentException("La sucursal que quiere borrar no existe");
                }
            }
        }
    }

    public void modifySucursal(String nombre, String director, String direccion) {

        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).getNombre().equals(nombre)) {
                try {
                    Sucursal newsucursal = new Sucursal(sucursales.get(i).getId(), nombre, director, direccion);
                    sucursales.set(i, newsucursal);
                    break;
                } catch (Exception e) {
                    throw new IllegalArgumentException("La sucursal que quiere borrar no existe");
                }
            }
        }
    }

    public Sucursal searchSucursal(int id) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getId() == id) {
                return sucursal; // Devuelve la sucursal si coincide el ID
            }
        }
        return null; // Devuelve null si no se encuentra la sucursal
    }


}