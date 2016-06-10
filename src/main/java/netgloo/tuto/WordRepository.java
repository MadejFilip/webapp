package netgloo.tuto;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface WordRepository extends CrudRepository<Word, Long> {

	public Word findByText(String text);

}
