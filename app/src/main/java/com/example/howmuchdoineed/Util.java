package com.example.howmuchdoineed;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

class CsvReadWrite {
    private String baseDir;

    public CsvReadWrite(String directory) {
        baseDir = directory;
    }

    public void writeCsvToStorage(ArrayList<String[]> arrayToWrite) {
        String[] courseName = arrayToWrite.get(0);
        String[] assignmentNames = arrayToWrite.get(1);
        String[] assignmentWeights = arrayToWrite.get(2);
        String[] grades = arrayToWrite.get(3);

        try {
            System.out.println(baseDir + "/" + courseName[0] + ".csv");
            CSVWriter writer = new CSVWriter(new FileWriter(baseDir + "/" + courseName[0] + ".csv"));

            writer.writeNext(courseName);
            writer.writeNext(assignmentNames);
            writer.writeNext(assignmentWeights);
            writer.writeNext(grades);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> readCsvFromStorage(String courseName) {
        ArrayList<String[]> arrList = new ArrayList<>();
        try {
            System.out.println(baseDir + "/" + courseName + ".csv");
            CSVReader reader = new CSVReader(new FileReader(baseDir + "/" + courseName + ".csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                arrList.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrList;
    }
}


class ScrollViewWithMaxHeight extends ScrollView {

    public static int WITHOUT_MAX_HEIGHT_VALUE = -1;

    private int maxHeight = WITHOUT_MAX_HEIGHT_VALUE;

    public ScrollViewWithMaxHeight(Context context) {
        super(context);
    }

    public ScrollViewWithMaxHeight(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewWithMaxHeight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            if (maxHeight != WITHOUT_MAX_HEIGHT_VALUE
                    && heightSize > maxHeight) {
                heightSize = maxHeight;
            }
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.AT_MOST);
            getLayoutParams().height = heightSize;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }
}





//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        // do more stuff, runs after onCreate and only if there's a save state
//        super.onRestoreInstanceState(savedInstanceState);
//    }

//    public void onSaveInstanceState(Bundle outState) {
//        // outState.putString();
//
//        // call superclass to save any view hierarchy
//        super.onSaveInstanceState(outState);
//    }

//    public void openExisting(View v) {
//        Intent intent = new Intent(this, ViewFilesActivity.class);
//        startActivity(intent);
//    }

//    public void openContact(View v) {
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:1999jasontang@gmail.com"));
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "About Art3mis App");
//
//        startActivity(Intent.createChooser(emailIntent, "Email Me"));
//    }

//  public void showPath(View v) {
//    Button button = findViewById(R.id.button);
//    File dir = this.getFilesDir();
//    String dirString = dir.toString();
//    button.setText(dirString);
//  }
//
// public void openHomePage(View v) {
//    String url = "https://1999jasontang.github.io/";
//    Uri parsedUri = Uri.parse(url);
//    Intent mIntent = new Intent(Intent.ACTION_VIEW, parsedUri);
//    if (mIntent.resolveActivity(getPackageManager()) != null ) {
//      startActivity(mIntent);
//    }
//  }
//
//  public void shareText(View v) {
//    String mimeType = "text/plain";
//    String title = "Share my site";
//    ShareCompat.IntentBuilder.from(this)
//      .setChooserTitle(title)
//      .setType(mimeType)
//      .setText("https://1999jasontang.github.io/")
//      .startChooser();
//  }


//  public static boolean isNum(String input) {
//    return input.matches("[\\d\\.\\/]*");
//  }
//
//  public static double toDecimal(String input) {
//    System.out.println(input);
//
//    if ( !isNum(input) ) {
//      System.out.println("Check that you entered the number correctly!");
//      return -1.0;
//    }
//    else {
//      if (input.contains("/")) {
//        String[] splt = input.split("/");
//        if (splt.length > 2) {
//          System.out.println("You have too many fractions! Try again");
//          return -1.0;
//        }
//        else {
//          return Double.parseDouble(splt[0]) / Double.parseDouble(splt[1]);
//        }
//      }
//      else {
//        return Double.parseDouble(input);
//      }
//    }
//  }