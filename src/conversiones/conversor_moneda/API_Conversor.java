package conversiones.conversor_moneda;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import proceso_aplicacion.desarrollo;


public class API_Conversor {
	
	 public double get(String dia, String Cantidad_Dinero,String pasar_De, String pasar_a  ) {
		 double valor_final=0;

		
		 try {
			System.out.println("Esperando ejecución");	
			URL url = new URL ("https://api.apilayer.com/exchangerates_data/convert?to="+pasar_a+"&from="+pasar_De+"&amount="+Cantidad_Dinero+"&apikey=wSIdZtZe37dtPx7doriTCt7sLqjjLo4X");
			 HttpURLConnection c_api =(HttpURLConnection) url.openConnection() ;
			 c_api.setRequestMethod("GET");
			 c_api.setRequestProperty("apikey", "wSIdZtZe37dtPx7doriTCt7sLqjjLo4X");
			 
			 if(c_api.getResponseCode()==200) {
				
				//mostrar respuesta
				List information_string= new ArrayList();
				Scanner scanner = new Scanner(url.openStream());
				
				while (scanner.hasNext()) {
					information_string.add(scanner.nextLine());
				}
				scanner.close();
				
			    String valor= (String)information_string.get(12); // para obtener el valor 
			    valor= valor.replaceAll("\"result\": ",""); // quita esa palabra y devuelve solo el numero
			    valor_final = Double.parseDouble(valor); // pasa el numero a dooble
				System.out.println("El valor final  es: "+valor_final);								
			   
			    
			 }else {
				 System.out.println("error de respuesta" +c_api.getResponseCode());
			 }
			 
			 c_api.disconnect();
		 }
		 
		 catch(Exception ex) {
			 
			JOptionPane.showMessageDialog(null,"Error,Intenta mas tarde","Error",JOptionPane.ERROR_MESSAGE);
			desarrollo intentar_de_nuevo= new desarrollo();
			intentar_de_nuevo.iniciar();
		 }
		 
		 return valor_final;
   
	 }
}

