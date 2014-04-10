package com.maciej.imiela.domain;

public class Message {

    protected String message = "";

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
