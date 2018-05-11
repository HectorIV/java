/**
 * @(#)F2a.java
 *
 *
 * @author Héctor Vásquez
 * @version 1.00 2018/5/9
 */

import java.io.*;
class Crea_arcFW_PW
{ private String ced;
  private String nom;
  private String edad;
  private FileWriter   f;
  private PrintWriter   s;

    //constructor de la clase
   Crea_arcFW_PW () throws Exception
  {   try
        { f = new FileWriter ("caracter.txt");
          s = new PrintWriter (f);
        }

      catch (IOException e)
        { throw e;  }

  }


   //se guarda cada dato en una linea nueva
   void grabar () throws Exception
   { try {
   for(int i=0;i<=9;i++)
   {
   	 s.println(i);
   }

          }
     catch (SecurityException e)
     { throw e;}
    }

   void cerrar() throws Exception
   { try {s.close();
          f.close(); }
     catch (IOException e)
     { throw e; }
   }

}

 class Crea_archpFW_PW
{ public static void main (String [] arg) throws IOException {

  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
  int i;
  try{
  Crea_arcFW_PW obj = new Crea_arcFW_PW();

  obj.grabar();
  obj.cerrar();
 }catch (Exception e){
  	System.out.println(e);
  	}

 }}