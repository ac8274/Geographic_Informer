package com.example.geographic_informer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , AdapterView.OnItemClickListener{
    int selected_continent = 0;
    Spinner spin;
    ListView countries;
    TextView Capital;
    TextView Population;
    TextView Language;
    TextView Anthem;
    String[] continents = {"Asia","Africa","North America","South America","Europe","Australia"};
    String [][] Countries = {{"Japan","China","India","Pakistan","Yemen","Iran","Turkey"},
            {"Nigeria","Egypt","Tanzania","Kenya","Uganda","Sudan","Algeria"},
            {"Canada","Mexico","Greenland","Cuba","Panama","Costa Rica","Belize"},
            {"Peru","Chile","Ecuador","Bolivia","Brazil","Argentina","Paraguay"},
            {"Germany","France","Italy","Spain","Poland","Luxembourg","Monaco"},
            {"New Zealand","Solomon Islands","Vanuatu","Samoa","Guam","Tonga","Palau"}
    };

    String[][][] information =
            {{{"Tokyo","125.7 million","Japanese","Kimi Ga Yo"},{"Beijing","21,766,000","Mandarin","March of the Volunteers"},{"New Delhi","32,941,000","indian","Jana Gana Mana"},{"Islamabad","1,232,000","Urbu","Pāk Sarzamīn"},{"Sana'a","3,292,000","arabic","United Republic"},{"Tehran","9,499,781","Persian","Sorude Melliye Jomhuriye Eslāmiye Irān"},{"Ankara","5,397,000","Turkish","İstiklâl Marşı"}},
            {{"Abuja","224,858,031","English","Arise, O Compatriots"},{"Cairo","113,065,935","Arabic","My homeland, you have my love and my heart"},{"Dodoma","67,827,502","Swahili","Mungu ibariki Afrika"},{"Nairobi","55,318,096","Swahili","Ee Mungu Nguvu Yetu"},{"Kampala","48,846,305","Swahili","Oh Uganda, Land of Beauty"},{"Khartoum","48,354,905","Arabic","As-salam Al-jamhuri"},{"Algiers [El Djazaïr]","45,738,127","Arabic","Kassaman"}},
            {{"Ottawa","38.25 million","English","O Canada"},{"Mexico City","126.7 million","Spanish","Mexicans, at the cry of war"},{"Nuuk","56,653","Greenlandic","You, Our Ancient Land"},{"Havana","11.26 million","Spanish","The Bayamo Anthem"},{"Panama City","4.351 million","Spanish","Isthmian Hymn"},{"San José","5.154 million","Spanish","Noble fatherland, your beautiful flag"},{"Belmopan","400,031","English","Land of the Free"}},
            {{"Lima","33.72 million","Spanish","We are free!"},{"Santiago","19.49 million","Spanish","How pure, Chile, is your blue sky"},{"Quito","17.8 million","Spanish","Hail, Oh Fatherland!"},{"La Paz","12.08 million","Spanish","Bolivians, a Propitious Fate"},{"Brasília","214.3 million","Portuguese","Brazilian National Anthem"},{"Buenos Aires","45.81 million","Spanish","Argentine National Anthem"},{"Asunción","6.704 million","Spanish","Paraguayan National Anthem"}},
            {{"Berlin","83.2 million","German","Fuck Hitler(XD)"},{"Paris","67.75 million","French","The Marseillaise"},{"Rome","59.11 million","Italian","The Song of the Italians"},{"Madrid","47.42 million","Spanish","Royal March"},{"Warsaw","37.75 million","Polish","Poland Is Not Yet Lost"},{"Letzeburg","640,064","German","Our Homeland"},{"Monte Carlo","36,686","French","Monégasque Anthem"}},
            {{"Wellington","5.123 million","Māori","God Defend New Zealand"},{"Honiara","707,851","English","God Save Our Solomon Islands"},{"Port Vila","319,137","Bislama","Yumi, Yumi, Yumi"},{"Apia","218,764","English","The Banner of Freedom"},{"Hagåtña","170,534","Chamorro","Fanohge CHamoru"},{"Nuku'alofa","106,017","Tongan","Song of the King of the Tongan Islands"},{"Ngerulmud","18,024","English","Our Palau"}}};

    final String CAPITAL = "Capital = ";
    final String POPULATION = "Population = ";
    final String LANGUAGE = "Language = ";
    final String ANTHEM = "Anthem = ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spinner);
        countries = findViewById(R.id.countries);
        Capital = findViewById(R.id.Capital);
        Population = findViewById(R.id.population_size);
        Language = findViewById(R.id.official_language);
        Anthem = findViewById(R.id.anthem_name);
        ArrayAdapter<String> adp_spinner = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,continents);
        spin.setAdapter(adp_spinner);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected_continent = position;
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Countries[position]);
        countries.setAdapter(adp);
        countries.setOnItemClickListener(this);
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String_setter(information[selected_continent][position]);
    }

    public void String_setter(String[]info)
    {
        String st1 = CAPITAL + info[0];
        String st2 = POPULATION + info[1];
        String st3 = LANGUAGE + info[2];
        String st4 = ANTHEM + info[3];
        Capital.setText(st1);
        Population.setText(st2);
        Language.setText(st3);
        Anthem.setText(st4);
    }
}