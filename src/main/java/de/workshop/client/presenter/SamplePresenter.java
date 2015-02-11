package de.workshop.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.RootPanel;

import com.sencha.gxt.widget.core.client.event.SelectEvent;
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
        LeafValueEditor<Integer> ageEditor();

        void showInfo(SampleModelBean modelBean);

        public interface Driver extends SimpleBeanEditorDriver<SampleModelBean, SampleModelBeanDisplay>{}
    }

    Driver driver = GWT.create(Driver.class);

    public SamplePresenter()
    {
        final SampleModelBeanDisplayImpl display = new SampleModelBeanDisplayImpl();
        RootPanel.get().add(display);

        display.getCmdOk().addSelectHandler(new SelectEvent.SelectHandler()
        {
            @Override
            public void onSelect(SelectEvent selectEvent)
            {
                final SampleModelBean modelBean = SamplePresenter.this.driver.flush();
                display.showInfo(modelBean);
            }
        });

        SampleModelBean bean = new SampleModelBean();
        bean.setAge(85);
        bean.setFirstName("Alfons");
        bean.setLastName("Zitterbacke");

        driver.initialize(display);

        driver.edit(bean);
    }
}
