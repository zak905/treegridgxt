package com.opencode.components;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;
import com.sencha.gxt.widget.core.client.treegrid.TreeGridSelectionModel;

public class MyTreeGrid implements IsWidget {
	    TreeGrid<Concept> grid;
	    ColumnConfig<Concept, String> 	nameColumn;
		ColumnConfig<Concept, String>	typeColumn;
		ColumnConfig<Concept, String> 	ownerColumn;
		TreeStore<Concept> store;
		
		Object[][] sampleValues = {
				{new Concept("Car","Transportation","Z.amine"), new ConceptMetaInformation("Location", "MENA"), new ConceptMetaInformation("Revenues", "150 000$")},
				{new Concept("Computer","I.T","H.John"), new ConceptMetaInformation("Location", "Europe"), new ConceptMetaInformation("Revenues", "180 000$")},
				{new Concept("Cookies","Food","R.David"), new ConceptMetaInformation("Location", "North America"), new ConceptMetaInformation("Revenues", "200 000$")},
				{new Concept("Electric Appliance","Home","T.Short"), new ConceptMetaInformation("Location", "China"), new ConceptMetaInformation("Revenues", "500 000$")},
				{new Concept("Air conditioner","Home","F.Jospeh"), new ConceptMetaInformation("Location", "Australia"), new ConceptMetaInformation("Revenues", "120 000$")}
		};
	
	@Override
	public Widget asWidget() {
		Properties properties = GWT.create(Properties.class);
		// TODO Auto-generated method stub
		 store = new TreeStore<Concept>(new ModelKeyProvider<Concept>() {
			@Override
			public String getKey(Concept item) {
				if(item instanceof ConceptMetaInformation){
					return String.valueOf(item.getConceptName().hashCode()) + item.getConceptType().hashCode();
				}else {
					return String.valueOf(item.getConceptName().hashCode());
				}
				
			}
		 });
		 
		 FillStore();
		 
		 nameColumn =  new ColumnConfig<Concept, String> (properties.conceptName(), 180); 
		 typeColumn =  new ColumnConfig<Concept, String> (properties.conceptType(), 180); 
		 ownerColumn =  new ColumnConfig<Concept, String> (properties.conceptOwner(), 180); 
		 
		 List<ColumnConfig<Concept, ?>> columns = new ArrayList<ColumnConfig<Concept, ?>>();
			
		 columns.add(nameColumn);
	     columns.add(typeColumn);
	     columns.add(ownerColumn);
	
		ColumnModel<Concept> columnsModel = new ColumnModel<Concept>((List<ColumnConfig<Concept, ?>>) columns);
		
		grid = new TreeGrid<Concept>(store, columnsModel, nameColumn);
		grid.setHideHeaders(true);
		grid.setBorders(false);
		
		grid.setSelectionModel(new TreeGridSelectionModel<Concept>());
		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		return grid;
	}
	
	private void FillStore(){
		for(Object[] conceptInfo: sampleValues){
			Concept concept = (Concept) conceptInfo[0];
			ConceptMetaInformation location = (ConceptMetaInformation) conceptInfo[1];
			ConceptMetaInformation revenues = (ConceptMetaInformation) conceptInfo[2];
			store.add(concept);	
			store.add(concept, location);	
			store.add(concept, revenues);	
		}
	}

}
