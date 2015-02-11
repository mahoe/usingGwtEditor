package de.workshop.client.view;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.i18n.client.NumberFormat;

import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.IntegerPropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import de.workshop.client.model.SampleModelBean;
import de.workshop.client.presenter.SamplePresenter.SampleModelBeanDisplay;

/**
 * Created by hoepmat on 2/10/15.
 */
public class SampleModelBeanDisplayImpl extends Window implements SampleModelBeanDisplay
{
    private TextField lastNameEditorTextBox = new TextField();
    private TextField firstNameEditorTextBox = new TextField();
    private NumberField<Integer> ageEditorTextBox;

    private TextButton cmdOk = new TextButton("OK");

    public SampleModelBeanDisplayImpl()
    {
        this.setHeadingText("Editor Sample");
        VerticalLayoutContainer container = new VerticalLayoutContainer();
        container.add(new FieldLabel(firstNameEditorTextBox, "First Name"));
        container.add(new FieldLabel(lastNameEditorTextBox, "Last Name"));

        final NumberFormat format = NumberFormat.getDecimalFormat();
        final IntegerPropertyEditor propertyEditor = new IntegerPropertyEditor(format);
        ageEditorTextBox = new NumberField<Integer>(propertyEditor);

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
    public LeafValueEditor<Integer> ageEditor()
    {
        return ageEditorTextBox;
    }

    @Override
    public void showInfo(SampleModelBean modelBean)
    {
        Info.display("You are registered now... :-)",modelBean.toString());
    }
}
