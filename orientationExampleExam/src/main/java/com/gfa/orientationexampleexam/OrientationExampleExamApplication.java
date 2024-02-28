package com.gfa.orientationexampleexam;

import com.gfa.orientationexampleexam.repositories.AliasRepository;
import com.gfa.orientationexampleexam.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrientationExampleExamApplication implements CommandLineRunner {

	private final AliasRepository aliasRepository;
	private final LinkRepository linkRepository;

	@Autowired
    public OrientationExampleExamApplication(AliasRepository aliasRepository, LinkRepository linkRepository) {
        this.aliasRepository = aliasRepository;
        this.linkRepository = linkRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(OrientationExampleExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
