package Negocios;

import javax.swing.JOptionPane;

public class MinhaThread implements Runnable {

	private String b;
	
	
	public String getB() {
		return b;
	}


	public void setB(String b) {
		this.b = b;
	}


	Cliente c = new Cliente();
	@Override
	
	public void run() {
		// TODO Auto-generated method stub
	
		
	for(int i = 0; i < 100;i++){
		System.out.println("Thread :"+b+"valor:"+i);
		
		
	}
		
		
		
	}

	

	
	

}
