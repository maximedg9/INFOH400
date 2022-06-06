package ulb.lisa.infoh400.labs2022.controller.exceptions;
/*quand une entité existe pas dans la database */

public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
