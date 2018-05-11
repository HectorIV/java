import java.io.*;
// Héctor Vásquez
class Lee_archFR_BR
{ private String nom;

  private FileReader    f;
  private BufferedReader    e;


  //constructor de la clase Crea_archivo
  Lee_archFR_BR () throws Exception
  {  try
       { f = new FileReader ("caracter.txt");
         e = new BufferedReader  (f) ;
       }
     catch (FileNotFoundException y)
       { throw y; }
  }


   boolean leer ()  throws Exception
   {   boolean fin = false;
       try
         {nom=e.readLine ();

          // para controlar fin de archivo ( no hay más datos)
          // se verifica si el registro es null
          if (nom == null)
              fin = true;
          }
         catch (IOException y)
          {throw y; }

       return fin;
   }

      String mostrar()
   { return nom;}


   void cerrar() throws Exception
   { try {e.close();}
     catch (IOException y)
     { throw y; }
   }

}

 class Lee_archpFR_BR
{ public static void main (String arg[] ) throws Exception {

  boolean fin;
  try
  { Lee_archFR_BR obj = new Lee_archFR_BR();

    fin = obj.leer();
    while (fin == false)
    { try{

       System.out.println (obj.mostrar());

       fin = obj.leer();}
       catch (Exception z) {
       	 System.out.println ("+++Error..."+z);
       }

     }
     obj.cerrar();
    }
    catch (Exception z )
    { System.out.println ("+++Error..."+z);  }

 }
 }