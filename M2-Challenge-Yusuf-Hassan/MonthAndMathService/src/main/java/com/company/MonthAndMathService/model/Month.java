package com.company.MonthAndMathService.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Month {

    @NotNull(message = "Please enter a number between 1 and 12.")
    private int number;
    @NotEmpty(message = "Please enter the correct month's name.")
    private String name;

    public Month(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Month() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return number == month.number && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
