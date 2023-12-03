package com.example.producingwebservice;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateXMLConverter {


        // Convert Date to XMLGregorianCalendar
        public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
            try {
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(date);
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
                return null;
            }
        }

        // Convert XMLGregorianCalendar to Date
        public static Date XMLGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {
            return xmlGregorianCalendar.toGregorianCalendar().getTime();
        }

        public static void main(String[] args) {
            // Test the methods
            Date currentDate = new Date();
            XMLGregorianCalendar xmlCalendar = dateToXMLGregorianCalendar(currentDate);
            System.out.println("XMLGregorianCalendar: " + xmlCalendar);

            Date convertedDate = XMLGregorianCalendarToDate(xmlCalendar);
            System.out.println("Converted Date: " + convertedDate);
        }
    }

