package cse.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import cse.data.pojo.Trail;

@Service
public class CSVService {
	private CSVParser csvParser = new CSVParserBuilder().withEscapeChar('\0').build();
	
	public List<Trail> readTrailsFromCSV(String path) throws FileNotFoundException {
		final FileReader reader = new FileReader(path);
		final CSVReader csvReader = new CSVReaderBuilder(reader)
				.withCSVParser(csvParser)
				.build();

		final CsvToBean<Trail> csvToBean = new CsvToBeanBuilder<Trail>(csvReader)
				.withType(Trail.class)
				.build();

		return csvToBean.parse();
	}
	
	/**
	 * Util to split a string by spaces, UNLESS there are quotes.
	 * <br>
	 * Not actually used to parse CSV files, just a related util.
	 * @param str
	 * @return
	 */
	public String[] spaceQuoteSplit(String str) {
		List<String> matchList = new ArrayList<String>();
		Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
		Matcher regexMatcher = regex.matcher(str);
		while (regexMatcher.find()) {
			if (regexMatcher.group(1) != null) {
				// Add double-quoted string without the quotes
				matchList.add(regexMatcher.group(1));
			} else if (regexMatcher.group(2) != null) {
				// Add single-quoted string without the quotes
				matchList.add(regexMatcher.group(2));
			} else {
				// Add unquoted word
				matchList.add(regexMatcher.group());
			}
		} 
		return matchList.toArray(new String[matchList.size()]);
	}
}
