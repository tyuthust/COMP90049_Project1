package com.comp90049.project1;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class StringMatching {
	public static String getMatchingString(String str) throws IOException {
		String result = "";
		String pathName = "dict.txt";
		double highestSim = 0.0;
		
		
		try {
			File fileName = new File(pathName);
			if (fileName.exists() && fileName.isFile()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				while ((line = br.readLine()) != null) {
					/* use JaroWInkler.sinilarity method to calculate the similarity of
					 *  target string and current line in dict.txt*/ 
					JaroWinkler jw = new JaroWinkler();
					double sim = jw.similarity(str, line);
					if(sim>highestSim){
						result = line;
						highestSim = sim;
						//System.out.println(line);
					}

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * Set set = matchingMap.entrySet(); Iterator iterator = set.iterator();
		 * while(iterator.hasNext()){ Map.Entry mentry = (Map.Entry)
		 * iterator.next(); if((int) mentry.getValue() == 0){ result= (String)
		 * mentry.getKey(); //System.out.println("exact matching"); } }
		 */

		return result;
	}
}
