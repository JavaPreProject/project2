package com.mb.transfer.TransferToBoot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "field must contain from 2 to 30")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Имя может содержать только буквы")
    private String name;

    @Column(name = "last_name")
    @NotBlank(message = "Фамилия не может быть пустой")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Фамилия может содержать только буквы")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;

    public User() {
    }

    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last name='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}