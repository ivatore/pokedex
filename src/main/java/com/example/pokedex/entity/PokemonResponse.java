package com.example.pokedex.entity;

//
//Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
//Visite https://eclipse-ee4j.github.io/jaxb-ri 
//Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//Generado el: 2024.10.07 a las 05:23:24 PM CST 
//



import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;


/**
* <p>Clase Java para anonymous complex type.
* 
* <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
* 
* <pre>
* &lt;complexType&gt;
*   &lt;complexContent&gt;
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
*       &lt;sequence&gt;
*         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
*         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
*         &lt;element name="baseExperience" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
*         &lt;element name="abilities" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
*         &lt;element name="heldItems" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
*         &lt;element name="locationAreaEncounters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
*       &lt;/sequence&gt;
*     &lt;/restriction&gt;
*   &lt;/complexContent&gt;
* &lt;/complexType&gt;
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 "name",
 "id",
 "baseExperience",
 "abilities",
 "heldItems",
 "locationAreaEncounters"
})
@XmlRootElement(name = "PokemonResponse")
@Data
public class PokemonResponse {

 @XmlElement(required = true)
 protected String name;
 protected int id;
 protected int baseExperience;
 @XmlElement(required = true)
 protected List<String> abilities;
 @XmlElement(required = true)
 protected List<String> heldItems;
 @XmlElement(required = true)
 protected String locationAreaEncounters;

 /**
  * Obtiene el valor de la propiedad name.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getName() {
     return name;
 }

 /**
  * Define el valor de la propiedad name.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setName(String value) {
     this.name = value;
 }

 /**
  * Obtiene el valor de la propiedad id.
  * 
  */
 public int getId() {
     return id;
 }

 /**
  * Define el valor de la propiedad id.
  * 
  */
 public void setId(int value) {
     this.id = value;
 }

 /**
  * Obtiene el valor de la propiedad baseExperience.
  * 
  */
 public int getBaseExperience() {
     return baseExperience;
 }

 /**
  * Define el valor de la propiedad baseExperience.
  * 
  */
 public void setBaseExperience(int value) {
     this.baseExperience = value;
 }

 /**
  * Gets the value of the abilities property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the Jakarta XML Binding object.
  * This is why there is not a <CODE>set</CODE> method for the abilities property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getAbilities().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link String }
  * 
  * 
  */
 public List<String> getAbilities() {
     if (abilities == null) {
         abilities = new ArrayList<String>();
     }
     return this.abilities;
 }

 /**
  * Gets the value of the heldItems property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the Jakarta XML Binding object.
  * This is why there is not a <CODE>set</CODE> method for the heldItems property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getHeldItems().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link String }
  * 
  * 
  */
 public List<String> getHeldItems() {
     if (heldItems == null) {
         heldItems = new ArrayList<String>();
     }
     return this.heldItems;
 }

 /**
  * Obtiene el valor de la propiedad locationAreaEncounters.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getLocationAreaEncounters() {
     return locationAreaEncounters;
 }

 /**
  * Define el valor de la propiedad locationAreaEncounters.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setLocationAreaEncounters(String value) {
     this.locationAreaEncounters = value;
 }

}
