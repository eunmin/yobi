package models;

import org.junit.*;

import play.test.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ArticleTest {
	
	private static FakeApplication app;

	@BeforeClass
	  public static void startApp() {
	    app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
	    Helpers.start(app);
	  }

	  @AfterClass
	  public static void stopApp() {
	    Helpers.stop(app);
	  }
	
	@Test
	public void testFindById() throws Exception {
		// FIXME How to test it!?
	}
	
	@Test
	public void testWrite() throws Exception {
		
		Article article = new Article();
		article.contents = "new Contents";
		article.title = "new_title";
		article.writer = "new_writer";
		int id = Article.write(article);
		
		Article actual = Article.findById(id);
		
		assertThat(actual.title).isEqualTo(article.title);
		assertThat(actual.contents).isEqualTo(article.contents);
		assertThat(actual.date).isEqualTo(article.date);
		assertThat(actual.writer).isEqualTo(article.writer);
		assertThat(actual.articleNum).isEqualTo(id);
	}

}
