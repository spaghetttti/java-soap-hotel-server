//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.12.03 at 09:46:41 PM CET 
//


package io.spring.guides.gs_producing_web_service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Room complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Room"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="roomNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="roomType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pricePerNight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="numberOfBeds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="isAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
    "roomNumber",
    "roomType",
    "pricePerNight",
    "numberOfBeds",
    "isAvailable"
})
public class Room {

    protected int roomNumber;
    @XmlElement(required = true)
    protected String roomType;
    protected double pricePerNight;
    protected int numberOfBeds;
    protected boolean isAvailable;

    /**
     * Gets the value of the roomNumber property.
     * 
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of the roomNumber property.
     * 
     */
    public void setRoomNumber(int value) {
        this.roomNumber = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the pricePerNight property.
     * 
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Sets the value of the pricePerNight property.
     * 
     */
    public void setPricePerNight(double value) {
        this.pricePerNight = value;
    }

    /**
     * Gets the value of the numberOfBeds property.
     * 
     */
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * Sets the value of the numberOfBeds property.
     * 
     */
    public void setNumberOfBeds(int value) {
        this.numberOfBeds = value;
    }

    /**
     * Gets the value of the isAvailable property.
     * 
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * Sets the value of the isAvailable property.
     * 
     */
    public void setIsAvailable(boolean value) {
        this.isAvailable = value;
    }

}
