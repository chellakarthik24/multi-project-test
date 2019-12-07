package com.example.multiprojectmain.presentation.form.message;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateMessageForm {

    @NotNull
    private Integer id;

    @NotEmpty
    private String message;

}
