package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;
import java.util.Objects;

public class NetworkException extends IOException{

     public NetworkException(final String messageBeingSent) {
        super("Network error while sending message " + messageBeingSent);
        Objects.requireNonNull(messageBeingSent);
    }

    public NetworkException() {
        super("Network error: no response");
    }
}
