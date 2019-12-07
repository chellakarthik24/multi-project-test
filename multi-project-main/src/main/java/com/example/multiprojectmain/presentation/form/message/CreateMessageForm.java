package com.example.multiprojectmain.presentation.form.message;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateMessageForm {

    @NotEmpty
    private String message;

}
