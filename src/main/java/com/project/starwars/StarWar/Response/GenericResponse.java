package com.project.starwars.StarWar.Response;

import java.util.ArrayList;

public class GenericResponse<T>{
    private String status;
    private ArrayList<Exception> error;
    private T data;
    public static final String SuccessMessage = "success";
    public static final String FailMessage = "fail";

    public GenericResponse( ) {
    }

    public GenericResponse(String status, ArrayList<Exception> error, T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public GenericResponse(Exception error) {
        this.status = "fail";
        ArrayList<Exception> oneException = new ArrayList();
        oneException.add(error);
        this.error = oneException;
        this.data = null;
    }

    public GenericResponse(T data) {
        this.status = "success";
        this.error = null;
        this.data = data;
    }

    public GenericResponse(boolean statusResponse) {
        if (statusResponse) {
            this.status = "success";
        } else {
            this.status = "fail";
        }

        this.data = null;
    }

    public String getStatus( ) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Exception> getError( ) {
        return this.error;
    }

    public void setError(ArrayList<Exception> error) {
        this.error = error;
    }

    public T getData( ) {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString( ) {
        return "{\"ResponseDTO\":{\"status\":\"" + this.status + "\", \"error\":" + this.error + ", \"data\":" + this.data + "}}";
    }
}

