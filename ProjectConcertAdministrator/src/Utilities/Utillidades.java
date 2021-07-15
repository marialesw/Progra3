package Utilities;

import javax.swing.JOptionPane;


public class Utillidades {

	public static void showMessageWarning(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.WARNING_MESSAGE);
	}

	public static void showMessageError(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.ERROR_MESSAGE);
	}

	public static Integer convertData(String data) {
		try {
			if (data != null && !data.isEmpty()) {
				return Integer.parseInt(data);
			}
		} catch (NumberFormatException e) {
			showMessageError("No se puede convertir la cadena: "+data+" a numero ", "Error");
		}
		return null;
	}
	
	public static Short convertStringToShort(String data) {
		try {
			if (data != null && !data.isEmpty()) {
				return Short.parseShort(data);
			}
		} catch (NumberFormatException e) {
			showMessageError("No se puede convertir la cadena: "+data+" a numero ", "Error");
		}
		return null;
	}
	
	public static Byte convertStringToByte(String data) {
		try {
			if (data != null && !data.isEmpty()) {
				return Byte.parseByte(data);
			}
		} catch (NumberFormatException e) {
			showMessageError("No se puede convertir la cadena: "+data+" a numero ", "Error");
		}
		return null;
	}	
	
	public int printMessageDeseaSalir(){
		String [] botones = { "Si", "No"};
		return JOptionPane.showOptionDialog (null, " ¿Esta seguro que decea salir?", 
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
				null/*icono*/, botones, botones[1]);
		}
}
