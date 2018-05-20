import java.io.*;
class Archi{
	
  private FileReader    f;
  private BufferedReader    r;
  private FileWriter   fd, fl;
  private PrintWriter   d, l;
 
 	Archi() throws Exception{
 	try{
 	     f = new FileReader ("caracter.txt");
         r = new BufferedReader  (f) ;  
         	
         fd = new FileWriter ("digitos.txt"); 
         d = new PrintWriter (fd); 
         	
         fl = new FileWriter ("letras.txt"); 
         l = new PrintWriter (fl); 
 		 	 
 	}catch (IOException y){

 		throw y;
 
 		}
 	}
 void Leer()throws IOException{
 		try{int g;
 			String c="";
 		while((g=r.read())!=-1) 
 		{	
 			if(g=='0'||g=='1'||g=='2'||g=='3'||g=='4'||g=='5'||g=='6'||g=='7'||g=='8'||g=='9')
 			{
 				d.write(g);
 			
 			}else{
 				c+=(char)g; 
 				
 			}
 		}
 			   l.write(c);  
 		}catch(FileNotFoundException y){
 			throw y;
 		}
 	}
void close() throws Exception{
	try{
	 r.close();
	 d.close();
	 l.close();
	}
	catch(IOException e){
       throw e;}
	}

 }

 public class asig2_4 {


    public static void main (String arg[]) throws Exception {
     Archi obj = new Archi();
  	  try
 	   { 
       obj.Leer();
       obj.close();
       
 	   } catch (Exception z) {
       	 System.out.println ("+++Error..."+z);
        }

    }
    
}
