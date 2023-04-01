package com.example.TopicHandler;

import java.util.ArrayList;
import java.sql.*;

public class TopicHandler {
    public static void SavePost(String Post,String TopicID){

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/petrogram";
        String user = "root";
        String password = "";



        try {

            Class.forName(driver);

            Connection con = DriverManager.getConnection(url,user,password);


            String query = "INSERT INTO `topichandler`(`TopicID`,`Post`) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, TopicID);
            stmt.setString(2, Post);

            // Execute the prepared statement to insert the data
            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
           System.out.println("Error Error. Please try again");
        }
    }

    public static ArrayList<String> GetPost(int ID){

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/petrogram";
        String user = "root";
        String password = "";

        ArrayList<String> Post = new ArrayList<>();

        try {

            Class.forName(driver);

            Connection con = DriverManager.getConnection(url,user,password);


            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery( String.format("SELECT * FROM `topichandler` WHERE TopicID = %d", ID));


            // Execute the prepared statement to get the data
            while(rs.next()) {
                Post.add(rs.getString("Post"));
            }



            con.close();
        } catch (Exception e) {
            System.out.println("Error Error. Please try again");}

        return Post;


    }



}
