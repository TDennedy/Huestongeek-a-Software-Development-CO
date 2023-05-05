package cse;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cse.data.pojo.Trail;
import cse.data.pojo.trailforks.TFGeoJSON;
import cse.data.repo.FeatureCollectionRepo;
import cse.data.repo.pojo.FeatureCollection;
import cse.service.CSVService;
import cse.service.ScrapeService;

@Component
public class CmdRunner implements CommandLineRunner {	
	@Autowired
	private ScrapeService scrapeService;
	
	@Autowired
	private CSVService csvService;
	
	@Autowired
	private FeatureCollectionRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
        new Thread(this::parseCommands).start();
        
//		x.getFeatures().forEach(y -> System.out.println(y.getProperties()));
	}
	
	private void parseCommands() {
		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
        
        for (;;) {
        	System.out.print("> ");
        	parseCommand(scanner.nextLine());
        }
	}
	
	private void parseCommand(String command) {
		final String[] cmd = csvService.spaceQuoteSplit(command);
		switch (cmd[0].toLowerCase()) {
		
		// scrape tf <trail_name> <url>
		case "scrape":
			scrape(cmd);
			break;
			
		case "csv":
			csv(cmd);
			break;
			
		}
	}
	
	/**
	 * Logic for the "csv" command.
	 * @param cmd The command split by spaces.
	 */
	private void csv(String[] cmd) {
		if (cmd.length < 2) {
			System.err.println("Error: Specify a file");
			return;
		}
		
		try {
			final List<Trail> trails = csvService.readTrailsFromCSV(cmd[2]);
			
			repo.saveAndFlush(new FeatureCollection(cmd[1], trails));
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
	}

	/**
	 * Logic for the "scrape" command.
	 * @param cmd The command split by spaces.
	 */
	private void scrape(String[] cmd) {
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
