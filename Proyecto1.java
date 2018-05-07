/**
 * Grupo 1LS123
 * @author 
 * Erick Pérez 8-855-1697
 * Héctor Vásquez 8-913-2324
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 * @version 1.00 2018/4/7
 */
import java.io.*;

    class Encuesta1{
    private int m[][];
    
    Encuesta1(){
        m=new int[5][5];
    }
    
    
    public void asignar(int x[][]){
        m=x;
    }
    
    public int[] calcularCiertas(){
        int suma=0,x=0,vec[]=new int[5];
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                        if(m[i][j]==1)
                            suma+=1;
                }
            vec[x]=suma;
            x++;
            suma=0;
            }
        return vec;
    }
    
   
    public double calcularPorcentaje(){
         int suma=0;
         double porc;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                    if(m[i][j]==1)
                        suma+=1;
            }
        porc=(100*suma)/(25);
        return porc;
    }
}

class Encuesta2 extends Encuesta1
{ 
     private int m[][];
    Encuesta2(){
        m=new int[5][5];
    }
    
    @Override
    public void asignar(int x[][]){
        m=x;
    }
    
    
    public int[][] getMatriz(){
    	return m;
    	}
    @Override
    public int[] calcularCiertas(){
        
        int suma=0,x=0,vec2[]=new int[5];
        vec2=super.calcularCiertas();
            
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                        if(m[i][j]==1)
                            suma+=1;
                }
            vec2[x]+=suma;
            x++;
            suma=0;
            }
        return vec2;
    }
    
    @Override
    public double calcularPorcentaje(){
         int suma=0,veca[]=calcularCiertas();
         double porc;
        
        for (int i = 0; i < veca.length; i++)
            suma+=veca[i];
            
        porc=(100*suma)/(50);
        return porc;
    }
}
	

public class Proyecto1
    {  public static void main (String args [])
    
      {
    	 
    	 BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
         
         //Los objetos van aqui 
         Encuesta1 obj;
         Encuesta2 obj2;
         //La variable elejir es para el menu que esta hecho con un switch se sale con la opción 3 y seguir es para que el do/while continue en ejecución 
    	 int elegir=0, seguir=0, p=0;
         //Vector de preguntas
         String preguntas[] = new String [5];
         preguntas[0]= "¿Pregunta 1?";
         preguntas[1]= "¿Pregunta 2?";
         preguntas[2]= "¿Pregunta 3?";
         preguntas[3]= "¿Pregunta 4?";
         preguntas[4]= "¿Pregunta 5?";
         //Respuestas
         int respuesta[][] = new int [5][5];
         int respuesta2[][] = new int [5][5];
         int vec1[]=new int[5];
         int vec2[]=new int[5];
         int entro=0;
         
    // Este do/while es para que el programa se repita varias veces 
     do{
         System.out.println("Bienvenido al programa elija una opción:\n\n 1- Encuesta 1 \n 2- Encuesta 2 \n 3- Salir\n");
         System.out.println("Elije una opción: ");
         elegir=0;
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
                 obj= new Encuesta1();
    	    System.out.println("Responda la Encuesta con un 1 si es verdadero y con 0 si es falso. \n");
    	       
    	      for(int e=0; e<=4;e++)
    	      { p=e+1;
    	      	System.out.println("Persona "+p);
    	      	
    	       for(int i=0; i<=4;i++)
    	       { 
    	       	
    	       	try{
    	       		
    	       	do{
    	       	System.out.println(preguntas[i]);
    	       	
    	       	respuesta[e][i]=Integer.parseInt(br.readLine());
    	       	
    	       	}while(respuesta[e][i]<0||respuesta[e][i]>1);
    	        }
    	        catch(IOException a){
         	     System.out.print("Error de entrada/salida.\n");
         	     i--;
         	     
                  }
  			     catch(NumberFormatException a){
  			   	
         	     System.out.print("Solo Introduzca numeros.\n");
         	     i--;
                 }
    	       	
    	       }
    	      }
              int y=1;
              obj.asignar(respuesta);
                 vec1=obj.calcularCiertas();
                 for(int i = 0; i < vec1.length; i++){
          	 System.out.println("Total de Si de la pregunta "+y+"\n"+vec1[i]);
                 y+=1;
                 }
                 System.out.println("Calcular porcentaje de respuestas Si \n"+obj.calcularPorcentaje()+"%");
              entro=1;
                 break;
         
          case 2:
          	if(entro==1)
          	{ obj2= new Encuesta2();
              System.out.println("Responda la Encuesta con un 1 si es verdadero y con 0 si es falso. \n");
    	       
    	      for(int e=0; e<=4;e++)
    	      { p=e+1;
    	      	System.out.println("Persona "+p);
    	      	
    	       for(int i=0; i<=4;i++)
    	       { 
    	       	
    	       	try{
    	       		
    	       	do{
    	       	System.out.println(preguntas[i]);
    	       	
    	       	respuesta2[e][i]=Integer.parseInt(br.readLine());
    	       	
    	       	}while(respuesta2[e][i]<0||respuesta2[e][i]>1);
    	        }
    	        catch(IOException a){
         	     System.out.print("Error de entrada/salida.\n");
         	     i--;
         	     
                  }
  			     catch(NumberFormatException a){
  			   	
         	     System.out.print("Solo Introduzca numeros.\n");
         	     i--;
                 }
    	       	
    	       }
    	      }
              y=1;
              obj2.asignar(respuesta2);
                 vec2=obj2.calcularCiertas();
                 for(int i = 0; i < vec2.length; i++){
                 int totalV= vec1[i]+vec2[i];	
          	 System.out.println("Total de Si de la pregunta "+y+"\n"+totalV);
                 y+=1;
                 }
                 System.out.println("Calcular porcentaje de respuestas Si \n"+obj2.calcularPorcentaje()+"%");
          	}
          	else{
          		System.out.println("Ingrese la encuesta 1 para poder introducir la encuesta 2");
          	}     
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