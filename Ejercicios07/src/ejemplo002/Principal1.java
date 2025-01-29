/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;
/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {
        
        String [] nombres = { "Jason", "Jonathan", "Kristen", "Robin", "Michelle", "Emily", "Noah", "Daniel"};
        String [] apellidos = { "Lynch", "George", "Lang", "Cochran", "Young", "Fletcher", "Adkins", "Harris"};
        int [][] notas = { {10, 80, 80, 95}, {40, 80, 80, 45}, {80, 10, 20, 55}, {70, 30, 20, 65}, 
            {60, 50, 70, 75}, {50, 70, 30, 85},{40, 80, 40, 45}, {30, 90, 50, 95}};
        
        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int [] filaNotas;
        int notaMayor;
        int notaMenor;
        String mensajeFinal = "";
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            filaNotas = notas[i];
            notaMayor = obnotaMayor(filaNotas);
            notaMenor = obnotaMenor(filaNotas);
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas, 
                    promedio_paralelo);
            tipoNotas = funcion03(filaNotas);
            String correo = obtenerCorreo(nombre,apellido);
            mensajeFinal = String.format("%s%s\n", mensajeFinal,    
                    presentarReporte(nombre.toUpperCase(), apellido.toUpperCase(), 
                    tipoNotas, promedioEstudiante, numeroNotasArribaPromedio, correo, notaMayor, notaMenor));
            /*
                Acumula todo dento de una cadena para luego enviarlo todo sin 
                que reescriba al convertirlo en un txt
            */
        }
        CrearArchivoTexto.agregarRegistros(mensajeFinal);

    }
    public static String obtenerCorreo(String nombre,String apellido){
 
            nombre= nombre.toLowerCase();
            apellido=apellido.toLowerCase();
            String correo = nombre.substring(0,1)+"."+apellido+"@utpl.edu.ec";
        return correo;
    }
    public static String presentarReporte(String nom, String ap, String notas, 
            double prom, int numeroNotas, String correo, int nMa, int nMe){
        String reporte = String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Correo: %s\n"
                + "Con notas: \n"
                + "%s\n"
                + "Promedio - %2f\n"
                + "Número de notas arriba del promedio: %d\n"
                + "Nota mayor: %d\n"
                + "Nota menor: %d\n",
                nom, ap,correo, notas, prom, numeroNotas, nMa, nMe);
        
        return reporte;
    }

    public static int obnotaMayor(int [] n){
        int mayor = n[0];
        for (int i=0;i <n.length;i++){
            if (n[i]>mayor){
                mayor = n[i];
            }
        }
        return mayor;
    }

    public static int obnotaMenor(int [] n){
        int menor = n[0];
        for (int i=0;i <n.length;i++){
            if (n[i]<menor){
                menor = n[i];
            }
        }
        return menor;
    }
    public static double obtenerPromedioParalelo(int [][] n){
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }
        
        promedio = (double)suma/ contador;
        return promedio;
    }
    
    public static double funcion01(int [] notas){
        int suma = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        promedio = (double) suma / notas.length;
        return promedio;
    }
    
    public static int funcion02(int [] notas, double promedio){
        
        int contador = 0;
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota > promedio) {
                contador = contador + 1;
            }
            
        }
        
        return contador;
    }
    
    public static String funcion03(int [] notas){
        String cadena = "";
        
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota >=0 && nota<=20) {
                cadena = String.format("%s%d-%s\n", cadena, nota, "M");
            }else{
                if (nota >20 && nota<=50) {
                    cadena = String.format("%s%d-%s\n", cadena, nota, "MB");
                }else{
                    if (nota > 50) {
                        cadena = String.format("%s%d-%s\n", cadena, nota, "S");
                    }
                }
            }
            
        }
        
        return cadena;
    }
    
    
    
    
}
