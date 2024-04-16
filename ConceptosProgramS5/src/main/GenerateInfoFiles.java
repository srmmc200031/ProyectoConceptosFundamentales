package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
	public static String Ruta="C:/Program Files/Java/";
	
	public static void  Ventas () {
		Random random = new Random();
        for (int i = 0; i < 5; i++) {
            try {
                String ruta = Ruta + "archivoVentas_" + (i+1) + ".txt";
                File file = new File(ruta);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                for (int j = 0; j < 20; j++) {
                    String productId = "P" + (random.nextInt(10) + 1);
                    int quantity = random.nextInt(10) + 1; // Cantidad aleatoria entre 1 y 10
                    String line = productId + "; " + quantity;
                    writer.write(line);
                    writer.newLine();
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void  Vendedores () {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoVendedores.txt";
			
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
			//se usa como prueba un valor aleatorio para el ID
			Random random = new Random();
            for (int i = 0; i < 5; i++) {
                String documentType = "CC";
                String documentNumber = String.valueOf(10000000 + random.nextInt(90000000));
                String firstName = "Nombre" + i;
                String lastName = "Apellido" + i;
                String line = documentType + "; " + documentNumber + "; " + firstName + "; " + lastName;
                bw.write(line);
                bw.newLine();
            }
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
			Random random = new Random();
            for (int i = 0; i < 10; i++) {
                String productId = "P" + (i + 1);
                String productName = "Producto " + (i + 1);
                double unitPrice = 10 + random.nextDouble() * 90; // Precio aleatorio entre 10 y 100
                String line = productId + "; " + productName + "; " + unitPrice;
                bw.write(line);
                bw.newLine();
            }
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
