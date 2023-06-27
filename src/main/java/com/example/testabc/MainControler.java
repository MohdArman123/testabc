package com.example.testabc;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class MainControler {
    @Autowired
    CredentialRepository
            credentialRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;
    @Autowired
    private UserTypeLinkRepository userTypeLinkRepository;

    @GetMapping("/landing")
    public String getLandingPage()
    {
        return "landingpage";
    }

    @GetMapping("/save")
    public String saveCredentials()
    {
        Credential cr = new Credential();
        cr.setUsername("Arman");
        cr.setPassword("Arman@321");
        credentialRepository.save(cr);
        return
                "New Credential Saved";
    }

    @PostMapping("/signup")
    public String
    signup(@RequestParam("username")
    String username, @RequestParam("password") String password)
    {
        Credential credential = new Credential();

        credential.setUsername(credential.getUsername());

        credential.setPassword(password);

        credentialRepository.save(credential);

        return "dashboard";
    }
    @PostMapping("/login")
    public String
    login(@RequestParam("username")
          String username,

          @RequestParam("password") String password , HttpSession session, Model model)
    {
        Optional<Credential>
                matchedCredential = credentialRepository.findById(username);
        if (matchedCredential.isPresent()) {
            if (matchedCredential.get().getPassword().equals(password)) {
                session.setAttribute("username", username);

                Optional<Userdetail> userdetail = userdetailRepository.findById(username);
                List<UserTypeLink> userTypeLinks = userTypeLinkRepository.findAll();
                Optional<Userdetail>
                if (userdetail.isPresent()) {
                    model.addAttribute("userdetail", userdetail.get());
                }
                return "dashboard";
            } else {
                return "landingpage";
            }
        }
            else
            {
                return "landingpage";
            }
        }
    }

