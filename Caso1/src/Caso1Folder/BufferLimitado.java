package Caso1Folder;

import java.util.LinkedList;
import java.util.List;

public class BufferLimitado {
	
	private List<String> buffer;
	
	private int size;
	
	public BufferLimitado(int size)
	{
		
		this.size = size;
		this.buffer = new LinkedList<String>();
		
	}
	
	public synchronized boolean hasProducts()
	{
		return this.buffer.size() > 0;
	}
	
	
	//Estos tres metodos siguientes definene el comprtamiento de un thrread o proceso de tipo azul
	
	public synchronized void insertProductAzul(String message)
	{
		
		while (this.buffer.size() == this.size)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.buffer.add(message);
		
		notifyAll();
		
	}
	
	public synchronized String recogerProductAzul()
	{
		String message = "";
		
		while (this.buffer.size() == 0 || (buffer.get(0).contains("proceso 0"))==false)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		message = this.buffer.remove(0);
		
		notifyAll();
					
		return message;
		
	}
	
	public synchronized String recogerProductAzulEtapa2()
	{
		String message = "";
		
		while (this.buffer.size() == 0||(buffer.get(0).contains("recibido en etapa 2 por proceso 0"))==false)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		message = this.buffer.remove(0);
		
		notifyAll();

		return message;
		
	}
	
	//Estos tres metdoso siguiente simulan el comportamiento del  thread naranja o el prcoeso naranja de espera semiactiva
	
	public synchronized void insertProductNaranaja(String message)
	{
		
		while (this.buffer.size() == this.size)
		{
			
			try {
				wait(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.buffer.add(message);
		
		notifyAll();
		
	}
	
	public synchronized String recogerProductNaranaja()
	{
		String message = "";
		
		while (this.buffer.size() == 0||buffer.get(0).contains("proceso 1")==false)
		{
			
			try {
				wait(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		message = this.buffer.remove(0);
		
		notifyAll();
		
		return message;
		
	}
	
	public synchronized String recogerProductNaranajaEtapa2()
	{
		String message = "";
		
		while (this.buffer.size() == 0||(buffer.get(0).contains("recibido en etapa 2 por proceso 1"))==false)
		{
			
			try {
				wait(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		message = this.buffer.remove(0);
		
		notifyAll();
		
		return message;
		
	}
	
	public boolean isFinishedBuffer() {
		return buffer.size()==0;
	}
	
	public List<String> getBuffer() {
		return buffer;
	}
	
	

}
