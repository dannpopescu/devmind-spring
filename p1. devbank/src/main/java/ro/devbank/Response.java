package ro.devbank;

public class Response<T> {

    private String message;
    private T entity;

    public Response(String message) {
        this.message = message;
    }

    public Response(T entity) {
        this.entity = entity;
    }

    public Response(String message, T entity) {
        this.message = message;
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public T getEntity() {
        return entity;
    }
}
