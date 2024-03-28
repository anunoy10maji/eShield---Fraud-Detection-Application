package org.proj.Exceptions;

import lombok.Builder;

@Builder
public class ResourceNotFound extends RuntimeException{


    public ResourceNotFound(){
        super("Resource not found !!");
    }

    public ResourceNotFound(String message){
        super(message);
    }
}
