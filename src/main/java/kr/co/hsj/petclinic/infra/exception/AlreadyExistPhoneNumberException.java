package kr.co.hsj.petclinic.infra.exception;

public class AlreadyExistPhoneNumberException extends RuntimeException {

    public AlreadyExistPhoneNumberException(String message) {
        super(message);
    }
}
