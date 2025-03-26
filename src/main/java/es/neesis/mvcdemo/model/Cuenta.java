package es.neesis.mvcdemo.model;

public class Cuenta
{
    /*
    Estos clientes tendrán cuentas asociadas, las que podremos dar de alta con los siguientes 
    datos: Número de cuenta (20 dígitos), sucursal, id de usuario y balance (importe total de la 
    cuenta).
    Las cuentas se pueden dar de alta, modificar, listar, borrar y ver el detalle de la cuenta que
    será indicar el número de la cuenta y el balance únicamente.
    */
   private int numeroCuenta;
   private int sucursal;
   private int idUsuario;
   private double balance;

   public Cuenta(int numeroCuenta, int sucursal, int idUsuario, double balance)
   {
        this.numeroCuenta = numeroCuenta;
        this.sucursal = sucursal;
        this.idUsuario = idUsuario;
        this.balance = balance;
   }

   public int getNumeroCuenta()
   {
        return this.numeroCuenta;
   }

   public void setNumeroCuenta(int numeroCuenta)
   {
        this.numeroCuenta = numeroCuenta;
   }

   public int getSucursal()
   {
        return this.sucursal;
   }

    public void setSucursal(int sucursal)
   {
        this.sucursal = sucursal;
   }

   public int getIdUsuario()
   {
        return this.idUsuario;
   }

   public void setIdUsuario(int idUsuario)
   {
        this.idUsuario = idUsuario;
   }

   public double getBalance()
   {
        return this.balance;
   }

    public void setBalance(double balance)
   {
        this.balance = balance;
   }
}