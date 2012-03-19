package pushQueue;

/**
 * Thrown by the PushQueue class to indicate a problem with the
 * queue's bounded capacity.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class PushQueueException extends Throwable {
	
	/**
	 * Constructs a PushQueueException with null as its error message string.
	 */
	public PushQueueException() {
		super();
	}
	
	/**
	 * Constructs a PushQueueException with a particular error message string.
	 * 
	 * @param message a description of the exception's cause
	 */
	public PushQueueException(String message) {
		super(message);
	}

}
