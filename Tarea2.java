/**
 * @(#)Tarea1.java
 *
 *
 * @author H�ctor V�squez 8-913-2324
 * Erick P�rez 8-855-1697
 * Aldair Duque 8-923-2304
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 * @version 1.00 2018/4/7
 */
 
 import java.io.*;
 
class Persona  {  
  	private String nombre;  
   	private int a_nac;
  	  
        public void  asignar  (String n, int a)   
   	   { 
   	   	nombre = n; a_nac = a;
   	   }   	
   		   
       public String  get_nom()
   	   { 
   	   	return nombre;
   	   }  

       public int  get_a()
   	   { 
   	   	return a_nac;
   	   }
   	public int calcularA(int a�o_ac)
   	   { 
   	   	return a�o_ac - a_nac;
   	   }    
 }  	 
 	 
 class Alumno extends Persona {  
    private int totcredito, puntos;     
    private  String carrera; 
         
    public void  asignar (String n, int a, int t, int p, String carr)   
    { asignar (n, a);
      totcredito = t; 
      puntos = p; 
      carrera = carr;     }  
        
    public double calcular_indice ()  
    { double indice; 
      indice =  puntos/totcredito;   
      return indice ;   } 
      
    public int get_totcre(){
    	return totcredito;  }
    
    public int get_puntos() {
    	return puntos; }
    	
    public String get_carrera(){
    	return carrera; }
    
   } 
 class Empleado extends Persona{
   private int horat ;
   private double tarifa;
   
   public void  asignar (String n, int a, int ht, double t ) 
   	{    asignar(n, a);
   		 horat= ht;
   		 tarifa= t;
   		
    }     
    	
  public double calcularSalario ()
    { double salario;
      salario= horat*tarifa;
      return salario;
    }		   

 public double  calcularBono (int a�oS)
    {  double  bono=0;
       if(a�oS>20)
       {
       	 bono= calcularSalario ()*0.2 ;
       }
        else
       {
       	 bono= 35;
       }
      
      return bono;
    }	
 	
 }

public class Tarea2 {
        
    public static void main(String[] args) {
        
        Persona per = new Persona();
        Alumno est = new Alumno();
        Empleado emp = new Empleado();	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Variables 
         String nombre=" ", carre=" ";
         int edad=0, elegir=0, seguir=0, TC=0, pun=0, a�oA=0, a�o=0, hora=0, a�oS=0; 
         double t=0;
         boolean  a=true;
        

        do{
         System.out.println("Bienvenido al programa elija una opci�n:\n\n 1- Estudiante\n 2- Empleado\n 3- Salir\n");
         System.out.println("Elije una opci�n: ");
         try{
         
         elegir=Integer.parseInt(br.readLine());
         
         }catch(NumberFormatException  e){
         	System.out.print("Introduzca solo n�meros. ");
         }
         catch(IOException e){
         	System.out.print("Error de entrada/salida ");
         }
         
          switch(elegir){
          	
         	 case 1:
         	 do{
         	 a= true;  
         	 try{
         	 	
         	 System.out.println("Introduzca su nombre: "); 
         	 	 nombre=br.readLine();
         	 System.out.println("Introduzca su a�o de nacimiento");	
         	     a�o=Integer.parseInt(br.readLine());
         	 System.out.println("Introduzca el a�o actual");	
         	     a�oA=Integer.parseInt(br.readLine());	
         	 System.out.println("Introduzca su total de creditos: "); 
         	 	 TC=Integer.parseInt(br.readLine());
         	 System.out.println("Introduzca su total de puntos: "); 
         	 	 pun=Integer.parseInt(br.readLine());
         	 System.out.println("Introduzca su carrera: "); 
         	 	 carre=br.readLine();
         	 	 
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
         	 	
         	 per.asignar(nombre, a�o);	
         	 est.asignar(nombre, a�o, TC, pun, carre);
         	 edad=per.calcularA(a�oA);
         	 
         	 	   	  
          	 System.out.println(per.get_nom()+" su indice: " +  est.calcular_indice()+"\n");
          	 System.out.println("Edad: "+edad+"\n");   
          	 System.out.println("Total de creditos: " +  est.get_totcre()+"\n");
          	 System.out.println("Total de puntos: " +  est.get_puntos()+"\n"); 
          	 System.out.println("Carrera: " +  est.get_carrera()+"\n");
          	    break;
          	    
             /*Caso Empleado*/
             
          	 case 2:
           do{
         	 a= true;  
         	 try{
         	 System.out.println("Introduzca su nombre: "); 
         	 	 nombre=br.readLine();	
         	 System.out.println("A�o de Ingreso: "); 
         	 	 a�o=Integer.parseInt(br.readLine());
         	 System.out.println("Introduzca el a�o actual: ");	
         	     a�oA=Integer.parseInt(br.readLine());		        	 	 
         	 System.out.println("Introduzca horas trabajadas: "); 
         	     hora=Integer.parseInt(br.readLine());
         	 System.out.println("Introduzca la tarifa por hora: "); 
         	 	 t=Double.parseDouble(br.readLine());
         	 	 
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
          	 
          	  per.asignar(nombre, a�o);	 
          	  emp.asignar(nombre, a�o, hora, t );
          	  a�oS=per.calcularA(a�oA);
          	   
          	 System.out.println(per.get_nom()+" sus a�os de servicio son: " + a�oS +"\n");
          	 System.out.println("Su salario: "+emp.calcularSalario()+"\n");   
          	 System.out.println("Su bono navide�o es: " + emp.calcularBono(a�oS)+"\n");
     
          	   
          	    
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
