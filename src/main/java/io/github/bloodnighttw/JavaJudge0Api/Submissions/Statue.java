package io.github.bloodnighttw.JavaJudge0Api.Submissions;

public class Statue {

    private final int id;
    private final String description;

    public Statue(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
