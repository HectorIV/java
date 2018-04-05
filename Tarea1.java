/**
 * @(#)Tarea1.java
 *
 *
 * @author Héctor Vásquez 8-913-2324
 * Erick Pérez 8-855-1697
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 * @version 1.00 2018/3/29
 */
 
 import java.io.*;
 
 
class Poligono {    	 
   
 private int ancho , altura;   
 
  void set_atributos (int a, int b) {  
  ancho=a; altura=b;}
  
  int get_altura( ){
  	return altura;
  }
  
  int get_ancho( ){
  	return ancho;
  }   
}   
   	  
class Rectangulo  extends Poligono {    
 
  	  public int area() { 
  	  return get_ancho() * get_altura() ; 
       }   
}  	 

class Triangulo extends Poligono{
	
	  public int area() { 
  	  return get_ancho() * get_altura() / 2 ; 
       }  
} 


public class Tarea1 {

	public static void main (String[] args){
		
       Rectangulo recta = new Rectangulo();
       Triangulo tria = new Triangulo();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       //Variables
        int elegir=0, seguir=0, ancho=0, altura=0;
        boolean  a=true;
        
      //El do/while que permite que el ciclo se repita
        do{
         System.out.println("Bienvenido al programa elija una opción:\n\n 1- Calcular el área del Rectángulo\n 2- Calcular  el área del Triángulo\n 3- Salir\n");
         System.out.println("Elije una opción: ");
         try{
         
         elegir=Integer.parseInt(br.readLine());
         
         }catch(NumberFormatException  e){
         	System.out.print("Introduzca solo números. ");
         }
         catch(IOException e){
         	System.out.print("Error de entrada/salida ");
         }
         
          switch(elegir){
          	
         	 case 1:
         	 do{
         	 a= true;  
         	 try{
         	 	
         	 System.out.println("INTRODUZCA EL ANCHO DEL RECTANGULO: "); 
         	 	 ancho=Integer.parseInt(br.readLine());
         	 System.out.println("INTRODUZCA LA ALTURA DEL RECTANGULO: ");	
         	     altura=Integer.parseInt(br.readLine());
         	 } 
         	 catch(NumberFormatException ex)
         	 {
         	 	System.out.println("\n\n Ha ocurrido un error en la lectura"+ex+"\n\n");
         	 	a=false;
         	 }
         	 catch(IOException e){
         	System.out.print("Error de entrada/salida ");
         	a=false;
             }
         	 }while(a==false);	
         	 	
         	 recta.set_atributos (ancho,altura);
         	 	    	  
          	 System.out.println("AREA DEL RECTANGULO: " +  recta.area()+"\n");   
          	    break;
          	    
             /*Caso 2 triangulo*/
             
          	 case 2:
          	 do{
         	 a= true;  
         	 try{
         	 		
          	 System.out.println("INTRODUZCA EL ANCHO DEL TRIANGULO: "); 
          	 	  ancho=Integer.parseInt(br.readLine());
         	 System.out.println("INTRODUZCA LA ALTURA DEL TRIANGULO: ");
         	      altura=Integer.parseInt(br.readLine());
         	 }catch(NumberFormatException ex){
         	 	System.out.println("\n\n Ha ocurrido un error en la lectura"+ex+"\n\n");
         	 	a=false;
         	 }         
         	 catch(IOException e){
         	  System.out.print("Error de entrada/salida ");
         	  a=false;
             }
         	 }while(a==false);
         	 	
          	 tria.set_atributos (ancho,altura);     	  
          	 System.out.println("AREA DEL TRIANGULO: " +  tria.area()+"\n" );   
          	    break;
          	 
          	 case 3:
          	 	System.out.println("\nVuelva pronto :D ");
          	 	System.exit(0);
          	 	break;
          	 	
          	 default:
          	 	 System.out.println("Por favor elija entre las 3 opciones.\n");
          	 	 break;
          }
          

         
        }while(seguir==0);

}
    
    
}