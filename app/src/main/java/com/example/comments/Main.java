package com.example.comments;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

    PostHandler Ph = new PostHandler();
    ArrayList<Comment> post1Comment = Ph.getComments(1);

    for (Comment x: post1Comment){
        System.out.println(x.content);
    }

    Ph.close();
}
}