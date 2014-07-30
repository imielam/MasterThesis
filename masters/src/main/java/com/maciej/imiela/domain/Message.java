package com.maciej.imiela.domain;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    protected String message;

    public Message() {
        super();
    }

    public Message(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [message=" + this.message + "]";
    }

}
