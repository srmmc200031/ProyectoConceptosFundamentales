package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class GenerateInfoFiles {
	public static String Ruta="C:/Program Files/Java/";
	//Se crean variables globales para la cantidad de vendedores, productos y ventas
	public static int cantVend, cantProd, cantVent;
	//Se crean 2 archivos que van a recopilar datos dentro de las distintas funciones
	public static String[][] listaVend;
	public static String[][] listaPrecios;
	
	public static void  generarVendedores () {
		try {
			//Se le pregunta al usuario por la cantidad de vendedores
			while (cantVend==0) {
				cantVend=Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la cantidad\nde vendedores."));
			}
			listaVend=new String[cantVend][5];
			
			//se usa un numero aleatorio como base para los ID
			Random random = new Random();
			int numID=10000000 + random.nextInt(90000000);
            for (int i = 0; i < cantVend; i++) {
                String documentType = "ID";
                //Se escribe el tipo de documento en la lista de vendedores
                listaVend[i][0]=documentType;
                if (i>0) {
                	numID=numID+1;
                }
                String documentNumber = String.valueOf(numID);
                //Se escribe el numero de ID en la lista de vendedores
                listaVend[i][1]=documentNumber;
                //Se le pregunta usuario por el nombre y apellido del usuario
                String firstName = JOptionPane.showInputDialog("Digite el nombre del vendedor #" + (i+1));
                //Se escribe el nombre en la lista de vendedores
                listaVend[i][2]=firstName;
                String lastName = JOptionPane.showInputDialog("Digite el apellido del vendedor #" + (i+1));
                //Se escribe el apellido en la lista de vendedores
                listaVend[i][3]=lastName;
                //Se escribe un placeholder en la lista de vendedores donde irían las ventas totales
                listaVend[i][4]="-";
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void  generarProductos () {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoProductos.txt";
			
			//se inicializa el archivo
			File ArchivoProductos=new File(ruta);
			
			//Se le pregunta al usuario por la cantidad de vendedores
			while (cantProd==0) {
				cantProd=Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la cantidad\nde productos."));
			}
			listaPrecios=new String[cantProd][4];
			
			//crear el archivo en caso de que no exista
			if (!ArchivoProductos.exists()) {
				ArchivoProductos.getParentFile().mkdirs(); 
				ArchivoProductos.createNewFile();
			}
			
			//se escribe dentro del archivo el contenido deseado
			FileWriter fw=new FileWriter(ArchivoProductos);
			BufferedWriter bw= new BufferedWriter(fw);
			//exceptuando la ID, se le pregunta al usuario detalles de los productos, y estos se guardan en la lista
            for (int i = 0; i < cantProd; i++) {
                String productId = "P_" + (i + 1);
                listaPrecios[i][0]=productId;
                String productName = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto #"+(i+1));
                listaPrecios[i][1]=productName;
                int unitPrice = Integer.parseInt(JOptionPane.showInputDialog("Inserte el valor del producto #"+(i+1)));
                listaPrecios[i][2]=String.valueOf(unitPrice);
                String line = productId + "; " + productName + "; " + unitPrice;
                bw.write(line);
                listaPrecios[i][3]="-";
                bw.newLine();
            }
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void  generarVentas () {
		Random random = new Random();
        for (int i = 0; i < cantVend; i++) {
            try {
            	//se genera la ruta del archivo
                String ruta = Ruta + "archivoVentas_" + (i+1) + ".txt";
                //se inicializa el archivo y el BufferedWriter
                File file = new File(ruta);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                //se escribe el ID del vendedor respectivo
                writer.write(listaVend[i][0]+"; "+listaVend[i][1]);
                writer.newLine();

                //se escribe en el archivo el ID de los productos y la cantidad de ventas
                for (int j = 0; j < cantProd; j++) {
                    String productId = "P_" + (j+1);
                    int quantity = random.nextInt(9) + (10*(j+1)); // Cantidad aleatoria entre 1 y 10
                    String line = productId + "; " + quantity;
                    writer.write(line);
                    listaPrecios[i][3]=String.valueOf(quantity);
                    writer.newLine();
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
	}
	
	public static void escribirVendedores() {
		try {
			//se genera la ruta del archivo y que va a tener
			String ruta = Ruta + "ArchivoVendedores.txt";
			
			//se inicializa el archivo
			File ArchivoVendedores=new File(ruta);
			
			//crear el archivo en caso de que no exista
			if (!ArchivoVendedores.exists()) {
				ArchivoVendedores.getParentFile().mkdirs(); 
				ArchivoVendedores.createNewFile();
			}
			
			//se escribe dentro del archivo el contenido deseado
			FileWriter fw=new FileWriter(ArchivoVendedores);
			BufferedWriter writer= new BufferedWriter(fw);
			
			for (int i=0; i<cantVend; i++ ) {
				//dentro del ciclo, se usa otro ciclo para hacer el calculo de
				//las ventas de cada vendedor, y se escribe ese resultado despues
				//de la información de este
				int suma=0;
				for (int j=0; j<cantProd; j++) {
					suma=suma+(Integer.parseInt(listaPrecios[i][2])*Integer.parseInt(listaPrecios[i][3]));
				}
				listaVend[i][4]=String.valueOf(suma);
				String line = listaVend[i][0] + "; " + listaVend[i][1] + "; " + listaVend[i][2] + "; " + listaVend[i][3] + "; " + listaVend[i][4];
		        writer.write(line);
		        writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}