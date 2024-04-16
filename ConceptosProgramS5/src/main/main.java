package main;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;

//Conceptos Fundamentales de ProgramaciÃ³n
//Politecnico Grancolombiano, marzo 26 2024
//Trabajo Colaborativo, Grupo 2
//Samuel Hoyos Montoya
//Sebastian Rodriguez Marroquin

public class main{

	public static void main (String[]arg) {
		
		GenerateInfoFiles.Ventas();
		GenerateInfoFiles.Vendedores();
		GenerateInfoFiles.Productos();
		System.out.println("Los archivos han sido generados en " + GenerateInfoFiles.Ruta);
		
	}
	
}

