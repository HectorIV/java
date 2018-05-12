/**
 * @author Héctor Vásquez 8-913-2324
 * Erick Pérez 8-855-1697
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 */
import java.io.*;

class AsignarArchivos
{
  private String cont;
  private String digi, letra;
  
  private FileReader    f;
  private BufferedReader    e;
  private FileWriter   fd, fl;
  private PrintWriter   d, l;
  
   
  //constructor de la clase Crea_archivo
  AsignarArchivos () throws Exception
  {  try 
       { f = new FileReader ("carácter.txt");
         e = new BufferedReader  (f) ;  
         	
         fd = new FileWriter ("dígitos.txt"); 
         d = new PrintWriter (fd); 
         	
         fl = new FileWriter ("letra.txt"); 
         l = new PrintWriter (fl); 	              
       }  
     catch (FileNotFoundException y)
       { throw y; }  
  }
   
    public static boolean isNumeric(String cadena) 
     {

        boolean resultado;

        try {
            Integer.parseInt(cadena);	
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }   
   boolean leer ()  throws Exception
   {   boolean fin = false;
       
       try 
         {  
         	cont=e.readLine ();
            if(isNumeric(cont) == true)
            {
              d.println(cont);
            }
            	
            else
            {
              l.println(cont);
            }	
            	
          // para controlar fin de archivo ( no hay más datos)
          // se verifica si el registro es null
          if (cont == null)
              fin = true;
          }                  
         catch (IOException y)
          {throw y; }
     return fin;         
   }
    
   String mostrarC()
   { return cont;}
   
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

  boolean fin;
  try
  { AsignarArchivos obj = new AsignarArchivos();
      System.out.println ("El contenido del documento carácter.txt es: ");
    fin = obj.leer();     
    while (fin == false) 
    { try{
    
       System.out.println (obj.mostrarC());
   
   
       fin = obj.leer();}
       catch (Exception z) { 
       	 System.out.println ("+++Error..."+z);
       }     
         
     } 
     System.out.println ("Se han separado en dos documentos uno contiene números y el otro letras, revise su carpeta. :D");
     obj.cerrar();
    }
    catch (Exception z )
    { System.out.println ("+++Error..."+z);  }
     
 } 
	
	
}