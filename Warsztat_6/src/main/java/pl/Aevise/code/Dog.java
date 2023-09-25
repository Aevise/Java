package pl.Aevise.code;

import lombok.*;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@With
public class Dog {
    @EqualsAndHashCode.Include
    private final String name;
    @EqualsAndHashCode.Include
    @Getter(AccessLevel.NONE)
    @NonNull
    private Integer age;
    private final Owner owner;
    @ToString.Exclude
    private Food food;

    public void consume(@NonNull String somethingToEat){
        System.out.println(somethingToEat);
    }


}
