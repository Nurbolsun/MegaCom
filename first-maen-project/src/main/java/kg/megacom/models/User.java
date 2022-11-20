package kg.megacom.models;

import kg.megacom.models.enums.UserStatus;

public class User {
    public User(String name, String definition, int age, String email, UserStatus status) {
        this.name = name;
        this.definition = definition;
        this.age = age;
        this.email = email;
        this.status = status;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    private Long id;
    private String name;
    private String definition;
    private int age;
    private String email;
    private UserStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' + ", definition='" + definition + '\'' + ", age=" + age + '}';
    }
}
