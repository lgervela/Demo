package demo;

import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class TestApplication extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		Window mainWindow = new Window("Test Application");
		Form form = new Form();
		form.setCaption("Form Caption");
		form.setDescription("This is a description of the Form that is " +
				"displayed in the upper part of the form. You normally " +
				"enter some descriptive text about the form and its " +
				"use here.");
		// Add a field and bind it to an named item property. 
		form.addField("nom", new TextField("Nom"));
		form.addField("prenom", new TextField("Prenom"));
		form.addField("age", new TextField("Age"));
		// Set the footer layout. 
		form.setFooter(new VerticalLayout());

		form.getFooter().addComponent(
				new Label("This is the footer area of the Form. "+
						"You can use any layout here. "+
						"This is nice for buttons."));

		// Have a button bar in the footer.
		HorizontalLayout okbar = new HorizontalLayout();
		okbar.setHeight("25px");
		form.getFooter().addComponent(okbar);
		Button okbutton = new Button("OK", form, "commit");
		okbutton.addListener(new OkListener(form));
		okbar.addComponent(okbutton);
		okbar.setComponentAlignment(okbutton, Alignment.TOP_RIGHT);
		Button resetbutton = new Button("Reset", form, "discard");
		resetbutton.addListener(new ResetListener(form));
		okbar.addComponent(resetbutton);
		mainWindow.addComponent(form);
		setMainWindow(mainWindow);


	}

	class OkListener implements ClickListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Form form;
		
		public OkListener(Form form) {
			this.form = form;
		}

		public void buttonClick(ClickEvent event) {
			Label label = new Label("Vous êtes "+form.getField("name")+" "+form.getField("prenom")+" et vous avez "+form.getField("age")+" ans.");
			TestApplication.this.getMainWindow().addComponent(label);
			
		}

	}

	class ResetListener implements ClickListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Form form;
		
		public ResetListener(Form form) {
			this.form = form;
		}

		public void buttonClick(ClickEvent event) {
			Field name = form.getField("name");
			Field prenom = form.getField("prenom");
			Field age = form.getField("age");
			name.setValue("");
			prenom.setValue("");
			age.setValue("");
			
		}	

	}

}

