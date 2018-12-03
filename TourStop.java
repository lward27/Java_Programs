package edu.ncsu.csc.csc216.wolftours.tour_stop;

/**
 * Describes a TourStop object
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class TourStop {
	
	/** Unique database id for a tour stop */
	private long _id;
	/** Name of tour stop */
	private String name;
	/** Building number (on NCSU campus map) of tour stop */
	private String buildingNumber;
	/** Building address of tour stop */
	private String buildingAddress;
	/** Description of tour stop */
	private String description;
	/** Absolute path (on Android file system to image showing tour stop */
	private String imagePath;
	
	/**
	 * Constructs a basic tour stop object with an invalid id and no state
	 */
	public TourStop() {
		this(-1, null, null, null, null, null);
	}
	
	/**
	 * Constructs a tour stop with the following information
	 * @param _id tour stop's id
	 * @param name tour stop's name
	 * @param buildingNumber tour stop's building number
	 * @param buildingAddress tour stop's address
	 * @param description tour stop's description
	 * @param imagePath tour stop's image (full path to)
	 */
	public TourStop(int _id, String name, String buildingNumber, String buildingAddress,
			String description, String imagePath) {
		this._id = _id;
		this.name = name;
		this.buildingNumber = buildingNumber;
		this.buildingAddress = buildingAddress;
		this.description = description;
		this.imagePath = imagePath;
	}

	/**
	 * Returns the tour stop's id
	 * @return the _id
	 */
	public long get_id() {
		return _id;
	}

	/**
	 * Sets the tour stop's id
	 * @param id the _id to set
	 */
	public void set_id(long id) {
		_id = id;
	}

	/**
	 * Returns the tour stop's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the tour stop's name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the tour stop's building number
	 * @return the buildingNumber
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * Sets the tour stop's building number
	 * @param buildingNumber the buildingNumber to set
	 */
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * Returns the tour stop's building address
	 * @return the buildingAddress
	 */
	public String getBuildingAddress() {
		return buildingAddress;
	}

	/**
	 * Sets the tour stop's building address
	 * @param buildingAddress the buildingAddress to set
	 */
	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}

	/**
	 * Returns the tour stop's description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the tour stop's description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the image path for the tour stop's picture
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the image path for the tour stop's picture
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (_id ^ (_id >>> 32));
		result = prime * result
				+ ((buildingAddress == null) ? 0 : buildingAddress.hashCode());
		result = prime * result
				+ ((buildingNumber == null) ? 0 : buildingNumber.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourStop other = (TourStop) obj;
		if (_id != other._id)
			return false;
		if (buildingAddress == null) {
			if (other.buildingAddress != null)
				return false;
		} else if (!buildingAddress.equals(other.buildingAddress))
			return false;
		if (buildingNumber == null) {
			if (other.buildingNumber != null)
				return false;
		} else if (!buildingNumber.equals(other.buildingNumber))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TourStop [_id=" + _id + ", buildingAddress=" + buildingAddress
				+ ", buildingNumber=" + buildingNumber + ", description="
				+ description + ", imagePath=" + imagePath + ", name=" + name
				+ "]";
	}
	
}
