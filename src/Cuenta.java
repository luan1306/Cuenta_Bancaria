public class Cuenta {

    private int numero;
    private int cedula;
    private double saldo;

    public Cuenta() {}

    public Cuenta(int numero, int cedula, double saldo) {
        this.numero = numero;
        this.cedula = cedula;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{numero=" + numero + ", cedula=" + cedula + ", saldo=" + saldo + "}";
    }

    // ahora reciben parámetros en vez de leer del teclado
    public void ingresarDinero(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Ingreso exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: monto inválido.");
        }
    }

    public void retirarDinero(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo actual: " + saldo);
        } else {
            System.out.println("No se puede realizar el retiro. Monto inválido o insuficiente.");
        }
    }

    public void extraccionRapida() {
        double retiro = saldo * 0.20;
        if (retiro > 0) {
            saldo -= retiro;
            System.out.println("Extracción rápida realizada. Retiró el 20% (" + retiro + ")");
            System.out.println("Saldo actual: " + saldo);
        } else {
            System.out.println("No hay saldo disponible para extracción rápida.");
        }
    }
}