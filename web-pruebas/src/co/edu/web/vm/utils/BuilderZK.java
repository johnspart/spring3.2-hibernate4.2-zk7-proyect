/**
 * 
 */
package co.edu.web.vm.utils;

import org.springframework.util.StringUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Messagebox;

/**
 * @author 696768
 * 
 */
public abstract class BuilderZK {
	private StringBuilder messages;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	public BuilderZK() {
		this.messages = new StringBuilder();
	}

	protected void addMessage(String message) {
		this.messages.append(message);
	}

	protected void showMessage(String icon, String title) {
		if (!StringUtils.isEmpty(this.messages.toString())) {
			title = this.getTitle(title, icon);
			Messagebox.show(this.messages.toString(), title, Messagebox.OK,
					icon);
			this.messages = new StringBuilder();
		}
	}

	protected void showErrorMessage(Exception e) {
		for (StackTraceElement str : e.getStackTrace()) {
			this.addMessage(str.toString());
			this.addMessage("\n");
		}
		this.showMessage(Messagebox.ERROR, null);
	}

	private String getTitle(String title, String icon) {
		if (title == null && icon != null) {
			if (Messagebox.INFORMATION.equals(icon))
				return "Informaci�n";
			else if (Messagebox.ERROR.equals(icon))
				return "Error";
			else if (Messagebox.EXCLAMATION.equals(icon))
				return "Atenci�n";

		} else if (icon == null && title == null)
			return "Informaci�n";

		return title;
	}
}
