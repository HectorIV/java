/**
 * @(#)Tarea8.java
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

interface Estadistica
 {  
   int	suma();
   int	maximo();
   int	minimo();
 }

class CVector implements Estadistica
{ protected int vector[] = new int [4];
  public void  asignar(int v[])
  {
  	vector=v;
  }
  public int suma()
	{ int t_suma = 0;
	  
	    for (int x=0; x < vector.length ; x++) 
  			 {
          	    t_suma=t_suma+vector[x];
  			 }
		return t_suma; 
	}
	
  public int maximo()
	{  int max = 0;
	   for(int i = 0; i < vector.length; i++)
	   {
	   	  if(max<vector[i])
			{
				max=vector[i];
			}
	   }
		return  max;
	}
	
  public int minimo()
   {   int min = vector[0] ;
   	  
   	  for(int i = 0; i < vector.length; i++)
	   {
	   	  if(min>vector[i])
			{
				min=vector[i];
			}
	   }
   	    return min;
   }
}

class CMatriz implements Estadistica
{
  protected int matriz[][] = new int [4][4];
  public void  asignar(int m[][])
  {
  	matriz=m;
  }
  public int suma()
	{ int t_suma = 0;
	    for (int x=0; x < matriz.length; x++) 
    	  { 
  			for (int y=0; y < matriz[x].length; y++) 
  			 {
             t_suma = t_suma + matriz[x][y];
  		
             }
          }
		return t_suma; 
	}
	
  public int maximo()
	{  int max = 0;
	
	    for (int x=0; x < matriz.length; x++) 
    	  { 
  			for (int y=0; y < matriz[x].length; y++) 
  			 {  
  			 if(max<matriz[x][y])
			   {
                max =  matriz[x][y];
			   }
             }
          }
	
		return  max;
	}
	
  public int minimo()
   {   int min = matriz[0][0];
   
      	 for (int x=0; x < matriz.length; x++) 
    	  { 
  			for (int y=0; y < matriz[x].length; y++) 
  			 {  
  			 if(min>matriz[x][y])
			   {
                min =  matriz[x][y];
			   }
             }
          }
   
   	    return min;
   }
}

class Tarea8
    {  public static void main (String args [])
    
      {
    	 
    	 BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    	 CVector v = new CVector();
    	 CMatriz m = new CMatriz();
    	 int matriz[][] = new int[4][4];
    	 int vector[] = new int [4];
    	 int elegir=0, seguir=0;
    	 
     do{
         System.out.println("Bienvenido al programa elija una opción:\n\n 1- Matriz \n 2- Vector \n 3- Salir\n");
         System.out.println("Elije una opción: ");
         try{
         
         elegir=Integer.parseInt(br.readLine());
         
         }catch(NumberFormatException  e){
         	System.out.print("Introduzca solo números. ");
         }
         catch(IOException e){
         	System.out.print("Error de entrada/salida. ");
         } 
    	 
    	 switch(elegir){
    	 case 1:
    	 
    	 
    	 for (int x=0; x < matriz.length; x++) 
    	  {
  			for (int y=0; y < matriz[x].length; y++) 
  			 { try{
  			   System.out.println("Llene la matriz: ");
               matriz[x][y]=Integer.parseInt(br.readLine());
  			   }
  			   catch(IOException e){
         	     System.out.print("Error de entrada/salida.\n");
         	     y--;
                }
  			   catch(NumberFormatException e){
         	     System.out.print("Solo Introduzca numeros.\n");
         	     y--;
               }
             }
          }
          System.out.println("Matriz");
          for (int x=0; x < matriz.length; x++) 
    	  { System.out.print("\n");
  			for (int y=0; y < matriz[x].length; y++) 
  			 {
               System.out.print(matriz[x][y]);
               System.out.print(" ");
  		
             }
          }
          
             m.asignar(matriz);
             System.out.println("\nSuma total de la Matriz: "+m.suma());
             System.out.println("Máximo de la Matriz: "+m.maximo());
             System.out.println("Minimo de la Matriz: "+m.minimo());
          
          break;
          
          case 2:
          	

  			for (int x=0; x < 4 ; x++) 
  			 { 
  			   try{
  			   System.out.println("Llene el vector: ");
               vector[x]=Integer.parseInt(br.readLine());
  			   }
  			   catch(IOException e){
         	     System.out.print("Error de entrada/salida.\n");
         	     x--;
                }
  			   catch(NumberFormatException e){
         	     System.out.print("Solo Introduzca numeros.\n");
         	     x--;
               }
             }
             System.out.println("Vector");
             for (int x=0; x < 4 ; x++) 
  			 {
          	    System.out.println(vector[x]);
  			 }
  			 v.asignar(vector);
             System.out.println("Suma total del Vector: "+v.suma());
             System.out.println("Máximo del Vector: "+v.maximo());
             System.out.println("Minimo del Vector: "+v.minimo());
          	  
 
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