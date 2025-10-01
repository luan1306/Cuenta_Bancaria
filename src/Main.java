import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Cuenta> lstLista = new ArrayList<>();

    public static void main(String[] args) {

        Menu();
    }

    public static void Menu() {
        int opcion;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Mostrar cuentas");
            System.out.println("3. Buscar cuenta");
            System.out.println("4. Eliminar cuenta");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = nextIntSafe();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    mostrarCuentas();
                    break;
                case 3:
                    buscarCuenta();
                    break;
                case 4:
                    eliminarCuenta();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intenta otra vez.");
            }

        } while (opcion != 0);
    }

    private static void crearCuenta() {
        System.out.print("Ingrese el número de cuenta: ");
        int numero = nextIntSafe();
        System.out.print("Ingrese la cédula: ");
        int cedula = nextIntSafe();
        System.out.print("Ingrese el saldo inicial: ");
        double saldo = nextDoubleSafe();

        Cuenta nueva = new Cuenta(numero, cedula, saldo);
        lstLista.add(nueva);
        System.out.println("Cuenta creada: " + nueva);
    }

    private static void mostrarCuentas() {
        if (lstLista.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }
        System.out.println("Lista de cuentas:");
        int i = 1;
        for (Cuenta c : lstLista) {
            System.out.println(i + ". " + c);
            i++;
        }
    }

    private static void buscarCuenta() {
        System.out.print("Ingrese el número de cuenta a buscar: ");
        int num = nextIntSafe();
        for (Cuenta c : lstLista) {
            if (c.getNumero() == num) {
                System.out.println("Cuenta encontrada: " + c);

                subMenu(c);
                return;
            }
        }
        System.out.println("No se encontró ninguna cuenta con ese número.");
    }

    private static void eliminarCuenta() {
        System.out.print("Ingrese el número de cuenta a eliminar: ");
        int num = nextIntSafe();

        for (int i = 0; i < lstLista.size(); i++) {
            if (lstLista.get(i).getNumero() == num) {
                Cuenta eliminado = lstLista.remove(i);
                System.out.println(" Cuenta encontrada y eliminada: " + eliminado);
                return;
            }
        }
        System.out.println("No se encontró ninguna cuenta con ese número.");
    }

    // SUBMENU que actúa sobre una cuenta específica
    private static void subMenu(Cuenta cuenta) {
        int op;
        do {
            System.out.println("\n--- Submenú cuenta " + cuenta.getNumero() + " ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Extracción rápida (20%)");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = nextIntSafe();

            switch (op) {
                case 1:
                    System.out.println("Saldo actual: " + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.print("Monto a ingresar: ");
                    double m = nextDoubleSafe();
                    cuenta.ingresarDinero(m);
                    break;
                case 3:
                    System.out.print("Monto a retirar: ");
                    double r = nextDoubleSafe();
                    cuenta.retirarDinero(r);
                    break;
                case 4:
                    cuenta.extraccionRapida();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    // Helpers para lectura segura
    private static int nextIntSafe() {
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Introduce un número entero:");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double nextDoubleSafe() {
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Introduce un número válido (decimal o entero):");
            sc.next();
        }
        return sc.nextDouble();
    }
}