package com.maciej.imiela.domain;

public class ContactMessage extends Message {

    protected String email = "";

    public ContactMessage() {
        super();
    }

    public ContactMessage(String message, String email) {
        super(message);
        this.setEmail(email);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactMessage [email=" + this.email + ", message="
                + this.message + "]";
    }

}
