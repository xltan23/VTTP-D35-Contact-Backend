package sg.edu.nus.iss.server.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.server.models.Contact;

// http://localhost:8080/contact
@Controller
@RequestMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ContactController {
    
    // Post the form to the server
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    private ResponseEntity<String> postContactEntity(@RequestBody MultiValueMap<String, String> form) {
        System.out.println(">>> Contact form: " + form);
        Contact contact = Contact.create(form);
        System.out.println(">>> New Contact: " + contact);
        // Return {name:'', phone:'', email:''}
        return ResponseEntity.ok(contact.toJSON().toString());
    }
}
