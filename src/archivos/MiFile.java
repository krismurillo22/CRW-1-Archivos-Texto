/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author kristianmurillo
 */
public class MiFile {

    private File mf=null;
    
    public void setFile (String dir){
        mf=new File(dir);
    }
    
    public void Info(){
        if (mf.exists()){
            System.out.println("\nSI EXISTE: \n----------");
            System.out.println("Nombre: "+mf.getName());
            System.out.println("Path: "+mf.getPath());
            System.out.println("Absoluta: "+mf.getAbsolutePath());
            System.out.println("Padre: " +mf.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: "+mf.length());
            if(mf.isFile()){
                System.out.println("ES UN ARCHIVO");
            }else if(mf.isDirectory()){
                System.out.println("ES UN FOLDER");
            }
            System.out.println("Ultima modificacion: "+ new Date(mf.lastModified()));
        }else{
            System.out.println("Aun no existe.");
        }
    }
    /*Para llamar las exception
    1- throws:  Solo permite ser usado en funciones o en el contructor.
    2- throw: Permite ser llamada en una estructura if, usando el cmd new.
    */
    public void crearFile()throws IOException{
        if (mf.createNewFile()){
            System.out.println("Creado exitosamente");
        }else{
            System.out.println("No se pudo crear.");
        }
    }
    
    public void crearFolder(){
        if (mf.mkdirs()){
            System.out.println("Creado exitosamente.");
        }else{
            System.out.println("No se pudo crear.");
        }
    }
    
    private boolean antidoto(File file){
        if (file.isDirectory()){
            for(File child: file.listFiles()){
                antidoto(child);
            }
        }
        return file.delete();
    }
    
    public void borrar(){
        if(antidoto(mf)){
            System.out.println("SE BORRO");
        }else{
            System.out.println("NO SE BORRO");
        }
    }
    
    public void dir(){
        if(mf.isDirectory()){
            System.out.println("Directorio de: "+mf.getAbsolutePath());
            System.out.println("");
            int cfiles=0, cdirs=0, tbytes=0;
            
            for (File  child: mf.listFiles()){
                if (!child.isHidden()){
                    //Fecha Ultima Modificacion
                    Date ultimaMod=new Date(child.lastModified());
                    System.out.print(ultimaMod+"\t");
                    //Si es File or Folder
                    if (child.isDirectory()){
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    }else {
                        //Si es un File/Archivo
                        cfiles++;
                        tbytes+=child.length();
                        System.out.print("      \t"+child.length()+"\t");
                    }
                    System.out.println(child.getName());
                }
            }
            
            System.out.println(cfiles+ " archivos\t"+tbytes+"  bytes"+"\n"+cdirs+" dirs");
        }
    }
    
    public void tree(){
        tree(mf,"-");
    }
    
    private void tree(File dir, String tab){
        if (dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for(File child: dir.listFiles()){
                if (!child.isHidden()){
                    tree(child, tab+"--");
                    
                }
            }
        }
                
    }
}
