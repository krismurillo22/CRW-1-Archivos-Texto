/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kristianmurillo
 */
public class TestMiFile {
    static MiFile mf=new MiFile();
    static Scanner lea=new Scanner(System.in);
    
    
    public static void main (String[] args){
        int opcion=0;
        String contenido="";
        lea.useDelimiter("\n");
        do{
            System.out.println("\nMenu\n");
            System.out.println("1- Set el Archivo / folder");
            System.out.println("2- Ver informacion");
            System.out.println("3- Crear Archivos");
            System.out.println("4- Crear un folder");
            System.out.println("5- Borrar.");
            System.out.println("6- CMD - DIR");
            System.out.println("7- Tree");
            System.out.println("8- Escribir en archivo txt (Remplazando lo que ya existe)");
            System.out.println("9- Escribir en archivo txt (Sin eliminar lo que ya existe)");
            System.out.println("10- Leer el archivo txt");
            System.out.println("11- Salir");
            System.out.println("Escoja una opcion");

            try{
                opcion=lea.nextInt();
                switch(opcion){
                    case 1:
                        set();
                        break;
                    case 2:
                        mf.Info();
                        break;
                    case 3:
                        mf.crearFile();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        mf.borrar();
                        break;
                    case 6: 
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;
                    case 8:
                        System.out.println("Ingrese el contenido:");
                        contenido=lea.next();
                        mf.escribirArchivo(8, contenido);
                        break;
                    case 9:
                        System.out.println("Ingrese el contenido:");
                        contenido=lea.next();
                        mf.escribirArchivo(9, contenido);
                        break;
                    case 10:
                        mf.leerArchivo();
                        break;
                }
                
            }catch(InputMismatchException e){
                lea.nextLine();
                System.out.println("Por favor ingrese una opcion correcta");
            }catch(NullPointerException e){
                System.out.println("Debes seleccionar la opcion 1 por lo menos una vez.");
            }catch(IOException e){
                System.out.println("Error: "+e.getMessage());
            }
             
        }while(opcion!=11);
                      
    }
    
    private static void set(){
            System.out.println("Direccion: ");
            mf.setFile(lea.next());
    }
    
    
}
