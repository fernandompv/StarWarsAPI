package com.project.starwars.StarWar.Response;

import java.util.ArrayList;

public class Response<T> {
    private String status;
    private ArrayList<ExceptionDTO> error;
    private T data;
    public static final String SuccessMessage = "success";
    public static final String FailMessage = "fail";

    public Response() {
    }

    public Response(String status, ArrayList<ExceptionDTO> error, T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public Response(ExceptionDTO error) {
        this.status = "fail";
        ArrayList<ExceptionDTO> oneException = new ArrayList();
        oneException.add(error);
        this.error = oneException;
        this.data = null;
    }

    public Response(T data) {
        this.status = "success";
        this.error = null;
        this.data = data;
    }

    public Response(boolean statusResponse) {
        if (statusResponse) {
            this.status = "success";
        } else {
            this.status = "fail";
        }

        this.data = null;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ExceptionDTO> getError() {
        return this.error;
    }

    public void setError(ArrayList<ExceptionDTO> error) {
        this.error = error;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "{\"ResponseDTO\":{\"status\":\"" + this.status + "\", \"error\":" + this.error + ", \"data\":" + this.data + "}}";
    }

