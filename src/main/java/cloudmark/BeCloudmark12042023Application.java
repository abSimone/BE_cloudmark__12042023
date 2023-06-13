package cloudmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeCloudmark12042023Application {

	public static void main(String[] args) {
		SpringApplication.run(BeCloudmark12042023Application.class, args);

		System.out.println(org.hibernate.Version.getVersionString());
	}

}
