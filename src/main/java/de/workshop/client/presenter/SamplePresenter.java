package de.workshop.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.RootPanel;

import de.workshop.client.model.SampleModelBean;
import de.workshop.client.presenter.SamplePresenter.SampleModelBeanDisplay.Driver;
import de.workshop.client.view.SampleModelBeanDisplayImpl;

/**
 * Created by hoepmat on 2/10/15.
 */
public class SamplePresenter
{
    public interface SampleModelBeanDisplay extends Editor<SampleModelBean>{
        LeafValueEditor<String> lastNameEditor();
        LeafValueEditor<String> firstNameEditor();
        LeafValueEditor<String> ageEditor();

        public interface Driver extends SimpleBeanEditorDriver<SampleModelBean, SampleModelBeanDisplay>{}
    }

    Driver driver = GWT.create(Driver.class);

    public SamplePresenter()
    {
        SampleModelBeanDisplayImpl display = new SampleModelBeanDisplayImpl();

        RootPanel.get().add(display);
    }
}
