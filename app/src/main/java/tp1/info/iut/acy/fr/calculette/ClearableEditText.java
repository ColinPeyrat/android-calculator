package tp1.info.iut.acy.fr.calculette;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by peyratc on 19/01/2016.
 */
public class ClearableEditText extends LinearLayout {
    // déclaration de références sur les Views inclues dans ce composite
    EditText editText;
    Button clearButton;

    public ClearableEditText(Context context,
                      AttributeSet attrs) {
        super(context, attrs);
    }

    // constructeur
    public ClearableEditText(Context context) {
        super(context);

        // instancier la vue à partir de la ressource layout xml
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.clearable_edit_text, this, true);
        // recupere les references des Views impliquees
        editText = (EditText)findViewById(R.id.editText);
        clearButton = (Button)findViewById(R.id.button_efface);
        HookupButton(); // connexion aux gestionnaires d'evenements
    }
    private void HookupButton() { // ajout d'un listener...
        clearButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) { // definition directe de la methode abstraite
                editText.setText("");
            }
        });
    }
    public Editable getText(){
        return editText.getText();
    }
}
