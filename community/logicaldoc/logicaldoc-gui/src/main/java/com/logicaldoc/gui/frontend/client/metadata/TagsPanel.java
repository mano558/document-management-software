package com.logicaldoc.gui.frontend.client.metadata;

import com.logicaldoc.gui.common.client.Session;
import com.logicaldoc.gui.common.client.beans.GUIParameter;
import com.logicaldoc.gui.common.client.i18n.I18N;
import com.logicaldoc.gui.frontend.client.administration.AdminPanel;
import com.logicaldoc.gui.frontend.client.search.TagsForm;
import com.smartgwt.client.widgets.tab.Tab;

/**
 * This panel collects the administration panels regarding the tags.
 * 
 * @author Marco Meschieri - Logical Objects
 * @since 6.2
 */
public class TagsPanel extends AdminPanel {

	/**
	 * 
	 * @param tagMode The current input mode: 'free' or 'preset'
	 */
	public TagsPanel(GUIParameter[] parameters) {
		super("tags");

		body.setMembers(new TagsSettingsPanel(parameters));

		Tab used = new Tab();
		used.setTitle(I18N.message("usedtags"));
		used.setPane(new TagsForm(true, false));

		Tab preset = new Tab();
		preset.setTitle(I18N.message("tagspreset"));
		for (GUIParameter p : parameters) {
			if ((Session.get().getTenantName() + ".tag.mode").equals(p.getName())) {
				preset.setPane(new TagsPreset(p.getValue()));
				break;
			}
		}

		tabs.addTab(used);
		tabs.addTab(preset);
	}
}