package models;

import org.junit.BeforeClass;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;

import static org.fest.assertions.Assertions.*;

/**
 * User: mguillermin
 * Date: 20/06/12
 */
public class PeopleTest {

    public static FakeApplication app;

    @BeforeClass
    public static void startApp() {
        app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
        Helpers.start(app);
    }

    @Test
    public void createTest() throws Exception {

        People.removeAll();

        People people = new People("John", "Doe");
        people.address = new Address("123", "Main Street", "12345", "City");
        People.save(people);

        Iterable<People> all = People.all();
        assertThat(all).containsOnly(people);
        assertThat(People.findById(people._id)).isEqualTo(people);
    }

    @Test
    public void findTest() throws Exception {
        People.removeAll();

        People johnDoe = new People("John", "Doe");
        johnDoe.address = new Address("123", "Main Street", "12345", "City");
        People.save(johnDoe);

        People johnDee = new People("John", "Dee");
        johnDee.address = new Address("456", "Main Street", "12345", "City");
        People.save(johnDee);

        People mikeDee = new People("Mike", "Dee");
        mikeDee.address = new Address("789", "Main Street", "12345", "City");
        People.save(mikeDee);

        assertThat(People.findByFirstName("John")).containsOnly(johnDoe, johnDee);
        assertThat(People.findByLastName("Dee")).containsOnly(johnDee, mikeDee);

    }
}
