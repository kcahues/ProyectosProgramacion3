package com.kc.bo;

import com.kc.entity.Jugador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kevin
 */
public class JugadorBO {
        //Se instancian para usar en todos los metodos
        
        //Metodo de creación
	public void crearArchivo(ArrayList<Jugador> lista) {
		FileWriter fw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("C:\\Tmp\\Ruleta.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(fw);
			for (Jugador jugador : lista) {
				//escribe los datos en el archivo
				bfwriter.write(jugador.getIdJugador() + "," + jugador.getNombre() + "," 
                                        + jugador.getSaldo()
						+ "," + jugador.isBorrado() + "\n");
			}
			//cierra el buffer 
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {//cierra el flujo principal
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//crea el archivo en disco, retorna la lista de estudiantes
	public ArrayList leerArchivo() {
		// crea el flujo para leer desde el archivo
		File file = new File("C:\\Tmp\\Ruleta.txt");
		ArrayList listaJugadores= new ArrayList<Jugador>();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Jugador jugador= new Jugador();
                                jugador.setIdJugador(Integer.parseInt(delimitar.next()));
                                jugador.setNombre(delimitar.next());
                                jugador.setSaldo(Integer.parseInt(delimitar.next()));
                                jugador.setBorrado(Boolean.parseBoolean(delimitar.next()));
				listaJugadores.add(jugador);
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaJugadores;
	}
	
	//añadir más estudiantes al archivo
	public void agregaArchivo(ArrayList<Jugador> lista) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("C:\\Tmp\\Ruleta.txt", true);
			BufferedWriter bf = new BufferedWriter(flwriter);
			for (Jugador jugador : lista) {
				//escribe los datos en el archivo
				bf.write(jugador.getIdJugador() + "," + jugador.getNombre() + "," + jugador.getSaldo()
						+ "," + jugador.isBorrado() + "\n");
			}
			bf.close();
			System.out.println("Archivo modificado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
                    if (flwriter != null) {
                            try {
                                    flwriter.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
		}
	}
        
    public int getRandom(){
        return (int) (Math.random()*10) + 1;
    } 
    
    public boolean validaUsuario(int idPersona, int recibido){
        if(idPersona == recibido){
            return true;
        }else{
            return false;
        }  
    }
    
    public void menu(){
        System.out.println("|--------------------------------------------|");
        System.out.println("                  _      _   _               |");
        System.out.println("                 | |    | | | |              |");
        System.out.println("  _ __ ___  _   _| | ___| |_| |_ ___         |");
        System.out.println(" | '__/ _ \\| | | | |/ _ \\ __| __/ _ \\        |");
        System.out.println(" | | | (_) | |_| | |  __/ |_| ||  __/        |");
        System.out.println(" |_|  \\___/ \\__,_|_|\\___|\\__|\\__\\___|        |");
        System.out.println("|                                            |");
        System.out.println("|--------------------------------------------|");
        System.out.println("|");
        System.out.println("| Bienvenido a la ruleta de Cahues            ");
        System.out.println("|");
        System.out.println("| ¿Ya cuentas con un ID?                      ");
        System.out.println("  1. Inicia sesion                      ");
        System.out.println("  2. Crea tu usuario                      ");
        System.out.println("  3. Salir                      ");
        System.out.println(" ");
        System.out.println("Ingresa la opción: ");
    }
    
    public void menuCreacion(Jugador jugador){
        System.out.println("|--------------------------------------------|");
        System.out.println("                  _      _   _               |");
        System.out.println("                 | |    | | | |              |");
        System.out.println("  _ __ ___  _   _| | ___| |_| |_ ___         |");
        System.out.println(" | '__/ _ \\| | | | |/ _ \\ __| __/ _ \\        |");
        System.out.println(" | | | (_) | |_| | |  __/ |_| ||  __/        |");
        System.out.println(" |_|  \\___/ \\__,_|_|\\___|\\__|\\__\\___|        |");
        System.out.println("|                                            |");
        System.out.println("|--------------------------------------------|");
        System.out.println("|");
        System.out.println("| Creacion de usuario            ");
        System.out.println("");
        //Se valida si el fichero existe
        boolean existe = false;
        String sFichero = "C:\\Tmp\\Ruleta.txt";
        File fichero = new File(sFichero);
        ArrayList<Jugador> lista = new ArrayList<>();
        
        if (fichero.exists()){
            //Lee la información
            existe = true;
            lista = leerArchivo();
            for (Jugador jug : lista) {
                System.out.print(jug.getIdJugador());
                //Por defecto asigna el id y se quedara el ultimo
                jugador.setIdJugador(jug.getIdJugador()+1);
            }
            }else{
            //De no existir por defecto asigna 1 
            jugador.setIdJugador(1);
            existe = false;
        }
        
        //Asignación de datos
         // Define variables
         System.out.println("| ID Asignado: " + jugador.getIdJugador());
         System.out.println("");
        System.out.println("Ingrese su nombre: ");
        Scanner objInput = new Scanner(System.in);
   
        //Recibe el valor del buffer del teclado
        String nombre = objInput.nextLine();
        
        //Se limpia el buffer para que no se salte el menu
        //objInput.nextLine();
       jugador.setNombre(nombre);
        jugador.setSaldo(100);
        
        jugador.setBorrado(false);
        //Crea archivo de lista
            ArrayList<Jugador> lista2 = new ArrayList<>();
        if (!existe) {
            
            lista.add(jugador);
            crearArchivo(lista2);
        }else{
            //De ya existir agrega un registro
            lista.add(jugador);
            crearArchivo(lista);
        }

    }
    
    public void iniciaJuego(Jugador jugador){
        System.out.println(jugador.getIdJugador() + " " + jugador.getNombre() + " " +
                           jugador.getSaldo() );
        
        //Se guardan los resultados
        jugador.setSaldo(999);
    }
    
    public void menuInicio(String codigo, Jugador jugador, boolean error){
        System.out.println("|--------------------------------------------|");
        System.out.println("                  _      _   _               |");
        System.out.println("                 | |    | | | |              |");
        System.out.println("  _ __ ___  _   _| | ___| |_| |_ ___         |");
        System.out.println(" | '__/ _ \\| | | | |/ _ \\ __| __/ _ \\        |");
        System.out.println(" | | | (_) | |_| | |  __/ |_| ||  __/        |");
        System.out.println(" |_|  \\___/ \\__,_|_|\\___|\\__|\\__\\___|        |");
        System.out.println("|                                            |");
        System.out.println("|--------------------------------------------|");
        System.out.println("|");
        //Se valida si el fichero existe
        String sFichero = "C:\\Tmp\\Ruleta.txt";
        File fichero = new File(sFichero);
        if (fichero.exists()){
            //Lee la información
            ArrayList<Jugador> lista = new ArrayList<>();
            lista = leerArchivo();
            for (Jugador jug : lista) {
                //Verifica si el id existe y procede
                if (jug.getIdJugador() == Integer.parseInt(codigo)) {
                    jugador.setIdJugador(jug.getIdJugador());
                    jugador.setNombre(jug.getNombre());
                    jugador.setSaldo(jug.getSaldo());
                }
                
            }
            }else{
            error = true;
        }
        
        if (!error) {
            System.out.println("| Bienvenid@ " + jugador.getNombre());
            System.out.println("");
            System.out.println("| ID : " + jugador.getIdJugador());
            System.out.println("");


        }
    }
}
