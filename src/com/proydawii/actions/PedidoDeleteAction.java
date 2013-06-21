package com.proydawii.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;

public class PedidoDeleteAction extends ViewBaseAction {

	public void execute() throws Exception {
		if (getView().getKeyValuesWithValue().isEmpty()) {
			addError("no_delete_not_exists");
			return;
		}

		Map<String, Boolean> values = new HashMap<String, Boolean>();
		values.put("deleted", true);
		MapFacade.setValues(getModelName(), getView().getKeyValues(), values);
		resetDescriptionsCache();
		addMessage("object_deleted", getModelName());
		getView().clear();
		getView().setEditable(false);

	}
}
