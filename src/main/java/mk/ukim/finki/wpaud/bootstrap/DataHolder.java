package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.Manufacturer;
import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = null;
    public static List<User> users = null;
    public static List<Manufacturer> manufacturers = null;
    public static List<Product> products = null;
    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        users = new ArrayList<>();
        manufacturers = new ArrayList<>();
        products = new ArrayList<>();
        categories.add(new Category("Software", "Software desc"));
        categories.add(new Category("Books", "Books desc"));
        users.add(new User("lazar.panov", "lp", "Lazar", "Panov"));
        users.add(new User("daniel.grkov", "gk", "Daniel", "Grkov"));
        Manufacturer manufacturer = new Manufacturer("Nike", "NY NY");
        Category category = new Category("Sport", "Sport category");
        categories.add(category);
        manufacturers.add(manufacturer);
        products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 2", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 3", 235.8, 7, category, manufacturer));
    }
}
