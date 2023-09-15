package materialy.systemPlikow.serialization_deserialization;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final Long SerialVersionUID = 1L;
    static int age = 190;

    static {
        age = 100;
        System.out.println("Calling static init block");
    }

    private transient String name = "fieldName";
    private String nickname = "fieldNickName";

    {
        System.out.println("Calling init block");
        this.name = "defaultName";
        this.nickname = "defaultnickname";
    }

    public Dog() {
        System.out.println("Calling default constructor");
        this.name = "constructorDefaultName";
        this.nickname = "constructorDefaultnickname";
    }

    public Dog(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
        System.out.println("Calling normal constructor");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
