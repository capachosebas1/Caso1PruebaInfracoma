package Caso1Folder;

public class ProcesoAzul extends Thread{
	
	private Numero idProductos;
	
	private BufferLimitado buf;
	
	private BufferLimitado buf2;
	
	private BufferLimitado buf3;
	
	private int cantProductos;
	
	private boolean tipo;
	
	private int etapa;
	
	public ProcesoAzul(Numero id,BufferLimitado buf,BufferLimitado buf2,BufferLimitado buf3,int cantidadproductos,boolean tipo,int etapa)
	{
		
		this.idProductos = id;
		this.buf = buf;
		this.buf2 = buf2;
		this.cantProductos = cantidadproductos;
		this.tipo = tipo;
		this.etapa = etapa;
		this.buf3 = buf3;
		
	}
	
	//MandarProducto este metodo manda los productos al primer buffer desde la etapa 1
	
	private void MandarProducto(int id)
	{
		
		this.buf.insertProductAzul("El producto con el id" + id + ", sale del proceso 0 en la etapa 1  a la etapa 2");
		
	}
	
	//imprimirProducto este metodo recoge los productos del primer buffer en la etapa 2 y
	//este metodo manda los productos al segundo buffer desde la etapa 2
	
	private void imprimirProductoyMandarProductoEtapa2(String message)
	{
		
		System.out.println(message + ", recibido en etapa 2 por proceso 0");
		String mensaje = message + ", recibido en etapa 2 por proceso 0";
		this.buf2.insertProductAzul(mensaje  + " El producto sale de la etapa 2 a etapa 3");
		
	}
	
	//imprimirProductoEstapa3 este metodo recoge los productos del segundo buffer en la etapa 3
	//MandarProductoEtapa3 este metodo manda los productos al tercer buffer desde la etapa 3
	
	private void imprimirProductoEstapa3yMandarProductoEtapa3(String message)
	{
		
		System.out.println(message + ", recibido en etapa 3 por proceso 0");
		String mensaje = message + ", recibido en etapa 3 por proceso 0";
		this.buf3.insertProductAzul(mensaje  + " El producto sale de la etapa 3 a etapa final");
		
	}
	
	@Override
	public void run() 
	{
		
		//Primera etapa 
		
		if (tipo==true && etapa==1)
		{
			
			for(int i = 0; i < this.cantProductos;i++)
			{
				idProductos.MasNumero();
				this.MandarProducto(idProductos.getNumero());
			}
			
		}
		
		//Segunda etapa 
		
		if (etapa==2)
		
		{
			
			while(!buf.isFinishedBuffer()||this.buf.hasProducts())
			{
				
				String message = this.buf.recogerProductAzul();
				
				if (message == "")
				{
					return;
				}

				//recibe y envia etapa 
				
				this.imprimirProductoyMandarProductoEtapa2(message);
				
			}
			
		}
		
		//Tercera etapa 
		
		if (etapa==3)
			
		{
			
			while(!buf2.isFinishedBuffer()||this.buf2.hasProducts())
			{
				
				String message = this.buf2.recogerProductAzulEtapa2();
				
				if (message == "")
				{
					return;
				}
				
				//recibe y envia etapa
				
				this.imprimirProductoEstapa3yMandarProductoEtapa3(message);
			
				
			}
			
		}
		
			
	}

}
