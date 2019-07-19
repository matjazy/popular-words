package pl.sii;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Implementation of WordReader interface using basic java functionalities for file reading.
 * @author MJazy
 *
 */
public class WordReaderImpl implements WordReader {

	@Override
	public Map<String, Long> getWordsFromFile(String path) {
		List<String> wordList = createWordsList(path);
		return createWordsMap(wordList);
	}	
	
	private List<String> createWordsList(String path) {
		List<String> wordList = new LinkedList<String>();
		File file = new File(path);
		Scanner scanner;
			try {
				scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String line = scanner.nextLine().toLowerCase();
					String[] lineArray = line.split(" ");
					addArrayElementsToList(lineArray, wordList);
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		return wordList;
	}
	
	private void addArrayElementsToList(String[] lineArray, List<String> wordList) {
		boolean containsNumber;
		boolean isAbbreviation;
		boolean isAWord;
		
		for (int index=0; index < lineArray.length; index++) {
			isAbbreviation = lineArray[index].contains(".");
			containsNumber = lineArray[index].matches(".*\\d.*");
			isAWord = lineArray[index].length() > 1;
			if (!isAbbreviation && !containsNumber && isAWord) {
				wordList.add(lineArray[index]);
			}
		}

	}
	
	private Map<String, Long> createWordsMap(List<String> wordList) {
		Map<String, Long> wordsMap = new HashMap<String, Long>();
		for (String word: wordList) {
			if (!wordsMap.containsKey(word)) {
				wordsMap.put(word, Long.valueOf(Collections.frequency(wordList, word)));
			}
		}
		return wordsMap;
	}
}
