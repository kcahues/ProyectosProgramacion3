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
        
        //Metodo de creación y sobreescribir archivo
	public void crearArchivo(ArrayList<Jugador> lista) {
		FileWriter fw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("C:\\Tmp\\Ruleta.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(fw);
			for (Jugador jugador : lista) {
				//escribe los datos en el archivo separados por coma
				bfwriter.write(jugador.getIdJugador() + "," + jugador.getNombre() + "," 
                                        + jugador.getSaldo()
						+ "," + jugador.isBorrado() + "\n");
			}
			//cierra el buffer 
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
                                        //cierra el flujo principal
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
                        //Se recorre linea por linea
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
                //Se retorna la lista
		return listaJugadores;
	}
	
        
    //Obtiene numero random de 1 a 10
    public int getRandom(){
        return (int) (Math.random()*10) + 1;
    } 
    
    
    //Impresion de titulo
    public void titulo(){
        System.out.println("|--------------------------------------------|");
        System.out.println("                  _      _   _               |");
        System.out.println("                 | |    | | | |              |");
        System.out.println("  _ __ ___  _   _| | ___| |_| |_ ___         |");
        System.out.println(" | '__/ _ \\| | | | |/ _ \\ __| __/ _ \\        |");
        System.out.println(" | | | (_) | |_| | |  __/ |_| ||  __/        |");
        System.out.println(" |_|  \\___/ \\__,_|_|\\___|\\__|\\__\\___|        |");
        System.out.println("|                                            |");
        System.out.println("|--------------------------------------------|");
    }
    
    //Menu principal
    public void menu(){
        titulo();
        System.out.println("|");
        System.out.println("| Bienvenido a la ruleta de Kevin Cahues      ");
        System.out.println("|");
        System.out.println("| ¿Ya cuentas con un ID?                      ");
        System.out.println("  1. Inicia sesion                      ");
        System.out.println("  2. Crea tu usuario                      ");
        System.out.println(" ");
        System.out.println("Ingresa la opción: ");
    }
    
    
    //Creación de usuario (Añadir registro nuevo)
    public void menuCreacion(Jugador jugador){
        titulo();
        System.out.println("|");
        System.out.println("| Creacion de usuario            ");
        System.out.println("");
        //Se valida si el fichero existe
        boolean existe = false;
        String sFichero = "C:\\Tmp\\Ruleta.txt";
        String sFichero2 = "C:\\Tmp";
        File fichero = new File(sFichero);
        File carpeta = new File(sFichero2);
        ArrayList<Jugador> lista = new ArrayList<>();
        
        
        //Verifica si el archivo existe
        if (fichero.exists()){
            //Lee la información
            existe = true;
            lista = leerArchivo();
            for (Jugador jug : lista) {
                
                //Por defecto asigna el id y se quedara el ultimo
                jugador.setIdJugador(jug.getIdJugador()+1);
            }
            }else{
            //Verifica si existe la carpeta
            if (!carpeta.exists()){
                //Si no existe crea la carpeta 
                carpeta.mkdir();
            }
            //De no existir por defecto asigna 1 al correlativo
            jugador.setIdJugador(1);
            //Desactiva el flag
            existe = false;
        }
        
        //Asignación de datos
         System.out.println("| ID Asignado: " + jugador.getIdJugador());
         System.out.println("");
        System.out.println("Ingrese su nombre: ");
        Scanner objInput = new Scanner(System.in);
   
        //Recibe el valor del buffer del teclado
        String nombre = objInput.nextLine();
        
        //Se setean los datos 
        jugador.setNombre(nombre);
        jugador.setSaldo(100);
        jugador.setBorrado(false);
        //Crea archivo de lista
        ArrayList<Jugador> lista2 = new ArrayList<>();
        if (!existe) {
            //Archivo con un solo registro
            lista2.add(jugador);
            crearArchivo(lista2);
        }else{
            //De ya existir agrega un registro
            lista.add(jugador);
            crearArchivo(lista);
        }

    }
    
    
    //Menu del juego
    public void menuJuego(String nombre){
        System.out.println("Bienvenido " + nombre);
        System.out.println("Presiona una tecla para iniciar...");
        Scanner objInput = new Scanner(System.in);
        objInput.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
    }
    
    //Delay para simular que la ruleta esta corriendo
    public void sleep(){
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException ex) {
        }
    }
    
    //Rutina principal del juego
    public void iniciaJuego(Jugador jugador){
        //Muestra el menu del juego
        menuJuego(jugador.getNombre());
        
        //Primero chequea que tenga saldo
        if (jugador.getSaldo() == 0) {
            System.out.println("El jugador no cuenta con creditos para participar");
            System.out.println("Desea agregar 100 creditos nuevos?");
            
            // Define variables
            Scanner objInput = new Scanner(System.in);
            String strValor = null;
            
            //De no tener, permite si quiere agregar creditos
            do {
            System.out.println("1: Si / 2: No");
            //Recibe el valor del buffer del teclado
            String strOpcion = objInput.nextLine();
            strValor = strOpcion;

            switch(strOpcion){
                case "1":
                    //Se setean los nuevos 100 creditos
                     System.out.println("Se agregaron nuevos creditos");
                     jugador.setSaldo(100);
                    break;
                case "2":
                    //No se hace nada
                     System.out.println("No se agregaron nuevos creditos");
                    break;
                default:
                    System.out.println("Hubo un error en seleccionar las opciones");
                    break;
            }
            System.out.println("");
            
        //Ejecuta mientras el valor sea diferente a 1 y 2 (por si hay errores)
        } while (!strValor.equals("1") && !strValor.equals("2"));
            
        }else{
            //Inicio del juego
            System.out.println("Instrucciones:");
            System.out.println("- La  ruleta la cual está dividida en 10 partes, del 1 al 10");
            System.out.println("- Los números pares son negros y los números impares son blancos.");
            System.out.println("- Cada apuesta es de 10 unidades.");
            System.out.println("- Si el jugador acierta el número entonces ganará el triple de la apuesta.");
            System.out.println("- - Si el jugador acierta al color entonces ganará el doble..");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
                
            // Define variables
            Scanner objInput = new Scanner(System.in);
            String strValor = null;
            do {            
                
                System.out.println("Su saldo es: " + jugador.getSaldo());
                System.out.println("¿Desea continuar? 1. Si / 2. No");
                
                //Recibe el valor del buffer del teclado
                String strOpcion = objInput.nextLine();
                strValor = strOpcion;
                
                switch(strOpcion){
                    case "1":
                        
                        int numero = 0;
                        // Define variables
                        Scanner objInput2 = new Scanner(System.in);
                                                  
                        System.out.println("Ingrese el número a apostar 1 a 10");
                        String strOpcion2 = objInput.nextLine();
                        numero = Integer.parseInt(strOpcion2);
                        System.out.println("Se corre la ruleta");
                        System.out.println(".");
                        //Ejecuta delay para simular que corre la ruleta
                        sleep();
                        System.out.println("..");
                        sleep();
                        System.out.println("...");
                        sleep();
                        //Se llama la rutina para obtener el random
                        int valRuleta = getRandom();
                        System.out.println("El valor de la ruleta es:" + valRuleta);
                        //Condiciones generales del juego
                        //Si son iguales
                        if (valRuleta == numero) {
                            System.out.println("Ha acertado el resultado!");
                            //Al valor que ya se tiene se le suman 30 puntos
                            jugador.setSaldo(jugador.getSaldo() + (10 * 3));
                            //Si ambos son par significa que le apunto al color negro
                        }else if( (numero % 2) == 0 && (valRuleta % 2) == 0){
                            //Hizo match con color negro
                            System.out.println("Ha acertado con el color negro");
                            //Se suma 20 al saldo
                            jugador.setSaldo(jugador.getSaldo() + (10 * 2));
                            //Si los numeros con mod de 2 nos da 1 en ambos
                            //Se le pego al color blanco
                        }else if( (numero % 2) == 1 && (valRuleta % 2) == 1){
                            //Hizo match con color blanco
                            System.out.println("Ha acertado con el color negro");
                            jugador.setSaldo(jugador.getSaldo() + (10 * 2));
                        }else{
                            //De no hacer match con ninguno le resta los 10 de
                            //la tirada
                            System.out.println("No ha acertado :( ");
                            jugador.setSaldo(jugador.getSaldo() - 10);
                        }

                        break;

                    case "2":
                         System.out.println("Saliendo del juego...");
                        break;
                    default:
                        System.out.println("Hubo un error en seleccionar las opciones");
                        break;
                }
             
                //Sale cuando el saldo sea menor de 10 y el valor no sea 2
            } while (jugador.getSaldo() >= 10 && !strValor.equals("2"));
            
        }
        
        //Lee la información
        ArrayList<Jugador> lista = new ArrayList<>();
        ArrayList<Jugador> lista2 = new ArrayList<>();
        lista = leerArchivo();
        //Se recorre la lista
        for (Jugador jug : lista) {

            //Verifica si el id existe y procede
            if (jug.getIdJugador() == jugador.getIdJugador()) {
                jugador.setIdJugador(jug.getIdJugador());
                jugador.setNombre(jug.getNombre());
                //jugador.setSaldo(jug.getSaldo());
                jugador.setBorrado(jug.isBorrado());

                //Se actualiza el registro
                lista2.add(jugador);
            }else{
                //Se agrega los datos ya existentes
                lista2.add(jug);
            }


        }
        //Se almacena en disco
        crearArchivo(lista2);
    }
    
    //Menu de inicio
    public boolean menuInicio(String codigo, Jugador jugador, boolean error){
        titulo();
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
            //Si el ID es 0 significa que no lo encontro
            if (jugador.getIdJugador() == 0)  {
                 error = true;   
            }
            
            }else{
            error = true;
        }
        
        //Si no hay error muestra su información 
        if (!error) {
            System.out.println("| Bienvenid@ " + jugador.getNombre());
            System.out.println("");
            System.out.println("| ID : " + jugador.getIdJugador());
            System.out.println("");


        }else{
            System.out.println("El ID no existe. Verifique");
        }
        return error;
    }
}