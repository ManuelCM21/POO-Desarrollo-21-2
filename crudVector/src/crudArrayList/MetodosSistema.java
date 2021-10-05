
package crudArrayList;

import crudvector.*;
import java.util.*;

public class MetodosSistema {
    
    public ArrayList<datosPersona> list = new ArrayList<>();

    public void registrarPersona(datosPersona x) {
        list.add(x);
    } 
    
    public void eliminarPersona(String nombre){
        for (int i = 0; i < list.size(); i++) {
            datosPersona dp = list.get(i);
            if (nombre.equals(dp.nombres)) {
                list.remove(i);
            }
        }
    }
    
}
