package models;

/**
* User: mguillermin
* Date: 20/06/12
*/
public class Address {
    public String number;
    public String street;
    public String zip;
    public String city;

    public Address() {}

    public Address(String number, String street, String zip, String city) {
        this.number = number;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        if (city != null ? !city.equals(address.city) : address.city != null) {
            return false;
        }
        if (number != null ? !number.equals(address.number) : address.number != null) {
            return false;
        }
        if (street != null ? !street.equals(address.street) : address.street != null) {
            return false;
        }
        if (zip != null ? !zip.equals(address.zip) : address.zip != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
