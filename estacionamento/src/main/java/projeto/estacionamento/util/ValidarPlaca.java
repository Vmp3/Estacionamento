package projeto.estacionamento.util;

import java.util.regex.Pattern;

public class ValidarPlaca {

 
    private static final String MODELO_ANTIGO = "^[A-Z]{3}[0-9]{4}$";  
    private static final String MODELO_NOVO = "^[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}$";

    public static boolean isValid(String placa) {

        return Pattern.matches(MODELO_ANTIGO, placa) || Pattern.matches(MODELO_NOVO, placa);
    }
}
