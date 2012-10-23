package com.hellomvp.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hellomvp.client.DBConnection;

public class MySQLConnection extends RemoteServiceServlet implements DBConnection
{
  private Connection conn = null;
  private String url = "jdbc:mysql://127.0.0.1:3306/bookingsystem";
  private String user = "root";
  private String pass = "1111"; //TODO: change to your password
  
  public MySQLConnection() 
  {
    try 
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection(url, user, pass);
    } 
    catch (Exception e) 
    {
      //NEVER catch exceptions like this
      System.out.println("connection fails to be setup" + e.getMessage());
    }
  }
  
  @Override
  public boolean AuthenticateUser(String user, String pass) 
  {
    boolean found = false;
    try 
    {
      PreparedStatement ps = conn.prepareStatement(
      "select * from students where FirstName = \"" + user + "\" AND " +
        "Password = \"" + pass + "\"");
      
      ResultSet result = ps.executeQuery();
      while (result.next()) 
      {
        found = true;
        System.out.println("User successfully authenticated!");
      }
      
      result.close();
      ps.close();
    } 
    catch (SQLException sqle) 
    {
      System.out.println("SQL exception!");
    }
    
    return found;
  }
}
