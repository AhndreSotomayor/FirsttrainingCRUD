/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dalex
 */
public class conexion {
    String strconexionDB="jdbc:sqlite:C:/Users/Dalex/Desktop/Base de Datos del CRUD/Empleados.s3db";
            Connection conn=null;
            
            public conexion () {
                    try{
                        Class.forName("org.sqlite.JDBC");
                        conn= DriverManager.getConnection(strconexionDB);
                                // Tal vez esto se modifique, de URL a String
                        
                        System.out.println("Conexion Establecida");
            
                            } catch (Exception e) {
            
                        System.out.println("Error de Conecxion"+e);
                    }
                                    
                    
                    }
    
    
            public int ejecutarSentenciaSQL(String strSentenciaSQL){
                    try {
                        PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
                        pstm.execute();
                        return 1;
                    
                    } catch (SQLException e) {
                                System.out.println(e);
                                return 0;
                                
                }
            }
           
            
            
                        public ResultSet consultarRegistrosSQL(String strSentenciaSQL){
                    try {
                        PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
                        ResultSet respuesta= pstm.executeQuery();
                        return respuesta;
                    
                    } catch (Exception e) {
                        System.out.println(e);
                        return null;
                                
                }
            }
            
            
            
}
