package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

/**
 * Object definition for a Contact
 * @author SarahHeckman
 */
public class Contact {
	
	/** Contact's first name */
	private String lastName;
	/** Contact's last name */
	private String firstName;
	/** Contact's email */
	private String email;
	/** Contact's organization */
	private String organization;
	/** Contact's label */
	private String label;
	/** Position of label in spinner */
	private int labelPosition;
	
	/**
	 * Default constructor for Contact
	 */
	public Contact() {
		this("", "", "", "", "", -1);
	}
	/**
	 * Constructor for a Contact
	 * @param lastName Contact's last name
	 * @param firstName Contact's first name
	 * @param email Contact's email
	 * @param organization Contact's organization
	 * @param label Contact's label
	 */
	public Contact(String lastName, String firstName, String email, String organization, String label, int labelPosition) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.organization = organization;
		this.label = label;
		this.labelPosition = labelPosition;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the emailAddresses
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param emailAddresses the emailAddresses to set
	 */
	public void setEmail(String emailAddresses) {
		this.email = emailAddresses;
	}
	/**
	 * @return the organizations
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * @param organizations the organizations to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the labelPosition
	 */
	public int getLabelPosition() {
		return labelPosition;
	}
	/**
	 * @param labelPosition the labelPosition to set
	 */
	public void setLabelPosition(int labelPosition) {
		this.labelPosition = labelPosition;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	/**
	 * Returns true if all the required fields (first name, last name, email,
	 * and label) contain some text and are not null.
	 * @return true if fields make a valid contact
	 */
	public boolean isValidContact() {
		if (firstName == null || lastName == null ||
				email == null || label == null) {
			return false;
		}
		if (firstName.equals("") || 
				lastName.equals("") ||
				email.equals("") ||
				label.equals("")) {
			return false;
		}
		return true;
	}

}
