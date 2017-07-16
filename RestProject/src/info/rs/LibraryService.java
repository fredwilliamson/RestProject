/**
 * 
 */
package info.rs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.base.Strings;

import info.beans.Author;
import info.beans.Book;
import info.beans.DetailBook;

/**
 * @author fabien
 *
 */
@Path("/services")
public class LibraryService {
	
	private static final Book MONTE;
	private static final Book ADIEU_ARMES;
	public static final List<Book> ALL_BOOKS;
	static {
		MONTE = new DetailBook("L'Adieu aux armes","22.3",new Author("Ernest",  "Hemingway"),"1", "Si l'on pouvait résumer le livre d'Hemingway, ce serait sur ces modestes dialogues qu'il faudrait méditer. Comment, en quelques lignes, son auteur met en place toute la trame de son roman qui raconte l'inéluctable basculement des êtres confrontés à leur destin, ironiquement, de la vie à l'amour et à la mort.", true, "10","adieu_aux_armes.jpg");
		ADIEU_ARMES = new DetailBook("Le compte de Monte-Cristo","33.5",new Author("Alexandre","Dumas"),"2", "On fit encore quatre ou cinq pas en montant toujours, puis Dantès sentit qu'on le prenait par la tête et par les pieds et qu'on le balançait.«Une, dirent les fossoyeurs.- Deux.- Trois !»En même temps, Dantès se sentit lancé, en effet, dans un vide énorme, traversant les airs comme un oiseau blessé, tombant, tombant toujours avec une épouvante qui lui glaçait le cœur. Quoique tiré en bas par quelque chose de pesant qui précipitait son vol rapide, il lui sembla que cette chute durait un siècle", true,"8","monte-cristo.jpg");
		ALL_BOOKS= Arrays.asList(MONTE,ADIEU_ARMES);
	}

	@GET
	@Path("/books/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Book> getBooks() {
		return ALL_BOOKS;

	}

	@GET
	@Path("/book/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DetailBook getDetailBook(@PathParam("id") final String id) {
		if(Strings.isNullOrEmpty(id)) {
			throw new IllegalArgumentException("Le param id ne peut pas être null");
		}
		final List<Book> listById =ALL_BOOKS.stream().filter(book->id.equals(book.getId())).collect(Collectors.toList());
		return ((DetailBook) listById.stream().findFirst().get());
	}
	
	
	@GET
	@Path("/book/author/{author}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooksByAuthor(@PathParam("author") final String author) {
		if(Strings.isNullOrEmpty(author)) {
			throw new IllegalArgumentException("Le param author ne peut pas être null");
		}
		final List<Book> listByAuthor =ALL_BOOKS.stream().filter(book->book.getAuthor().getLastName().startsWith(author)).collect(Collectors.toList());
		return listByAuthor;
		
	}
	
	
}
