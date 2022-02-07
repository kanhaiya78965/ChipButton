package luttipur.kanhaiya.ooappoo.chipbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChipButtonActivity extends AppCompatActivity implements RevItemSelectListener, View.OnClickListener {

    private RecyclerView rev;
    private RevAdapter revAdapter;
     List<Contact> contactList = new ArrayList<>();
     EditText userName;
     ChipGroup chipGroup3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip_button);
        rev = findViewById(R.id.rev);
        userName = findViewById(R.id.name_et);
        chipGroup3 = findViewById(R.id.chip_group3);

        rev.setLayoutManager(new LinearLayoutManager(this));
        rev.setHasFixedSize(true);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rev.addItemDecoration(decoration);

        getContectList();
        revAdapter = new RevAdapter(this,contactList);
        rev.setAdapter(revAdapter);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String userName = s.toString();
                List<Contact> newContact = new ArrayList<>();
                for (Contact contact : contactList)
                {
                    if (contact.getName().contains(userName)){
                        newContact.add(contact);
                    }
                }
                revAdapter = new RevAdapter(ChipButtonActivity.this,newContact);
                rev.setAdapter(revAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemSelected(Contact contact) {
        Chip chip = new Chip(this);
        chip.setText(contact.getName());
        chip.setChipIcon(ContextCompat.getDrawable(this,contact.getPicId()));
        chip.setCloseIconVisible(true);
        chip.setCheckable(false);
        chip.setClickable(false);
        chip.setOnCloseIconClickListener(this);

        chipGroup3.addView(chip);
        chipGroup3.setVisibility(View.VISIBLE);

    }

    private void getContectList() {
        String[] userName = getResources().getStringArray(R.array.name);
        int[] picId = {R.drawable.calculation,R.drawable.chanakya,R.drawable.che,R.drawable.eng
        ,R.drawable.genetics,R.drawable.globe,R.drawable.hindi,R.drawable.history,
        R.drawable.notebook,R.drawable.physics,R.drawable.politician,R.drawable.sanskrit};

        int count = 0;
        for (String name : userName) {
            contactList.add(new Contact(name,picId[count]));
            count++;
        }
    }

    @Override
    public void onClick(View v) {
        Chip chip = (Chip) v;
        chipGroup3.removeView(chip);
    }
}