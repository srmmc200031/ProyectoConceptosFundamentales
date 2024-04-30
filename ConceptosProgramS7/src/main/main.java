package main;


//Conceptos Fundamentales de Programacion
//Politecnico Grancolombiano, 30 de abril de 2024
//Trabajo Colaborativo, Grupo 2
//Samuel Hoyos Montoya
//Sebastian Rodriguez Marroquin

public class main{

	public static void main (String[]arg) {
		
		GenerateInfoFiles.generarVendedores();
		GenerateInfoFiles.generarProductos();
		GenerateInfoFiles.generarVentas();
		GenerateInfoFiles.escribirVendedores();
		System.out.println("Los archivos han sido generados en " + GenerateInfoFiles.Ruta);
		
	}
	
}