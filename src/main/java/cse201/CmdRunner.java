package cse201;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cse201.data.pojo.trailforks.TFGeoJSON;
import cse201.data.repo.FeatureCollectionRepo;
import cse201.data.repo.pojo.FeatureCollection;
import cse201.service.ScrapeService;

@Component
public class CmdRunner implements CommandLineRunner {	
	@Autowired
	private ScrapeService scrapeService;
	
	@Autowired
	private FeatureCollectionRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
        new Thread(this::parseCommands).start();
        
//		x.getFeatures().forEach(y -> System.out.println(y.getProperties()));
	}
	
	public void parseCommands() {
		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
        
        for (;;) {
        	System.out.print("> ");
        	parseCommand(scanner.nextLine());
        }
	}
	
	public void parseCommand(String command) {
		System.out.println(command);
		final String[] cmd = command.split(" ");
		switch (cmd[0].toLowerCase()) {
		
		case "scrape":
			scrape(cmd);
			break;
			
		}
	}
	
	public void scrape(String[] cmd) {
		if (!cmd[1].equalsIgnoreCase("tf") || cmd.length != 4) {
			System.out.println("Error scraping.");
			return;
		}
		
		try {
			final TFGeoJSON json = scrapeService.scrapeTrailForksGeoJson(cmd[3]);
			
			// cmd[2] is the name of the new collection
			repo.saveAndFlush(new FeatureCollection(cmd[2], json));
		} catch (Exception e) {
			System.err.println("Exception occurred while trying to scrape trailforks.");
			e.printStackTrace();
		}
	}
}
