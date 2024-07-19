package dev.pavleceranic.jdbc_users.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Principal princ) {

        var STR_C = session.getAttribute("count") == null ? "nothing" : session.getAttribute("count").toString();
        var STR_PRINC = princ == null ? " Guest ": princ.getName();
        return "Hello World! " + STR_C + " " + STR_PRINC;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin";
    }

    @GetMapping("/myuser")
    public String getUser(HttpSession session) {

        var homeViewCount = session.getAttribute("count") == null ? 0 : (Integer) session.getAttribute("count");

        session.setAttribute("count", homeViewCount+=1);


        return "this is myUser";
    }

    @GetMapping("/login")
    public String doMyLogin() throws URISyntaxException, IOException {

        var response = "Hello";

//       ima index.html u resources
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/pavle/Desktop/index.html"))) {
            response = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return (String) response;

    }

    @GetMapping("logins")
    public RedirectView login() {
        return new RedirectView("http://localhost:3000/register");
    }
    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, HttpSession session, HttpSecurity security) {
        System.out.println(session.getCreationTime());

        System.out.println(security);


        System.out.println(username);
        System.out.println(password);
//      return "success";
    }

}
