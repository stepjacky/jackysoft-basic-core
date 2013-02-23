package org.jackysoft.collection.function;

import org.jackysoft.entity.User;

public class UserFunction extends AbstractGoogleFunction<User, TreeItem> {

	@Override
	public
	TreeItem apply(User input) {
	    TreeItem item = new TreeItem();
	    item.setName(input.getUsername());
	    item.setText(input.getLocalName());
	    item.setParent(false);
		return item;
	}

}
