import java.util.ArrayList;

public class SistemaSaludMentalArreglo {
    Instrumento[] instrumentos;
    int contador;

    public SistemaSaludMentalArreglo(int numeroInstrumentos)
    {
        instrumentos = new Instrumento[numeroInstrumentos];
        contador = 0;
    }

    public void registrar(String nombre, String tipo, boolean evaluacion, String referencia, String problemaMental, ArrayList<Instrumento> autores, int clave)
    {
        if (contador < instrumentos.length) {
            StringBuilder autoresString = new StringBuilder();
            for (String autor : instrumentos[contador].getAutores()) {
                autoresString.append(autor + " ");
            }
            instrumentos[contador] = new Instrumento( nombre,  tipo, evaluacion, referencia, problemaMental, autores, clave);
        }
        ++contador;
    }

    public void instrumentoBaja(int indice) {

        for (int i = indice; i < contador - 1; i++) {
            instrumentos[indice] = instrumentos[indice + 1];
        }
        --contador;
    }

    public String consultaGeneral()
    {
        StringBuilder consulta = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            consulta.append(instrumentos[i].toString() + "\n");
        }
        return consulta.toString();
    }

    public String buscarPorClave(int clave)
    {
        String instrumento = "";
        for (int i = 0; i < contador; i++) {
            if (instrumentos[i].getClave() == clave) {
                instrumento = instrumentos[i].toString();
            }
        }

        return instrumento;
    }
}
