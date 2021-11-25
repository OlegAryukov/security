package ru.aryukov.security.validator;

public interface AuthValidator<T> {

    void validate(T target);

}
