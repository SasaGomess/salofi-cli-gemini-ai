package br.com.sabrinaweb.saLofi;

import br.com.sabrinaweb.saLofi.application.App;
import br.com.sabrinaweb.saLofi.application.Menu;
import br.com.sabrinaweb.saLofi.services.ArtistaService;
import br.com.sabrinaweb.saLofi.services.GeminiChatService;
import br.com.sabrinaweb.saLofi.services.MusicaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaLofiApplication implements CommandLineRunner {
	private MusicaService musicaService;
	private ArtistaService artistaService;
	private GeminiChatService geminiChatService;

	public SaLofiApplication(MusicaService musicaService, ArtistaService artistaService, GeminiChatService geminiChatService) {
		this.musicaService = musicaService;
		this.artistaService = artistaService;
		this.geminiChatService = geminiChatService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SaLofiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		App app = new App(artistaService, musicaService, geminiChatService);
		Menu.menuDeEscolha(app);
	}
}
