package br.com.vr.model;

public class ServiceResponse<T> {

    private T response;

    public ServiceResponse() {

    }

    public ServiceResponse(T response) {
        this.response = response;
    }


    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

}