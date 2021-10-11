package com.example.myblog.core.utilities.results;

public class ErrorDataResult <T> extends DataResult<T> {
    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult(T data,String message) {
        super(data, false,message);
    }
}