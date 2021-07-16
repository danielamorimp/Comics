package br.com.daniel.comics.usuarios.service;

import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class GeraIsbn {
	
	Random random = new Random();
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	public String isbn(){
		Integer n1 = random.nextInt(999);
		Integer n2 = random.nextInt(999);
		Integer n3 = random.nextInt(999);
		Integer n4 = random.nextInt(999);
		Integer n5 = random.nextInt(9);

		String isbn = n1.toString() + "-" + n2.toString() + "-" + n3.toString() + "-" + n4.toString() + "-" + n5.toString();
		
		log.info(isbn);
		
		return isbn.toString();
	}
	
}
