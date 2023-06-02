package com.solvd.flightreservation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Utilmain {

	public static final Logger LOGGER = LogManager.getLogger(Utilmain.class);

	public static void main(String[] args) throws IOException

	{
		File inputFile = new File("src//main//resources//input.txt");
		File outputFile = new File("src//main//resources//output.txt");

		String inputContent = FileUtils.readFileToString(inputFile, "UTF-8");
		String[] words = StringUtils.split(inputContent);

		Map<String, Integer> wordCountMap = new HashMap<>();
		for (String word : words) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		StringBuilder outputBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			outputBuilder.append(entry.getKey()).append(" = ").append(entry.getValue()).append(System.lineSeparator());
		}

		FileUtils.writeStringToFile(outputFile, outputBuilder.toString(), "UTF-8");
		LOGGER.info("Output is written to output.txt file ");
	}
}
