package com.pcstore.model;

import jakarta.persistence.*;

@Entity
@Table(name="contact_messages")
public class ContactMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
	@SequenceGenerator(name="contact_seq", sequenceName="contact_seq", allocationSize=1)
	private Long id;

private String name;
private String email;
private String phone;
private String message;


    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}