import java.util.function.Function;

public class Page {
	
	public String preMessage = null;
	public Function<String, String> postMessage = null;  // takes userInput and returns a String to print
	
	public Page(String preMessage, Function<String, String> postMessage) {
		this.preMessage = preMessage;
		this.postMessage = postMessage;
	}
	
	public Page() {
		// do nothing
	}
	
	public boolean onInput(String userInput) {
		return true;  // true if we should advance to the next page
	}
	
}
