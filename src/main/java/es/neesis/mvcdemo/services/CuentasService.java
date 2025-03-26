package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.model.Cuenta;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CuentasService 
{
    /*
    Podremos dar de alta con los siguientes datos: 
    Número de cuenta (20 dígitos), sucursal, id de usuario y balance

    Las cuentas se pueden dar de alta, modificar, listar, borrar y 
    ver el detalle de la cuenta que será indicar el número de la cuenta y el balance únicamente.
    */

    private static List<Cuenta> cuentas = new ArrayList();

    public void addCuenta(int numeroCuenta, int sucursal, int idUsuario, double balance) 
    {
        Cuenta cuenta = new Cuenta(numeroCuenta, sucursal, idUsuario, balance);
        cuentas.add(cuenta);
    }

    public void editCuenta(int numeroCuenta)
    {

    }

    public List<Cuenta> listCuentas()
    {
        return cuentas;
    }

    public void deleteCuenta(int numeroCuenta)
    {
        boolean found = false;
        Iterator<Cuenta> iterator = cuentas.iterator();

        while (iterator.hasNext())
        {
            Cuenta cuenta = iterator.next();
            if (cuenta.getNumeroCuenta() == numeroCuenta)
            {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (!found)
        {
            throw new IllegalArgumentException("La cuenta con el número " + numeroCuenta + " no existe.");
        }
    }


    public Cuenta detailCuenta(int numeroCuenta)
    {
        for (Cuenta cuenta : cuentas)
        {
            if (cuenta.getNumeroCuenta() == numeroCuenta)
            {
                return cuenta;
            }
        }
        return null;
    }

    public Cuenta mostrarCuenta(int identificador) {
        for (Cuenta cuenta: cuentas) {
            if (cuenta.getNumeroCuenta() == identificador) {
                return cuenta;
            }
        }
        return null;
    }
}