/**
 * @(#)F2b.java
 *
 *
 * @author Héctor Vásquez
 * @version 1.00 2018/5/9
 */
 import java.io.*;
class Crea_arcFW_PW
{ private char ca1;
  private char ca2;
  private char ca3;
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

   void asignar (char a, char b, char c)
   {ca1=a;  ca2= b;   ca3=c;}

   //se guarda cada dato en una linea nueva
   void grabar () throws Exception
   { try {s.println(ca1);

          s.println(ca2);

          s.println(ca3);

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

 class Crea_archpFW_PW {

public static void main (String [] arg) throws IOException {

  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
  char c1,c2,c3;

  try{
  Crea_arcFW_PW obj = new Crea_arcFW_PW();


  	 try {
  	   System.out.println ("Entre el caracter 1:  ");
       c1=(char)br.read();
         br.skip(1);
       System.out.println ("Entre el caracter 2:  ");
       c2=(char)br.read();
         br.skip(1);
       System.out.println ("Entre el caracter 3:  ");
       c3=(char)br.read();
         br.skip(1);
       obj.asignar(c1,c2,c3);
       obj.grabar();
     }catch (Exception e){
  	   System.out.println(e);}
  obj.cerrar();
 }catch (Exception e){
  	System.out.println(e);
  	}
 }


}