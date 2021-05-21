package org.bootcamp.spring.mycashapi.exception;

public class UsuarioException  extends  RuntimeException{

    private static final long serialVersionUID = -3118583923866015191L;

    public UsuarioException() {
        super();
    }

    public UsuarioException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(Throwable cause) {
        super(cause);
    }

}
