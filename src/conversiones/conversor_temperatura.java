package conversiones;

import javax.swing.JOptionPane;

import proceso_aplicacion.desarrollo;
import proceso_aplicacion.mensaje_final;

public class conversor_temperatura {
	public void obtener_datos() {

		// ingreso de temperatura
		Object[] opciones_temperatura = { "Grado Celsius a Kelvin ", "Grado Kelvin a Celsius",
				"Grado Celsius a Grado Fahrenheit", "Grado Fahrenheit a Grado Celsius",
				"Grado Fahrenheit a Grado Kelvin" };
		Object opciones_elegir_temperatura = JOptionPane.showInputDialog(null, "Seleccione un opción de conversión",
				"Menu", JOptionPane.QUESTION_MESSAGE, null, opciones_temperatura, opciones_temperatura[0]);
		String opcionTemperatura_elegida = (String) opciones_elegir_temperatura;

		if (opciones_elegir_temperatura == null) {
			mensaje_final mensaje_final = new mensaje_final();
			mensaje_final.mensaje_final();
			// si escoge no seguir se sale del programa
			System.exit(0);
		}

		try {
			// ingresar valor
			String opcion_cantidad_grados = JOptionPane.showInputDialog(
					"Ingrese los grados que desea convertir \n Opción escogida : " + opcionTemperatura_elegida);
			double opcion_elegida_cantidadGrados = Double.parseDouble(opcion_cantidad_grados);

			// operción conversión
			conversor_temperatura operacion = new conversor_temperatura();
			operacion.resultado_conversion(opcionTemperatura_elegida, opcion_elegida_cantidadGrados);
		} // en caso de ingresar un valor no permitido
		catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
			desarrollo intentar_de_nuevo = new desarrollo();
			intentar_de_nuevo.iniciar();

		}
	}

	public void resultado_conversion(String tipoConvercion, double cantidadGrados) {

		double resultado_conversion = 0;

		switch (tipoConvercion) {

			case "Grado Celsius a Kelvin ":

				resultado_conversion = cantidadGrados + 273;
				break;

			case "Grado Celsius a Grado Fahrenheit":

				resultado_conversion = (1.8 * cantidadGrados) + 32;
				break;

			case "Grado Fahrenheit a Grado Celsius":

				resultado_conversion = (cantidadGrados - 32) / 1.8;
				break;

			case "Grado Kelvin a Celsius":
				resultado_conversion = cantidadGrados - 273;
				break;

			case "Grado Fahrenheit a Grado Kelvin":
				int valordolar_cop = 3905;
				resultado_conversion = ((cantidadGrados - 32) / 1.8) + 273;
				break;

			default:
				break;

		}

		// mostrar conversión
		JOptionPane.showMessageDialog(null,
				"El valor de la conversión  " + tipoConvercion + " es : " + resultado_conversion);

		// mensaje final

		mensaje_final mensaje_final = new mensaje_final();
		mensaje_final.mensaje_final();

	}
}
