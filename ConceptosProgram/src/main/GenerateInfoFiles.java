package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerateInfoFiles {
	public static String Ruta="C:/Program Files/Java/";
	
	public static void  Ventas () {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoVentas.txt";
			String contenido="ejemplo ventas";
			
			//se inicializa el archivo
			File ArchivoVentas=new File(ruta);
			
			
			//crear el archivo en caso de que no exista
			if (!ArchivoVentas.exists()) {
				ArchivoVentas.getParentFile().mkdirs(); 
				ArchivoVentas.createNewFile();
				//System.out.println(ArchivoVentas.getAbsolutePath()); ;
			}
			//se escribe dentro del archivo el contenido deseado
			FileWriter fw=new FileWriter(ArchivoVentas);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void  Vendedores () {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoVendedores.txt";
			String contenido="ejemplo vendedores";
			
			//se inicializa el archivo
			File ArchivoVendedores=new File(ruta);
			
			
			//crear el archivo en caso de que no exista
			if (!ArchivoVendedores.exists()) {
				ArchivoVendedores.getParentFile().mkdirs(); 
				ArchivoVendedores.createNewFile();
				//System.out.println(ArchivoVentas.getAbsolutePath()); ;
			}
			//se escribe dentro del archivo el contenido deseado
			FileWriter fw=new FileWriter(ArchivoVendedores);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void  Productos () {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoProductos.txt";
			String contenido="ejemplo productos";
			
			//se inicializa el archivo
			File ArchivoProductos=new File(ruta);
			
			
			//crear el archivo en caso de que no exista
			if (!ArchivoProductos.exists()) {
				ArchivoProductos.getParentFile().mkdirs(); 
				ArchivoProductos.createNewFile();
				//System.out.println(ArchivoVentas.getAbsolutePath()); ;
			}
			//se escribe dentro del archivo el contenido deseado
			FileWriter fw=new FileWriter(ArchivoProductos);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
