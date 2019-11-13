
package escuela_estudiantes;

public class control_estudiantes {
    
    sql sensql;
   
    public control_estudiantes() {
        
        sensql = new sql();
    }

    
    public boolean ingresar_estudiante(String id_carnet, String documento, String Tipo_doc, String nombre, String apellido, String sexo)
    {               
        
            String datos[] = {id_carnet,documento,Tipo_doc,nombre,apellido,sexo};           
            return sensql.insertar(datos, "insert into alumno(id_dni, ref_alumno,Tipo_doc,nombre,apellidos,sexo) values(?,?,?,?,?,?)");
                                        
    }
    
    public boolean borrar_estudiante(String strDni)
    {            
        String datos[] = {strDni};   
        // SET FOREING...0 || 1 truquillo para borrar en cascada el registro
        sensql.insertar(datos, "delete from asignaturaxestudiante where cod_dni = ?");
        sensql.insertar(datos, "delete from nota where cod_dni_nota = ?");
        return sensql.insertar(datos, "delete from alumno where id_dni = ?");
    }
     
    
}
