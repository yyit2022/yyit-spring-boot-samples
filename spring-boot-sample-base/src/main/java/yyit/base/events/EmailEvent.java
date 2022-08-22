package yyit.base.events;

public class EmailEvent {

    private final String message;

    public EmailEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
