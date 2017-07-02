/**
 * 
 */
package info.rs;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import info.beans.Book;

/**
 * @author fabien
 *
 */
@Path("/services")
public class LibraryService {

	@GET
	@Path("/books/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Book> getBooks() {
		Book newBook =new Book("Adieu aux armes", "Hemingway");
		Book newBook2 =new Book("MonteCristo", "Dumas");
		return Arrays.asList(newBook,newBook2);

	}
}
