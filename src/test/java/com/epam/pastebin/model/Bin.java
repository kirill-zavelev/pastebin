package com.epam.pastebin.model;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Bin {

    private String newPaste;
    private String nameTitle;

    public Bin() {
        Faker faker = new Faker();
        this.newPaste = faker.commerce().material();
        this.nameTitle = faker.commerce().price();
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getNewPaste() {
        return newPaste;
    }

    public void setNewPaste(String newPaste) {
        this.newPaste = newPaste;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "newPaste='" + newPaste + '\'' +
                ", nameTitle='" + nameTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bin bin = (Bin) o;
        return Objects.equals(newPaste, bin.newPaste) &&
                Objects.equals(nameTitle, bin.nameTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newPaste, nameTitle);
    }
}
