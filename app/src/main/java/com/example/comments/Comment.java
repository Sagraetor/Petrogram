package com.example.comments;

public class Comment {
    public String content;
    public Reactions reactions;
    private final int postID;

    public Comment(String content, int[] reactionlist, int postID){
        this.content = content;
        this.reactions = new Reactions(reactionlist);
        this.postID = postID;
    }

    public int getPostID() {
        return postID;
    }
}
