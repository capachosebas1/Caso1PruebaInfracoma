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
	        
			BufferLimitado buf1 = new BufferLimitado(25);
	        
	        //esta es la creacion del numero
	        
	        idproductos = new Numero(0);
	        
	        //esto es la creacion del buffer primera etapa
	        
	        BufferLimitado buf2 = new BufferLimitado(25);
	        
	        //esto es la creacion del buffer segunda etapa
	        
	        BufferLimitado buf3 = new BufferLimitado(25);
	        
	        //esta es la cantidad 
	        
	        ProcesoAzul p1 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,true,1);
	        
	        ProcesoAzul p0 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,true,1);
	        
			ProcesoAzul p2 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,2);
			
			ProcesoAzul p3 = new ProcesoAzul(idproductos, buf1,buf2,buf3, 5,false,3);
			
			ProcesoNaranja p5 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,true,1);
			
			ProcesoNaranja p6 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,true,1);
			
			ProcesoNaranja p7 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,false,2);
			
			ProcesoNaranja p8 = new ProcesoNaranja(idproductos, buf1,buf2,buf3, 5,false,3);
			
			p1.start();
			p0.start();
			
			p5.start();
			p6.start();
			
			p2.start();
			
			p7.start();
			
			try {
				System.out.println("Termina Etapa 1");
				p7.join();
				p2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			p3.start();
			p8.start();
			
			try {
				System.out.println("Termina Etapa 2");
				p3.join();
				p8.join();
				System.out.println("Termina Etapa 3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
