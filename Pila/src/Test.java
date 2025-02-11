public class Test {

    public String invertirCadena(String cadena)
    {
        Pila<String> pila = new Pila<>(cadena.length());
        String[] nuevaCadena = new String[cadena.length()];

        for (int i = 0; i < cadena.length(); i++) {
            nuevaCadena[i] = String.valueOf(cadena.charAt(i));
        }

        for (int i = 1; i < nuevaCadena.length ; i++) {
            pila.push(nuevaCadena[(nuevaCadena.length-i)]);
        }
        
        String cadenaFinal = "";
        for (int i = 0;i < nuevaCadena.length;i++) {
            cadenaFinal = pila.pop();
        }
        return cadenaFinal;
    }
}
