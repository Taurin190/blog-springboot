package com.taurin190.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ContactForm {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}")
    private String phone;

    @NotNull
    private String message;
}
