package com.mindtree.utils.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.mindtree.utils.GenerateXml;
import com.mindtree.model.Persons;

public class GenerateXmlImpl implements GenerateXml {

	@Override
	public void displayXml(Persons persons) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(persons, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
