import java.util.Set;

public class Pet {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pet_toy"
            joinColumns = {@JoinColumn(name="pet_id")}
            inverseJoinColumns = {@JoinColumn(name="toy_id")}
    )
    private Set<Toy> toys;
}
