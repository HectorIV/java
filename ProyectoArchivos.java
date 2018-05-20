/**
 * Grupo 1LS123
 * Erick Pérez 8-855-1697
 * Héctor Vásquez 8-913-2324
 * Oliver Aparicio 8-918-1083
 * Rudas Felix 8-928-508
 * Aldair Duque 8-923-2304
 */

//Se importan los paquetes io donde esta la clase File, until donde esta la clase Date y text donde esta la clase SimpleDateFormat
import java.io.*;
import java.util.*;
import java.text.*;

class Archivo{
 //Los datos se declaron privados y son los datos del archivo mem.txt de los socios del club Las Olas
 //Num. De Id: nid      Nombre Del Socio: nom         Fecha de Ingreso: di/mi/ai       Fecha de Vencimiento: dv/mv/av          Costo de Menbresía: cosm
	private String nid;
	private String nom;
	private String di;
	private String mi;
  	private String ai;
  	private String dv;
  	private String mv;
  	private String av;
  	private String cosm;
  	
 //Objetos para la lectura de mem.txt y los objetos para la creación y escritura de mem_2018.txt y mem_ven_2018.xls
  	private FileReader f;
  	private BufferedReader e;
  	private FileWriter fmv, fm; 
  	private PrintWriter v, a;
 //Date trae la fecha actual del sistema y la guarda en el objeto fa que hace nomenclatura a fecha actual
    Date fa = new Date();
 //SimpleDateFormat da un formato simple a la fechas que uno desee en este caso se uso día/mes/año
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
    	
	Archivo () throws Exception{
  	try{
  		//Reader lectura del archivo mem.txt 
  		f = new FileReader ("mem.txt");
  		e = new BufferedReader  (f) ;
  		
  		//Writer escritura de los archivos mem_ven_2018.xls y mem_2018.txt
  		fmv = new FileWriter ("mem_ven_2018.xls"); 
        v = new PrintWriter (fmv); 
         	
        fm = new FileWriter ("mem_2018.txt"); 
        a = new PrintWriter (fm); 
        	
  		
  		}  
    catch (FileNotFoundException y){
    	throw y;
    	}}
 // Metodo boolean que permite retornar true o false y se permite ejecutar varias veces este metodo dependiendo lo que retorne   			
  boolean leerEscribir()  throws Exception{
   //variable fin que es la que se retorna y es declarada false para se siga ejecutando en el while de la clase principal
   	boolean fin = false;
    try{
     // lee las lineas secuencialmente y en orden se van guardando en variables	
		nid=e.readLine ();
        nom=e.readLine();
        di=e.readLine ();
        mi=e.readLine ();
        ai=e.readLine ();
        dv=e.readLine ();
        mv=e.readLine ();
        av=e.readLine ();
        cosm=e.readLine ();
        
      
     //Si las lineas pasan a Null fin pasa a true y cuando retorna a la clase principal rompe al while y termina la ejecución del programa   
		if(nid == null & nom == null & di== null & mi== null & ai==null & dv==null & mv==null & av == null & cosm == null)
		{	
			fin = true;
		}
		else{
	 //De otro modo toma la fecha de vencimiento y la guarda en fecha que es declara String y se le cambia el formato a Date y se guarda en la variable fecha
		String fecha1 = dv+"/"+mv+"/"+av;
        Date fecha = format.parse(fecha1);
    /*
     *
     * OJO el enunciado solo nos pide que tomemos en cuenta el año de vencimiento, pero para hacerlo más real se toma en cuenta el día y el mes por puede que 
     * la fecha de vencimiento no se haya cumplido aun por el día o el mes, pero en caso de solo tomar el año solo se pone la variable av y se compara con el
     * año actual y se cambia el formato simple. 
     *
	*/	
		//Fecha llama al metodo before y le manda como parametro el año actual y este metodo compara que las fechas sean antes que la fecha actual
/* 
 * Si es solo por año solo compara que el año sea inferior a 2018 y se tendria que usar otro validación para ver si es el mismo año y esto se puede hacer con 
 * el metodo equals.
 *
*/
		 if(fecha.before(fa))
		 {
     	 //En caso de ser cirerto escribe en el archivo mem_ven_2018.xls con formato de excel
     	  v.print(nid+"\t");
     	  v.print(nom+"\t");
          v.print(di+"/"+mi+"/"+ai+"\t");
          v.print(dv+"/"+mv+"/"+av+"\t");
          v.print(cosm+"\n");
		 }
         else
         {	
         // De otro modo lo escribe en el archivo mem_2018.txt
          a.println(nid);
          a.println(nom);
          a.println(di+"/"+mi+"/"+ai);
          a.println(dv+"/"+mv+"/"+av);
          a.println(cosm);
         }
       }
        	
        }                  
	catch (IOException y){
		throw y;}
	//Retorna fin con true o false
        return fin;
   }
   //Retorna todos los datos que son privados
   String mostrar_nid(){
   	return nid;}
   
   String mostrar_nom(){
   	return nom;}
   
   String mostrar_di(){
   	return di;}
   
   String mostrar_mi(){
   	return mi;}
   
   String mostrar_ai(){
   	return ai;}
   
   String mostrar_dv(){
   	return dv;}
   
   String mostrar_mv(){
   	return mv;}
   
   String mostrar_av(){
   	return av;}
   
   String mostrar_cosm(){
   	return cosm;}
 //Se cieran los archivos mem.txt, mem_ven_2018.xls y mem_2018.txt		
    void cerrar() throws Exception{
   	try{
   		e.close();
   		v.close();
   		a.close();
   		}
	catch (IOException y){
		throw y;}
		}
}

 class ProyectoArchivos{
 	public static void main (String arg[] ) throws Exception{ 
 //Se declara la variable fin
 	boolean fin;
 	//Fecha actual del sistema 
 	   Date fa = new Date();
 	 //Formato simple de la fecha
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
   
 	try{
 
 		Archivo obj = new Archivo();
 		//Se inicializa la variable fin en false
 		fin = obj.leerEscribir();
 		//Impresiones
 		System.out.println("                       			             	  Listado de los socios del club las Olas");
    	System.out.println("                            		           		   con membresía vencida al año"+"\n");
    	System.out.println("Num. De Id:			"+"Nombre Del Socio:			"+"Fecha de Ingreso:			"+"Fecha de Vencimiento:			"+"Costo de Menbresía:			"+"\n"); 
     //Mientras fin no retorne true del metodo leerEscribir seguira leyendo mem.txt y escribiendo mem_ven_2018.xls y mem_2018.txt
    while (fin == false){
       //Date trae la fecha actual del sistema y la guarda en el objeto fa que hace nomenclatura a fecha actual
    	String fecha1 = obj.mostrar_dv()+"/"+obj.mostrar_mv()+"/"+obj.mostrar_av();
       //SimpleDateFormat da un formato simple a la fechas que uno desee en este caso se uso día/mes/año
        Date fecha = formatter.parse(fecha1);
        
    //Fecha llama al metodo before y le manda como parametro el año actual y este metodo compara que las fechas sean antes que la fecha actual
        //Se imprime en pantalla la lista de miembros con fechas de vencimiento
      if(fecha.before(fa))
     	{	
     		try{
    		System.out.println("	"+obj.mostrar_nid()+"			"+obj.mostrar_nom()+"					"+obj.mostrar_di()+"/"+obj.mostrar_mi()+"/"+obj.mostrar_ai()+"					"+obj.mostrar_dv()+"/"+obj.mostrar_mv()+"/"+obj.mostrar_av()+"				    		"+obj.mostrar_cosm()+"\n");
    		fin = obj.leerEscribir();}
       catch (Exception z){
       		System.out.println ("Codigo Error"+z);} 
       	}

      else
      { //Sigue llamando al metodo leerEscribir para seguir o terminar con el ciclo.
      	fin = obj.leerEscribir();
      } 		
    }
 //Se llama al metodo cerrar para que se cierron los archivos   		  
     obj.cerrar();
    }
    
    catch(Exception z){
    	System.out.println("Codigo Error"+z);}
 }} 