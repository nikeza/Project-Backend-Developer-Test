package com.serviceshuffle.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class NumberDto {

    @Min(1)
    @Max(1000)
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
