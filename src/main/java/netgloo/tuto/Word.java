package netgloo.tuto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "words")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String text;

	public Word() {
	}

	public Word(long id) {
		this.id = id;
	}

	public Word(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return text;
	}

	public void setWord(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", text=" + text + "]";
	}

}
