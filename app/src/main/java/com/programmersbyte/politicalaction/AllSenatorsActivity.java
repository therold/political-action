package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AllSenatorsActivity extends AppCompatActivity {
    @Bind(R.id.senatorsListView) ListView mListView;
    String[] senators = new String[] {"Al Franken", "Amy Klobuchar", "Angus King", "Barbara Boxer", "Barbara Mikulski", "Ben Cardin", "Ben Sasse", "Bernie Sanders", "Bill Cassidy", "Bill Nelson", "Bob Casey,", "Bob Corker", "Bob Menendez", "Brian E.", "Chris Coons", "Christopher S.", "Chuck Grassley", "Chuck Schumer", "Claire McCaskill", "Cory Booker", "Cory Gardner", "Dan Coats", "Daniel S.", "David Perdue", "David Vitter", "Dean Heller", "Deb Fischer", "Debbie Stabenow", "Dianne Feinstein", "Dick Durbin", "Ed Markey", "Elizabeth Warren", "Gary Peters", "Harry Reid", "Heidi Heitkamp", "Jack Reed", "James Lankford", "Jeanne Shaheen", "Jeff Flake", "Jeff Merkley", "Jeff Sessions", "Jerry Moran", "Jim Inhofe", "Jim Risch", "Joe Donnelly", "Joe Manchin", "John Barrasso", "John Boozman", "John Cornyn", "John Hoeven", "John McCain", "John Thune", "Johnny Isakson", "Jon Tester", "Joni Ernst", "Kelly Ayotte", "Kirsten Gillibrand", "Lamar Alexander", "Lindsey Graham", "Lisa Murkowski", "Marco Rubio", "Maria Cantwell", "Mark Kirk", "Mark Warner", "Martin Heinrich", "Mazie K.", "Michael Bennet", "Mike Crapo", "Mike Enzi", "Mike Lee", "Mike Rounds", "Mitch McConnell", "Orrin Hatch", "Pat Roberts", "Pat Toomey", "Patrick Leahy", "Patty Murray", "Rand Paul", "Richard Blumenthal", "Richard Burr", "Richard Shelby", "Rob Portman", "Roger Wicker", "Ron Johnson", "Ron Wyden", "Roy Blunt", "Sheldon Whitehouse", "Shelley Moore", "Sherrod Brown", "Steve Daines", "Susan Collins", "Tammy Baldwin", "Ted Cruz", "Thad Cochran", "Thom Tillis", "Tim Kaine", "Tim Scott", "Tom Carper", "Tom Cotton", "Tom Udall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_senators);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, senators);
        mListView.setAdapter(adapter);
    }
}
