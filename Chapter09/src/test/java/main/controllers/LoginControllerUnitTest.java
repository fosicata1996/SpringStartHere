package main.controllers;

import main.entities.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoginControllerUnitTest
{

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPost_LoginSucceedsTest()
    {
        given(loginProcessor.login()).willReturn(true);

        String result = loginController.loginPost("username", "password", model);

        assertEquals("redirect:/main", result);

        verify(model).addAttribute("message", "You are now logged in.");
    }

}