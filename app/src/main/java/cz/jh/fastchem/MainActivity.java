package cz.jh.fastchem;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import androidx.appcompat.app.AlertDialog;

import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainActivity extends AppCompatActivity {

    private static final int CREATE_FILE1 = 1;
    private static final int CREATE_FILE2 = 2;
    private static final int CREATE_FILE3 = 3;
    private static final int READ_FILE1 = 4;
    private static final int READ_FILE2 = 5;
    private static final int READ_FILE3 = 6;
    private static final int READ_FILE30 = 60;
    private Uri documentUri1;
    private Uri documentUri2;
    private Uri documentUri3;
    private Uri documentUri4;
    private Uri documentUri5;
    private Uri documentUri6;
    private Uri documentUri60;
    private static final int MY_PERMISSION_REQUEST_STORAGE = 1;
    private TextView config_label;
    private EditText config;
    private TextView atmospheric_profile_label;
    private EditText atmospheric_profile;
    private Button openatmofile;
    private Button openatmofile2;
    private Button saveatmofile;
    private Button saveatmofile2;
    private TextView abundance_label;
    private EditText abundance;
    private Button openabundfile;
    private Button openabundfile2;
    private Button saveabundfile;
    private Button saveabundfile2;
    private Button database1;
    private Button database2;
    private Button database1cond;
    private Button database2cond;
    private Button run;
    private Button saveoutputfile;
    private Button saveoutputfile2;
//    private Button transpose;
    private Button highlight;
    private Button about;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private Handler handler = new Handler();
    private Button manual;
    private Button license;

    static final String LOGTAG = "";
    static final int BUFSIZE = 5192;
    static final String ZIP_FILTER = "assets";

    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        config_label = (TextView) findViewById(R.id.config_label);
        config = (EditText) findViewById(R.id.config);
        atmospheric_profile_label = (TextView) findViewById(R.id.atmospheric_profile_label);
        atmospheric_profile = (EditText) findViewById(R.id.atmospheric_profile);
        openatmofile = (Button) findViewById(R.id.openatmofile);
        openatmofile2 = (Button) findViewById(R.id.openatmofile2);
        saveatmofile = (Button) findViewById(R.id.saveatmofile);
        saveatmofile.setOnClickListener(saveatmofileClick);
        saveatmofile2 = (Button) findViewById(R.id.saveatmofile2);
        saveatmofile2.setOnClickListener(saveatmofile2Click);
        abundance_label = (TextView) findViewById(R.id.abundance_label);
        abundance = (EditText) findViewById(R.id.abundance);
        openabundfile = (Button) findViewById(R.id.openabundfile);
        openabundfile2 = (Button) findViewById(R.id.openabundfile2);
        saveabundfile = (Button) findViewById(R.id.saveabundfile);
        saveabundfile.setOnClickListener(saveabundfileClick);
        saveabundfile2 = (Button) findViewById(R.id.saveabundfile2);
        saveabundfile2.setOnClickListener(saveabundfile2Click);
        database1 = (Button) findViewById(R.id.database1);
        database2 = (Button) findViewById(R.id.database2);
        database1cond = (Button) findViewById(R.id.database1cond);
        database2cond = (Button) findViewById(R.id.database2cond);
        run = (Button) findViewById(R.id.run);
        run.setOnClickListener(runClick);
        saveoutputfile = (Button) findViewById(R.id.saveoutputfile);
        saveoutputfile.setOnClickListener(saveoutputfileClick);
        saveoutputfile2 = (Button) findViewById(R.id.saveoutputfile2);
        saveoutputfile2.setOnClickListener(saveoutputfile2Click);
//        transpose = (Button) findViewById(R.id.transpose);
//        transpose.setOnClickListener(transposeClick);
        highlight = (Button) findViewById(R.id.highlight);
        highlight.setOnClickListener(highlightClick);
        about = (Button) findViewById(R.id.about);
        about.setOnClickListener(aboutClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);

        openatmofile = (Button) findViewById(R.id.openatmofile);
        openatmofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectAtmoFile.class);
                startActivity(intent);
            }
        });

        openatmofile2 = (Button) findViewById(R.id.openatmofile2);
        openatmofile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read1(getApplicationContext());
            }
        });

        openabundfile = (Button) findViewById(R.id.openabundfile);
        openabundfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectAbundFile.class);
                startActivity(intent);
            }
        });

        openabundfile2 = (Button) findViewById(R.id.openabundfile2);
        openabundfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read2(getApplicationContext());
            }
        });

        database1 = (Button) findViewById(R.id.database1);
        database1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectDataFile.class);
                startActivity(intent);
            }
        });

        database1cond = (Button) findViewById(R.id.database1cond);
        database1cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectDataFileCond.class);
                startActivity(intent);
            }
        });

        database2 = (Button) findViewById(R.id.database2);
        database2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read3(getApplicationContext());
            }
        });

        database2cond = (Button) findViewById(R.id.database2cond);
        database2cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read30(getApplicationContext());
            }
        });

        license = (Button) findViewById(R.id.License);
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Licenses.class);
                startActivity(intent);
            }
        });

        manual = (Button) findViewById(R.id.manual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Manual.class);
                startActivity(intent);
            }
        });





        // give the app permissions to access the storage
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);
                }
                ;
            } else {
                // do nothing
            }
            ;
        }

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        SharedPreferences.Editor editor = wmbPreference.edit();

        if (isFirstRun){

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Installing FASTCHEM. It may take a while.");
            progressDialog.show();
            new Thread() {
                public void run() {


                    copyFromAssetsToInternalStorage("assets.zip");
                    copyFromAssetsToInternalStorage("abundances.dat");
                    copyFromAssetsToInternalStorage("atmospheric-profile.dat");
                    copyFromAssetsToInternalStorage("config.input");
                    copyFromAssetsToInternalStorage("database.dat");
                    copyFromAssetsToInternalStorage("database_cond.dat");
                    String zipFilePath = getFilesDir()+"/assets.zip";
                    String destDir = getFilesDir()+"/" ;
//                    unzipfile( zipFilePath, destDir ) ;
                    try {
                        unzip(new File(zipFilePath),destDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    exec("rm "+getFilesDir()+"/assets.zip");
//                    unZipFile(getFilesDir()+"/assets.zip");

//                    unzipAssets(MainActivity.this);
//                    copyAsset("assets.zip");
                    exec("mkdir "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"/fastchem");
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(ErgoInput.getWindowToken(), 0);
//                String command = ErgoInput.getText().toString();
//                    String command = "export HOME="+getFilesDir()+"/ ; cd $HOME ; unzip assets.zip ; rm assets.zip ; chmod -R 755 *";
//                    new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);
                    exec("chmod -R 755 "+getFilesDir()+"/");
                    output_conf(exec("cat "+getFilesDir()+"/config.input"));
                    output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                    output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));

                    onFinish();
                }
                public void onFinish(){
                    progressDialog.dismiss();
                }
            }.start();
            editor.putBoolean("FIRSTRUN", false);
            editor.apply();
        }
    }

    private void copyAsset(String filename) {
        File filePath = new File(getFilesDir()+"");
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        AssetManager assetManager = getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            File outFile = new File(filePath, filename);
            out = new FileOutputStream(outFile);
            copyFile(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    public void onStart()
    {
        super.onStart();

        output_conf(exec("cat "+getFilesDir()+"/config.input"));
        output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
        output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
        output("App prepared.");
    }

    private View.OnClickListener runClick; {

        runClick = new View.OnClickListener() {
            public void onClick(View v) {
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openprogressdialog();
            }
        };
    }

    private void openprogressdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Calculation is running...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();
        new Thread() {
            public void run() {
                try {
                    exec("chmod 755 -R "+getFilesDir());
                    try {
                        com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.jh.fastchem/files ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so config.input > monitor.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t condensates.dat > condensates_trans.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t chemistry.dat > chemistry_trans.dat ; rm condensates.dat ; rm chemistry.dat ; mv chemistry_trans.dat chemistry.dat ; cat condensates_trans.dat >> chemistry.dat ; cat monitor.dat >> chemistry.dat ; rm condensates_trans.dat");
//                        exec(getApplicationInfo().nativeLibraryDir+"/libfastchem.so "+getFilesDir()+"/config.input");
                        output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                        output("Staying idle.");
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
            }
            // Executes UNIX command.
            private String exec(String command) {
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    int read;
                    char[] buffer = new char[4096];
                    StringBuffer output = new StringBuffer();
                    while ((read = reader.read(buffer)) > 0) {
                        output.append(buffer, 0, read);
                    }
                    reader.close();
                    process.waitFor();
                    return output.toString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(str2);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener saveatmofileClick; {

        saveatmofileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveInput();
            }
        };
    }

    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /atmospheric-profiles")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = atmospheric_profile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/atmospheric-profiles");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automaticall visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener saveatmofile2Click; {

        saveatmofile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write1(getApplicationContext());
            }
        };
    }

    private View.OnClickListener saveabundfileClick; {

        saveabundfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveInput2();
            }
        };
    }

    public void alertSaveInput2(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /element-abundances")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = atmospheric_profile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/element-abundances");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automaticall visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener saveabundfile2Click; {

        saveabundfile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write2(getApplicationContext());
            }
        };
    }

    private View.OnClickListener saveoutputfileClick; {

        saveoutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
            }
        };
    }

    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText15)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String OutputProtocol = outputView2.getText().toString();
                        String SaveOutputName = editText15.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveOutputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(OutputProtocol);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/work");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automaticall visible
        editText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener highlightClick; {

        highlightClick = new View.OnClickListener() {
            public void onClick(View v) {

                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();

        new Thread() {
            public void run() {

                try {
                    String Results = outputView2.getText().toString();
                    FileOutputStream fileout = openFileOutput("Output.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Results);
                    outputWriter.close();

                    outputX(exec("cat "+getFilesDir()+"/Output.txt"));
                    output_conf(exec("cat "+getFilesDir()+"/config.input"));
                    output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                    output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                    output("Staying idle.");

                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

//    private View.OnClickListener transposeClick; {
//
//        transposeClick = new View.OnClickListener() {
//            public void onClick(View v) {
//
//                String configfile = config.getText().toString();
//                try {
//                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(configfile);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                String atmofile = atmospheric_profile.getText().toString();
//                try {
//                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(atmofile);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                String abundfile = abundance.getText().toString();
//                try {
//                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(abundfile);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                // TODO Auto-generated method stub //
//                opentransposedialog();
//            }
//        };
//    }
//
//
//    private void opentransposedialog() {
//        // TODO Auto-generated method stub //
//        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setTitle("Please wait...");
//        progressDialog.setMessage("Transposing the output is in progress...");
//        progressDialog.setCancelable(false);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        progressDialog.show();
//
//        new Thread() {
//            public void run() {
//                try {
//                    String Results = outputView2.getText().toString();
//                    FileOutputStream fileout = openFileOutput("Output.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Results);
//                    outputWriter.close();
//
//                    output2(exec(getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t "+getFilesDir()+"/Output.txt"));
//                    output("Columns and rows were transposed.");
//
//
//                    output_conf(exec("cat "+getFilesDir()+"/config.input"));
//                    output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
//                    output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
//
//                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                }
//
//                onFinish();
//            }
//
//            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
//            public void outputX(final String strX) {
//                Runnable procX = new Runnable() {
//                    public void run() {
//                        outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
//                    }
//                };
//                handler.post(procX);
//            }
//
//            public void onFinish() {
//                progressDialog.dismiss();
//            }
//        }.start();
//    }


    private View.OnClickListener saveoutputfile2Click; {

        saveoutputfile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write3(getApplicationContext());
            }
        };
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyAtmosphericProfileFile");
        startActivityForResult(intent1, CREATE_FILE1);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyElementAbundancesFile");
        startActivityForResult(intent2, CREATE_FILE2);
    }

    private void write3(Context context3) {
        Intent intent3 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent3.addCategory(Intent.CATEGORY_OPENABLE);
        intent3.setType("text/plain");
        intent3.putExtra(Intent.EXTRA_TITLE,"MyOutput");
        startActivityForResult(intent3, CREATE_FILE2);
    }

    private void read1(Context context4) {
        Intent intent4 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent4.addCategory(Intent.CATEGORY_OPENABLE);
        intent4.setType("text/plain");
        startActivityForResult(intent4, READ_FILE1);
    }

    private void read2(Context context5) {
        Intent intent5 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent5.addCategory(Intent.CATEGORY_OPENABLE);
        intent5.setType("text/plain");
        startActivityForResult(intent5, READ_FILE2);
    }

    private void read3(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE3);
    }

    private void read30(Context context60) {
        Intent intent60 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent60.addCategory(Intent.CATEGORY_OPENABLE);
        intent60.setType("text/plain");
        startActivityForResult(intent60, READ_FILE30);
    }

    private View.OnClickListener aboutClick; {

        aboutClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertAbout();
            }
        };
    }

    public void alertAbout() {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("About the FASTCHEM app")
                .setMessage(exec("cat "+getFilesDir()+"/About.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }






    @Override
    protected void onResume() {
        super.onResume();
        output_conf(exec("cat "+getFilesDir()+"/config.input"));
        output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
        output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
        output("Staying idle.");
        output2(exec("cat "+getFilesDir()+"/Output.txt"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_FILE1 && data != null) {
            // save atmospheric profile file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri1 = data.getData();
                ParcelFileDescriptor pfd1 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd1.getFileDescriptor());
                String fileContents = atmospheric_profile.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd1.close();
                FileOutputStream fileout = openFileOutput("atmospheric-profile.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE2 && data != null) {
            // save element abundances file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri2 = data.getData();
                ParcelFileDescriptor pfd2 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd2.getFileDescriptor());
                String fileContents = abundance.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd2.close();
                FileOutputStream fileout = openFileOutput("abundances.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE3 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri3 = data.getData();
                ParcelFileDescriptor pfd3 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd3.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd3.close();
                FileOutputStream fileout = openFileOutput("MyOutput.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE1 && data != null) {
            // open atmospheric profile file
            try {
                documentUri4 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd4 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd4.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();
                atmospheric_profile.setText(myData);
                atmospheric_profile.setText("");
                FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd4.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE2 && data != null) {
            // open element abundances file
            try {
                documentUri5 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd5 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd5.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();
                abundance.setText(myData);
                abundance.setText("");
                FileOutputStream fileout = openFileOutput("abundance.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd5.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == READ_FILE3 && data != null) {
            // open database file
            try {
                documentUri6 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();
                FileOutputStream fileout = openFileOutput("database.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == READ_FILE30 && data != null) {
            // open database file
            try {
                documentUri60 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd60 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd60.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();
                FileOutputStream fileout = openFileOutput("database_cond.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd60.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output_conf(final String str_conf) {
        Runnable proc_conf = new Runnable() {
            public void run() {
                config.setText(str_conf);
            }
        };
        handler.post(proc_conf);
    }
    public void output_atmo(final String str_atmo) {
        Runnable proc_atmo = new Runnable() {
            public void run() {
                atmospheric_profile.setText(str_atmo);
            }
        };
        handler.post(proc_atmo);
    }
    public void output_elem(final String str_elem) {
        Runnable proc_elem = new Runnable() {
            public void run() {
                abundance.setText(str_elem);
            }
        };
        handler.post(proc_elem);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                outputView.setText(str);
            }
        };
        handler.post(proc);
    }
    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }
    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    protected void copyFromAssetsToInternalStorage(String filename){
        AssetManager assetManager = getAssets();

        try {
            InputStream input = assetManager.open(filename);
            OutputStream output = openFileOutput(filename, Context.MODE_PRIVATE);

            copyFile2(input, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unZipFile(String filename){
        try {
            ZipInputStream zipInputStream = new ZipInputStream(openFileInput(filename));
            ZipEntry zipEntry;

            while((zipEntry = zipInputStream.getNextEntry()) != null){
                FileOutputStream zipOutputStream = openFileOutput(zipEntry.getName(), MODE_PRIVATE);

                int length;
                byte[] buffer = new byte[1024];

                while((length = zipInputStream.read(buffer)) > 0){
                    zipOutputStream.write(buffer, 0, length);
                }

                zipOutputStream.close();
                zipInputStream.closeEntry();
            }
            zipInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFile2(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private static void unzipfile( String zipFilePath, String destDir ) {
        File dir = new File( destDir ) ;
        // creating an output directory if it doesn't exist already
        if( !dir.exists( ) ) dir.mkdirs( ) ;
        FileInputStream FiS ;
        // buffer to read and write data in the file
        byte[ ] buffer = new byte[ 1024 ] ;
        try {
            FiS = new FileInputStream( zipFilePath ) ;
            ZipInputStream ZiS = new ZipInputStream( FiS ) ;
            ZipEntry ZE = ZiS.getNextEntry( ) ;
            while( ZE != null ) {
                String fileName = ZE.getName( ) ;
                File newFile = new File( destDir + File.separator + fileName ) ;
                System.out.println( " Unzipping to " + newFile.getAbsolutePath( ) ) ;
                // create directories for sub directories in zip
                new File( newFile.getParent( ) ).mkdirs( ) ;
                FileOutputStream FoS = new FileOutputStream( newFile ) ;
                int len ;
                while ( ( len = ZiS.read( buffer ) )  > 0 ) {
                    FoS.write( buffer, 0, len ) ;
                }
                FoS.close( ) ;
                // close this ZipEntry
                ZiS.closeEntry( ) ;
                ZE = ZiS.getNextEntry( ) ;
            }
            // close last ZipEntry
            ZiS.closeEntry( ) ;
            ZiS.close( ) ;
            FiS.close( ) ;
        } catch ( IOException e ) {
            e.printStackTrace( ) ;
        }
    }

    public static void unzip(File source, String out) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {

            ZipEntry entry = zis.getNextEntry();

            while (entry != null) {

                File file = new File(out, entry.getName());

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();

                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

                        int bufferSize = Math.toIntExact(entry.getSize());
                        byte[] buffer = new byte[bufferSize > 0 ? bufferSize : 1];
                        int location;

                        while ((location = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, location);
                        }
                    }
                }
                entry = zis.getNextEntry();
            }
        }
    }

}