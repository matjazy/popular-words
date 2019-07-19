package pl.sii;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class enabling finding most popular words from particular file.
 * @author MJazy
 * @author Tomasz Czerwonka
 *
 */
public class PopularWords {	
	
	WordReader wordReader;
	
	/**
	 * Constructor for PopularWords class.
	 */
	public PopularWords() {
		wordReader = new WordReaderImpl();
	}
	
    public static void main(String[] args) {
        PopularWords popularWords = new PopularWords();
        Map<String, Long> result = popularWords.findOneThousandMostPopularWords();
        result.entrySet().forEach(System.out::println);
    }

    /**
     * Method getting 1000 most popular words from "3esl.txt" file.
     * @return map with relevant records.
     */
    public Map<String, Long> findOneThousandMostPopularWords() {
    	Map<String, Long> wordsMap = wordReader.getWordsFromFile("src/main/resources/3esl.txt")
    			.entrySet().stream().limit(1000).sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, HashMap::new));
    		return wordsMap;
    			
    }
}
