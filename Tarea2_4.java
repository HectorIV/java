/**
 * @author Héctor Vásquez 8-913-2324
 * Erick Pérez 8-855-1697
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 */
import java.io.*;
import java.util.regex.*;

class AsignarArchivos
{
  private String cont;
  
  private FileReader    f;
  private BufferedReader    e;
  private FileWriter   fd, fl;
  private PrintWriter   d, l;
  
   
  //constructor de la clase Crea_archivo
  AsignarArchivos () throws Exception
  {  try 
       { 
       	 f = new FileReader ("carácter.txt");
         e = new BufferedReader  (f) ;  
         	
         fd = new FileWriter ("dígitos.txt"); 
         d = new PrintWriter (fd); 
         	
         fl = new FileWriter ("letra.txt"); 
         l = new PrintWriter (fl); 	              
       }  
     catch (FileNotFoundException y)
       { throw y; }  
  }
   
//Este metodo usa las expresiones regulares para encontrar cooncidencias entre una cade y el patron que se desea 
     public static int expRegular(String cadena) 
     {
     	int resultado;
     	//Se declara el objeto p que tendra el patron que en este caso es para buscar si son letras y el objeto m evalua la cadena con el patron
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(cadena);
        //Se declara el objeto p que tendra el patron que en este caso es para buscar si son numeros y el objeto m evalua la cadena con el patron
        Pattern p1 = Pattern.compile("[0-9]");
        Matcher m1 = p1.matcher(cadena);
        //find verifica si el objeto m se encuentra una expresión regular
        if(m.find()==true)
        {
        	resultado = 1;
        }
        //find verifica si el objeto m1 se encuentra una expresión regular
        else if(m1.find()==true)
        {
        	resultado = 2;
        }
        //En caso de no encontrar ninguna le asigna 3 para que no grabe caracteres especiales
        else{ 
        	
        	resultado = 3;
        }
        return resultado;
    }   	
    	
   boolean leerEscribir ()  throws Exception
   {   boolean fin = false;
       String digi, letra;
       try 
         {  
           	cont=e.readLine ();
          // para controlar fin de archivo ( no hay más datos)
          // se verifica si el registro es null 
          if (cont == null)
           { //Si fin es true en el main rompe el while y se cierra el programa
           	  fin = true;
           
           }
           //llama a la funcion expRegular verifica si es un numero entero o una letra
           else if(expRegular(cont) == 1)
            {
              l.println(cont);
            }
            	
            else if(expRegular(cont) == 2)
            {
              d.println(cont);
            }
            
            
          }                  
         catch (IOException y)
          {throw y; }
   //Retorna fin para cerrar el ciclo en el main y no se repita
     return fin;         
   }
    
   
   void cerrar() throws Exception
   { try 
   	 {
   	  e.close();
      d.close();
      l.close();
      
       }
     
    catch (IOException y)
     { throw y; } 
   }
	
	
	
}

class Tarea2_4
{
	public static void main (String arg[] ) throws Exception 
  { 
 //Se crea la variable fin
  boolean fin;
  
  try
  {   AsignarArchivos obj = new AsignarArchivos();
      System.out.println ("El contenido del documento carácter.txt es: ");
    //Se inicializa la variable fin en false
    fin = obj.leerEscribir();     
    //El while es necesario ya que si se quita solo hace la opereración una sola vez
    while (fin == false) 
    { 
    	
      try{
       //Mientras fin no retorne true del metodo leerEscribir seguira leyendo caracter.txt y escribiendo digitos.txt y letra.txt
       fin = obj.leerEscribir();}
       catch (Exception z) { 
       	 System.out.println ("Error..."+z);
       }     
         
     }
     System.out.println ("Se han separado en dos documentos uno contiene números y el otro letras, revise su carpeta. :D");
     obj.cerrar();
    }
    catch (Exception z )
    { System.out.println ("+++Error..."+z);  }
     
 } 
	
	
}