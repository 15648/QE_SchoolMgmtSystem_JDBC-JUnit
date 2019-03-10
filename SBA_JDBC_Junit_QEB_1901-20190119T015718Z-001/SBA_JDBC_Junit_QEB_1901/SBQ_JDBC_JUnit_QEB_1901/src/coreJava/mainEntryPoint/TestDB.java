package coreJava.mainEntryPoint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import coreJava.dao.OracleConnection;

public class TestDB {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Connection conn;
        OracleConnection oc;
        
        oc = new OracleConnection();
        conn = oc.getConnection();
        System.out.println("You’re connected!");
    }
}