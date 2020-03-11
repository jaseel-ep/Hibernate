package org.hibernate.DTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "USER_DETAILS")
public class UserDetails {

    @EmbeddedId
    private Login login;
  //  private Set<Address> listOfAddresses = new HashSet(); // here at left side you should not use HashSet , instead use interface
    // in hibernate
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

  //  @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_ID")
    //@Id  //Indicated userID is the Primary key
    //@GeneratedValue (strategy = GenerationType.AUTO) // To automatically generate primary Key. No need to set using the setter method now.
    private int userID;

    @Embedded   //Works without @Embedded annotation here. Needs only @Embeddable in the Address class.
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "pincode", column = @Column(name = "Home_PINCODE")),
            @AttributeOverride(name = "city", column = @Column(name = "Home_CITY"))
    })
    private Address HomeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
            @AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE")),
            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY"))
    })
    private Address officeAddress;

    /* NOTE: Suppose we have two Address objects namely office address and home address. Then we cannot use @Embedded for both address, because
    address fields like Street , pincode.. cannot be added twice as a column in the same table. We will have to use @AttributeOverride
    *  */

    // By default date will be stored as timestamp (2020-03-08 14:08:05.901) . If we want to store only Date or time use
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    // By default String will be mapped to varchar 255, If we need no limit on String character use Lob
    @Lob
    private String description;

    // We don't want password to be added to the table  -- Use @Transient
    @Transient
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    // Can also specify the @Column od @Id annotations on top of getter methods;
    //Like shown below
    //@Column (name ="USER_ID")
    @Column(name="USER_NAME_FROM_SET")
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        HomeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "login=" + login +
                ", userName='" + userName + '\'' +
                ", userID=" + userID +
                ", HomeAddress=" + HomeAddress +
                ", officeAddress=" + officeAddress +
                ", joinedDate=" + joinedDate +
                ", description='" + description + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
