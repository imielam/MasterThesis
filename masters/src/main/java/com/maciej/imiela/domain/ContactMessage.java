package com.maciej.imiela.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class ContactMessage extends Message {

    @Email
    @NotNull
    protected String email;

    private CaptchaMessage captcha;

    public ContactMessage() {
        super();
    }

    public ContactMessage(String message, String email) {
        super(message);
        this.setEmail(email);
    }

    public CaptchaMessage getCaptcha() {
        return this.captcha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCaptcha(CaptchaMessage captcha) {
        this.captcha = captcha;
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
