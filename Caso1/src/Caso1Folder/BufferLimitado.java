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
		
		notify();
		
	}
	
	public synchronized String recogerProductAzul()
	{
		String message = "";
		
		while (this.buffer.size() == 0)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int j = 0; j < buffer.size();j++)
		{
			if ((buffer.get(j).contains("proceso 0"))==true)
				{
					message = this.buffer.remove(j);
					
					notify();
					
					return message;
				}
		}
		return message;
		
	}
	
	public synchronized String recogerProductAzulEtapa2()
	{
		String message = "";
		
		while (this.buffer.size() == 0)
		{
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int j = 0; j < buffer.size();j++)
		{
			if ((buffer.get(j).contains("proceso 0 en la etapa 1  a la etapa 2 El producto sale de la etapa 2 a etapa 3"))==true)
				{
					message = this.buffer.remove(j);
					
					notify();
					
					return message;
				}
		}
		return message;
		
	}
	
	//Estos tres metdoso siguiente simulan el comportamiento del  thread naranja o el prcoeso naranja de espera semiactiva
	
	public synchronized void insertProductNaranaja(String message)
	{
		
		while (this.buffer.size() == this.size)
		{
			
			try {
				wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.buffer.add(message);
		
		notify();
		
	}
	
	public synchronized String recogerProductNaranaja()
	{
		String message = "";
		
		while (this.buffer.size() == 0)
		{
			
			try {
				wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int j = 0; j < buffer.size();j++)
		{
			if ((buffer.get(j).contains("proceso 1"))==true)
				{
					message = this.buffer.remove(j);
					
					notify();
					
					return message;
				}
		}
		return message;
		
	}
	
	public synchronized String recogerProductNaranajaEtapa2()
	{
		String message = "";
		
		while (this.buffer.size() == 0)
		{
			
			try {
				wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int j = 0; j < buffer.size();j++)
		{
			if ((buffer.get(j).contains("proceso 1 en la etapa 1  a la etapa 2 El producto sale de la etapa 2 a etapa 3"))==true)
				{
					message = this.buffer.remove(j);
					
					notify();
					
					return message;
				}
		}
		return message;
		
	}
	
	public boolean isFinishedBuffer() {
		return buffer.size()==0;
	}
	
	public List<String> getBuffer() {
		return buffer;
	}
	
	

}
