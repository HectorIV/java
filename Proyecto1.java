/**
 * Grupo 1LS123
 * @author 
 * Erick P�rez 8-855-1697
 * H�ctor V�squez 8-913-2324
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 * @version 1.00 2018/4/7
 */
import java.io.*;



interface Encuesta {
    static final int t=5;
    
    void asignar(int x[][]);
    int[] calcularCiertas();
    double calcularPorcentaje();
}

class Encuesta1 implements Encuesta{
    private int m[][];
    
    Encuesta1(){
        m=new int[t][t];
    }
    
    @Override
    public void asignar(int x[][]){
        m=x;
    }
    @Override
    public int[] calcularCiertas(){
        int suma=0,x=0,vec[]=new int[5];
            for (int i = 0; i < t; i++){
                for (int j = 0; j < t; j++) {
                        if(m[i][j]==1)
                            suma+=1;
                }
            vec[x]=suma;
            x++;
            suma=0;
            }
        return vec;
    }
    
    @Override
    public double calcularPorcentaje(){
         int suma=0;
         double porc;
        for (int i = 0; i < t; i++)
            for (int j = 0; j < t; j++) {
                    if(m[i][j]==1)
                        suma+=1;
            }
        porc=(100*suma)/(t*t);
        return porc;
    }
}

class Encuesta2 extends Encuesta1
{  private int m[][];
    
    Encuesta2(){
        m=new int[t][t];
    }
    
    @Override
    public void asignar(int x[][]){
        m=x;
    }
    @Override
    public int[] calcularCiertas(){
        int suma=0,x=0,vec[]=new int[5];
            for (int i = 0; i < t; i++){
                for (int j = 0; j < t; j++) {
                        if(m[i][j]==1)
                            suma+=1;
                }
            vec[x]=suma;
            x++;
            suma=0;
            }
        return vec;
    }
    
    @Override
    public double calcularPorcentaje(){
         int suma=0;
         double porc;
        for (int i = 0; i < t; i++)
            for (int j = 0; j < t; j++) {
                    if(m[i][j]==1)
                        suma+=1;
            }
        porc=(100*suma)/(t*t);
        return porc;
    }
}
	

public class Proyecto1
    {  public static void main (String args [])
    
      {
    	 
    	 BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
         
         //Los objetos van aqui 
         Encuesta1 obj = new Encuesta1();
         Encuesta2 obj2 = new Encuesta2();
         //La variable elejir es para el menu que esta hecho con un switch se sale con la opci�n 3 y seguir es para que el do/while continue en ejecuci�n 
    	 int elegir=0, seguir=0, p=0;
         //Vector de preguntas
         String preguntas[] = new String [5];
         preguntas[0]= "�Pregunta 1?";
         preguntas[1]= "�Pregunta 2?";
         preguntas[2]= "�Pregunta 3?";
         preguntas[3]= "�Pregunta 4?";
         preguntas[4]= "�Pregunta 5?";
         //Respuestas
         int respuesta[][] = new int [5][5];
         int respuesta2[][] = new int [5][5];
         int vec1[]=new int[5];
         int vec2[]=new int[5];
         int entro=0;
         
    // Este do/while es para que el programa se repita varias veces 
     do{
         System.out.println("Bienvenido al programa elija una opci�n:\n\n 1- Encuesta 1 \n 2- Encuesta 2 \n 3- Salir\n");
         System.out.println("Elije una opci�n: ");
         elegir=0;
         try{
         
         elegir=Integer.parseInt(br.readLine());
        //Validaci�n 
         }catch(NumberFormatException  e){
         	System.out.print("Introduzca solo n�meros. ");
         }
         catch(IOException e){
         	System.out.print("Error de entrada/salida. ");
         } 
    	 
    	 //Solo tiene 3 casos para m�s opciones se deben agregar m�s case 
    	 //La opci�n 3 es salir
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
          //Opci�n para salir
          case 3:
          	 	System.out.println("\nVuelva pronto :D ");
          	 	System.exit(0);
          	 	break;
          //Validaci�n 	
          default:
          	 	 System.out.println("Por favor elija entre las 3 opciones.\n");
          	 	 break;
    	 }
    	//Esto se volvera a repetir ya que nunca ser� diferente a 0
        }while(seguir==0);
      }	                      
  }  