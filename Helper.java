package grand_restaurante;

import java.util.Scanner;
public class Helper {
public static Scanner scanner = new Scanner(System.in);
	
	//METODO PARA VALIDAR STRING
	public static String validarString(String inputMessage, String errorMessage) {
		while(true) {
			try {
				System.out.println(inputMessage);
				return scanner.nextLine();
		    }catch(Exception e) {
		        	System.out.println(errorMessage);
			}
		}
    }
	public static String validarString(String inputMessage) {
        return validarString(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN STRING");
    }
	
	//METODO PARA VALIDAR INT
	public static Integer validarEntero(String inputMessage, String errorMessage) {
        while(true){
            try {
                System.out.println(inputMessage);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
 
    public static Integer validarEntero(String inputMessage) {
        return validarEntero(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
    }
  //METODO PARA VALIDAR DOUBLE
  	public static Double validarPrecio(String inputMessage, String errorMessage) {
          while(true){
              try {
                  System.out.println(inputMessage);
                  return Double.parseDouble(scanner.nextLine());
              } catch (NumberFormatException e) {
                  System.out.println(errorMessage);
              }
          }
      }
   
      public static Double validarPrecio(String inputMessage) {
          return validarPrecio(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO DOUBLE");
      }
}
