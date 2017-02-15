package work.assisjrs.shipwreck;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShipwreckNotFoundException extends Exception {
	private static final long serialVersionUID = 965983203874603238L;

}
