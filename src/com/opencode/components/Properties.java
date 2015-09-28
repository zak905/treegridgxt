package com.opencode.components;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.PropertyAccess;


public interface Properties extends PropertyAccess<Concept>{
	
    ValueProvider<Concept, String> conceptName();
	
	ValueProvider<Concept, String> conceptType();
	
	ValueProvider<Concept, String> conceptOwner();

}
