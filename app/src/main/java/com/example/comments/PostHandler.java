package com.example.comments;

import java.util.ArrayList;
import java.sql.*;
public class PostHandler {
    private Connection con;
    public PostHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){ System.out.println(e);}

        try {
            String url = "jdbc:mysql://db4free.net:3306/petrogram";
            String username = "utp12345";
            String passwd = "utp12345";
            con = DriverManager.getConnection(url, username, passwd);
        }
        catch(Exception e){ System.out.println(e);}
    }
    public ArrayList<Comment> getComments(int PostID){
        ArrayList<Comment> result = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Comments where PostID =".concat(String.valueOf(PostID)));
            while (rs.next())
                result.add(new Comment(rs.getString(3), reactionDBConv(rs.getString(4)), rs.getInt(1)));
        }
        catch(Exception e){ System.out.println(e);}

        return result;
    }
    public void uploadComment(Comment newComment){
        try {
            String ReactionList = reactionDBConv(newComment.reactions.getReactions());
            Statement stmt = con.createStatement();
            String Data = String.format("values (%d, '%s', '%s')", newComment.getPostID(), newComment.content, ReactionList);
            System.out.println(Data);
            stmt.executeUpdate("insert into Comments (PostID, Body, Reactions) " + Data);
        }
        catch(Exception e){ System.out.println(e);}
    }
    public void close() {
        try {
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

    private static int[] reactionDBConv(String reactionList){
        String[] stringArray = reactionList.split(",");
        int[] intList = new int[8];

        for (int i = 0; i < 8; i++) {
            intList[i] = Integer.parseInt(stringArray[i]);
        }
        return intList;
    }
    private static String reactionDBConv(int[] reactionList){
        String result = "";
        for (int i = 0; i < 8; i++) {
            result = result.concat(String.valueOf(reactionList[i]));
            result = result.concat(",");
        }
        return result;
    }
}
