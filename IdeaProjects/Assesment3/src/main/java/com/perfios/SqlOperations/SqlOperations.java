
package com.perfios.SqlOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlOperations {

    static SqlOperations so=new SqlOperations();
    public static void main(String[] args) {

        System.out.println("Fiest Query");
        so.getFullName();
        System.out.println("Second Query");
        so.getDepartments();
        System.out.println("Third Query");
        so.getPosition();


    }

    public Statement get_statement(){
        Statement st=null;
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WorkerManagement", "root", "password");
            st = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return st;
    }

    public void getFullName(){

        try {

            String sql1 = "select upper(concat(first_name,'  ',last_name)) as FULL_NAME from worker";
            ResultSet rs = so.get_statement().executeQuery(sql1);
            System.out.println("FULL NAME");
            System.out.println("----------------");
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void getDepartments(){

        try{
            String sql2 = "select distinct(department) from worker";
            ResultSet rs2 = so.get_statement().executeQuery(sql2);
            System.out.println("Unique Departments");
            System.out.println("-------------------");
            while (rs2.next()) {

                System.out.println(rs2.getString(1));
            }
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void getPosition(){
        try{
            String sql3="select instr(binary first_name,'a') from worker where first_name='Amitabh'";
            ResultSet rs3=so.get_statement().executeQuery(sql3);
            System.out.println("Position");
            System.out.println("--------------");
            while(rs3.next()){
                System.out.println(rs3.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
