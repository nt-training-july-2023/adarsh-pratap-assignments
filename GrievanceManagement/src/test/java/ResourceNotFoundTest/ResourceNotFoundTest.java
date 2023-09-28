package ResourceNotFoundTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.exception.ResourceNotFound;

public class ResourceNotFoundTest {
	
	ResourceNotFound rs;
	@BeforeEach
	void setup() {
		rs = new ResourceNotFound("Adarsh" , "Adarsh");
		rs.setEntity("Adarsh");
		rs.setMessage("Adarsh Singh");
	}
	
	@Test
	public void getter(){
		assertEquals("Adarsh", rs.getEntity());
		assertEquals("Adarsh Singh",rs.getMessage());
	}
}

