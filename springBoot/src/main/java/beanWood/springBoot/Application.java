package beanWood.springBoot;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.service.ColorService;
import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.service.SizeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner sizeRun(SizeService sizeService){
		return args ->{
			sizeService.saveSize(Size.builder()
					.sizeName("SSS")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("SS")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("S")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("L")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("XL")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("XXL")
					.build());
			sizeService.saveSize(Size.builder()
					.sizeName("XXXL")
					.build());
		};
	}

	@Bean
	CommandLineRunner colorRun(ColorService colorService){
		return args ->{
			colorService.saveColor(Color.builder()
					.colorName("white")
					.build());
			colorService.saveColor(Color.builder()
					.colorName("black")
					.build());
			colorService.saveColor(Color.builder()
					.colorName("red")
					.build());
			colorService.saveColor(Color.builder()
					.colorName("blue")
					.build());
			colorService.saveColor(Color.builder()
					.colorName("pink")
					.build());
		};
	}
}
