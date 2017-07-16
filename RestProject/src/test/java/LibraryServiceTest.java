package test.java;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.resteasy.mock.MockHttpRequest;
import org.junit.Assert;
import org.junit.Test;

import info.beans.Book;
import info.beans.DetailBook;
import info.rs.LibraryService;

public class LibraryServiceTest {

	public LibraryServiceTest() {
	}

	@Test
	public  void testDetailBook() {
		List<Book> list = LibraryService.ALL_BOOKS.stream().filter(book-> "1".equals(book.getId())).collect(Collectors.toList());
		DetailBook detail= (DetailBook) list.stream().findFirst().get();
		Assert.assertNotNull(detail);
	}
}
