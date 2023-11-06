package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = null;
    public static List<User> users = null;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        users = new ArrayList<>();
        categories.add(new Category("Software", "Software desc"));
        categories.add(new Category("Books", "Books desc"));
        users.add(new User("lazar.panov", "lp", "Lazar", "Panov"));
        users.add(new User("daniel.grkov", "gk", "Daniel", "Grkov"));
    }
}
