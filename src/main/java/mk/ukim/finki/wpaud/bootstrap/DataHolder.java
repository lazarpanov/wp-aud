package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wpaud.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Software", "Software desc"));
        categories.add(new Category("Books", "Books desc"));
    }
}
