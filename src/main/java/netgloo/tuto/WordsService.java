package netgloo.tuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordsService {

	@Autowired
	private WordRepository wordRepository;

	/**
	 * GET /add --> Add a new word and save it in the database.
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(String text) {
		Word word;
		try {
			word = new Word(text);
			wordRepository.save(word);
		} catch (Exception ex) {
			return "Error creating the word: " + ex.toString();
		}
		return "Word added: " + word;
	}

	/**
	 * GET /load --> Load list of words from the file to the database.
	 */
	@RequestMapping("/load")
	@ResponseBody
	public String load(String fileName) {// to do
		try {

		} catch (Exception ex) {
			return "Error loading words from the file" + ex.toString();
		}
		return "Words loaded to the database from the file" + fileName;
	}

	/**
	 * GET /count --> Count all word in the database..
	 */
	@RequestMapping("/count")
	@ResponseBody
	public String count() {// to do
		try {

		} catch (Exception ex) {
			return "Error during counting words in the database" + ex.toString();
		}
		return "Number of words stored in the database: ";
	}

	/**
	 * GET /delete --> Delete the word having the passed id.
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Word word = new Word(id);
			wordRepository.delete(word);
		} catch (Exception ex) {
			return "Error deleting the word:" + ex.toString();
		}
		return "Word deleted";
	}

	/**
	 * GET /clear --> Clear all words from the database.
	 */
	@RequestMapping("/clear") // to do
	@ResponseBody
	public String clear() {
		try {

		} catch (Exception ex) {
			return "Error deleting the words from the database" + ex.toString();
		}
		return "All words deleted the database";
	}

	/**
	 * GET /search --> Return the id for the word having the passed text.
	 */
	@RequestMapping("/search")
	@ResponseBody
	public String search(String text) {
		Word word;
		try {
			word = wordRepository.findByText(text);
		} catch (Exception ex) {
			return "Word not found";
		}
		return "Finded word is: " + word.getWord();
	}

	/**
	 * GET /update --> Update the list in the database having the passed id.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateWord(long id, String text) {
		try {
			Word word = wordRepository.findOne(id);
			word.setWord(text);
			wordRepository.save(word);
		} catch (Exception ex) {
			return "Error updating the list: " + ex.toString();
		}
		return "List updated!";
	}

}
