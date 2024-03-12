package com.example.repository;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FinanceiraRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiraRepositoryApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Finance Control";
	}

}    