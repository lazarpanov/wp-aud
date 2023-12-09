package mk.ukim.finki.wpaud.model;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;
    private String desc;

    public Category(String name, String desc) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.desc = desc;
    }
}
