package com.example.comments;

import java.util.ArrayList;

public class Reactions {
    private class Reaction {
        public int count = 0;
        private int ID;
        //private int Image;
        public Reaction(int ID) {
            this.ID = ID;
        }
        public void addCount(){
            count++;
        }
        public void removeCount(){
            count--;
        }
    }
    public Reaction thumbsUp = new Reaction(1);
    public Reaction thumbsDown = new Reaction(2);
    public Reaction laugh = new Reaction(3);
    public Reaction surprised = new Reaction(4);
    public Reaction angry = new Reaction(5);
    public Reaction disgust = new Reaction(6);
    public Reaction heart = new Reaction(7);
    public Reactions(int[] counters){
        thumbsUp.count = counters[0];
        thumbsDown.count = counters[1];
        laugh.count = counters[2];
        surprised.count = counters[3];
        angry.count = counters[4];
        disgust.count = counters[5];
        heart.count = counters[6];
    }

    public int[] getReactions(){
        return new int[]{thumbsUp.count, thumbsDown.count, laugh.count, surprised.count,
                         surprised.count, angry.count, disgust.count, heart.count};
    }
    public void addReaction(int ID){
        switch (ID) {
            case 1:
                thumbsUp.addCount();
            case 2:
                thumbsDown.addCount();
            case 3:
                laugh.addCount();
            case 4:
                surprised.addCount();
            case 5:
                angry.addCount();
            case 6:
                disgust.addCount();
            case 7:
                heart.addCount();
        }
    }
    public void removeReaction(int ID){
        switch (ID) {
            case 1:
                thumbsUp.removeCount();
            case 2:
                thumbsDown.removeCount();
            case 3:
                laugh.removeCount();
            case 4:
                surprised.removeCount();
            case 5:
                angry.removeCount();
            case 6:
                disgust.removeCount();
            case 7:
                heart.removeCount();
        }
    }
    public int getReactionCount(int ID){
        switch (ID) {
            case 1:
                return thumbsUp.count;
            case 2:
                return thumbsDown.count;
            case 3:
                return laugh.count;
            case 4:
                return surprised.count;
            case 5:
                return angry.count;
            case 6:
                return disgust.count;
            case 7:
                return heart.count;
        }
        return 0;
    }
}
