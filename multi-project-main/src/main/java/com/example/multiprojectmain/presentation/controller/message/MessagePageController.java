package com.example.multiprojectmain.presentation.controller.message;

import com.example.multiprojectmain.application.command.request.message.CreateMessageRequest;
import com.example.multiprojectmain.application.command.request.message.UpdateMessageRequest;
import com.example.multiprojectmain.application.command.response.message.UpdateMessageResponse;
import com.example.multiprojectmain.application.command.service.message.MessageCommandService;
import com.example.multiprojectmain.application.query.response.message.MessageQueryResponse;
import com.example.multiprojectmain.application.query.service.message.MessageQueryService;
import com.example.multiprojectmain.presentation.form.message.CreateMessageForm;
import com.example.multiprojectmain.presentation.form.message.UpdateMessageForm;
import com.example.multiprojectmain.presentation.view.message.MessageView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MessagePageController {

    private final MessageCommandService messageCommandService;

    private final MessageQueryService messageQueryService;

    @GetMapping
    public String index(Model model) {
        final MessageQueryResponse messageQueryResponse = messageQueryService.getMessageList();
        final MessageView messageView = MessageView.of(messageQueryResponse);
        model.addAttribute("messageInformation", messageView);
        return "index";
    }

    @GetMapping("register")
    public String register() {
        return "registerMessage";
    }

    @PostMapping("register")
    public String registMessage(@Validated @ModelAttribute CreateMessageForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "registerMessage";
        }
        final CreateMessageRequest messageRequest = CreateMessageRequest.of(form.getMessage());
        messageCommandService.createMessage(messageRequest);
        return "redirect:index";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Integer id, UpdateMessageForm form) {
        final UpdateMessageResponse messageResponse = messageCommandService.getUpdateMessage(id);
        form.setId(id);
        form.setMessage(messageResponse.getMessage());
        return "updateMessage";
    }

    @PostMapping("update")
    public String updateMessage(@Validated @ModelAttribute UpdateMessageForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "updateMessage";
        }
        final UpdateMessageRequest messageRequest = UpdateMessageRequest.of(form.getId(), form.getMessage());
        messageCommandService.updateMessage(messageRequest);
        return "redirect:index";
    }

}
