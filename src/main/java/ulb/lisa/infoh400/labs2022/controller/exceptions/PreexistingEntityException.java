package ulb.lisa.infoh400.labs2022.controller.exceptions;
/*quand on veut ajouter une entité qui existe déjà */

public class PreexistingEntityException extends Exception {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
