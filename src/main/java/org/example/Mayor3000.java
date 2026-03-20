package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Mayor3000 {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword());
            Statement stmt = conn.createStatement()){

            String sql = "SELECT count(*) as cantidad FROM empleado WHERE salario >3000";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int cantidad = rs.getInt("cantidad");
                System.out.println("Numero de empleados con salario mayor a 3000: " + cantidad);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}