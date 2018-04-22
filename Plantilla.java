/**
 * @author Héctor Vásquez 8-913-2324
 * Erick Pérez 8-855-1697
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 */

//Importaciones de paquetes
import java.io.*;

//Clase Padre 

//Clases Hijas



class Principal 
    {  public static void main (String args [])
    
      {
    	 
    	 BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
         
         //Los objetos van aqui 
         
         //La variable elejir es para el menu que esta hecho con un switch se sale con la opción 3 y seguir es para que el do/while continue en ejecución 
    	 int elegir=0, seguir=0;
    
    // Este do/while es para que el programa se repita varias veces 
     do{
         System.out.println("Bienvenido al programa elija una opción:\n\n 1- Op1 \n 2- Op2 \n 3- Salir\n");
         System.out.println("Elije una opción: ");
         try{
         
         elegir=Integer.parseInt(br.readLine());
        //Validación 
         }catch(NumberFormatException  e){
         	System.out.print("Introduzca solo números. ");
         }
         catch(IOException e){
         	System.out.print("Error de entrada/salida. ");
         } 
    	 
    	 //Solo tiene 3 casos para más opciones se deben agregar más case 
    	 //La opción 3 es salir
    	 //default sirve para validar que no se introduzcan numeros negativos o mayores a las opciones
    	 switch(elegir){
    	  case 1:
    	    
    	    System.out.println("Caso 1 metan codigo aqui \n");
             
             break;
          
          case 2:
          	 
          	 System.out.println("Caso 1 metan codigo aqui \n");
          	 
          	 break;
          //Opción para salir
          case 3:
          	 	System.out.println("\nVuelva pronto :D ");
          	 	System.exit(0);
          	 	break;
          //Validación 	
          default:
          	 	 System.out.println("Por favor elija entre las 3 opciones.\n");
          	 	 break;
          
    	 }
    	//Esto se volvera a repetir ya que nunca será diferente a 0
        }while(seguir==0);
      }	                      
  }         