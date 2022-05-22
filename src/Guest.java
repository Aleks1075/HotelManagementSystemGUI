
public class Guest
{

    private String name;
    private String gender;
    private String country;
    private String contact;

    public Guest(String name, String gender, String country, String contact)
    {
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.contact = contact;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    @Override
    public String toString()
    {
        return "Navn: " + name + ", Køn: " + gender + ", Nationalitet: " + country + ", Kontakt: " + contact;
    }

}