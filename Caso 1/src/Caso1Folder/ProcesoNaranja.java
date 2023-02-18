package Caso1Folder;

public class ProcesoNaranja extends Thread{
	
	private Numero idProductos;
	
	private BufferLimitado buf1;
	
	private BufferLimitado buf2;
	
	private int cantProductos;
	
	private boolean tipo;
	
	private int etapa;
	
	public ProcesoNaranja(Numero id,BufferLimitado buf1,BufferLimitado buf2,int cantidadproductos,boolean tipo,int etapa)
	{
		
		this.idProductos = id;
		this.buf1 = buf1;
		this.buf2=buf2;
		this.cantProductos = cantidadproductos;
		this.tipo = tipo;
		this.etapa = etapa;

		
	}
	
	private void MandarProducto(int id,String message)
	{
		
		if(etapa==1) {
			
			while(!this.buf1.insertProductNaranja("El producto con el id" + id + ", sale del proceso  en la etapa 1 a la etapa 2",this)) {
				this.yield();
			}
			}
			else if(etapa==2)  {
				
			System.out.println(message + ", recibido en etapa 2 por proceso 0");
			String mensaje = message + ", recibido en etapa 2 por proceso 0";
			while(!this.buf2.insertProductNaranja(mensaje  + " El producto sale de la etapa 2 a etapa 3",this)) {
				this.yield();
			}
			}
			else {
				System.out.println(message + ", recibido en etapa 3 por proceso 1");
				while(!this.buf2.insertProductNaranja(message  + " El producto sale de la etapa 3 a etapa final",this)) {
					this.yield();
				}
			}
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
				String message = null;
				
				this.MandarProducto(idProductos.getNumero(),message);
			}
			
		}
		
		//Segunda y tercera etapa
		
		else
		{
	
			while(!buf1.isFinishedBuffer()||this.buf1.hasProducts())
			{	
				
				String message = this.buf1.recogerProductNaranja(this);
				if (message != "")
				{
					int i=0;
					this.MandarProducto(i, message);
				}
				else {
					this.yield();
				}
				
				
			}
			
		}
	}

}