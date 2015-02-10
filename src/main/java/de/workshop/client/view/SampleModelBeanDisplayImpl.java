package de.workshop.client.view;

import com.google.gwt.editor.client.LeafValueEditor;

import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import de.workshop.client.presenter.SamplePresenter;

/**
 * Created by hoepmat on 2/10/15.
 */
public class SampleModelBeanDisplayImpl extends Window implements SamplePresenter.SampleModelBeanDisplay
{
    private TextField lastNameEditorTextBox = new TextField();
    private TextField firstNameEditorTextBox = new TextField();
    private TextField ageEditorTextBox = new TextField();


    private TextButton cmdOk = new TextButton("OK");

    public SampleModelBeanDisplayImpl()
    {
        this.setHeadingText("Editor Sample");
        VerticalLayoutContainer container = new VerticalLayoutContainer();
        container.add(new FieldLabel(firstNameEditorTextBox, "First Name"));
        container.add(new FieldLabel(lastNameEditorTextBox, "Last Name"));
        container.add(new FieldLabel(ageEditorTextBox, "Age"));
        this.setWidget(container);

        this.addButton(cmdOk);
    }

    @Ignore
    public TextButton getCmdOk()
    {
        return this.cmdOk;
    }

    @Override
    public LeafValueEditor<String> lastNameEditor()
    {
        return lastNameEditorTextBox;
    }

    @Override
    public LeafValueEditor<String> firstNameEditor()
    {
        return firstNameEditorTextBox;
    }

    @Override
    public LeafValueEditor<String> ageEditor()
    {
        return ageEditorTextBox;
    }
}
