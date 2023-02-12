package sg.edu.nus.iss.server.models;

import org.springframework.util.MultiValueMap;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Contact {
    
    // Defining members
    private String name;
    private String phone;
    private String email;
    
    // Generate getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
    }

    // Create JsonObject from Contact object
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                    .add("name", name)
                    .add("phone", phone)
                    .add("email", email)
                    .build();
    }

    // Create contact object from Form
    public static Contact create(MultiValueMap<String, String> form) {
        Contact contact = new Contact();
        contact.setName(form.getFirst("name"));
        contact.setPhone(form.getFirst("phone"));
        contact.setEmail(form.getFirst("email"));
        return contact;
    }
}
