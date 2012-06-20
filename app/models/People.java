package models;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

import java.io.IOException;

/**
 * User: mguillermin
 * Date: 20/06/12
 */
public class People {

    public ObjectId _id;

    public String firstname;

    public String lastname;

    public Address address;

    public People() {}

    public People(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected static MongoCollection collection = JongoUtil.jongo.getCollection("peoples");

    public static void save(People people) throws IOException {
        people._id = new ObjectId(collection.save(people));
    }

    public static Iterable<People> all() {
        return collection.find("{}").as(People.class);
    }

    public static Iterable<People> findByFirstName(String firstname) {
        return collection.find("{firstname: #}", firstname).as(People.class);
    }

    public static Iterable<People> findByLastName(String lastname) {
        return collection.find("{lastname: #}", lastname).as(People.class);
    }

    public static People findById(ObjectId id) {
        return collection.findOne(id).as(People.class);
    }

    public static void removeAll() {
        collection.remove("{}");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        People people = (People) o;

        if (_id != null ? !_id.equals(people._id) : people._id != null) {
            return false;
        }
        if (address != null ? !address.equals(people.address) : people.address != null) {
            return false;
        }
        if (firstname != null ? !firstname.equals(people.firstname) : people.firstname != null) {
            return false;
        }
        if (lastname != null ? !lastname.equals(people.lastname) : people.lastname != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
