package com.project.StarWar.Contexts.Response;

public class GenericResponse{
    private String status;
    private Exception error;
    public static final String SuccessMessage = "success";
    public static final String FailMessage = "fail";


    public GenericResponse(String status, Exception exception) {
        this.status = status;
        this.error = error;
    }

    public String getStatus( ) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exception getError( ) {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

}

