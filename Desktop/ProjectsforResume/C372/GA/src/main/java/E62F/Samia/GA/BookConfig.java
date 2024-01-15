package E62F.Samia.GA;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BookConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String dirName = "uploads/";

		Path uploadDir = Paths.get(dirName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();

	//	registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");

		// If the above does not work, comment line 20 and uncomment the line below.
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
	}
}
