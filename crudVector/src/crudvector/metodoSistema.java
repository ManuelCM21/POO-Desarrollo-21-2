
package crudvector;

import java.util.*;

public class metodoSistema {
    
    public Vector lista = new Vector();

    public void registrarPersona(Object x) {
        lista.add(x);
    }
    
    public void eliminarPersona(String nombre){
        for (int i = 0; i < lista.size(); i++) {
            datosPersona dp = (datosPersona)lista.get(i);
            if (nombre.equals(dp.nombres)) {
                lista.remove(i);
            }
        }
    }
    
}
