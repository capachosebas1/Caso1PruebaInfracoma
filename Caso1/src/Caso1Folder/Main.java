package Caso1Folder;

public class Main {
	
	private static Numero idproductos;
	
	private  BufferLimitado buf1;
	
	private  BufferLimitado buf2;
	
	private  BufferLimitado buf3;
	
	private static int cantidad;
	
	public static void main(String[] args) 
	{
        
		//Todo el siguiente codigo emula la creacion de los hilso de los procesos azules
		
	        //esto es la creacion del buffer primera etapa
	        
			BufferLimitado buf1 = new BufferLimitado(5);
	        
	        //esta es la creacion del numero
	        
	        idproductos = new Numero(0);
	        
	        //esto es la creacion del buffer primera etapa
	        
	        BufferLimitado buf2 = new BufferLimitado(5);
	        
	        //esto es la creacion del buffer segunda etapa
	        
	        BufferLimitado buf3 = new BufferLimitado(45);
	        
	        //esta es la cantidad 
	        
	        ProcesoAzul p1 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,true,1);
	        
	        ProcesoAzul p0 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,true,1);
	        
			ProcesoAzul p2 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,2);
			
			ProcesoAzul p2uno = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,2);
			
			ProcesoAzul p3 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,3);
			
			ProcesoAzul p3uno = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,3);
			
			ProcesoNaranja p5 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,true,1);
			
			ProcesoNaranja p7 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,false,2);
			
			ProcesoNaranja p8 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,false,3);
			
			p1.start();
			p0.start();
			p5.start();
			
			p2.start();
			p2uno.start();
			p7.start();
	     
			p3.start();
			p3uno.start();
			p8.start();
			
			try {
				p3.join();
				p3uno.join();
				p8.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
