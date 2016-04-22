package com.pru.shifty.api.basic;

import java.util.ArrayList;
import java.util.List;

//This could be used a number of ways. We could include status codes like 404s for Not Found
//But still responding with a 200 in the actual header. This gives consistency to the api calls and responses.
public class RestResponse<R> {

    private RestResponseStatus status;
    private List<RestError> errors;
    private R response;

    public RestResponseStatus getStatus() {
        return status;
    }

    public void setStatus(RestResponseStatus status) {
        this.status = status;
    }

    public List<RestError> getErrors() {
        return errors;
    }

    public void setErrors(List<RestError> errors) {
        this.errors = errors;
    }

    public R getResponse() {
        return response;
    }

    public void setResponse(R response) {
        this.response = response;
    }

    public void addResponse(R response) {
        this.status = RestResponseStatus.SUCCESS;
        this.response = response;
    }

    public void addRestError(RestError error) {
        if(errors == null) {
            errors = new ArrayList<RestError>();
        }
        this.status = RestResponseStatus.FAIL;
        errors.add(error);
    }
}