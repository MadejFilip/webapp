package netgloo.tuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	WordsService wordsService;
	@Autowired
	WordRepository wordRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {

		System.out.println("startujemy");

		// if(args[0].equals("load"))
		// repository.load("words.txt");
		wordsService.add("ddd");
		wordRepository.save(new Word("Alice"));
		wordRepository.save(new Word("Bob"));

		System.out.println();

	}
}