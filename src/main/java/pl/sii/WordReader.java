package pl.sii;

import java.util.Map;

/**
 * Interface for class enabling word reading.
 * @author MJazy
 *
 */
public interface WordReader {

	/**
	 * Method for getting words and number of their appearances from supplied file.
	 * @return Map with words used and number of their appearances.
	 */
	Map<String, Long> getWordsFromFile(String path);
	
}
