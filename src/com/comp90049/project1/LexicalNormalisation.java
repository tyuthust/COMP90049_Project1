package com.comp90049.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.*;

public class LexicalNormalisation {

	public static void main(String[] agrs) throws IOException {
		System.out.println("Start to read documents");
		String pathName = agrs[0];
		List<String> sentenceList = new ArrayList<String>();
		List<String> tokenList = new ArrayList<String>();
		List<String> answerList = new ArrayList<String>();
		int totalCal = 0;
		int matchingCal = 0;
		// System.out.println(matchingString.getMatchingString("comming"));

		try {
			File fileName = new File(pathName);
			if (fileName.exists() && fileName.isFile()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
				BufferedReader br = new BufferedReader(reader);
				String line = "";

				while ((line = br.readLine()) != null) {
					String tokens[] = line.split("\t");
					totalCal++;
					tokenList.add(tokens[0]);
					answerList.add(tokens[2]);
					// System.out.println(line);
					String result = StringMatching.getMatchingString(tokens[0]);

					if (result.equals(tokens[2])) {
						// System.out.println(tokens[2]);
						matchingCal++;
					}
				}
				System.out.println("the number of tokens: " + totalCal);
				System.out.println("the number of matching tokens: " + matchingCal);

			} else {
				System.out.println("WARNING: The file doesn't exist");
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Fail to read the file!");
			e.printStackTrace();
		}
	}
}
