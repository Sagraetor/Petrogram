import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String content;
    private String comment;
    private Date date;
    private List<Reaction> reactions;

    public Post(String content, Date date) {
        this.content = content;
        this.date = date;
        this.reactions = new ArrayList<>();
    }

    public void addComment(String comment) {
        this.comment = comment;
    }

    public void addReaction(String name, int count) {
        Reaction reaction = new Reaction(name, count);
        this.reactions.add(reaction);
    }

    public void removeReaction(String name) {
        for (Reaction reaction : this.reactions) {
            if (reaction.getName().equals(name)) {
                this.reactions.remove(reaction);
                break;
            }
        }
    }

    public void incrementReactionCount(String name) {
        for (Reaction reaction : this.reactions) {
            if (reaction.getName().equals(name)) {
                reaction.setCount(reaction.getCount() + 1);
                break;
            }
        }
    }

    // getters and setters for the attributes

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }
}

class Reaction {
    private String name;
    private int count;

    public Reaction(String name, int count) {
        this.name = name;
        this.count = count;
    }

    // getters and setters for the attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
