package com.example.TopicHandler;

import java.sql.*;

public class TopicHandler {
    public static void save(String Post){

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/petrogram";
        String user = "root";
        String password = "";


        String TopicID = "1";
        String PostID = "1";

        try {

            Class.forName(driver);

            Connection con = DriverManager.getConnection(url,user,password);


            String query = "INSERT INTO `topichandler`(`TopicID`, `PostID`, `Post`) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, TopicID);
            stmt.setString(2, PostID);
            stmt.setString(3, Post);

            // Execute the prepared statement to insert the data
            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    public static void GetPost(int ID){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/petrogram";
        String user = "root";
        String password = "";



        try {

            Class.forName(driver);

            Connection con = DriverManager.getConnection(url,user,password);


            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery( String.format("SELECT * FROM `topichandler` WHERE TopicID = %d", ID));




            // Execute the prepared statement to insert the data
            while(rs.next()) {
                System.out.println(rs.getString("Post") + "\n");

            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }



    }



}
