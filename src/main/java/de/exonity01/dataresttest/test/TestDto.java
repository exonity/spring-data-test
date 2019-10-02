package de.exonity01.dataresttest.test;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TestDto {

    @NotNull
    private String aBc;

}
