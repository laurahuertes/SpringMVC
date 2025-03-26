package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.model.Cuenta;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
        for (Cuenta cuenta : cuentas)
        {
            if (cuenta.getNumeroCuenta() == numeroCuenta)
            {
                try
                {
                    cuentas.remove(cuenta);
                }
                catch(Exception e)
                {
                    throw new IllegalArgumentException("La cuenta que quiere borrar no existe");
                }
            }
        }
    }

    public void detailCuenta(int numeroCuenta, double balance)
    {

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