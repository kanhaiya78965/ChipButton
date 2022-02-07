package luttipur.kanhaiya.ooappoo.chipbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {
    ChipGroup chipGroup2;
    Button addChip;
    int chipNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipGroup2 = findViewById(R.id.chipGroup2);
        addChip = findViewById(R.id.addChip);

        addChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chip chip = new Chip(MainActivity.this);
                chip.setText("Chip"+(chipNumber++));
                chip.setCheckable(true);
                chip.setCloseIcon(getDrawable(R.drawable.ic_baseline_close_24));
                chip.setCloseIconVisible(true);

                chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked)
                            Toast.makeText(MainActivity.this, buttonView.getText().toString() +" is selected", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, buttonView.getText().toString() +" is Unselected", Toast.LENGTH_SHORT).show();


                    }
                });

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chipGroup2.removeView(v);
                    }
                });

                chipGroup2.addView(chip,0);
            }
        });
    }

    public void goChipButtonActivity(View view) {
        startActivity(new Intent(this,ChipButtonActivity.class));
    }
}